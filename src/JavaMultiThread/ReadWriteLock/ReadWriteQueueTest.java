package JavaMultiThread.ReadWriteLock;

import java.util.Random;

public class ReadWriteQueueTest {

    public static void main(String[] args) {

        DefQueue queue = new DefQueue();

        for (int i = 1; i < 9; i++){
            //启动线程进行读操作
            new Thread(new Runnable(){
                @Override
                public void run(){
                    while (true){
                        queue.get();
                    }
                }

            }).start();

            //启动线程进行写操作
            new Thread(new Runnable(){
                @Override
                public void run(){
                    while(true){
                        queue.put(new Random().nextInt(10000));
                    }
                }
            }).start();
        }
    }
}
