package JavaMultiThread.ThreadLocal;

/**
 * ThreadLocal
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        AThread aThread = new AThread();

        Thread threadA = new Thread(aThread, "ThreadA");
        Thread threadB = new Thread(aThread, "ThreadB");
        Thread threadC = new Thread(aThread, "ThreadC");
        Thread threadD = new Thread(aThread, "ThreadD");
        Thread threadE = new Thread(aThread, "ThreadE");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();


    }

}
