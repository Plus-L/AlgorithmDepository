package Algo;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: AlgorithmDepository
 * @description: 二叉搜索树
 * @author: PlusL
 * @create: 2022-10-07 17:09
 **/
public class JudgeBST {

    public static void main(String[] args) {

    }

    List<Integer> resList = new ArrayList<>();

    public void judgeBST(TreeNode node) {
        // 二叉搜索树的特点是中序遍历有序，可以先将中序遍历打印，随后判断是否有序

        judgeBST(node.left);
        resList.add(node.val);
        judgeBST(node.right);

    }

}
