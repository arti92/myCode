package ds_plan2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arti.Jadhav
 */
public class EasyMain {

    public static void main(String[] args) {
        System.out.println("single num");
        int[] nums = {4,1,2,1,2};
        EasyMain em = new EasyMain();
        em.singleNumber(nums);

        String inputDateString ="2022-11-17T22:70:00";

        String a = inputDateString.indexOf("+05:30") == -1 ? inputDateString
                : inputDateString.substring(0, inputDateString.indexOf("+05:30"));

        System.out.println("a:: "+convertDateToTime(a,"yyyy-MM-dd'T'HH:mm:ss","HH:mm:ss"));
    }

    private static String convertDateToTime(String inputDateString, String inputDateFormat, String outputDateFormat)
    {
        try
        {
            Date inputDate = new SimpleDateFormat(inputDateFormat).parse(inputDateString);
            return new SimpleDateFormat(outputDateFormat).format(inputDate);
        }
        catch (ParseException e)
        {
            System.out.println(e);
        }
        return null;
    }

    public int singleNumber(int[] nums) {

        return 0;
    }
}
