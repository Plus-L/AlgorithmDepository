package Sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 归并排序
 * 思路如下：归并排序可以看作一个自底向上的递归，
 * 1.首先让list的左半部分、右半部分有序。
 * 2.随后将两部分merge（两个指针分别在两部分上移动，将指针中小的那个放入结果集）
 * @author: PlusL
 * @create: 2022-10-02 20:33
 **/
public class MergeSort {

    private static void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // 对左侧子序列进行递归排序
        sort(array, left, mid);
        // 对右侧子序列进行递归排序
        sort(array, mid + 1, right);
        // 合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= right) {
            temp[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }
        while (p2 <= right) {
            temp[i++] = array[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, 0, arr.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }


}
