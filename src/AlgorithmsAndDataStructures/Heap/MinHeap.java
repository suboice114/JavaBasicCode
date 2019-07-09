package AlgorithmsAndDataStructures.Heap;

/**
 * 最小堆
 */
public class MinHeap {

    private int[] data;          // 堆的存储结构 - 数组
    public MinHeap(int[] data){  // 将一个数组传入构造方法，并转换成一个小根堆
        this.data = data;
        buildMinHeap(data.length);
    }

    // 将数组转换成最小堆
    public void buildMinHeap(int heapSize) {
        for (int i = heapSize/2-1; i >= 0 ; i--) {
            heapify(i,heapSize);   //只有下标小于 ( length/2-1 )才子节点
        } 
    }

    private void heapify(int index, int heapSize) {
        int right = right(index);
        int left = left(index);

        int min = index;

        if(right < heapSize && data[right] < data[min]){
            min = right;
        }
        if(left < heapSize && data[left] < data[min]){
            min = left;
        }
        if(min == index){
            return;
        }
        swap(index,min);

        heapify(min,heapSize);
    }


    //左子树的下标
    private int left(int index) {
        return (index*2 + 1);
    }

    //右子树的下标
    private int right(int index) {
        return (index*2 + 2);
    }

    public void swap(int index1, int index2) {
       int temp =  data[index1];
       data[index1] = data[index2];
       data[index2] = temp;
    }

    public int getRoot(){
        return data[0];
    }

    public void setRoot(int root){
        data[0] = root;
        heapify(0, data.length);
    }
}
