package UseOfStringClass;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 检查数组中是否包含某个值
 */
public class ArrayContainsValue {
    public static void main(String[] args) {
        String[] arr = new String[]{"CD", "BC", "EF", "DE", "AB"};

        String value = "EF";

        boolean l = useList(arr, value);
        System.out.println("List 判断 数组arr中是否包含value值:" + l);


        boolean s = useSet(arr, value);
        System.out.println("Set 判断 数组arr中是否包含value值:" + s);


        boolean b = useLoop(arr, value);
        System.out.println("Loop 判断 数组arr中是否包含value值:" + b);
    }

    //1 使用List
    public static boolean useList(String[] arr, String targetValue) {
        boolean contains = Arrays.asList(arr).contains(targetValue);
        return contains;
    }

    //2 使用Set
    public static boolean useSet(String[] arr, String targetValue) {
        HashSet<String> set = new HashSet<>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    //3 使用循环
    public static boolean useLoop(String[] arr, String targetValue) {

        for (String s : arr) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }
}
