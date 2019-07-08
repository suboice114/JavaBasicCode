package JavaMultiThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单一线程数的线程池
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 20; i++) {
            singleThreadExecutor.execute(new WorkTask());
        }
        singleThreadExecutor.shutdown();
    }
}
