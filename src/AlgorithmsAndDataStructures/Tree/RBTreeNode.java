package AlgorithmsAndDataStructures.Tree;

/**
 *  红黑树 节点
 */
public class RBTreeNode {

    private final boolean RED = false;
    private final boolean BLACK = true;

    private boolean color;       // 颜色
    private int key;             // 关键字(键值)
    private RBTreeNode left;     // 左孩子
    private RBTreeNode right;    // 右孩子
    private RBTreeNode parent;   // 父结点

    public RBTreeNode(int key) {
        this.key = key;
        this.color = RED;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return  "key= "+key+" color= "+(this.color==RED?"(RED)":"BLACK");
    }

}
