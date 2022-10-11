package LeetCode;

import java.util.Stack;

/**
 * @program: AlgorithmDepository
 * @description: 栈的压入，弹出序列
 * @author: PlusL
 * @create: 2022-10-11 16:07
 **/
public class LeetCodeOffer_31 {

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, poped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 开一个栈空间，模拟入栈出栈场景
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        // 原本想用一层循环实现，发现没办法处理循环何时退出
        // 外层循环遍历pushed数组，内层判断栈顶是否匹配，匹配则出栈，思路没问题
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();

    }

}
