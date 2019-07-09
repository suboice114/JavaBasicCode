package AlgorithmsAndDataStructures.Heap;

public class MinHeapDemo {
    public static void main(String[] args) {

        //最小堆 实现 topK（找出最大的K个数）
        topKByMinHeap();

        System.out.println("——————————————");

        //最小堆 实现 从大到小排序
        sortByMinHeap();

    }


    //找出最大三个数
    private static void topKByMinHeap() {

        int[] arrTopK = {18,5,60,6,23,90,218,133,88,15};

        int k = 3;
        //创建一个大小为 K 的数组
        int[] data = new int[k];
        for (int i = 0; i < k; i++) {
            data[i] = arrTopK[i];
        }

        MinHeap heap = new MinHeap(data);
        //如果大于堆顶的元素则替换顶并重新构造
        for (int i = k; i < arrTopK.length; i++) {
            int root = heap.getRoot();
            if(arrTopK[i] > root) {
                heap.setRoot(arrTopK[i]);
            }
        }
        //打印最大的k个数
        for(int i = 0; i < k; i ++){
            System.out.println(data[i]);
        }
    }



    private static void sortByMinHeap() {

        int[] arrSort = {90,3,60,6,7,2,89,100,33,5};

        MinHeap heap = new MinHeap(arrSort);
        for(int i = arrSort.length - 1;i > 0; i --){
            //把最小的元素移到末尾
            heap.swap(0,i);
            //重新构造最小堆
            heap.buildMinHeap(i);
        }
        //打印排序后的数组
        for(int i = 0; i < arrSort.length;i ++){
            System.out.println(arrSort[i]);
        }
    }
}
