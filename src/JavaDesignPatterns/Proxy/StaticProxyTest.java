package JavaDesignPatterns.Proxy;

/**
 * 静态代理测试
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Person stu = new Student("张三");     //被代理的学生张三

        Person monitor = new StudentsProxy(stu);    //生成代理对象

        monitor.giveMoney();            //代理对象 monitor 操作 收取班费
    }
}
