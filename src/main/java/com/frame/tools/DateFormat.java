package com.frame.tools;

import com.frame.logger.LoggerControler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 米阳 on 2017/10/16.
 */
public class DateFormat {
    final static LoggerControler LOGGER = LoggerControler.getLogger(DateFormat.class);

    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";

    public static final String SHORT_DATE_FORMAT = "yy-MM-dd HH:mm";

    public static final String SMALL_DATE_FORMAT = "MM-dd";

    public static final String ABC_ORDER_DATE_FORMAT = "yyyy/MM/dd";

    public static final String ABC_ORDER_TIME_FORMAT = "HH:mm:ss";

    public static final String LOTTERY_PRINTING_TIME_FORMAT = "HH_mm_ss";

    public static final String CHECK_LOG_FORMAT = "yyyyMMdd";

    public static final String TEN_PAY_DATE_STRING_FORMAT = "yyMMdd";

    public static final String REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ZH_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

    /**
     * 引入SimpleDateFormat类处理时间
     *
     */
    private static SimpleDateFormat simpleDateFormat;

    public static String format(String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        String s = simpleDateFormat.format(new Date());
        LOGGER.info(s);
        return s;
    }


    public static long time() {
        long t = System.currentTimeMillis();
        LOGGER.info(String.valueOf(t));
        return t;
    }

}
