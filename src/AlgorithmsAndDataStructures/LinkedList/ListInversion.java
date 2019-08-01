package AlgorithmsAndDataStructures.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class ListInversion {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        ArrayList<Integer> arrayList = printLinkListFromTailToHeadByStack(node);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList1 = printLinkListFromTailToHeadByCollections(node);
        System.out.println(arrayList1);
    }


    /**
     * 1.利用栈 后进先出的特性，将链表的值先push堆栈，然后在一一将值pop到ArrayList集合中输出
      * @param node
     * @return
     */
    private static ArrayList<Integer> printLinkListFromTailToHeadByStack(Node node) {

        Stack<Integer> stack = new Stack<>();
        while (node != null){
            stack.push(node.getData());
            node = node.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


    /**
     * 2. 利用Collections集合的API方法reverse()可以反转集合中的数值
     * @param node
     * @return
     */
    private static ArrayList<Integer> printLinkListFromTailToHeadByCollections(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null){
            list.add(node.getData());
            node = node.next;
        }
        if (list != null && list.size() > 0) {
            Collections.reverse(list);
        }

        return list;
    }

}
