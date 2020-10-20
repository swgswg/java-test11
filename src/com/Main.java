package com;


import Goods.Goods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * 1.编写一段程序，把"一站式门店运营服务平台"按单字符添加到HashSet中后，再删除"门店"两个字符，最后循环打印输出每一个字符。
 * 2.针对上面那段文字，删除并打印输出按自然排序的第一个字符和最后一个字符。
 * 3.编写一段程序，统计这段文字"This class implements the <tt>Set</tt> interface, backed by a hash
 * 	table(actually a <tt>HashMap</tt> instance).  It makes no guarantees as to the iteration order of the set; in
 * 	particular, it does not guarantee that the order will remain constant over time.  This class permits the
 * 	<tt>null</tt> element."中不重复字符的数量。
 * 4.编写一段程序，统计这段文字"This class offers constant time performance for the basic operations add
 * 	remove contains and size"中不重复词语的数量，并按序列打印输出。
 * 5.定义一个商品类（id, 名称，分类，售价，创建时间），重写toString，可以输出json形式的商品信息，同时实现
 * 	Comparable接口，能在TreeSet中按创建时间倒序排列。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        hashset();
        System.out.println("2======================");
        treeset();
        System.out.println("3======================");
        countNoRepeat();
        System.out.println("4======================");
        countNoRepeatWord();
        System.out.println("5======================");
        goods();
    }

    /**
     * 1.编写一段程序，把"一站式门店运营服务平台"按单字符添加到HashSet中后，再删除"门店"两个字符，最后循环打印输出每一个字符。
     */
    public static void hashset() {
        String str = "一站式门店运营服务平台";
        HashSet<String> hashSet = new HashSet<>();
        int len = str.length();
        for (int i = 0; i < len; ++i) {
            String s = String.valueOf(str.charAt(i));
            hashSet.add(s);
        }

        System.out.println(hashSet.toString());

        hashSet.remove("门");
        hashSet.remove("店");
        System.out.println(hashSet.toString());
    }


    /**
     * 2.针对上面那段文字，删除并打印输出按自然排序的第一个字符和最后一个字符。
     */
    public static void treeset() {
        TreeSet<String> treeSet = new TreeSet<>();
        String str = "一站式门店运营服务平台";
        int len = str.length();
        for (int i = 0; i < len; ++i) {
            String s = String.valueOf(str.charAt(i));
            treeSet.add(s);
        }
        System.out.println(treeSet.toString());

        String first = treeSet.first();
        System.out.println("first: " + first);

        String last = treeSet.last();
        System.out.println("last: " + last);

        treeSet.remove(first);
        treeSet.remove(last);

        System.out.println("删除第一个和最后一个: " + treeSet.toString());
    }


    /**
     * 3.编写一段程序，统计这段文字"This class implements the <tt>Set</tt> interface, backed by a hash
     *  table(actually a <tt>HashMap</tt> instance).  It makes no guarantees as to the iteration order of the set; in
     *  particular, it does not guarantee that the order will remain constant over time.  This class permits the
     *  <tt>null</tt> element."中不重复字符的数量。
     */
    public static void countNoRepeat() {
        String str = "This class implements the <tt>Set</tt> interface, backed by a hash table(actually a <tt>HashMap</tt> instance).  It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time.  This class permits the <tt>null</tt> element.";
        HashSet<Character> repeatSet = new HashSet<>();
        HashSet<Character> noRepeatSet = new HashSet<>();

        int len = str.length();
        for (int i = 0; i < len; ++i) {
            Character s = str.charAt(i);
            if (repeatSet.contains(s)) {
                noRepeatSet.remove(s);
            } else {
                repeatSet.add(s);
                noRepeatSet.add(s);
            }
        }

        System.out.println(repeatSet.toString());
        System.out.println(noRepeatSet.toString());
        System.out.println("不重复字符的数量: " + noRepeatSet.size());
    }


    /**
     * 4.编写一段程序，统计这段文字"This class offers constant time performance for the basic operations add
     *  * 	remove contains and size"中不重复词语的数量，并按序列打印输出。
     */
    public static void countNoRepeatWord() {
        String str = "This class offers constant time performance for the basic operations add remove contains and size";
        String[] strings = str.split(" ");
        System.out.println(Arrays.toString(strings));

        HashSet<String> repeatSet = new HashSet<>();
        HashSet<String> noRepeatSet = new HashSet<>();

        for (String s: strings) {
            if (repeatSet.contains(s)) {
                noRepeatSet.remove(s);
            } else {
                repeatSet.add(s);
                noRepeatSet.add(s);
            }
        }
        System.out.println(repeatSet.toString());
        System.out.println(noRepeatSet.toString());
        System.out.println("不重复词语的数量: " + noRepeatSet.size());
    }


    public static void goods() {
        Goods g1 = new Goods();
        g1.setId(1);
        g1.setName("珍珠奶茶");
        g1.setCategory(1);
        g1.setCreateTime("2020-10-20 12:00:00");
        System.out.println(g1.toString());

        Goods g2 = new Goods();
        g2.setId(2);
        g2.setName("珍珠奶茶2");
        g2.setCategory(1);
        g2.setCreateTime("2020-10-20 13:00:00");
        System.out.println(g2.toString());

        Goods g3 = new Goods();
        g3.setId(3);
        g3.setName("珍珠奶茶3");
        g3.setCategory(1);
        g3.setCreateTime("2020-10-20 14:00:00");
        System.out.println(g3.toString());

        TreeSet<Goods> treeSet = new TreeSet<>();
        treeSet.add(g1);
        treeSet.add(g2);
        treeSet.add(g3);

        System.out.println("Goods TreeSet: " + treeSet);
    }

}
