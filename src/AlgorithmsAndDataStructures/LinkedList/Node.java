package AlgorithmsAndDataStructures.LinkedList;

/**
 * 链表
 */
public class Node {

    Node next = null;   //下一个节点
    private int data;           //节点数据
    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
