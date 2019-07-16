package AlgorithmsAndDataStructures.Tree;

public class RBTreeTest {

    private static final int arr[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};

    private static final boolean mDebugInsert = false;    // "插入"动作的检测开关(false，关闭；true，打开)
    private static final boolean mDebugDelete = false;    // "删除"动作的检测开关(false，关闭；true，打开)

    public static void main(String[] args) {

        int length = arr.length;

        RBTree tree = new RBTree();

        System.out.printf("== 原始数据: ");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");

        //插入数据
        for (int i = 0; i < length; i++) {
            tree.insert(arr[i]);
        }


        System.out.printf("== 前序遍历: ");
        tree.preOrderTraversal();


        System.out.printf("\n== 中序遍历：");
        tree.inOrderTraversal();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrderTraversal();
        System.out.printf("\n");


    }

}
