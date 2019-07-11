package JavaMultiThread.Lock;

public class SynchronizedTest {

    public static void main(String[] args) {

        new SynchronizedTest().method1();
    }

    private void method1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("方法1获得synchronized的锁运行了");
            method2();
        }
    }

    private void method2() {
        synchronized (SynchronizedTest.class) {
            System.out.println("方法1中调用的方法2的重入锁执行了！");
        }
    }
}
