package LeetCode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmDepository
 * @description: 从上到下打印二叉树_II
 * @author: PlusL
 * @create: 2022-10-11 21:36
 **/
public class LeetCodeOffer_32_II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 与前一题差别不大，只是由答应到一行改为了分行打印
        if (root == null) {
            return null;
        }

        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
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
