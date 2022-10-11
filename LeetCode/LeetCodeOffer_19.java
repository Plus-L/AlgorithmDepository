package LeetCode;

/**
 * @program: AlgorithmDepository
 * @description: 正则表达式匹配
 * @author: PlusL
 * @create: 2022-10-08 21:24
 **/
public class LeetCodeOffer_19 {

    public static void main(String[] args) {
        String s = "miiidx";
        String p = "mi*d.";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 动规二位数组dp
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 外层i循环指代待匹配字符串
        for (int i = 0; i <= m; ++i) {
            // 内层j循环指代正则表达式
            for (int j = 1; j <= n; ++j) {
                // 分两种情况讨论，j - 1位置是否为 ‘*’
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 判断当前i，j位置是否匹配
     * @param s 待匹配字符串
     * @param p 正则表达式
     * @param i 当前所在待匹配字符串的下标
     * @param j 当前所在正则表达式的下标
     * @return 当前i，j位置是否匹配（boolean）
     */
    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
