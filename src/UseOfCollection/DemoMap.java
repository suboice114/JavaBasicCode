package UseOfCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DemoMap {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "asdfghkl");
        map.put(2, "dfghh");
        map.put(3, "hgyhddsf");

        /**
         * get()方法
         *      public V get(Object key) {
         *         Node<K,V> e;
         *         return (e = getNode(hash(key), key)) == null ? null : e.value;
         *      }
         */
        System.out.println(map.get(4)); //null


        /**
         * 遍历map 一 : 使用keySet + Iterator遍历
         */
        Set<Integer> ks = map.keySet();
        Iterator<Integer> it = ks.iterator();

        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println("key=" + key + " value=" + value);
        }


        /**
         * 遍历map 二 ：在for-each循环中遍历keys或values。单独获取key 和value 值
         */

        for (Integer key : map.keySet()) {
            System.out.println("key:" + key);
        }

        for (String value : map.values()) {
            System.out.println("value:" + value);
        }


        /**
         * 遍历map：三 使用 map.entrySet()
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            System.out.println("key:" + entry.getKey() + " value=" + entry.getValue());
        }


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


    }
}
