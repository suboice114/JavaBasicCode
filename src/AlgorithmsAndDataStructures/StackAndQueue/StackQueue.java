package AlgorithmsAndDataStructures.StackAndQueue;

import java.util.Stack;

/**
 * 用 栈 实现 队列:
 * <p>
 * 可以用一个栈作为入队，另一个栈作为出队。
 * 只要把第一个栈的栈顶的元素压入第二个栈就好了，出队的时候输出第二个栈的栈顶，
 * 如果第二个栈的空了就需要不断操作从第一个栈的栈顶压入第二个栈，
 * 但是如果第一个栈也空了，那就说明所有元素都输出来了。
 * 栈  ：后入先出 （入栈+出栈）
 * 队列：先入先出  （入队+出对）
 */
public class StackQueue {

    // 作为入队序列
    private Stack<Integer> stack1 = new Stack<Integer>();

    //作为出队序列
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //入队时，要保证stack2为空
        while (!stack2.empty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
        stack1.push(node);
        System.out.println("入队元素是:" + stack1.peek());

    }

    public int pop() {
        // 出队时，要保证stack1为空
        while (!stack1.empty()) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        System.out.println("出队元素是:" + stack2.peek());
        int temp = stack2.peek();
        stack2.pop();
        return temp;
    }


    public static void main(String[] args) {
        StackQueue so = new StackQueue();
        so.push(1);
        so.push(2);
        so.push(3);

        so.pop();
        so.pop();
        so.push(4);
        so.pop();
        so.push(5);
        so.pop();
    }
}
