package LeetCode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmDepository
 * @description: 从上到下打印二叉树——III
 * @author: PlusL
 * @create: 2022-10-11 21:51
 **/
public class LeetCodeOffer_32_III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 将LinkedList作为两端队列使用，奇数时尾插，偶数头插
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 奇数层，尾插
                if (res.size() % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }

}
