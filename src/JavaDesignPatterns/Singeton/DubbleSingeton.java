package JavaDesignPatterns.Singeton;

/**
 * 加锁的 单例模式 （“双重检查锁” --->
 * 双重锁验证需要将对象申明为 volatile 不然会因为指令重排序
 * 而导致在第一个判空时 将未初始化的对象返回）
 */
public class DubbleSingeton {

    private DubbleSingeton() {
    }

    ;

    private static volatile DubbleSingeton instance;    //volatile 关键字

    public static DubbleSingeton getInstance() {

        if (instance == null) {
            try {
                //模拟初始化对象的准备时间....
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //类加上锁 表示当前对象不可以在其他线程执行时创建
            synchronized (DubbleSingeton.class) {
                //如果不加这一层判断  每个线程都会得到一个实例 而不是所有线程得到的是一个实例
                if (instance == null) {
                    instance = new DubbleSingeton();
                }
            }

        }

        return instance;
    }
}
