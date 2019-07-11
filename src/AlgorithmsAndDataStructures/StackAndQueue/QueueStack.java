package AlgorithmsAndDataStructures.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用 队列 实现  栈
 */
public class QueueStack {

    private Queue<Integer> q1 = new LinkedList<Integer>(); //入栈

    private Queue<Integer> q2 = new LinkedList<Integer>(); //出栈

    //isEmpty
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }


    //push()
    public synchronized void push(Integer data) {
        q1.add(data);
    }

    //pop()
    public synchronized Integer pop() {
        if (q1.size() == 0) {
            System.out.println("栈为空！");
        }
        if (q1.size() == 1) {
            return q1.poll();
        } else {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            Integer tem = q1.poll();
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return tem;
        }
    }

    public static void main(String[] args) {

        QueueStack qs = new QueueStack();

        qs.push(13);
        qs.push(23);
        qs.push(11);

        System.out.println(qs.pop());
        System.out.println(qs.pop());

        qs.push(4);
        System.out.println(qs.pop());
        System.out.println(qs.pop());

    }

}
