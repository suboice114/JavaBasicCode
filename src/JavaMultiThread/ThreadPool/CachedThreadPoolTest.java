package JavaMultiThread.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool
 * 无界线程池，最多可创建Integer.MAX_VALUE =  0x7fffffff 个线程，运行结果没有重复的线程号
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        /**
         * Executors类中的静态方法：
         * public static ExecutorService newCachedThreadPool() {
         *      return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                           60L, TimeUnit.SECONDS,
         *                          new SynchronousQueue<Runnable>());
         *
         *  接口 public interface ExecutorService extends Executor { .....}
         *
         *  类 public class Executors {......}
         *
         *  接口：
         *  public interface Executor{
         *       void execute(Runnable command);
         *  }
         */

        ExecutorService cachedThread = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            cachedThread.execute(new WorkTask());
        }
        cachedThread.shutdown();

    }
}
