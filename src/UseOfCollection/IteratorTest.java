package UseOfCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterator 测试
 */
public class IteratorTest {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

        //初始化值
        for (int i = 0; i < 10; i++) {
            list.add(new String("list"+i));

            hashMap.put(i,new String("map"+i));
        }

        //使用Iterator 迭代器遍历list
        Iterator<String> iteratorList = list.iterator();
        while (iteratorList.hasNext()){
            String strList = iteratorList.next();
            System.out.println(strList);
        }

        Iterator<Map.Entry<Integer, String>> iteratorMap = hashMap.entrySet().iterator();
        while (iteratorMap.hasNext()){
            Map.Entry<Integer, String> next = iteratorMap.next();
            System.out.println("key:"+next.getKey()+"  value:"+next.getValue());
        }

    }
}
