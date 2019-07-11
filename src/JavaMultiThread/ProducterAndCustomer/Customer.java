package JavaMultiThread.ProducterAndCustomer;

/**
 * 消费者
 */
public class Customer implements Runnable {
    private Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {

            /*//等一下才可以吃哦！
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i=="+i+"现在开吃："+food.getName()+" 特点："+food.getEfficacy());
            */
            food.get();
        }
    }
}
