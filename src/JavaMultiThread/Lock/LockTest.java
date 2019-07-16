package JavaMultiThread.Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁和悲观锁的测试
 */
public class LockTest {

    //value1:不使用锁 线程不安全
    private static int value1 = 0;
    /**
     * value2 :使用乐观锁
     * （AtomicInteger 底层通过Unsafe类实现，基于CAS [java.util.concurrent.atomic包提供的原子类]）
     */
    private static AtomicInteger value2 = new AtomicInteger(0);
    //value3: 使用悲观锁
    private static int value3 = 0;
    private static synchronized void increaseValue3(){
        value3++;
    }

    public static void main(String[] args) throws Exception {

        //开启1000个线程，并进行自增操作
        for (int i = 0; i < 1000; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    value1++;
                    value2.getAndIncrement();
                    increaseValue3();
                }
            }).start();
        }


        //打印结果
        Thread.sleep(1000);
        System.out.println("value1="+value1);
        System.out.println("value2="+value2);
        System.out.println("value3="+value3);
    }
}
