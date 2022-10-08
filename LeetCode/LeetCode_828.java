package LeetCode;

import java.util.Arrays;

/**
 * @program: AlgorithmDepository
 * @description: 828. 统计子串中的唯一字符
 * @author: PlusL
 * @create: 2022-09-06 21:29
 **/
public class LeetCode_828 {

    public int uniqueLetterString(String s) {
        int ans = 0;
        int[] preIndex = new int[26]; //存储某一个字符前一个字符所在位置
        int[] localIndex = new int[26]; //存储某个字符当前所处位置

        //填充-1
        Arrays.fill(preIndex, -1);
        Arrays.fill(localIndex, -1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];
            int index = now - 'A';
            if (localIndex[index] > -1) {
                ans += (i - localIndex[index]) * (localIndex[index] - preIndex[index]);
            }
            preIndex[index] = localIndex[index];
            localIndex[index] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (localIndex[i] > -1) {
                ans += (localIndex[i] - preIndex[i]) * (s.length() - localIndex[i]);
            }
        }
        return ans;
    }

}
