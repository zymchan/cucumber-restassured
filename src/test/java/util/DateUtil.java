package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getCurrentTime(String dateFormat){
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(new Date());
    }
}
