package UseOfCollection;

import java.util.*;

public class DemoOthers {
    public static void main(String[] args) {

        /**
         * TreeMap 有序的 Map 实现类
         * 继承 AbstractMap 类，并且实现了 NavigableMap 接口。
         * 底层 通过 红黑树 实现，并保证有序性。
         */
        TreeMap<Integer, String> treeMap = new TreeMap<>();
 
        treeMap.put(10, "10");
        treeMap.put(83, "83");
        treeMap.put(15, "15");
        treeMap.put(72, "72");
        treeMap.put(20, "20");
        treeMap.put(60, "60");
        treeMap.put(30, "30");
        treeMap.put(50, "50");

        for (Map.Entry<Integer,String> entry: treeMap.entrySet()) {
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
        }

        /**
         * TreeSet : Set的一个子类, 提供有序的Set集合
         * 继承于AbstractSet抽象类，实现了 NavigableSet<E>,Cloneable,java.io.Serializable接口。
         *
         *      private transient NavigableMap<E,Object> m;
         *      private static final Object PRESENT = new Object();
         *      TreeSet(NavigableMap < E, Object > m) { this.m = m; }
         *
         * TreeSet集合是用来对象元素进行排序的。可以指定一个顺序, 对象存入之后会按照指定的顺序排列
         */
        TreeSet<String> treeSet = new TreeSet<String>();

        treeSet.add("dhfgd");
        treeSet.add("bmnbn");
        treeSet.add("d");
        treeSet.add("hd");
        System.out.println(treeSet);



        /**
         * HashSet 实现Set接口 ，允许使用null元素, 不允许有重复元素
         * 基于 HashMap实现的。
         *      HashSet中的元素都存放在HashMap的key上面，
         *      而value中的值都是统一的一个private static final Object PRESENT = new Object();
         * 即：
             private transient HashMap<E,Object> map;
             private static final Object PRESENT = new Object();
             public HashSet() { map = new HashMap<>();}

         HashSet中add方法调用的是底层HashMap中的put()方法

         */

        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

        HashSet<Integer> hashSet = new HashSet<Integer>();

    }
}
