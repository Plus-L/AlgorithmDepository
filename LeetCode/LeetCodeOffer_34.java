package LeetCode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmDepository
 * @description: 二叉树中和为某一值的路径 
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?favorite=xb9nqhhg
 * @author: PlusL
 * @create: 2022-10-22 22:23
 **/
public class LeetCodeOffer_34 {

    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //前序遍历，每找到一个存入列表
        if (root == null) {
            return resList;
        }

        traverse(root, target, new LinkedList<>());
        return resList;
    }

    private void traverse(TreeNode node, int sum, LinkedList<Integer> path) {
        if (node == null) {
            return;
        }

        int remain = sum - node.val;

        if (node.left == null && node.right == null) {
            if (remain == 0) {
                //找到一个符合条件的路径
                path.add(node.val);
                //存入结果集，注意这里不能直接把path丢到结果集，因为path最后会被删的一干二净，这里要new一个list存当前的path
                resList.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }

        //加入当前node值到path中，当回到上一个节点前删掉path中当前节点的值
        path.add(node.val);
        traverse(node.left, remain, path);
        path.removeLast();

        //同上
        path.add(node.val);
        traverse(node.right, remain, path);
        path.removeLast();
    }

}
