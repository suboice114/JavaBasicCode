package UseOfCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ArrayList add()方法 出现线程不安全问题
 * 主函数执行结果；
 *      All task finished!
 *      list size is :99961
 * 最后输出的结果会小于我们的期望值。即当多线程调用add方法的时候会出现元素覆盖的问题。
 */
public class TestArrayListThreadSafe {

    private static List<Integer> list = new ArrayList<Integer>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(1000);

    private static class IncreaseTask extends Thread{
        @Override
        public void run() {
            System.out.println("ThreadId:" + Thread.currentThread().getId() + " start!");
            for(int i =0; i < 100; i++){
                list.add(i);
            }
            System.out.println("ThreadId:" + Thread.currentThread().getId() + " finished!");
        }
    }

    public static void main(String[] args) {

        for(int i=0; i < 1000; i++){
            executorService.submit(new IncreaseTask());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
            try {
                Thread.sleep(1000*10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("All task finished!");
        System.out.println("list size is :" + list.size());


    }

}
