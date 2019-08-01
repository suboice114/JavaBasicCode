package UseOfCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {

        testArrayList();

        System.out.println("===========");

        testLinkedList();
    }



    private static void testArrayList() {
        ArrayList list = new ArrayList();
        list.add("ad");
        list.add("23");
        list.add("ert");
        list.add("23");
        list.add("23");
        list.add("ggf");
        list.add("uyi");

        System.out.println("原list："+list);
        System.out.println("长度："+list.size());

        list.set(1,"fg");   //替换index为1的元素值
        System.out.println("替换索引1值后，list："+list);

        System.out.println("list中是否包含'ad':"+list.contains("ad"));

        System.out.println("list是否为空："+list.isEmpty());

        System.out.println("截取list，索引为1，2的值："+list.subList(1,3));

        //使用 Iterator 遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.print(next+" ");
        }
        System.out.println("");

        //使用 for循环 遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"  ");
        }
        System.out.println("");

        //移除list已知的重复元素
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("23")){
                list.remove(list.get(i));
            }
        }
        System.out.println(list);

        //移除list重复元素
        list.add("23");
        list.add("uyi");
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i  ; j--) {
                if (list.get(j).equals(list.get(i))){
                    list.remove(j);
                }
            }
        }
        System.out.println(list);

    }


    private static void testLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(linkedList.isEmpty());
        linkedList.add("lk");
        linkedList.add("mn");
        linkedList.add("po");
        linkedList.add("oi");
        linkedList.addFirst("abc");
        linkedList.addLast("xyz");
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
    }

}
