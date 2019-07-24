package UseOfStringClass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays.sort() 方法：
 *  参数是基本数据类型时：快速排序
 *  参数是对象Object时： 归并排序
 */
public class ArraysSortTest {
    public static void main(String[] args) {

        int[] arr = new int[]{12,55,67,9,134,8};

        /**
         * 1  Arrays.sort(array):只能适用于数组在创建时就初始化的情况，
         *                       默认将数组升序排序。
         */
         Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }

        System.out.println("");


        /**
         *2 Arrays.sort(array,c): array必须是基础类型的包装类，并在创建时就初始化。
         *                        c；实现了Comparator接口的类的对象c。
         *  如下实现可倒序排序
         */
        Integer[] arrI = new Integer[]{10,9,21,16,50,88,11,70};
        Arrays.sort(arrI, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });

        for (int j = 0; j < arrI.length; j++) {
            System.out.print(arrI[j]+"  ");
        }

    }
}
