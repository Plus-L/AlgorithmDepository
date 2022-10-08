package CCF;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 201612-1中间数
 * @author: PlusL
 * @create: 2022-06-02 22:28
 **/
public class MidNum201612_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
//            System.out.print(arr[i]);
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int l = n / 2 - 1,r = n / 2;
        Arrays.sort(arr);
        int lCountLeft = 0,lCountRight = 0;
        int rCountLeft = 0,rCountRight = 0;
        for(int i = 0; i < n; i++) {
//            System.out.print(arr[i]);
            if(arr[l] > arr[i]) lCountLeft++;
            if(arr[l] < arr[i]) lCountRight++;
            if(arr[r] > arr[i]) rCountLeft++;
            if(arr[r] < arr[i]) rCountRight++;
        }
        if (lCountLeft == lCountRight) {
            System.out.println(arr[l]);
        } else if(rCountLeft == rCountRight) {
            System.out.println(arr[r]);
        } else {
            System.out.println(-1);
        }

    }

}
