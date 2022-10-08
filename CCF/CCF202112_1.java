package CCF;

/**
 * @program: AlgorithmDepository
 * @description: CCF202112-1序列查询
 * @author: PlusL
 * @create: 2022-06-06 16:34
 **/

import java.util.*;

public class CCF202112_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int N = in.nextInt();
        int[] elearr = new int[n + 1];
        elearr[0] = 0;
        for (int i = 1; i <= n; i++) {
            elearr[i] = in.nextInt();
//            System.out.print(elearr[i]);
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

        for (int k = 0; k < N; k++) {
            sum += f[k];
//            System.out.println("f[" + k + "] = :" + f[k]);
        }

        System.out.println(sum);
    }
}
