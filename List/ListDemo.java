package com.bh.List;

import com.bh.Collection.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    /**
     * List集合特有功能：
     * A:添加功能
     * void add(int index,Object element):在指定位置添加元素
     * B:获取功能
     * Object get(int index):获取指定位置的元素
     * C:列表迭代器
     * ListIterator listIterator()：List集合特有的迭代器
     * D:删除功能
     * Object remove(int index)：根据索引删除元素,返回被删除的元素
     * E:修改功能
     * Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
     */
    public static void main(String[] args) {
        // 创建集合对象
        List<String> list = new ArrayList();

        // 创建字符串并添加字符串
        list.add("hello");
        list.add("world");
        list.add("java");

        // 遍历集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
    }

    /**
     * List集合的特点：
     * <p>
     * 有序:存储和取出元素顺序一致
     * 可重复:存储的元素可以重复
     */

    /*
     * 存储自定义对象并遍历
     */
    @Test
    public void ListDemo() {

        List list = new ArrayList();
        // 创建学生对象
        com.bh.Collection.Student s1 = new com.bh.Collection.Student("杨公辰", 20);
        com.bh.Collection.Student s2 = new com.bh.Collection.Student("聂世盼", 20);
        com.bh.Collection.Student s3 = new com.bh.Collection.Student("杨玉", 13);
        com.bh.Collection.Student s4 = new com.bh.Collection.Student("杨杨", 25);
        com.bh.Collection.Student s5 = new Student("杨师傅", 52);

        // 把学生添加到集合中
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
//         //遍历
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            Student s = (Student) it.next();
//            System.out.println("姓名："+ss.getName() + "---" + "年龄："+ss.getAge());
//        }

        // 增强for循环
        for (Object s : list) {
            Student ss = (Student) s;
            System.out.println("姓名：" + ss.getName() + "---" + "年龄：" + ss.getAge());
        }

    }

    /**
     * List集合特有功能：
     * A:添加功能
     * void add(int index,Object element):在指定位置添加元素
     * B:获取功能
     * Object get(int index):获取指定位置的元素
     * C:列表迭代器
     * ListIterator listIterator()：List集合特有的迭代器
     * D:删除功能
     * Object remove(int index)：根据索引删除元素,返回被删除的元素
     * E:修改功能
     * Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
     */

    @Test
    public void ListDemo1() {
        // 创建集合对象
        List list = new ArrayList();

        // 添加元素
        list.add("yang");
        list.add("gong");
        list.add("chen");

        // add(int index,Object element):在指定位置添加元素
        list.add(1, "nie");//true
        //list.add(11, "javaee");//false 没有指定索引
        list.add(3, "pan"); //true
        //list.add(4, "javaee"); //false 没有指定索引

        // Object get(int index):获取指定位置的元素
        // System.out.println("get:" + list.get(1));
        // IndexOutOfBoundsException
        // System.out.println("get:" + list.get(11));

        // Object remove(int index)：根据索引删除元素,返回被删除的元素
        System.out.println("remove:" + list.remove(1)); // nie
        // IndexOutOfBoundsException
        // System.out.println("remove:" + list.remove(11)); //删除失败

        // Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
        // System.out.println("set:" + list.set(1, "hello"));

        System.out.println("list:" + list);
    }

    /**
     * List集合的特有遍历功能：
     * size()，get()方法结合使用
     */

    @Test
    public void ListDemo02() {
        // 创建集合对象
        List list = new ArrayList();

        // 添加元素
        list.add("yang");
        list.add("gong");
        list.add("chen");

        // Object get(int index):获取指定位置的元素
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println("------------");

        // 用循环改进
        // for (int x = 0; x < 3; x++) {
        // System.out.println(list.get(x));
        // }
        // size()获取长度
        // 利用size()来获取集合的长度get()获取指定的元素 从而完成遍历
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(x));

            String s = (String) list.get(i);
            System.out.println(s);
        }
    }
}
