package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 剑指offer-10 青蛙跳台阶
 * @author: PlusL
 * @create: 2022-09-14 16:31
 **/
public class LeetCodeOffer_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numWays(n));

        for (int i = 0; i < memo.length; i++) {
            System.out.println("memo[" + i + "] = " + memo[i]);
        }
    }

    static int[] memo;

    public static int numWays(int n) {
        // 动态规划解题，思路与斐波那契一样，用一个记忆数组存放动态规划值，从最底层一层层往上（有点子问题分解的感觉）
        if (n == 0) {
            return 1;
        }
        memo = new int[n + 1];
        return dp(n);
    }

    static int dp(int n) {
        // basecase
        if (n <= 2) {
            return n;
        }
        // 若记忆数组已经有值，则直接返回，避免重复计算
        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = (dp(n - 1) + dp(n - 2)) % 1000000007;
        return memo[n];
    }
}
