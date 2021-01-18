package com.bh.Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        /**
         * Date:表示特定的瞬间，精确到毫秒。
         *
         * 构造方法：
         * 		Date():根据当前的默认毫秒值创建日期对象
         * 		Date(long date)：根据给定的毫秒值创建日期对象
         */
        // 创建对象
        Date d = new Date();
        System.out.println("d:" + d);

        // 创建对象
        // long time = System.currentTimeMillis();
        long time = 1000 * 60 * 60; // 1小时
        Date d2 = new Date(time * 2);
        System.out.println("d2:" + d2);
    }

    @Test
    public void DateTest() {
        /**
         * public long getTime():获取时间，以毫秒为单位
         * public void setTime(long time):设置时间
         *
         * 从Date得到一个毫秒值
         * 		getTime()
         * 把一个毫秒值转换为Date
         * 		构造方法
         * 		setTime(long time)
         */
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

        // System.out.println(System.currentTimeMillis());
        System.out.println("d:" + date);
        // 设置时间
        date.setTime(1000);
        System.out.println("d:" + date);
    }
    /**
 * Date	 --	 String(格式化)
 * 		public final String format(Date date)
 *
 * String -- Date(解析)
 * 		public Date parse(String source)
 *
 * DateForamt:可以进行日期和字符串的格式化和解析，
       但是由于是抽象类，所以使用具体子类SimpleDateFormat。
 *
 * SimpleDateFormat的构造方法：
 * 		SimpleDateFormat():默认模式
 * 		SimpleDateFormat(String pattern):给定的模式
 * 			这个模式字符串该如何写呢?
 * 			通过查看API，我们就找到了对应的模式
 * 			年 y
 * 			月 M
 * 			日 d
 * 			时 H
 * 			分 m
 * 			秒 s
 *
 * 			2019年12月12日 12:12:12
 */
    @Test
    public void main() throws ParseException {
        // Date -- String
        // 创建日期对象
        Date d = new Date();
        // 创建格式化对象
        // SimpleDateFormat sdf = new SimpleDateFormat();
        // 给定模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        // public final String format(Date date)
        String s = sdf.format(d);
        System.out.println(s);

        //String -- Date
        String str = "2008-08-08 12:12:12";
        //在把一个字符串解析为日期的时候，请注意格式必须和给定的字符串格式匹配
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd = null;
        try {
            dd = sdf2.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dd);
    }
}
