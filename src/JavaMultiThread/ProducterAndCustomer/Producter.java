package JavaMultiThread.ProducterAndCustomer;

/**
 * 生产者
 */
public class Producter implements Runnable {
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) { //偶数 生产xx菜
               /*
                System.out.println("i=="+i+"是偶数！要准备做鱼香肉丝啦！");

                food.setName("鱼香肉丝");
                //增加做菜时间
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                food.setEfficacy("好吃！");
                */
                food.set("鱼香肉丝", "好吃");

            } else { //奇数 生产xx菜

                /*
                System.out.println("i=="+i+"是奇数！要准备脆皮鸭啦！");

                food.setName("脆皮鸭");
                //增加做菜时间
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                food.setEfficacy("香脆！");
                */
                food.set("脆皮鸭", "香脆");
            }

        }

    }
}
