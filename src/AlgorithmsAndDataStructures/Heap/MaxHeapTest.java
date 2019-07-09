package AlgorithmsAndDataStructures.Heap;

/**
 * 利用 最大堆 找出 N 个元素中最小的 K个数
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        Integer[] arrT = {11,3,76,35,22,90,111,88,53};

        int k = 5;
        Integer[] data = new Integer[k];
        //创建一个大小为 K 的数组
        for (int i = 0; i < k; i++) {
            data[i] = arrT[i];
        }

        MaxHeap heap = new MaxHeap(data);
        for (int i = k; i < arrT.length; i++) {



        }

    }
}
