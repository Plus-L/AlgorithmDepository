package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 矩阵中的路径
 * @author: PlusL
 * @create: 2022-10-02 19:55
 **/
public class LeetCodeOffer_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int deepth = sc.nextInt();
        int width = sc.nextInt();

        String[][] arr = new String[width][deepth];
        for (int i = 0; i < deepth; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = sc.next();
            }
        }

    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 这里的双层循环相当于把二维数组中的每一个元素都作为起点跑了一次
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    // dfs + 剪， k 表示已匹配的字符的数量（count）同时也作为要匹配的字符串的下标
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }

        // 将已匹配了的字符变为 0，也就相当于剪枝了，不往回走
        board[i][j] = '\0';
        // 尝试上下左右走
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
