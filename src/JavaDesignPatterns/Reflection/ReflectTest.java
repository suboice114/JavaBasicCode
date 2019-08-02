package JavaDesignPatterns.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射
 */
public class ReflectTest {

    public static void main(String[] args) {

        Class<People> peopleClass = People.class;   //通过类名获取Class对象
        System.out.println(peopleClass);

        //通过反射获取类的构造器并创建对象
        try {
            Constructor<People> constructor = peopleClass.getConstructor(String.class, int.class);
            People people = constructor.newInstance("Bill", 19);
            people.speak();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Student student = new Student("Bool", 18);

        //获取Student中的方法
        Method[] methods = student.getClass().getDeclaredMethods();
        for (Method m: methods) {
            System.out.println("declared method name: "+m.getName());
        }
        //获取Student中定义的所有属性
        Field[] fields = student.getClass().getDeclaredFields();
        for (Field field: fields) {
            System.out.println("declared field name: "+field.getName());
        }

        try {
            //获取learnMethod对象（封装了learn方法）
            Method learnMethod = student.getClass().getDeclaredMethod("learn", String.class);
            //获取learn方法的参数列表并打印出来
            Class<?>[] paramClasses  = learnMethod.getParameterTypes();
            for (Class<?>  classes: paramClasses) {
                System.out.println("learn 方法的参数类型："+classes.getName());
            }
            //判断learn方法是否为private
            System.out.println(learnMethod.getName()+" is private ："+ Modifier.isPrivate(learnMethod.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            // 获取指定的属性
            Field gradeField = student.getClass().getDeclaredField("grade");
            System.out.println(gradeField.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
