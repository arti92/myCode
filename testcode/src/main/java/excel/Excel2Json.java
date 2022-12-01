/**
 * @author Arti.Jadhav
 */
package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.STTwipsMeasureImpl;
import org.w3c.dom.NodeList;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Excel2Json {
    static String excelFilePath = "/Users/arti.jadhav/Desktop/c-drive data/Arti/my doc/workspace/myCode/testcode/src/main/resources/newCatalog.xlsx";
   // static String[] woValues = {"ORN", "SERVICE_ID", "WORK_ORDER_NO", "PURPOSE", "RECOVERY_DATE_TIME", "STATUS_REASON", "FIXED_LINE_NUMBER", "NEW_DEVICE_SR_NO", "FIXED_LINE_NUMBER_SERVICE_ID", "DEVICE_TYPE", "REASON_CODE_DESC", "DATE_TIME"};
   // static String[] workOrderNids = {"12800.0", "34200.0", "34200.0", "171001.0", "158000.0", "200401.0", "200402.0", "304801.0", "34200.0", "12800.0", "171000.0", "171001.0", "410214.0", "410216.0", "410215.0", "410217.0", "410219.0", "410218.0", "410453.0", "410447.0", "410448.0", "410449.0", "410450.0", "410451.0", "158000.0", "40407.0", "410258.0", "404702.0", "404702.0", "410255.0", "410254.0", "410257.0", "410256.0", "410253.0", "410252.0", "411158.0", "410214.0", "410215.0", "410216.0", "410217.0", "410218.0", "410219.0"};
     static String[] woValues = {"MSISDN"};
     static String[] workOrderNids = {"409063.0"};

    public static void main(String[] args) {

        String[] a = {"a"};
        System.out.println(a.length);

        String str = "b";
        str.length();

        List<String> l= new ArrayList<>();
        l.size();
        l.isEmpty();

        JSONArray excelJsonArray = getJsonFromExcel();
       /* String jsonArrayStr = "[{\n" +
                "    \"template\": \"Appointment for uninstallation of Jio STB for JioFiber connection having JioFixedVoice Number +91<<FIXED_LINE_NUMBERssss>> has been scheduled at your premises.\\nService Request Number : <<ORN>>\\nAppointment date and time : <<DATE_TIME>>\\nOn closure of service request, you will receive an OTP. Kindly share it with our Jio service engineer.\\nFor any queries or to reschedule this appointment, call us on 18008969999.\",\n" +
                "    \"NID\": \"410453.0\"\n" +
                "  },{\n" +
                "    \"template\": \"Dear Customer, \\nYour appointment with Jio service engineer, with reference number <<WORK_ORDER_NO>> is scheduled at your premises for <<PURPOSE>> on <<DATE_TIME>>. For queries, please call us on 1800 896 9999. \\nThank You,\\nTeam Jio\\n\",\n" +
                "    \"NID\": \"200401.0\"\n" +
                "  }]";*/
        JSONArray jsonArray = new JSONArray(excelJsonArray);
        JSONArray dynamicExValArray = getDynamicValues(jsonArray);
        // JSONArray excludeValArray = getExcludedVal(dynamicValArray); //after getting all val
    }


    private static JSONArray getDynamicValues(JSONArray jsonArray) {
        JSONArray opArray = new JSONArray();
        for (Object obj : jsonArray) {
            JSONObject nidObj = new JSONObject();
            JSONObject jsonObject = (JSONObject) obj;
            String template = (String) jsonObject.get("template");

            //nidObj.put("dynamic_values", getMatchedValues(template));//only give dynamic values
            //give excluded values
            List<String> excList = getExcludedValues(getMatchedValues(template));
            if (!excList.isEmpty()) {
                nidObj.put("NID", jsonObject.get("NID"));
                nidObj.put("dynamic_ex_values", excList);
                opArray.put(nidObj);
            }
        }
        System.out.println("Array:: " + opArray);
        return opArray;
    }

    private static List<String> getMatchedValues(String template) {
        Pattern pattern = Pattern.compile("<<(.*?)>>");
        Matcher matcher = pattern.matcher(template);
        List<String> listMatches = new ArrayList<>();
        while (matcher.find()) {
            //System.out.println(matcher.group(0)+"::"+matcher.group(1));
            listMatches.add(matcher.group(1));
        }
        return listMatches;
    }

    private static List<String> getExcludedValues(List<String> valList) {
        List<String> excList = new ArrayList<>();
        excList = valList.stream()
                .filter(val -> Arrays.stream(woValues).noneMatch(val::equalsIgnoreCase))
                .collect(Collectors.toList());
        return excList;
    }

    private static JSONArray getJsonFromExcel() {
        JSONArray jsonArray = new JSONArray();
        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = firstSheet.iterator();
            int count = 0;

            int skipHeaders = 7;
            for (int i = 0; i < skipHeaders; i++) {
                rowIterator.next(); // skip the header row
            }
            //int counter = 30;
            //row Iterator
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Boolean flag = false;
                JSONObject jsonObject = new JSONObject();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 15:
                            String nid = getNid(workOrderNids, nextCell);
                            if (nid != null) {
                                jsonObject.put("NID", nid);
                                flag = true;
                            }
                            break;
                        case 33:
                            if (flag) {
                                String template = nextCell.getStringCellValue();
                                jsonObject.put("template", template);
                            }
                    }

                }
                if (jsonObject != null && !jsonObject.isEmpty()) jsonArray.put(jsonObject);
                //counter--;
            }//row

            workbook.close();

            System.out.println("json for matched template..." + jsonArray);
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        }
        return jsonArray;
    }

    private static String getNid(String[] arrays, Cell nextCell) {
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

    //instaed of it getExclud val used
    private static JSONArray getExcludedVal(JSONArray dynamicVal) {
        String[] woValues = {"ORN", "SERVICE_ID", "WORK_ORDER_NO", "PURPOSE", "RECOVERY_DATE_TIME", "STATUS_REASON", "FIXED_LINE_NUMBER", "NEW_DEVICE_SR_NO", "FIXED_LINE_NUMBER_SERVICE_ID", "DEVICE_TYPE", "REASON_CODE_DESC", "DATE_TIME"};

        JSONArray opArray = new JSONArray();
        for (Object obj : dynamicVal) {
            JSONObject opObj = new JSONObject();
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray arr = (JSONArray) jsonObject.get("dynamic_values");
            List<String> valList = new ArrayList<>();
            for (Object a : arr) {
                valList.add((String) a);
            }
            System.out.println("valList:: " + valList);
            List<String> excList = new ArrayList<>();
            excList = valList.stream()
                    .filter(val -> Arrays.stream(woValues)
                            .noneMatch(val::equalsIgnoreCase))
                    .collect(Collectors.toList());
            System.out.println("exc:: " + excList);
            if (!excList.isEmpty()) {
                opObj.put("NID", jsonObject.get("NID"));
                opObj.put("excluded_values", excList);
                opArray.put(opObj);
            }
        }
        System.out.println("output of excluded:: " + opArray);
        return opArray;
    }

}