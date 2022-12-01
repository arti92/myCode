/**
 * @author Arti.Jadhav
 */
package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;

public class Excel2DatabaseTest {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/form_data_rs?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
        String username = "root";
        String password = "Root@0911";

        String excelFilePath = "/Users/arti.jadhav/Desktop/c-drive data/Arti/my doc/workspace/myCode/testcode/src/main/resources/newCatalog.xlsx";

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

            String sql = "INSERT INTO noti_temp (nid, template, is_active) VALUES (?, ?, true)";
            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;

            rowIterator.next(); // skip the header row
            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
           // int counter = 100;

            String[] arrays = {"12800.0","34200.0","34200.0","171001.0","158000.0","200401.0","200402.0","304801.0","34200.0","12800.0","171000.0","171001.0","410214.0","410216.0","410215.0","410217.0","410219.0","410218.0","410453.0","410447.0","410448.0","410449.0","410450.0","410451.0","158000.0","40407.0","410258.0","404702.0","404702.0","410255.0","410254.0","410257.0","410256.0","410253.0","410252.0","411158.0","410214.0","410215.0","410216.0","410217.0","410218.0","410219.0"};

            while (rowIterator.hasNext() ) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Boolean flag = false;
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();

                    // System.out.println(columnIndex);;

                    switch (columnIndex) {
                        case 15:
                            String nid = getNid(arrays, nextCell);
                            if (nid != null) {
                                statement.setString(1, nid);
                                flag = true;
                            }
                            break;
                        case 33:
                            if (flag) {
                                String template = nextCell.getStringCellValue();
                                statement.setString(2, template);
                            }
                    }

                }

                if (flag && statement != null) {
                    // System.out.println("statoment:: " + statement);
                    statement.addBatch();
                }

                if (flag && statement != null && count % batchSize == 0) {
                    statement.executeBatch();
                }
            }//row

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

    private static String getNid(String[] arrays, Cell nextCell) throws SQLException {
        String nid = "";

        if (nextCell.getCellType() == CellType.STRING) {
            nid = nextCell.getStringCellValue();
        } else if (nextCell.getCellType() == CellType.NUMERIC) {
            nid = nextCell.getNumericCellValue() + "";
        }
        //System.out.println("nid::: "+nid);
        String finalNid = nid;
        if (Arrays.stream(arrays).sequential().anyMatch(data -> data.equalsIgnoreCase(finalNid))) {
            System.out.println("nid:: " + nid);
            return nid;
        }
        return null;
    }
}