package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 1582. 二进制矩阵中的特殊位置
 * @author: PlusL
 * @create: 2022-09-04 20:36
 **/
public class LeetCode_1582 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        numSpecial(arr);
    }

    public static int numSpecial(int[][] mat) {
        // 看题意很像八皇后问题，就是不能有两个皇后在同一行或者同一列上，不然会相互攻击
        // 看看有没有取巧的解法，先将每行中满足行内唯一的拿出来，放到dp
        int wideLength = mat.length, deepLength = mat[0].length;
        int[] wideTotal = new int[wideLength];
        int[] deepTotal = new int[deepLength];

        for (int i = 0; i < wideLength; i ++) {
            for (int j = 0; j < deepLength; j ++) {
                wideTotal[i] += mat[i][j];
                deepTotal[j] += mat[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < wideLength; i ++) {
            for (int j = 0; j < deepLength; j ++) {
                if (mat[i][j] == 1 && wideTotal[i] == 1 && deepTotal[j] == 1) {
                    count ++;
                }
            }
        }

        System.out.println(count);

        return 1;
    }
}
