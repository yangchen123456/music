package com.bh.Game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * 玩游戏模块
     */
    public  void game(){
        System.out.println("======开始玩游戏=======");
        Random random = new Random();
        final int value = random.nextInt(100);
        System.out.println("请输入0-100之间的数字：");
        int count=0; //定义猜的次数
        while(true){
            count++; //循环次数自增
            Scanner sc = new Scanner(System.in);
            int number =sc.nextInt();
            if(number<value){
                System.out.println("你猜小了,请重新输入你要猜的数字：");
            }else if(number>value){
                System.out.println("你猜大了,请重新输入你要猜的数字：");
            }
            else{
                System.out.println("猜对了");
                System.out.println("游戏结束");
                break;
            }
        }
        System.out.println("你总共猜了"+count+"次");
    }
}
