package CCF;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 3195、有趣的数
 * @author: PlusL
 * @create: 2022-06-02 15:39
 **/
public class FunnyNum3195 {


    public static void main(String[] args) {
        int mode = 1000000000 + 7;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[1010][1010];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % mode;
                }
            }
        }

        int res = 0;
        for (int k = 2; k <= n - 2; k++) {
            res = (res + arr[n-1][k] * (k - 1) * (n - k - 1)) % mode;
        }
        System.out.println(res);

    }

}
