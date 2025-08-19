package Util;

import java.text.SimpleDateFormat;

public class DateUtil {
    public static java.sql.Date parseDate(String dateStr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return new java.sql.Date(sdf.parse(dateStr).getTime());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
