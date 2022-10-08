package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: LeetCode 76.最小覆盖子串
 * @author: PlusL
 * @create: 2022-08-29 22:01
 **/
public class LeetCode_76_minWindow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        String result = minWindows(s, t);
        System.out.println(result);
    }

    public static String minWindows(String s, String t) {
        Map<Character, Integer> totalMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();

        // 初始化装载needMap（需求的Map）
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needMap.containsKey(c)) {
                totalMap.put(c, totalMap.getOrDefault(c, 0) + 1);
                if (totalMap.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }

            while (valid == needMap.size()) {
                // 当当前的子串长度小于len，将其赋值给len（更新len）
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char moveOut = s.charAt(left);
                left++;
                if (needMap.containsKey(moveOut)) {
                    if (totalMap.get(moveOut).equals(needMap.get(moveOut))) {
                        valid--;
                    }
                    totalMap.put(moveOut, totalMap.get(moveOut) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
