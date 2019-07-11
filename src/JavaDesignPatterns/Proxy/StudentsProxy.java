package JavaDesignPatterns.Proxy;

/**
 * 学生代理类，也实现了Person接口
 */
public class StudentsProxy implements Person {

    Student stu;    //被代理的学生

    public StudentsProxy(Person stu) {
        //只代理学生对象
        if (stu.getClass() == Student.class) {
            this.stu = (Student) stu;
        }
    }

    //代理类 实行接口中方法 代收班费
    @Override
    public void giveMoney() {

        //代理类 在代理过程中 新增功能（操作）
        System.out.println("增强功能：在收取班费前，先表扬张三同学学习有进步！");

        stu.giveMoney();

        System.out.println("又新增功能：放学后去老师办公室领取小红花！");
    }
}
