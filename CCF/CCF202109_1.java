package CCF;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 202109-1数组推导
 * @author: PlusL
 * @create: 2022-06-05 11:19
 **/
public class CCF202109_1 {

    public static void main(String[] args) {
        int maxResult = 0;
        int minResult = 0;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            maxResult += arr[i];
        }

        int i = 0, j = 1;
        while (i < n && j <= n) {
            if (j == n){
                minResult += arr[i];
                break;
            }

            if (arr[i] == arr[j]) {
                j++;
            } else {
                minResult += arr[i];
                i = j;
            }
        }

        System.out.println(maxResult);
        System.out.println(minResult);

    }

}
