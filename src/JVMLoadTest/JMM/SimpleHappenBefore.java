package JVMLoadTest.JMM;

/**
 * Java的指令重排序问题：
 *
 * 一个简单的展示Happen-Before的例子.
 */
public class SimpleHappenBefore {

    /** 这是一个验证结果的变量 */
    private static int a=0;

    /** 这是一个标志位 */
    private static boolean flag=false;


    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i<100;i++){
            ThreadA threadA=new ThreadA();
            ThreadB threadB=new ThreadB();
            threadA.start();
            threadB.start();

            //这里等待线程结束后,重置共享变量,以使验证结果的工作变得简单些.
            threadA.join();
            threadB.join();

            a=0;
            flag=false;
        }

    }


    static class ThreadA extends Thread{

        @Override
        public void run() {
            a = 1;
            flag = true;
        }
    }

    static class ThreadB extends Thread{

        @Override
        public void run() {
            if (flag){
                a = a * 1;
            }
            if (a == 0){
                System.out.println("ha,a==0");
            }
        }
    }
}
