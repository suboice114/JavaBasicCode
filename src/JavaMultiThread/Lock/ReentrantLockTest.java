package JavaMultiThread.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    //定义锁对象
    private ReentrantLock lock=new ReentrantLock();

    private void method1(){
        //获取锁，加锁
        lock.lock();
        try {
            //需要保证线程安全的代码
            System.out.println("方法1获得ReentrantLock锁运行了");
            method2();
        }finally {  //使用finally来保证锁的释放
          lock.unlock();
        }

    }

    private void method2() {

        lock.lock();
        try {
            System.out.println("方法1里面调用的方法2重入ReentrantLock锁,也正常运行了");
         }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        new ReentrantLockTest().method1();
    }
}

