package AlgorithmsAndDataStructures.StringMatching;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个字符串 确定其中的 括号 是否匹配
 * 思路：
 * 1、将字符串的每个字符进行遍历
 * 2、如果发现是左括号，那么将该字符压入到栈中
 * 3、如果是右括号，先去存储好的栈顶找到相应的值
 * 4、若栈为空返回false，若匹配，pop该左括号，若不匹配也返回false
 * 5、最后看存储栈中的做括号是否都匹配上了，也就是栈最后为空，返回true，否则返回false
 */
public class StringMatchTest {

    public static boolean isMatch(String s) {

        //使用map定义左右字符串的对应关系
        Map<Character, Character> bracket = new HashMap<>();
        bracket.put(')', '(');
        bracket.put(']', '[');
        bracket.put('}', '{');

        Stack stack = new Stack();

        //遍历字符串S
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);  //先转换成字符

            //是否为左括号 -> 将 左括号 push到栈中
            if (bracket.containsValue(temp)) {
                stack.push(temp);

                //是否是右括号
            } else if (bracket.containsKey(temp)) {

                if (stack.isEmpty()) {   //栈为空 栈顶没有字符与右括号匹配
                    return false;
                }

                // 左右括号匹配
                if (stack.peek() == bracket.get(temp)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }


    public static void main(String[] args) {
        System.out.println(isMatch("(***)-[{-------}]"));   //true
        System.out.println(isMatch("(2+4)*a[5]"));          //true
        System.out.println(isMatch("({}[]]])"));            //false
        System.out.println(isMatch("())))"));               //false

    }
}
