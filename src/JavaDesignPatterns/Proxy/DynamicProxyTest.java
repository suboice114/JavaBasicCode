package JavaDesignPatterns.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 * （要实现java的动态代理，InvocationHandler接口和Proxy是必须要用到的）
 */
public class DynamicProxyTest {
    public static void main(String[] args) {

        //创建一个实例对象，这个对象是被代理的对象
        Person stu = new Student("张三");

        //创建一个与代理对象相关联的 InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(stu);

        //创建一个代理对象stuProxy来代理 stu
        //代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveMoney();
    }
}
