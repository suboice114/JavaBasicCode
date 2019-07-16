package AlgorithmsAndDataStructures.Tree;

/**
 * 红黑树
 */
public class RBTree{

    RBTreeNode root;    // 根结点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;


    private RBTreeNode parentOf(RBTreeNode node){
        return node != null ? node.getParent() : null;
    }

    private boolean colorOf(RBTreeNode node){
        return node != null ? node.getColor() : BLACK;
    }

    private boolean isBlack(RBTreeNode node) {
        if (node == null){
            return true;
        }
        return node.getColor() == BLACK;
    }

    private boolean isRed(RBTreeNode node) {
        if (node == null){
            return false;
        }
        return node.getColor() == RED;
    }

    private void setBlack(RBTreeNode node) {
        if (node != null){
            node.setColor(BLACK);
        }
     }

    private void setRed(RBTreeNode node) {
        if (node != null){
            node.setColor(RED);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal(){
        preOrder(root);
    }

    private void preOrder(RBTreeNode node) {
        if (node != null) {
            System.out.println(node.getKey() + "   ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 中序遍历
     */
    public  void inOrderTraversal(){
        inOrder(root);
    }

    private void inOrder(RBTreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getKey() + "   ");
            inOrder(root.getRight());
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        postOrder(root);
    }

    private void postOrder(RBTreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getKey()+ "   ");
        }
    }

    /**
     * 查找 红黑树 中键值为key的节点
     */
    public RBTreeNode searchNode(int key){
        RBTreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getKey() == key)
                return tmp;
            else if (tmp.getKey() > key)
                tmp = tmp.getLeft();
            else
                tmp = tmp.getRight();
        }
        return null;
    }

    /**
     * 新建节点 (键值为key) 插入到红黑树中
     */
    public void insert(int key){
        RBTreeNode node = new RBTreeNode(key); 
        if (root == null){
            root = node;
            root.setColor(BLACK);
            return;
        }

        RBTreeNode parent = root;
        RBTreeNode son = null;

        if (key <= parent.getKey()){
            son = parent.getLeft();
        }else{
            son = parent.getRight();
        }

        //while 循环 find  position
        while (son != null) {
            parent = son;
            if (key <= parent.getKey()){
                son = parent.getLeft();
            }else {
                son = parent.getRight();
            }
        }

        if (key <= parent.getKey()){
            parent.setLeft(node);
        }else {
            parent.setRight(node);
        }

        node.setParent(parent);

        //fix up tree
        insertFix(node);

    }

    /***
     * 插入重组
     * @param node
     */
    private void insertFix(RBTreeNode node) {
        
        RBTreeNode father, grandFather;
        
        while ((father = node.getParent()) != null && father.getColor() == RED) {
            grandFather = father.getParent();
            if (grandFather.getLeft() == father) {  //F为G左儿子的情况，如之前的分析
                RBTreeNode uncle = grandFather.getRight();
                if (uncle != null && uncle.getColor() == RED) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getRight()) {
                    leftRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                rightRotate(grandFather);
            } else {                               //F为G的右儿子的情况，对称操作
                RBTreeNode uncle = grandFather.getLeft();
                if (uncle != null && uncle.getColor() == RED) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getLeft()) {
                    rightRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                leftRotate(grandFather);
            }
        }
        setBlack(root); 

    }

    /**
     * 左旋
     * @param node
     */
    private void leftRotate(RBTreeNode node) {
        RBTreeNode right = node.getRight();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = right;
            right.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /**
     * 右旋
     * @param node
     */
    private void rightRotate(RBTreeNode node) {
        RBTreeNode left = node.getLeft();
        RBTreeNode parent = node.getParent();
        if (parent ==null){
            root = left;
            left.setParent(null);
        }else {
            if (parent.getLeft() != null && parent.getLeft() == node){
                parent.setLeft(left);
            }else {
                parent.setParent(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }


    /**
     * 删除键值为key的节点
     */
    public void delete(int key) {
        deleteNode(searchNode(key));
    }

    private void deleteNode(RBTreeNode node) {
        if (node == null)
            return;
        if (node.getLeft() != null && node.getRight() != null){

            RBTreeNode replaceNode = node;
            RBTreeNode tmp = node.getRight();

            while (tmp != null) {
                replaceNode = tmp;
                tmp = tmp.getLeft();
            }

            int t = replaceNode.getKey();
            replaceNode.setKey(node.getKey());
            node.setKey(t);
            deleteNode(replaceNode);
            return;
        }

        RBTreeNode replaceNode = null;
        if (node.getLeft() != null) {
            replaceNode = node.getLeft();
        }else{
            replaceNode = node.getRight();
        }

        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = replaceNode;
            if (replaceNode != null)
                replaceNode.setParent(null);
        } else {
            if (replaceNode != null)
                replaceNode.setParent(parent);
            if (parent.getLeft() == node)
                parent.setLeft(replaceNode);
            else {
                parent.setRight(replaceNode);
            }
        }

        if (node.getColor() == BLACK)
            removeFix(parent, replaceNode);

    }

    /**
     *  删除重组修正
     */
    private void removeFix(RBTreeNode father, RBTreeNode node) {

        while ((node == null || node.getColor() == BLACK) && node != root) {
            if (father.getLeft() == node) {  //S为P的左儿子的情况，如之前的分析
                RBTreeNode brother = father.getRight();
                if (brother != null && brother.getColor() == RED) {
                    setRed(father);
                    setBlack(brother);
                    leftRotate(father);
                    brother = father.getRight();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(brother.getRight()))) {
                    setRed(brother);
                    node = father;
                    father = node.getParent();
                    continue;
                }
                if (isRed(brother.getLeft())) {
                    setBlack(brother.getLeft());
                    setRed(brother);
                    rightRotate(brother);
                    brother = brother.getParent();
                }

                brother.setColor(father.getColor());
                setBlack(father);
                setBlack(brother.getRight());
                leftRotate(father);
                node = root;//跳出循环
            } else {                         //S为P的右儿子的情况，对称操作
                RBTreeNode brother = father.getLeft();
                if (brother != null && brother.getColor() == RED) {
                    setRed(father);
                    setBlack(brother);
                    rightRotate(father);
                    brother = father.getLeft();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(brother.getRight()))) {
                    setRed(brother);
                    node = father;
                    father = node.getParent();
                    continue;
                }
                if (isRed(brother.getRight())) {
                    setBlack(brother.getRight());
                    setRed(brother);
                    leftRotate(brother);
                    brother = brother.getParent();
                }

                brother.setColor(father.getColor());
                setBlack(father);
                setBlack(brother.getLeft());
                rightRotate(father);
                node = root;//跳出循环
            }
        }

        if (node != null){
            node.setColor(BLACK);
        }
    }

}
