package UseOfCollection;

import java.util.ArrayList;

public class RemoveTheSpecifiedElement {
    public static void main(String[] args) {

        ArrayList<String> alist = new ArrayList<>();
        alist.add("adf");
        alist.add("ghj");
        alist.add("klp");
        alist.add("oiu");
        alist.add("nbv");
        alist.add("xvc");
        alist.add("zxc");


        /*for (int i = 0; i < 3 ; i++) {  //移除前三个元素
            alist.remove(0);
        }

         */

        for (int i = 0; i < 3; i++) {     //移除后三个元素
            alist.remove(alist.size()-1);
        }


        for (int i = 0; i < alist.size() ; i++) {
            System.out.println(alist.get(i));
        }
    }
}
