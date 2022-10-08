package Sort;

/**
 * @program: AlgorithmDepository
 * @description: 选择排序
 * @author: PlusL
 * @create: 2022-06-18 20:58
 **/
import java.util.*;

public class SelectSort {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n - 1; i++) {
            int index = n - 1 - i;
            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        for(int i = 0; i < n; i ++) {
            System.out.println(arr[i]);
        }

    }
}
