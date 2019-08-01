package AlgorithmsAndDataStructures.Algorithms;

import java.util.Scanner;

/**
 * 回文数：一种数字，如：12321, 这个数字正读是12321，倒读也是12321，
 * 即：将这个数的数字按相反的顺序重新排列后，所得到的数和原来的数一样
 */
public class PalindromeNumber {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();

        //方法1 转换成字符数组  使用数组翻转
        boolean result1 = ArrayReverse(input);

        //方法2 StringBuffer的 reverse()方法
        boolean result2 = StringBufferReverse(input);

        //方法3 字符串首尾对比
        boolean result3 = ForeTailContrast(input);

    }

    private static boolean ArrayReverse(String input) {
        char[] nums = input.toCharArray();
        String output = "";
        for (int i = nums.length; i > 0 ; i--) {
            output += nums[i - 1];
        }

        System.out.println("方法1  ==input== " + input);
        System.out.println("方法1  ==output== " + output);

        if (output.equals(input)){
            System.out.println("方法1：" + input + "是回文数！");
            return true;
        }else {
            return false;
        }
    }


    private static boolean StringBufferReverse(String input) {

        StringBuffer sbfInput = new StringBuffer(input);
        StringBuffer sbfOutput = sbfInput.reverse();
        String output = sbfOutput.toString();   //转换成字符串

        System.out.println("方法2  ==input== " + input);
        System.out.println("方法2  ==output== " + output);

        if (input.equals(output)){
            System.out.println("方法2：" + input + "是回文数！");
            return true;
        }else {
            return false;
        }
    }


    private static boolean ForeTailContrast(String str) {

        boolean result = false;
        for (int i = 0; i < str.length() / 2 ; i++) {
            if(str.charAt(i) == str.charAt(str.length() - 1 - i)){
                result = true;
            }else {
                return result;
            }
        }
        System.out.println("方法3：" + str + "是回文数！");
        return result;
    }

}
