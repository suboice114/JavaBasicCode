package AlgorithmsAndDataStructures.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 将一个二叉树 转换成其  镜像
 *      8              8
 *   6   10    ->   10     6
 * 5  7 9  11    11   9  7   5
 *
 * 思路：使用递归
 *  从根部开始遍历，如果有子节点，则交换两个子节点，
 *  当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
 */
public class MirrorBinaryTree {

    public void MirrorTree(TreeNode root){

        //当传入内容为空
        if (root == null){
            System.out.println("二叉树为空！");
            return;
        }

        //只有 当两个子节点同时为空时不进行换位 ;否则 换位
        if (root.leftNode == null && root.rightNode == null){
            return;
        }else {

            //左右换位操作
            TreeNode temp = root.leftNode;
            root.leftNode = root.rightNode;
            root.rightNode = temp;

            //左节点作为新的根节点进行递归
            if (root.leftNode != null){
                MirrorTree(root.leftNode);
            }

            //右节点作为新的根节点进行递归
            if (root.rightNode != null){
                MirrorTree(root.rightNode);
            }
        }
    }

    //二叉树
    static class TreeNode{

        private int data;
        private TreeNode leftNode; //左节点
        private TreeNode rightNode;//右节点

        public TreeNode(int data){
            this.data = data;
        }
    }

    //输出一颗数上的值（从根节点开始）
    public ArrayList<Integer> printTreeFromTop(TreeNode root){

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            list.add(treeNode.data);
            if (treeNode.leftNode != null) {
                queue.add(treeNode.leftNode);
            }
            if (treeNode.rightNode != null)	{
                queue.add(treeNode.rightNode);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.leftNode = new TreeNode(6);
        root.rightNode = new TreeNode(10);

        root.leftNode.leftNode = new TreeNode(5);
        root.leftNode.rightNode = new TreeNode(7);

        root.rightNode.leftNode = new TreeNode(9);
        root.rightNode.rightNode = new TreeNode(11);

        MirrorBinaryTree mbTree = new MirrorBinaryTree();

        ArrayList<Integer> list = mbTree.printTreeFromTop(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }

        mbTree.MirrorTree(root);

        System.out.println("    ");
        System.out.println("镜像为：");

        ArrayList<Integer> list1 = mbTree.printTreeFromTop(root);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + ",");
        }
    }

}
