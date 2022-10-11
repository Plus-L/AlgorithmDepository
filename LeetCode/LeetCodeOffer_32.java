package LeetCode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmDepository
 * @description: 从上到下打印二叉树
 * @author: PlusL
 * @create: 2022-10-11 16:35
 **/
public class LeetCodeOffer_32 {

    public int[] levelOrder(TreeNode root) {
        //BFS宽度优先搜索，层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }


}
