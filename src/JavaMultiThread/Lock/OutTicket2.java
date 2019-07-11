package JavaMultiThread.Lock;

/**
 * 买票操作：
 * 使用 ReentrantLock
 */
public class OutTicket2 {
    public static void main(String[] args) {

        Ticket2 t = new Ticket2();

        Thread person1T = new Thread(t, "person1");
        Thread person2T = new Thread(t, "person2");
        Thread person3T = new Thread(t, "person3");
        Thread person4T = new Thread(t, "person4");
        Thread person5T = new Thread(t, "person5");
        Thread person6T = new Thread(t, "person6");

        person1T.start();
        person2T.start();
        person3T.start();
        person4T.start();
        person5T.start();
        person6T.start();


    }
}
