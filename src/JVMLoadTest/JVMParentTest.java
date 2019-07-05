package JVMLoadTest;

public class JVMParentTest {

    public static int width = 100;

    public static int count;

    {
        System.out.println("parent no static code block :" + count);    //非静态代码块

    }

    static{
        System.out.println("parent static's count:" + count);           //静态代码块

    }

    JVMParentTest(int a){       //有参构造函数

        System.out.println("parent init one parameter");

    }

    JVMParentTest(){           //无参构造函数

        System.out.println("parent init");

    }

}
