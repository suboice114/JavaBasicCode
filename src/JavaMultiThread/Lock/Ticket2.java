package JavaMultiThread.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟出票系统  多线程实现
 * <p>
 * 锁使用：ReentrantLock
 */
public class Ticket2 implements Runnable {


    //初始车票数共10张（共享资源）
    int ticketNum = 10;

    private ReentrantLock rLock = new ReentrantLock();


    @Override
    public void run() {

        if (ticketNum > 0) {

            try {
                Thread.sleep(10);
                rLock.lock();
                try {
                    System.out.println("currentName: " + Thread.currentThread().getName()
                            + "     余票： " + (--ticketNum));
                } finally {
                    rLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
