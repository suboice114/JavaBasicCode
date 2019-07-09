package JavaMultiThread.ReadWriteLock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的简单测试
 */
public class ReadWriteLockTest {

    private static double data = 0;

    private static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();

    static class readClass implements Runnable{

        @Override
        public void run() {
            rwl.readLock().lock();
            System.out.println("获得读锁，开始读取数据："+data);
            rwl.readLock().unlock();  //释放读锁
        }
    }

    static class writeClass implements Runnable{

        private double i;
        public writeClass(double i) {
            this.i = i;
        }


        @Override
        public void run() {
            rwl.writeLock().lock();
            data = i;
            System.out.println("获得写锁，开始写数据："+data);
            rwl.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        ExecutorService pool = Executors.newCachedThreadPool();  //获取无界线程池

        for (int i = 0; i < 10; i++) {
            pool.submit(new readClass());
            pool.submit(new writeClass((double)new Random().nextDouble()));
            pool.submit(new writeClass((double)new Random().nextDouble()));
            Thread.sleep(1000);
        }
        pool.shutdown();
    }

}
