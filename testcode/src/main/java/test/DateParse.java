package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arti.Jadhav
 */
public class DateParse {

    public static void main(String[] args) {
        System.out.println("date fomat");
        System.out.println(Boolean.parseBoolean("true"));
        // String dt = "";
        //  Date time = new Date();
        // Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2018-03-25T19:31:59");
      /*  System.out.println("date...");//E MMM dd HH:mm:ss Z yyyy//20180326010159

        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format( new Date()));*/
      //  System.out.println(formatDate("Mon Mar 26 01:01:59 IST 2018","EEE MMM dd HH:mm:ss zzz yyyy","yyyyMMddHHmmss"));
        //stringToDate();

    }

    private static void stringToDate() {
        String finalString = null;
        String start_dt = "20190325193159";
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date date = (Date) formatter.parse(start_dt);
            SimpleDateFormat newFrmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            finalString = newFrmt.format(date);
        } catch (ParseException e) {
          e.printStackTrace();
        }
    }



        public static String formatDate(String dateString, String fromFormat, String toFormat) {

            try {

                    Date date = new SimpleDateFormat(fromFormat).parse(dateString);
                    return new SimpleDateFormat(toFormat).format(date.getTime());

            } catch (ParseException e) {
               e.printStackTrace();

            }
            return null;
     }
}
