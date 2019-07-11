package JavaMultiThread.ThreadDeadLook;

public class B {
    public synchronized void waitMethod(A a) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "：正在执行b的等待方法，持有b的对象锁");
        Thread.sleep(2000L);
        System.out.println(Thread.currentThread().getName() + ": 试图调用a的死锁方法，尝试获取a的对象锁");
        a.deadLockMethod();
    }

    public synchronized void deadLockMethod() {
        System.out.println(Thread.currentThread().getName() + ": 正在执行b的死锁方法，持有b的对象锁");
    }
}
