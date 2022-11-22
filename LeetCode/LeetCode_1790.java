package LeetCode;

/**
 * @program: AlgorithmDepository
 * @description: 仅交换一次使两个字符串相等 （待完成）
 * @author: PlusL
 * @create: 2022-10-11 22:25
 **/
public class LeetCode_1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        // 首先比较两个字符串，处理特殊情况
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int length = c1.length;

        int[] dp = new int[length];
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {

            }
        }

        return false;
    }

}
