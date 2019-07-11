package JavaMultiThread.ThreadDeadLook;

public class A {

    public synchronized void waitMethod(B b) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "：正在执行a的等待方法，持有a的对象锁");
        Thread.sleep(2000L);
        System.out.println(Thread.currentThread().getName() + ": 试图调用b的死锁方法，尝试获取b的对象锁");
        b.deadLockMethod();
    }

    public synchronized void deadLockMethod() {
        System.out.println(Thread.currentThread().getName() + ": 正在执行a的死锁方法，持有a的对象锁");
    }
}
