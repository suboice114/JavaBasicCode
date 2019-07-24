package UseOfCollection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Comparable接口 实现排序：
 *
 * 需要进行排序的对象实现Comparable接口，
 * 并重写其中的compareTo(T o)方法，在其中定义排序规则，
 * 之后就可以直接调用Arrays.sort()方法了。
 *
 *
 */
public class ComparableSortTest {

    public static void main(String[] args) {

        Person[] person = {
                new Person("张飒",18,100),
                new Person("王望",17,99),
                new Person("田甜",18,99),
                new Person("郑铮",16,97)};

        Arrays.sort(person);

        for(Person p: person){
            System.out.println(p);
        }
    }
}


class Person implements Comparable<Person>{

    private String name;
    private int age;
    private float score;

    public Person(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String toString()
    {
        return name+"\t\t"+age+"\t\t"+score;
    }

    /**
     * 按成绩由大到小排名，成绩相同时候按照年龄由低到高排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {

        if (this.score > o.score){
            return -1;  //由高到底排序
        }else if (this.score < o.score){
            return 1;
        }else {
            if(this.age > o.age)
                return 1;//由底到高排序
            else if(this.age < o.age)
                return -1;
            else
                return 0;
        }
    }
}