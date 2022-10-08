package InterviewPac;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description:
 * @author: PlusL
 * @create: 2022-09-17 20:38
 * 5 6 3 3
 * 1 1 1 1 1 1
 * 1 2 2 2 2 1
 * 2 3 3 1 2 2
 * 1 2 2 3 4 5
 * 5 6 6 6 3 4
 * 1 10 1
 * 1 20 1
 * 1 8 1
 **/
public class KeDaXunFei_test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int[][] total = new int[m][n];
        int[][] core = new int[k][l];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                core[i][j] = sc.nextInt();
            }
        }

        int[][] res = new int[m][n];
        //首先要找到这个卷积核
        int coreX = k / 2, coreY = l / 2;
        // 需要将total数组每个都遍历一遍
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                // 记录两个矩阵[0][0] 相差的x和y
                int moveX = i - coreX, moveY = j - coreY;
                // 如何处理重合的区域
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < l; y++) {
                        // 对于核心矩阵，他们对应的原矩阵的位置
                        int indexX = x + moveX;
                        int indexY = y + moveY;
                        if (indexX < 0 || indexY < 0 || indexX >= m || indexY >= n) {
                            continue;
                        }

                        count += core[x][y] * total[indexX][indexY];
                    }
                }

                if (count > 255) {
                    res[i][j] = 255;
                } else if (count < 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = count;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(res[i][j]);
                } else {
                    System.out.print(res[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}

