package com.bh.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDEmo {
    /**
     * 数组和集合的区别?
     * A:长度区别
     * 数组的长度固定
     * 集合长度可变
     * B:内容不同
     * 数组存储的是同一种类型的元素
     * 而集合可以存储不同类型的元素
     * C:元素的数据类型问题
     * 数组可以存储基本数据类型，也可以存储引用数据类型
     * 集合只能存储引用类型
     * <p>
     * 刚说过集合是存储多个元的，但是呢，存储多个元素也是有不同需求的：比如说，
     * 要这多个元素中不能有相同的元素，
     * 再比如说，多个元素按照某种规则排序一下。针对不同的需求，
     * Java就提供了不同的集合类，这样呢，Java就提供了很多个集合类。
     * 这多个集合类的数据结构不同,结构不同不重要的，重要的是要能够存储数据，
     * 并且还要能够使用这些东西，比如说判断，获取等。
     * 既然这样，那么，这多个集合类是有共性的内容的，
     * 把这些集合类的共性内容不断的向上提取，最终就能形成集合的继承体系结构。
     * <p>
     * Collection:是集合的顶层接口，
     * 子接口有可重复，有唯一，有有序的，有无序的   //自己测试
     * <p>
     * Collection的功能概述：
     * 1：添加功能
     * boolean add(Object obj):添加一个元素
     * boolean addAll(Collection c):添加一个集合的元素
     * 2:删除功能
     * void clear():移除所有元素
     * boolean remove(Object o):移除一个元素
     * boolean removeAll(Collection c):移除一个集合的元素(是一个还是所有)
     * 3:判断功能
     * boolean contains(Object o)：判断集合中是否包含指定的元素
     * boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素(是一个还是所有)
     * boolean isEmpty()：判断集合是否为空
     * 4:获取功能
     * Iterator<E> iterator()(重点)
     * 5:长度功能
     * int size():元素的个数
     * 面试题：数组有没有length()方法呢?字符串有没有length()方法呢?集合有没有length()方法呢?
     * 6:交集功能
     * boolean retainAll(Collection c):
     * 7：把集合转换为数组
     * Object[] toArray()
     */
    @Test
    // 添加功能,测试不带All的方法
    public void add() {
        Collection c = new ArrayList();

        // 添加元素
        c.add("yang");
        c.add("chen");
        c.add("hello");

        // 移除一个元素
        // System.out.println("remove:"+c.remove("yang"));// true
        // System.out.println("remove:"+c.remove("yansdg"));// false

        // 判断集合中是否包含 指定元素
        System.out.println("contains:" + c.contains("yang"));// true
        System.out.println("contains:" + c.contains("jhhh"));// false

        //判断是否为空
        System.out.println("isEmty：" + c.isEmpty());// false

        // 获取元素个数
        System.out.println("size:" + c.size());

        System.out.println("c:" + c);
    }

    /**
     * boolean addAll(Collection c):添加一个集合的元素
     * boolean removeAll(Collection c):移除一个集合的元素(是一个还是所有)
     * boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素(是一个还是所有)
     * boolean retainAll(Collection c):两个集合都有的元素?返回的boolean又是什么意思呢?
     */
    @Test
    public void addAll() {
        // 创建集合1
        Collection c = new ArrayList();
        c.add("yang");
        c.add("gong");
        c.add("chen");
        c.add("hello");

        // 创建集合2
        Collection c2 = new ArrayList();
        c2.add("niw");
        c2.add("shi");
        c2.add("pan");
        c2.add("world");

        // 添加一个集合的元素
        System.out.println("addAll:" + c.addAll(c2));// true

        //boolean removeAll(Collection c):移除一个集合的元素(是一个还是所有)
        //只要有一个元素被移除了，就返回true。
//        System.out.println("removeAll:"+c.removeAll(c2));// true

        //判断集合中是否包含指定的集合元素(是一个还是所有)
        //只有包含所有的元素，才叫包含
        System.out.println("containsAll:" + c.containsAll(c2));// true
    }

    /**
     * 集合的遍历。是依次获取集合中的每一个元素。
     * <p>
     * Object[] toArray():把集合转成数组，可以实现集合的遍历
     */
    @Test
    public void IteratorTest() {
        // 创建集合对象
        Collection c = new ArrayList();

        // 添加元素
        c.add("yang"); // Object obj = "hello"; 向上转型
        c.add("chen");
        c.add("hello");

        // 遍历
        // Object[] toArray():把集合转成数组，可以实现集合的遍历
        Object[] objs = c.toArray();
        for (int i = 0; i < objs.length; i++) {
            // System.out.println(objs[x]);
            // 我知道元素是字符串，我在获取到元素的的同时，还想知道元素的长度。
            // System.out.println(objs[x] + "---" + objs[x].length());
            // 上面的实现不了，原因是Object中没有length()方法
            // 我们要想使用字符串的方法，就必须把元素还原成字符串
            // 向下转型
            String s = (String) objs[i];
            System.out.println(s + "---" + s.length());
        }
    }

    /**
     * 练习：用集合存储5个学生对象，并把学生对象进行遍历。
     * <p>
     * 分析：
     * A:创建学生类
     * B:创建集合对象
     * C:创建学生对象
     * D:把学生添加到集合
     * E:把集合转成数组
     * F:遍历数组
     */

    @Test
    public void Student() {
        // 创建集合对象
        Collection c = new ArrayList();

        // 创建学生对象
        Student s1 = new Student("杨公辰", 20);
        Student s2 = new Student("聂世盼", 20);
        Student s3 = new Student("杨玉", 13);
        Student s4 = new Student("杨杨", 25);
        Student s5 = new Student("杨师傅", 52);

        // 把学生添加到集合
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);

        // 把集合转成数组
        Object[] objs = c.toArray();
        // 遍历数组
        for (int x = 0; x < objs.length; x++) {
            // System.out.println(objs[x]);

            Student s = (Student) objs[x];
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }

    /**
     * Iterator iterator():迭代器，集合的专用遍历方式
     * Object next():获取元素,并移动到下一个位置。
     * NoSuchElementException：没有这样的元素，因为你已经找到最后了。
     * boolean hasNext():如果仍有元素可以迭代，则返回 true。（
     */

    @Test
    public void IteratorTest1() {
        // 创建集合对象
        Collection c = new ArrayList();

        // 创建并添加元素
        // String s = "hello";
        // c.add(s);
        c.add("yang");
        c.add("gong");
        c.add("chen");

        // Iterator iterator():迭代器，集合的专用遍历方式
        Iterator it = c.iterator(); // 实际返回的肯定是子类对象，是多态

        // 最终版代码
        while (it.hasNext()) {
            // System.out.println(it.next());
            String s = (String) it.next();
            System.out.println(s);
        }
    }

    /**
     * 练习：用集合存储5个学生对象，并把学生对象进行遍历。用迭代器遍历。
     * <p>
     * 注意：
     * A:自己的类名不要和我们学习的要使用的API中的类名相同。
     * B:复制代码的时候，很容易把那个类所在的包也导入过来，容易出现不能理解的问题。
     */
    @Test
    public void Student1() {
        // 创建集合对象
        Collection c = new ArrayList();

        // 创建学生对象
        Student s1 = new Student("杨公辰", 20);
        Student s2 = new Student("聂世盼", 20);
        Student s3 = new Student("杨玉", 13);
        Student s4 = new Student("杨杨", 25);
        Student s5 = new Student("杨师傅", 52);

        // 把学生添加到集合中
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);
        // 遍历
//        Iterator it = c.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            Student s = (Student) it.next();
//            System.out.println("姓名："+ss.getName() + "---" + "年龄："+ss.getAge());
//        }
        // 增强for循环
        for (Object s : c) {
            Student ss = (Student) s;
            System.out.println("姓名："+ss.getName() + "---" + "年龄："+ss.getAge());

        }
    }
}
