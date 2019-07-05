package JavaDesignPatterns.Proxy;

/**
 * 检测方法执行时间的工具类
 */
public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start(){
        tl.set(System.currentTimeMillis());
    }

    public static void finish(String methodName){
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName+"方法 耗时"+ (finishTime - tl.get()) +"ms") ;

    }
}
