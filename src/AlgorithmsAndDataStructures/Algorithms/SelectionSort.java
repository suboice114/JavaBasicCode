package AlgorithmsAndDataStructures.Algorithms;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4,6,3,8,9,11,54,23,10};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j <arr.length; j++) {
                if (arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
