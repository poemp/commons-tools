package org.poem.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL;

    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";


    public static String toDateString(Date date) {
        return SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().format(date);
    }

    /**
     * 多线程
     */
    static {
        SIMPLE_DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat(DATE_TIME);
            }
        };
    }
}
