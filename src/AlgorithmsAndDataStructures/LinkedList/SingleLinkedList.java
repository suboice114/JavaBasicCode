package AlgorithmsAndDataStructures.LinkedList;

public class SingleLinkedList {

    /**链表的头结点*/
    Node head = null;

     /**
     * 链表添加节点:找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
     * @param :data
     */
    public void addNode(int data){

        Node newNode  = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next!=null){
           temp =  temp.next;
        }
        temp.next = newNode;
    }


    /**
     * 链表删除节点:要删除结点的前结点指向要删除结点的后结点，即直接跳过待删除结点
     * @param index
     * @return
     */
    public boolean deleteNode(int index){

        if(index<1||index>length()){
            return false;
        }
        if(index == 1){//删除头结点
            head = head.next;
            return true;
        }
        Node preNode = head;
        Node curNode = preNode.next;
        int i = 1;
        while(curNode != null){
            if(i==index){   //寻找到待删除结点
                preNode.next = curNode.next;//待删除结点的前结点指向待删除结点的后结点
                return true;
            }
            //当先结点和前结点同时向后移
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }
        return true;
    }


    /**
     * 求链表的长度
     * @return
     */
    public int length(){
        int length = 0;
        Node curNode = head;
        while(curNode != null){
            length++;
            curNode = curNode.next;
        }
        return length;
    }


    /**
     * 打印结点
     */
    public void printLink(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.getData()+" ");
            curNode = curNode.next;
        }
        System.out.println();
    }


    /**
     * 链表结点排序,并返回排序后的头结点:
     * 选择排序算法,即每次都选出未排序结点中最小的结点，与第一个未排序结点交换
     */
    public Node linkSort(){
        Node curNode = head;
        while(curNode != null){
            Node nextNode = curNode.next;
            while(nextNode != null){
                if(curNode.getData() > nextNode.getData()){
                    int temp = curNode.getData();
                    curNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }


}
