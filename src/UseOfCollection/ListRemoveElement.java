package UseOfCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 统计list中的重复元素 ； 删除 list中的重复元素
 */

public class ListRemoveElement {
    public static void main(String[] args) {

        List<String> alist = new ArrayList<String>();
        alist.add("abc");
        alist.add("bcd");
        alist.add("abc");
        alist.add("efg");

        //1 .统计list中重复元素的方法：使用Collections.frequency(Collection<?> c,Object o)
        int count = Collections.frequency(alist, "abc");
        System.out.println("abc出现的次数："+count);


        //2 去除list集合中重复元素
        removeList(alist);

        List list = removeDuplicate(alist);
        for (Object object : list) {
            System.out.println(object);
        }

        List list2 = removeDuplicate2(alist);
        for (Object object : list2) {
            System.out.println(object);
        }


    }


    /**
     * 方法一:使用HashSet
     * @param list
     */
    public static void removeList(List list) {
        HashSet<String> hashSet = new HashSet<String>(list);
        for (String string : hashSet) {
            System.out.println(string);
        }
    }

    /**
     * 方法二：使用双层for循环
     * @param alist
     * @return
     */
    public static List removeDuplicate(List alist) {
        for (int i = 0; i < alist.size() - 1; i++) {
            for (int j = alist.size() - 1; j > i; j--) {
                if (alist.get(j).equals(alist.get(i))) {
                    alist.remove(j);
                }
            }
        }
        return alist;
    }

    //方法三：把list里的对象遍历一遍，用list.contain()，如果不存在就放入到另外一个list集合中
    public static List removeDuplicate2(List list) {

        List listTemp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!listTemp.contains(list.get(i))) {
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }


}