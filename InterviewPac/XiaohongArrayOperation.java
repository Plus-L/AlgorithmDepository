package InterviewPac;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 腾讯音乐笔试二题：小红的数组操作
 * @author: PlusL
 * @create: 2022-09-01 20:17
 **/
public class XiaohongArrayOperation {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            list.add(sc.nextInt());
        }
        int x = sc.nextInt();
        int k = sc.nextInt();

        minMax(list, k, x);
    }

    public static int minMax (List<Integer> list, int k, int x) {
        // 简单的思路既是：每次减之前找到当前的数组中的最大值，然后减去
        int max_index = 0;
        int size = list.size();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < size; j++) {
                if (list.get(j) > list.get(max_index)) {
                    max_index = j;
                }
            }

            list.set(max_index, list.get(max_index) - x);
        }

        for (int i = 0; i < size; i++) {
            if (list.get(i) > list.get(max_index)) {
                max_index = i;
            }
        }

        return list.get(max_index);
    }
}
