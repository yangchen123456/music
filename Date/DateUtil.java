package com.bh.Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 方法的作用就是把日期转成一个字符串
     *
     * @param d
     *            被转换的日期对象
     * @param format
     *            传递过来的要被转换的格式
     * @return 格式化后的字符串
     */
    public  String dateToString(Date d, String format) {
        // SimpleDateFormat sdf = new SimpleDateFormat(format);
        // return sdf.format(d);

        //复杂解决
        //  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        //  String format1 = simpleDateFormat.format(d);
        //  return format1;

        //链式编程，只要返回的是一个对象就可以直接.
        return new SimpleDateFormat(format).format(d);
    }

    /**
     * 方法的作用就是把一个字符串解析成一个日期对象
     *
     * @param s
     *            被解析的字符串
     * @param format
     *            传递过来的要被转换的格式
     * @return 解析后的日期对象
     * @throws ParseException
     */
    public  Date stringToDate(String s, String format)
            throws ParseException {
        return new SimpleDateFormat(format).parse(s);
    }

    /**
     * 测试调用工具类转化为日期
     */
    @Test
    public void get(){
        try {
            Date date = stringToDate("2008-08-08 12:12:12", "yyyy-MM-dd HH:mm:ss");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试调用工具类转化为字符串
     */
    @Test
    public void get1(){
        Date date = new Date();
        String s = dateToString(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
    }
}
