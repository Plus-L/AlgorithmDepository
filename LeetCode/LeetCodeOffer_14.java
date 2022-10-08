package LeetCode;

/**
 * @program: AlgorithmDepository
 * @description: 剪绳子
 * @author: PlusL
 * @create: 2022-10-07 13:06
 **/
public class LeetCodeOffer_14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }

    public static int cuttingRope(int n) {
        // 动态规划，dp数组的目的是记录 0~n 中每个取值的最大乘积结果，也就是将大化小的做法
        int[] dp = new int[n + 1];

        // 双层循环的外层循环，代表dp数组的遍历，逐个将dp数组的值计算出来
        for (int i = 2; i <= n; i++) {
            int currentMax = 0;
            // 双层循环的内层循环，从 1 开始逐个选择乘积最大的值
            for(int j = 1; j < i; j++) {
                // 确认好j后有两种情况，1.(i - j)不在拆分，直接作为整体与j相乘 2.(i - j)还需要拆分，直接用dp数组的值，因为dp存的就是当前值的最大乘积
                currentMax = Math.max(currentMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = currentMax;
        }

        return dp[n];
    }

}
