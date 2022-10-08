package LeetCode;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmDepository
 * @description: 1373. 二叉搜索子树的最大键值和
 * @author: PlusL
 * @create: 2022-09-05 21:58
 **/
public class LeetCode_1373 {

    Map<Integer, Integer> memory = new HashMap<>();

    public int maxSumBST(TreeNode root) {
        // 看到求子树的......，第一反应想到后序遍历
        traverse(root.left);
        traverse(root.right);
        return max;
    }

    int max = 0;
    int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traverse(node.left);
        int right = traverse(node.right);

        int total = left + right + node.val;
        memory.put(node.val, total);

        int maxValue = memory.get(node.val);
        if (total > maxValue) {
            max = node.val;
        }

        return total;
    }
}
