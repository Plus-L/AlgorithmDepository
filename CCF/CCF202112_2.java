package CCF;

/**
 * @program: AlgorithmDepository
 * @description: 202112-2 序列查询新解
 * @author: PlusL
 * @create: 2022-06-07 15:05
 **/
import java.util.*;
import java.lang.*;

public class CCF202112_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int N = in.nextInt();
        int[] elearr = new int[n + 1];
        elearr[0] = 0;
        for (int i = 1; i <= n; i++) {
            elearr[i] = in.nextInt();
        }

        int sum = 0, i = 0, j = 0;
        int[] f = new int[N];
        while (i + 1 <= n && j <= N -1) {
            if (j >= elearr[n]) {
                f[j] = n;
                j++;
            } else if (j < elearr[i + 1]) {
                f[j] = i;
                j++;
            } else if (j >= elearr[i + 1]) {
                i++;
                f[j] = i;
                j++;
            }
        }

        int r = N / (n + 1);
        int[] g = new int[N];
        int error = 0;
        for (int k = 0; k < N; k++) {
            g[k] = k / r;
            error += Math.abs(g[k] - f[k]);
        }

        System.out.println(error);


    }
}
