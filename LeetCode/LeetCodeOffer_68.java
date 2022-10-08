package LeetCode;


import common.TreeNode;

/**
 * @program: AlgorithmDepository
 * @description: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @author: PlusL
 * @create: 2022-09-03 21:23
 **/
public class LeetCodeOffer_68 {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 前序位置查找想要找的 节点
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 后续位置判断，此时已知是否找到了结果，如果左右节点都为空，说明并没有找到（左右指针都到了叶子结点仍未返回）
        // 左右节点都不为空，说明已经找到了，直接返回这个节点
        if (left != null && right != null) {
            //当前节点为公共节点
            return root;
        }
        if (left == null && right == null) {
            return null;
        }

        //这里还有一种特殊情况，就是 p或者q 本身就是两人的公共节点，所以会有一方为空的情况
        return left == null ? right : left;

    }

}
