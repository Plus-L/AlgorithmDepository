package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: leetcode 260 : 有两个数出现了奇数次，其他的数出现了偶数次
 * @author: PlusL
 * @create: 2022-09-28 19:39
 **/
public class XORtest_II {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int eor = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            eor ^= arr[i];
        }

        // 取出eor最右侧的1（很帅，但很常用）
        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & rightOne) == 0) {
                onlyOne ^= arr[i];
            }
        }

        System.out.println("两个数分别为：" + onlyOne + "  |  " + (eor ^ onlyOne));

    }
}
