package Sort;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 快速排序
 * 快排的原理：
 * 1.首先选择一个基准位（这里选择的是左指针当前所在的位置）
 * 2.从左往右找大于基准数的位置、从右往左找小于基准数的位置，把他俩交换，保证所有小于基准数的都在基准的左边，大于的都在基准的右侧（也就是找到基准对应的位置）
 * 3.
 * @author: PlusL
 * @create: 2022-10-02 18:49
 **/
public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = nums[left];  // 定义第一个数为基准数

        int i = left;
        int j = right;

        while (i < j) {
            while (pivot <= nums[j] && i < j) {  // 从右往左找比基准数小的
                j = j - 1;
            }
            while (pivot >= nums[i] && i < j) {  // 从左往右找比基准数大的
                i = i + 1;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];  // i位置的数一定小于基准数，两者可以进行交换
        nums[i] = pivot;  // i位置为基准数的最终位置

        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }

}
