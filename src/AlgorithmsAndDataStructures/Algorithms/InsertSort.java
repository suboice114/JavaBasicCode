package AlgorithmsAndDataStructures.Algorithms;

/**
 * 直接插入排序 :当前元素和左边的元素比较，若当前元素小，就交换两者，也就相当于插入
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {3,5,4,7,11,23,45,10,6};

        int[] newArr = insertSort(arr);

        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]+"  ");
        }
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            int temp = arr[i];
            int j = i-1;
            for (; j > 0 && arr[j] > temp;j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
