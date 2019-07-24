package UseOfCollection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collection.sort()方法  （list元素以整数为例）
 */
public class CollectionsSortTest {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(8);
        list.add(54);
        list.add(67);
        list.add(212);

        /**
         * Collections.sort(list)：将列表元素进行升序排序.
         *      列表元素实现了Comparable接口，且任意两个列表元素都是可比的
         *      列表必须支持set方法
         *
         * public static <T extends Comparable<? super T>> void sort(List<T> list) {
         *         list.sort(null);
         *   }
         *
         */
        Collections.sort(list);   //升序排序
        System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());  //降序排序
        System.out.println(list);


    }
}
