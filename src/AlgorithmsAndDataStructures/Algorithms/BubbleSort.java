package AlgorithmsAndDataStructures.Algorithms;

/**
 * 冒泡排序 (交换数据)
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {4,5,11,8,3,9,18,34,2,56};

        bubbleSort(arr);

        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i=0;i<arr.length;i++){         //外层控制循环次数
            for (int j=0;j<arr.length-1-i;j++){ //内存循环实现两个数的比较
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
