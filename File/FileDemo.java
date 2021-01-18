package com.bh.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    /**
     * 实现IO操作，须了解硬盘文件表现形式
     * Java就提供了一个类File
     * <p>
     * File:
     * 文件和目录(文件夹)路径名的抽象表示形式
     * 构造方法：
     * File(String pathname)：根据一个路径得到File对象
     * File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
     * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
     */
    @Test
    public void Test() {
        // File(String pathname)：根据一个路径得到File对象
        // 把e:\\demo\\a.txt封装成一个File对象
        File file = new File("E:\\demo\\a.txt");

        // File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
        File file2 = new File("E:\\demo", "a.txt");

        // File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
        File file3 = new File("e:\\demo");
        File file4 = new File(file3, "a.txt");

        // 三种方式效果一样
    }

    /**
     * 创建功能：
     * public boolean createNewFile():创建文件 如果文件存在，则不创建
     * public boolean mkdir():创建文件夹 如果文件夹存在，则不创建
     * public boolean mkdirs():创建文件夹,如果父文件夹不存在，则一同创建
     */
    @Test
    public void Test1() throws IOException {
        // 需求：在D盘目录下创建一个文件夹demo
//        File file = new File("D:\\demo");
//        System.out.println("mkdir:" + file.mkdir());
//
//        // 需求:在e盘目录demo下创建一个文件a.txt
//        File file2 = new File("D:\\demo\\a.txt");
//        try {
//            System.out.println("createNewFile:" + file2.createNewFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 需求：在D盘目录test下创建一个文件b.txt
        // Exception in thread "main" java.io.IOException: 系统找不到指定路径。
        // 注意：要在某个目录下创建内容，该目录首先必须存在。
        // File file3 = new File("D:\\test\\b.txt");
        // System.out.println("createNewFile:" + file3.createNewFile());

        // 需求:在D盘目录test下创建aaa目录
        // File file4 = new File("D:\\test\\aaa");
        // System.out.println("mkdir:" + file4.mkdir());

        // File file5 = new File("D\\test");
        // File file6 = new File("D:\\test\\aaa");
        // System.out.println("mkdir:" + file5.mkdir());
        // System.out.println("mkdir:" + file6.mkdir());

        // 更简单的方法
        //File file7 = new File("e:\\aaa\\bbb\\ccc\\ddd");
        //System.out.println("mkdirs:" + file7.mkdirs());

        //
        //File file8 = new File("D:\\demo\\a.txt");
        //System.out.println("mkdirs:" + file8.mkdirs());

        File file9 = new File("D:\\demo\\b.txt");
        file9.createNewFile();

    }

    /**
     * 删除功能:public boolean delete()
     * <p>
     * 注意：
     * A:如果创建文件或者文件夹无路径，默认是项目路径
     * B:Java中的删除不经过回收站。
     * C:要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
     */

    @Test
    public void delete() {
        // 删除功能：要删除a.txt文件
        File file3 = new File("D:\\demo\\b.txt");
        System.out.println("delete:" + file3.delete());

        // 删除功能：要删除ccc文件夹
        File file4 = new File("D:\\demo\\a.txt");
        System.out.println("delete:" + file4.delete());
    }

    /**
     * 重命名功能:public boolean renameTo(File dest)
     * 如果路径名相同，就是改名。
     * 如果路径名不同，就是改名并剪切。
     * <p>
     * 路径以盘符开始：绝对路径	c:\\a.txt
     * 路径不以盘符开始：相对路径	a.txt
     */
    @Test
    public void rename() {

        File file = new File("D:\\demo\\a.tx");

        file.renameTo(new File("D:\\demo\\b.txt"));
    }

    /**
     * 判断功能:
     * public boolean isDirectory():判断是否是目录
     * public boolean isFile():判断是否是文件
     * public boolean exists():判断是否存在
     * public boolean canRead():判断是否可读
     * public boolean canWrite():判断是否可写
     * public boolean isHidden():判断是否隐藏
     */

    @Test
    public void IsTest() {
        // 创建文件对象
        File file = new File("D:\\demo\\a.txt");
        //System.out.println(file.mkdir());

        // public boolean isDirectory():判断是否是目录
        System.out.println(file.isDirectory());

        // public boolean isFile():判断是否是文件
        System.out.println(file.isFile());

        // public boolean exists():判断是否存在
        System.out.println(file.exists());

        // public boolean canRead():判断是否可读
        System.out.println(file.canRead());

        // public boolean canWrite():判断是否可写
        System.out.println(file.canWrite());

        // public boolean isHidden():判断是否隐藏
        System.out.println(file.isHidden());

    }

    /**
     * 获取功能：
     * public String getAbsolutePath()：获取绝对路径
     * public String getPath():获取相对路径
     * public String getName():获取名称
     * public long length():获取长度。字节数
     * public long lastModified():获取最后一次的修改时间，毫秒值
     */
    @Test
    public void get() {
        // 创建文件对象
        File file = new File("D:\\demo\\b.txt");
        //System.out.println(file.mkdir());

        // public String getAbsolutePath()：获取绝对路径
        System.out.println(file.getAbsolutePath());

        // public String getName():获取名称
        System.out.println(file.getName());

        // public long length():获取长度。字节数
        System.out.println(file.length());

        // public long lastModified():获取最后一次的修改时间，毫秒值
        System.out.println(file.lastModified());
    }

    /*
     * 获取功能：
     * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
     * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
     */
    @Test
    public void getList() {
        // 指定一个目录
        File file = new File("D:\\");

        // public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
        System.out.println(file.list().length);
        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ",");
        }

        // public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
        System.out.println(file.listFiles().length);

    }
}
