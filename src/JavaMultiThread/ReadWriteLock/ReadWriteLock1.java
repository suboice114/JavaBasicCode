package JavaMultiThread.ReadWriteLock;

/**
 * 读写锁的实现原理
 */
public class ReadWriteLock1 {
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    /**
     *  读锁：
     *      没有正在写的操作 或者 没有对资源有写的请求 时 ，可进行读取操作，获得读锁
     */

    public synchronized void lockRead() throws InterruptedException {

        if(writers > 0 || writeRequests > 0){
            wait();
        }

        readers++;
    }


    //释放读锁
    public synchronized void unlockRead(){

        readers--;

        notifyAll();
    }


    /**
     * 写锁：
     *  没有进行读操作 或者 写操作 时，获得写锁
     */
    public synchronized void lockWrite() throws InterruptedException{

        writeRequests++;    //想要获得写锁 写锁请求+1

        if (readers > 0 || writers >0){
            wait();
        }

        writeRequests--;
        writers++;
    }

    //释放写锁
    public synchronized void unlockWrite() throws InterruptedException{
        writers--;
        notifyAll();
    }
}
