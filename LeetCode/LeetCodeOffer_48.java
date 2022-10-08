package LeetCode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 最长的不包含重复字符的子字符串，计算子字符串长度
 * @author: PlusL
 * @create: 2022-10-03 21:37
 **/
public class LeetCodeOffer_48 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(lengthOfLongestSubstring(s));
    }

    static HashSet<Character> resSet = new HashSet<>();

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            while (resSet.contains(c)) {
                resSet.remove(c);
                left++;
            }
            resSet.add(c);
            max = Math.max((right - left + 1) , max);
            right++;
        }

        return max;
    }


}
