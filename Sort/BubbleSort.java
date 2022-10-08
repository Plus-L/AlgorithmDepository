package Sort;

/**
 * @program: AlgorithmDepository
 * @description: 冒泡排序
 * @author: PlusL
 * @create: 2022-06-18 20:40
 **/
import java.util.*;

public class BubbleSort {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 -i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 0; i < n; i ++) {
            System.out.println(arr[i]);
        }

    }
}
