package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 剑指 Offer 04. 二维数组中的查找
 * @author: PlusL
 * @create: 2022-09-04 21:53
 **/
public class LeetCodeOffer_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int target = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("最后结果是，找到/没找到：" + findNumberIn2DArray(matrix, target));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 一旦摸清了思路，做起来就会很简单，其实就要在尽可能访问少的元素的情况下找到target
        // 观察会发现，这一矩阵从左到右有序，从上到下有序，也就是从左上到右下走都是有序的。
        // 如果从左上出发，因为向右或者向下都是递增的，而且递增幅度不好确定，所以不太好找
        // 咱可以从右上角出发，向左是递减、向下是递增，这样可以保证最坏所有元素遍历一遍找到target，不会重复遍历
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0, y = m - 1;

        while (x < n && y >= 0) {
            int temp = matrix[x][y];
            if (temp == target) {
                return true;
            }
            if (temp < target) {
                x++;
            } else {
                y--;
            }
        }

        return false;
    }
}
