package JavaMultiThread.ThreadPool;

/**
 * 任务
 */
public class WorkTask implements Runnable{


    @Override
    public void run() {

         try {

             int r = (int) (Math.random() * 10);
             Thread.sleep(r*1000);
             System.out.println(Thread.currentThread().getId()+"    is over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
