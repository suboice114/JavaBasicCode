package JavaMultiThread.ProducterAndCustomer;

/**
 * 生产者-消费者线程
 */
public class ThreadDemo1 {
    public static void main(String[] args) {

        Food food = new Food();
        Producter producter = new Producter(food);
        Customer customer = new Customer(food);

        //开启两个线程执行生产者和消费者
        Thread threadP = new Thread(producter);
        Thread threadC = new Thread(customer);

        threadP.start();
        threadC.start();
    }
}
