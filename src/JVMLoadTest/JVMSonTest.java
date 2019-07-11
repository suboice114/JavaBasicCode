package JVMLoadTest;

/**
 * 执行顺序：
 * <p>
 * 1）加载Main方法， 先要加载包含Main方法的类
 * ，
 * 加载类就先加载父类静态变量， 静态代码块（按照书写先后顺序）--> 子类静态变量，静态代码块
 * <p>
 * 2） 执行main方法
 * <p>
 * 3) main 方法中调用有构造函数
 * <p>
 * 父类非静态代码块--> 父类构造函数-->子类非静态代码块-->子类构造函数
 */
public class JVMSonTest extends JVMParentTest {

    {
        System.out.println("son no static code block :" + count);
    }

    static {
        System.out.println("son static 1");

    }

    public static int count1;

    JVMSonTest() {

        System.out.println("son init:" + count);

    }

    static {
        System.out.println("son static 2");
    }

    public static void main(String[] args) {
        System.out.println("son main start");
        JVMSonTest a = new JVMSonTest();
    }

}
