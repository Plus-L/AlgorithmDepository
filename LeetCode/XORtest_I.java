package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 一道特殊的异或
 * @author: PlusL
 * @create: 2022-06-17 22:38
 **/
public class XORtest_I {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;
        int n = in.nextInt();

        for (int i = 0; i < n; i++){
            int num = in.nextInt();
            res ^= num;
        }

        System.out.println(res);
    }

}
