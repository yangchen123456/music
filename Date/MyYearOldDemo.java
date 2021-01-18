package com.bh.Date;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MyYearOldDemo {
    /**
     * 计算你来到这个世界多少天?
     * <p>
     * 分析：
     * A:键盘录入你的出生的年月日
     * B:把该字符串转换为一个日期
     * C:通过该日期得到一个毫秒值
     * D:获取当前时间的毫秒值
     * E:用D-C得到一个毫秒值
     * F:把E的毫秒值转换为年
     * /1000/60/60/24
     */
    public static void main(String[] args) throws ParseException {
        DateUtil dateUtil = new DateUtil();
        System.out.println("请输入你的出生年月日：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //将输入的字符串转化为日期对象然后再转化为毫秒。
        long time = dateUtil.stringToDate(s, "yyyy-MM-dd").getTime();
        System.out.println(time);

        //获取当前时间，然后转为毫秒
        Date date = new Date();
        long time1 = date.getTime();
        System.out.println(time1);

        //将时间格式化为天数
        long time0 = (time1 - time)/1000/60/60/24;
        System.out.println(time0);
    }
}
