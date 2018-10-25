package cn.hlq.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetils {
    public static Long Date2long(Date date)
    {
        return date.getTime();
    }

    public static String Long2DateFormat(Long datetimestamp)
    {
        Date date = new Date(datetimestamp);
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        return sdf.format(date);
    }

}
