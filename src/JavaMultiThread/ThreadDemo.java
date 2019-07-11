package JavaMultiThread;

public class ThreadDemo extends Thread {

    private int count = 5;

    /*
    @Override
    public void  run(){                  //1 无 "synchronized"
        count--;
        System.out.println(currentThread().getName()+" count:"+count);
    }*/

    /*
    @Override
    public synchronized void  run(){    // 2 有 "synchronized"
        count--;
        System.out.println(currentThread().getName()+" count:"+count);
    }*/


    @Override
    public void run() {
        synchronized (this) {     //synchronized后面括号里是一对象,此时,线程获得的是对象锁
            count--;
            System.out.println(currentThread().getName() + " count:" + count);
        }
    }

    public static void main(String[] args) {
        ThreadDemo myThread = new ThreadDemo();

        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");
        Thread thread3 = new Thread(myThread, "thread3");
        Thread thread4 = new Thread(myThread, "thread4");
        Thread thread5 = new Thread(myThread, "thread5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
