package JavaMultiThread.ProducterAndCustomer;

public class Food {
    private String name;//菜名
    private String efficacy;//功效
    private boolean flag = true;

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public Food(String name, String efficacy) {
        super();
        this.name = name;
        this.efficacy = efficacy;
    }

    //synchronized 来管理food的生产和消费
    public synchronized void set(String name, String efficacy) {
        if (!flag) {  //消费状态，不允许生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产： " + name + " " + efficacy);

        this.setName(name);
        this.setEfficacy(efficacy);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = flag;//开始消费
        this.notify(); //唤起消费者线程
    }

    public synchronized void get() {
        if (flag) {  //true是生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + "消费——> " + this.getEfficacy());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true; //开始生产
        this.notify();
    }
}
