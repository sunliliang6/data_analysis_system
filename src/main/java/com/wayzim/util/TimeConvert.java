package com.wayzim.util;

import antlr.StringUtils;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/3/30 20:08
 */
public class TimeConvert {
    private Date t;

    public Date getT() {
        return t;
    }

    public void setT(Date t) {
        this.t = t;
    }

        /**
         * 将2019-06-03T16:00:00.000Z日期格式转换为2019-06-03 16:00:00格式
         * @param oldDateStr
         * @return
         */
        public static void transferDateFormat(String oldDateStr) {
            Date date = null;
            Date date1 = null;
            String dateStr = null;
            try {
                dateStr = oldDateStr.replace("Z", " UTC");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
                date1 = df.parse(dateStr);
                SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                date = df1.parse(date1.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);;
        }

    public static void convert(String t) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(t);
        System.out.println(format);

    }

    public static void main(String[] args) {
        transferDateFormat("2020-07-07T10:00:00.000Z");

    }

}
