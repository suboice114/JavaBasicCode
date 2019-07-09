package JavaMultiThread.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模拟一个队列 拥有一个data成员变量用于存储数据和存取两种操作。
 */
public class DefQueue {
    private int data;

    private  ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();

    //获取数据
    public void get(){

        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" be ready to get data");

            Thread.sleep((long) Math.random()*1000);

            System.out.println(Thread.currentThread().getName()+" get the data:  "+data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
    }

    //存入数据
    public void put(int data){

        rwl.writeLock().lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + " be ready to write data");

            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;

            System.out.println(Thread.currentThread().getName() + " has wrote the data: "+data);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally
        {
            rwl.writeLock().unlock();//释放写锁
        }
    }

}
