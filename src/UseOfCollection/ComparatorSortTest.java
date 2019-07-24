package UseOfCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Comparator接口实现排序
 *      对任意类型集合对象进行整体排序
 * 重要方法：    int compare(T o1, T o2);
 *           返回正数，零，负数各代表大于，等于，小于。
 */
public class ComparatorSortTest {

    public static void main(String[] args) {

        ArrayList<Student> slist = new ArrayList<>();
        slist.add(new Student("流云",25));
        slist.add(new Student("任飞",18));
        slist.add(new Student("子涧",20));
        slist.add(new Student("叶扬",22));

        //（单一条件排序）对 student 按照 年龄进行排序
        Collections.sort(slist, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                //升序排序 (相同结果)
                return s1.getAge()-s2.getAge();
                //return s1.getAge().compareTo(s2.getAge());

                //降序排序
                // return s2.getAge() - s1.getAge();
                //return s2.getAge().compareTo(s1.getAge());

            }
        });

        System.out.println("年龄      姓名  ");
        for(Student s : slist){
            System.out.println(s.getAge()+"       "+s.getName());
        }


        ArrayList<Student> slist1= new ArrayList<>();
        slist1.add(new Student("流云",25,8));
        slist1.add(new Student("任飞",18,11));
        slist1.add(new Student("子涧",20,3));
        slist1.add(new Student("叶扬",22,7));

        //（多条件排序）先按照年龄升序排序，再按照学号升序排序
        Collections.sort(slist1, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int flag;
                flag = s1.getAge() - s2.getAge();   //按年龄升序排序
                if (flag == 0){
                    flag = s1.getNum() - s2.getNum();  //按学号升序排序
                }
                return flag;
            }
        });


        System.out.println("年龄       学号       姓名  ");
        for(Student s : slist1){
            System.out.println(s.getAge()+"   "+s.getNum()+"   "+s.getName());
        }
    }


}


class Student{
    private String name;
    private Integer age;
    private Integer num;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age, Integer num) {
        this.name = name;
        this.age = age;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}