package JavaMultiThread.Lock;

/**
 * 买票操作:
 * 结果：未加锁 -> 出票结果存在增加情况
 *       synchronized -> 出票正常
 */
public class OutTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();   //创建共享资源

        Thread person1Thread = new Thread(ticket, "person1");
        Thread person2Thread = new Thread(ticket, "person2");
        Thread person3Thread = new Thread(ticket, "person3");
        Thread person4Thread = new Thread(ticket, "person4");
        Thread person5Thread = new Thread(ticket, "person5");
        Thread person6Thread = new Thread(ticket, "person6");
        Thread person7Thread = new Thread(ticket, "person7");


        //启动线程
        person1Thread.start();
        person2Thread.start();
        person3Thread.start();
        person4Thread.start();
        person5Thread.start();
        person6Thread.start();
        person7Thread.start();

    }
}
