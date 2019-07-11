package UseOfStringClass;

/**
 * String 类
 */
public class Demo1 {

    public static void main(String[] args) { //快捷键：psv -- main 函数

        /**
         * 情景一：字符串池
         * JAVA虚拟机(JVM)中存在着一个字符串池，其中保存着很多String对象;
         * 并且可以被共享使用，因此它提高了效率。
         * 由于String类是final的，它的值一经创建就不可改变。
         * 字符串池由String类维护，我们可以调用intern()方法来访问字符串池。
         */

        String s1 = "asdfghjkl";

        String s2 = "asdfghjkl";

        System.out.println("s1=s2:" + (s1 == s2));

        System.out.println("s1.equals(s2):" + (s1.equals(s2)));

        /**
         * 情景二：关于 new String("")
         */
        String s3 = new String("asdfghjkl");

        String s4 = new String("asdfghjkl");

        System.out.println("s3=s4:" + (s3 == s4));

        System.out.println("s3.equals(s4):" + (s3.equals(s4)));

        System.out.println("s1=s3:" + (s1 == s3));

        System.out.println("s1.equals(s3):" + (s1.equals(s3)));


        String s5 = "asdf" + "ghjkl";
        System.out.println("s1=s5:" + (s1 == s5));

        /**
         *  情景四： *******
         *      局部变量str6,str7存储的是存储两个符串对象的地址。
         *
         *      第三行代码原理(str6+str7)：
         *                  运行期JVM首先会在堆中创建一个StringBuilder类， 同时用str6指向的拘留字符串对象完成初始化，
         *                  然后调用append方法完成对str7所指向的拘留字符串的合并，
         *                  接着调用StringBuilder的toString()方法在堆中创建一个String对象，
         *                  最后将刚生成的String对象的堆地址存放在局部变量str8中。
         *
         *      而str9存储的是字符串池中"qwertyui"所对应字符串对象的地址
         *      。
         *      str8与str9地址当然不一样了。
         *
         *  内存中实际上有五个字符串对象：
         *  三个字符串对象、一个String对象和一个StringBuilder对象。
         */
        String str6 = "qwer";
        String str7 = "tyui";
        String str8 = str6 + str7;
        String str9 = "qwertyui";
        System.out.println("str8=str9:" + (str8 == str9));
        System.out.println("str8.equals(str9)：" + (str8.equals(str9)));


        /**
         * String method
         * 常用的： split();subString();length();isEmpty();trim();大小写转换；等等
         */

        String str = "poi,uyt,rew,qll";

        String[] split = str.split(",");    //自动补全变量名称 : Ctrl + Alt + v
        System.out.println("split[0]:" + split[0]);

        String subStr1 = str.substring(4);
        System.out.println("subStr1:" + subStr1);

        String subStr2 = str.substring(4, 8);
        System.out.println("subStr2:" + subStr2);


        /**
         * String类是不可改变的，一旦创建了String对象，那它的值就无法改变了。   （字符串常量 ）
         * 如果需要对字符串做很多修改，那么应该选择使用StringBuffer & StringBuilder 类。（字符串变量）
         *
         * String类中使用字符数组保存字符串， 如下就是，因为有“final”修饰符，所以可以知道string对象是不可变的。
         *
         *          private final char value[];
         *
         * StringBuilder与 StringBuffer都继承自 AbstractStringBuilder 抽象类，
         *  在 AbstractStringBuilder 中也是使用字符数组保存字符串，如下就是，可知这两种对象都是可变的。
         *
         *          char[] value;
         *
         *
         * 在这方面运行速度快慢为：StringBuilder > StringBuffer > String
         *
         * 在线程安全上，String中的对象是不可变的，也就可以理解为常量，显然线程安全。
         * StringBuilder是线程不安全的，而StringBuffer是线程安全的 （StringBuffer中很多方法可以带有synchronized关键字）
         *
         * 总结： String：适用于少量的字符串操作的情况
         * 　　   StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
         * 　　   StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
         *
         * String、StringBuffer、StringBuilder三个类都由 final修饰。是不可被继承的。
         */

        StringBuilder sbd = new StringBuilder();
        String sbdStr = sbd.append("zxc").append("vbnm").toString();
        System.out.println("sbdStr:" + sbdStr);


        StringBuffer sbf = new StringBuffer();
        String sbfStr = sbf.append("iop").append("dfhgj").toString();
        System.out.println("sbfStr:" + sbfStr);


    }

}
