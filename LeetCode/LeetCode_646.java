package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 646. 最长数对链  关键词：动态规划、贪心算法。
 * @author: PlusL
 * @create: 2022-09-03 20:22
 **/
public class LeetCode_646 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // 动态规划方式
        System.out.println("数对链最长值为：" + findLongestChain(arr));

        // 贪心算法方式
        System.out.println("贪心解：" + findLongestChainGreedy(arr));
    }

    /**
     * 动态规划解法
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {
        // 对一维pairs排序
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length, ans = 1;
        // 动态转移矩阵，存放的是每个位置能有的最多的数对链
        int[] dp = new int[n];

        // dp实际记录的就是 「当前位置的最多的数对链」。所以能直接在dp的最后几个元素中找到整个数组的数对链长度最大值
        for (int i = 0; i < n; i++) {
            // dp 都初始化为1 因为其本身也是链中的一环
            dp[i] = 1;
            // 这里的循环很有讲究，因为一维数组已经排序过，所以直接判断 j 位置上的 “b” 是否小于 i 位置上的 “a”。
            // 遍历的是i前的所有index（记得是 -- 逆着往前推，因为越靠近i自然他的dp值就越高，越容易找到最大），
            // 如果dp[i]已经不等于 1 了（找到了前继节点）就走到下一个数对
            for (int j = i - 1; j >= 0 && dp[i] == 1; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 贪心解法，不一定对，一旦有 统一数对 a b的跨度过大，就会出现问题，比如
     * 5
     * 1 9
     * 1 5
     * 1 3
     * 2 6
     * 5 9
     * 数对链最长值为（动态规划解）：2
     * 贪心解：1
     * @param pairs
     * @return
     */
    public static int findLongestChainGreedy(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int[] pre = new int[]{0, 0};
        for(int i = 0; i < pairs.length; i ++){
            if(i == 0){
                pre = pairs[0];
                ans ++;
            } else {
                // 贪心，一旦b小于当前i的a，就将i这一节点接到pre后面
                if(pre[1] < pairs[i][0]){
                    pre = pairs[i];
                    ans ++;
                }
            }
        }
        return ans;
    }

}
