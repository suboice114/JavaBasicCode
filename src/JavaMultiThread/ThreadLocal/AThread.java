package JavaMultiThread.ThreadLocal;

public class AThread implements Runnable{

   private static ThreadLocal<Integer> threadLocal =   new ThreadLocal<>();


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            threadLocal.set(i);

            System.out.println(Thread.currentThread().getName()+ " threadLocal.get() = " + threadLocal.get());

        }
    }
}
