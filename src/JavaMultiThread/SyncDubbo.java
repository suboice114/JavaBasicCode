package JavaMultiThread;

/**
 * 在一个 Synchronized 修饰的方法或代码块的内部调用本类的其他 Synchronized 修饰的方法或代码块时，
 * 是永远可以得到锁的
 */
public class SyncDubbo {
    public static void main(String[] args) {
        final SyncDubbo syncDubbo = new SyncDubbo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncDubbo.method1();
            }
        }).start();
    }


    public synchronized void method1() {
        System.out.println("method1 ————");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2 ————");
        method3();
    }

    public synchronized void method3() {
        System.out.println("method3 ————");
    }
}
