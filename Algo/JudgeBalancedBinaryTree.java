package Algo;

import common.TreeNode;

/**
 * @program: AlgorithmDepository
 * @description: 判断平衡二叉树
 * @author: PlusL
 * @create: 2022-10-07 12:09
 **/
public class JudgeBalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
//        TreeNode l1 = head.left;
//        l1.left = new TreeNode(3);

        System.out.println(judgeBalance(head));

    }

    public static int judgeBalance(TreeNode node) {
        int left = depth(node.left);
        int right = depth(node.right);

        if (Math.abs(left - right) > 1 || Math.abs(left - right) < -1) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left + 1, right + 1);
    }

}
