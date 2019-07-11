package JVMLoadTest;

/**
 * 按顺序加载静态代码块；
 * 执行main方法。
 */
public class JVMTest {

    static {
        System.out.println("Main 方法所在类的静态代码块 static 1");
    }

    public static void main(String[] args) {

        System.out.println("main start!");
        A a = new A();
        System.out.println(A.width);
        System.out.println(a.width);
    }

    static {
        System.out.println("Main 方法所在类的静态代码块 static 2");
    }
}


class A {

    public static int width = 100;

    static {
        System.out.println("静态初始化类A");
        width = 30;
    }

    public A() {
        System.out.println("创建A类的对象");
    }
}