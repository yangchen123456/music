package com.bh.Test;

import com.bh.Game.Game;
import com.bh.dao.UserDaoImpl.UserDaoImpl;
import com.bh.pojo.User;

import java.io.IOException;
import java.util.Scanner;

public class DemoTest {
    public static void main(String[] args) throws IOException {
        while (true) {
            //创建键盘录入对象，获取键盘录入信息
            Scanner sc = new Scanner(System.in);
            System.out.println("====欢迎来到注册登录界面====");
            System.out.print("1.注册");
            System.out.print("     ");
            System.out.print("2.登录");
            System.out.print("     ");
            System.out.println("3.退出");

            System.out.println("请选择功能:");
            String num = sc.nextLine();

            //创建一个用户操作类
            UserDaoImpl udi = new UserDaoImpl();

            // 调用游戏
            Game game = new Game();

            switch(num){
                case "1":
                    System.out.println("欢迎来到注册界面！");
                    System.out.println("请输入用户名：");
                    String userName = sc.nextLine();
                    System.out.println("请输入密码：");
                    String passWord = sc.nextLine();
                    User user = new User(userName,passWord);

                    udi.sign(user);

                    break;
                case "2":
                    System.out.println("欢迎来到登录界面！");
                    System.out.println("请输入用户名：");
                    String InputName = sc.nextLine();
                    System.out.println("请输入密码：");
                    String InputPassWord = sc.nextLine();
                    if (udi.login(InputName,InputPassWord)) {
                        System.out.println("登陆成功！可以玩游戏了！");
                       game.game();
                    }else{
                        System.out.println("登录失败！");
                    }
                    break;
                case "3":
                    //
                default:
                    //对于3或者其他数字的选择，都直接退出系统
                    System.exit(0);
                    break;

            }

        }

    }
}
