package Sort;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 插入排序
 * @author: PlusL
 * @create: 2022-09-29 21:00
 **/
public class InsertSort {

    // 插排思路很简单，即先保证0~1有序，再保证0~2有序，最后整个数组有序
    public static int[] insertSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return arr;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        arr = insertSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }

    }

}
