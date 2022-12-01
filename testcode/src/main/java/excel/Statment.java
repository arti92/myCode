package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Arti.Jadhav
 */
public class Statment {

    public static void main(String[] args) throws ParseException {
        String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
        String username = "root";
        String password = "Root@0911";

        String excelFilePath = "/Users/arti.jadhav/Desktop/c-drive data/Arti/my doc/workspace/myCode/testcode/src/main/resources/stmnt.xlsx";

        int batchSize = 50;

        Connection connection = null;
        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO stmt (`value_date`, `transaction_date`, `transaction_remarks`, `withdrawal`,deposit, `balance`, month) " +
                    "VALUES (?, ?, ?,?, ?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;
            int month = 0;
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Boolean flag = false;
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 1:
                            statement.setString(1, nextCell.getStringCellValue());
                            break;
                        case 2:
                            String date = nextCell.getStringCellValue();
                            statement.setString(2, date);
                            if (date != null && !date.equalsIgnoreCase("")) {
                                Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                                month = d1.getMonth()+1;
                            }
                            break;
                        case 3:
                            statement.setString(7, String.valueOf(month));
                            break;
                        case 4:
                            if (nextCell.getStringCellValue() != null && !nextCell.getStringCellValue().equalsIgnoreCase("")) {
                                statement.setString(3, nextCell.getStringCellValue());
                            }
                            break;
                        case 5:
                            if (nextCell.getStringCellValue() != null && !nextCell.getStringCellValue().equalsIgnoreCase("")) {
                                statement.setString(4, nextCell.getStringCellValue());
                            }
                            break;
                        case 6:
                            if (nextCell.getStringCellValue() != null && !nextCell.getStringCellValue().equalsIgnoreCase("")) {
                                statement.setString(5, nextCell.getStringCellValue());
                            }
                            break;
                        case 7:
                            if (nextCell.getStringCellValue() != null && !nextCell.getStringCellValue().equalsIgnoreCase("")) {
                                statement.setString(6, nextCell.getStringCellValue());
                            }
                            break;


                    }
                    if (columnIndex > 0)
                        flag = true;
                }
                if (flag && statement != null) {
                    // System.out.println("statoment:: " + statement);
                    statement.addBatch();
                }

                if (flag && statement != null && count % batchSize == 0) {
                    statement.executeBatch();
                }
            }//row
            //  rowIterator.next(); // skip the header row
            workbook.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
    }
}
