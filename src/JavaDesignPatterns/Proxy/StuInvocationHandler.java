package JavaDesignPatterns.Proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建StuInvocationHandler类，实现InvocationHandler接口（可以做额外的工作）。
 *  这个类中持有一个被代理对象的实例target。
 * InvocationHandler中有一个invoke方法 ,所有执行代理对象的方法都会被替换成执行invoke方法。
 *
 * （实现InvocationHandler接口？
 *      因为代理类的实例在调用实现类的方法的时候，不会调真正的实现类的这个方法，而是转而调用这个类的invoke方法）
 * @param <T>
 */
public class StuInvocationHandler<T> implements InvocationHandler {

    private Object target;

    public StuInvocationHandler(Object target) {
        this.target = target;
    }


    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理执行："+method.getName()+" 方法。");

        MonitorUtil.start();                    //加入 MointorUtil 开始方法

        Object result = method.invoke(target, args);

        MonitorUtil.finish(method.getName());    //加入 MointorUtil 结束方法

        return result;
    }
}
