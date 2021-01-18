package com.bh.dao.UserDaoImpl;

import com.bh.dao.UserDao.UserDao;
import com.bh.pojo.User;

import java.io.*;

public class UserDaoImpl implements UserDao {
    static File file = new File("user.txt");
    //随着类的加载而加载
    static {
        try {

            file.createNewFile();
        } catch (IOException e) {
            System.out.println("文件名已经存在");
//            e.printStackTrace();
        }
    }

    /**
     * 登录
     *
     * @param name
     * @param pass
     * @return
     */
    @Override
    public boolean login(String name, String pass) {
        boolean flag = false;
        try {
            //创建高效字符输入流来读取数据
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(":");
                if (s[0].equals(name.trim()) && s[1].equals(pass)) {
                    flag = true;
                }
            }
            // 关闭资源
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 判断用户是否注册
     *
     * @param name
     * @return
     */
    public boolean login(String name) {
        boolean flag = false;
        try {
            //创建高效字符输入流来读取数据
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(":");
                if (s[0].equals(name.trim())) {
                    flag = true;
                }
            }
            // 关闭资源
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 注册
     */
    @Override
    public void sign(User user) {
        if (login(user.getName())) {
            System.out.println("用户名已经注册,请直接登录");
        } else {
            //把用户信息存进文件里
            String info = user.getName() + ":" + user.getPassword();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

                bw.write(info);
                //换行
                bw.newLine();
                //刷新缓冲区
                bw.flush();
                //关闭资源
                bw.close();
                System.out.println("注册成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
