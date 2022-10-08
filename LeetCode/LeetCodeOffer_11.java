package LeetCode;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 旋转数组的最小数字
 * 一开始没能理解题意，实际上就是将一个原本有序的数组最后n位转移到数组的最前面
 * 题目要求的是旋转数组的最小元素
 * @author: PlusL
 * @create: 2022-10-02 13:50
 **/
public class LeetCodeOffer_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int res = minArray(arr);
        System.out.println(res);

    }

    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        // 进入循环，有几种情况
        // 1. 左值到中值到右值是有序的，这种情况不可能存在，因为只要发生过旋转则一定有非有序的情况
        // 2. 左值到中值有序，中值小于右值，说明最小值在mid + 1与right之间
        // 3. 中值小于左值，
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (numbers[left] > numbers[mid]) {
                right = mid;
            } else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }

        return numbers[left];

    }

}
