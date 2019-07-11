package JavaMultiThread.ThreadDeadLook;

/**
 * 一个简单的线程死锁：
 * 通过sleep()方法，可以实现主线程持有a的对象锁并请求b的对象锁、
 * 副线程持有b的对象锁并请求a的对象锁的场景，即发生死锁。
 * <p>
 * 主线程：正在执行a的等待方法，持有a的对象锁
 * 副线程：正在执行b的等待方法，持有b的对象锁
 * 主线程: 试图调用b的死锁方法，尝试获取b的对象锁
 * 副线程: 试图调用a的死锁方法，尝试获取a的对象锁
 */
public class ThreadDeadLockDemo implements Runnable {

    A a = new A();
    B b = new B();

    public void init() throws InterruptedException {
        Thread.currentThread().setName("主线程");
        a.waitMethod(b);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Thread.currentThread().setName("副线程");
        try {
            b.waitMethod(a);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDeadLockDemo deadLock = new ThreadDeadLockDemo();
        Thread thread = new Thread(deadLock);
        thread.start();
        deadLock.init();
    }
}
