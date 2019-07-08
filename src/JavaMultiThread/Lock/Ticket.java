package JavaMultiThread.Lock;

/**
 * 模拟出票系统，多线程实现
 *
 * 锁使用： synchronized
 */
public class Ticket implements Runnable{

    //初始时 有10张票 （共享资源）
    int  tickNum = 10;

    @Override
    public void run() {

        synchronized (this){    //增加 synchronized 锁 ，同步代码块

            //如果该有余票 进行出票操作
            if(tickNum>0){
                try {
                    Thread.sleep(10);
                    System.out.println("currentName:"+Thread.currentThread().getName()
                                        +"   余票："+(--tickNum));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
