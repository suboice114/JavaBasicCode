package AlgorithmsAndDataStructures.Tree;

/**
 * 二叉树遍历(递归方式)
 */
public class BinaryTree {

    /**
     * 初始化：
     * 注意必须逆序建立，先建立子节点，再逆序往上建立，
     * 因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
     */
    public Node init(){

        Node I = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, I);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);

        //返回根节点
        return A;
    }

    public void printNode(Node node){
        System.out.println("节点值："+node.getData());
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(Node root){

        printNode(root);

        if (root.getLeftNode()!=null){  //使用递归进行遍历左节点值
            preOrderTraversal(root.getLeftNode());
        }

        if(root.getRightNode()!=null){ //使用递归进行遍历右节点值
            preOrderTraversal(root.getRightNode());
        }
    }


    /**
     * 中序遍历
     * @param root
     */
    public void InOrderTraversal(Node root){

        if(root.getLeftNode()!=null){
            InOrderTraversal(root.getLeftNode());
        }

        printNode(root);

        if (root.getRightNode()!=null){
            InOrderTraversal(root.getRightNode());
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(Node root){

        if(root.getLeftNode()!=null){
            postOrderTraversal(root.getLeftNode());
        }

        if(root.getRightNode()!=null){
            postOrderTraversal(root.getRightNode());
        }

        printNode(root);
    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Node root = tree.init();
        System.out.println("前序遍历:");
        tree.preOrderTraversal(root);
        System.out.println("");
        System.out.println("中序遍历：");
        tree.InOrderTraversal(root);
        System.out.println("");
        System.out.println("后序遍历：");
        tree.postOrderTraversal(root);
        System.out.println("");

    }

}
