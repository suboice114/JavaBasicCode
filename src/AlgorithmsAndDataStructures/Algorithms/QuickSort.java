package AlgorithmsAndDataStructures.Algorithms;


/**
 * 快速排序 （二分+交换思想）
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {6,1,2,2,7,9,3,10,8,15,22};
        quickSort(arr);
    }

    private static void quickSort(int[] arr) {
        sort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println("i="+i);
        }
    }

    private static void sort(int[] arr,int low,int high){

        if(low>high){
            return;
        }
        int i = low;    //数组第一位
        int j = high;   //数组最后一位

        int temp = arr[low];     //temp就是基准数

        int t;
        while (i < j) {
            //先看右边，依次往左递减
            while (temp<=arr[j] && i<j) {
                j--;
            }

            //再看左边，依次往右递增
            while (temp>=arr[i] && i<j) {
                i++;
            }

            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用左半数组
        sort(arr, low, j-1);

        //递归调用右半数组
        sort(arr, j+1, high);
    }

}
