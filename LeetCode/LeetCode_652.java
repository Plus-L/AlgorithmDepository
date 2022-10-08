package LeetCode;


import common.TreeNode;

import java.util.*;

/**
 * @program: AlgorithmDepository
 * @description: 652. 寻找重复的子树
 * @author: PlusL
 * @create: 2022-09-05 20:18
 **/
public class LeetCode_652 {

    LinkedList<TreeNode> res = new LinkedList<>();
    Map<String, Integer> memory = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String left = traverse(node.left);
        String right = traverse(node.right);

        String serialize = left + "," + right + "," + node.val;

        int temp = memory.getOrDefault(serialize, 0);
        if (memory.get(serialize) == 1) {
            res.add(node);
        } else {
            memory.put(serialize, temp + 1);
        }
        return serialize;
    }
}
