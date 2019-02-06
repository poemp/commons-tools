package org.poem.utils.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL;

    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";


    /**
     * 格式化显示数据
     * @param date
     * @return
     */
    public static String toDateString(Date date) {
        return SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().format(date);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
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
