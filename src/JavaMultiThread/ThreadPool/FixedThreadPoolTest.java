package JavaMultiThread.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool
 * 固定线程数的线程池
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {

        //设置固定线程数的线程池 参数  nThreads the number of threads in the pool = 3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            fixedThreadPool.execute(new WorkTask());
        }
        fixedThreadPool.shutdown();
    }
}
