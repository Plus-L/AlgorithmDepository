package InterviewPac;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 广联达笔试第一题：有n个粒子，他们的发送顺序是第一行输入，到达顺序是第二行输入。这些粒子只能加速不能减速，问至少有几个粒子加速了
 * @author: PlusL
 * @create: 2022-08-31 20:50
 **/
public class x_speed_change {
    public static void main(String[] args) {
        // 有两个关键点，一个是发送顺序，一个是到达时间
        // 如果粒子更晚发射缺更早到，那么其速度就发生了异变
        // 首先，如果其到达顺序小于发送顺序，则他一定异变.
        // 出发 - 到达，如果后面的差值大于前面的差值，那么有加速
        // 有一个点，只能加速不能减速
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] send = new int[num];
        int[] arrive = new int[num];

        for (int i = 0; i < num; i++) {
            send[i] = sc.nextInt();
        }
        // 将发射顺序调整为正序
        for (int i = 0; i< num; i++) {
            arrive[send[i] - 1] = sc.nextInt();
        }
        int count = 0;

        if (arrive[0] == num) {
            System.out.println(num - 1);
            System.exit(0);
        }

        // i 表示当前的粒子，逐个与其前面的粒子比较
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i; j++) {
                if (arrive[i] < arrive[j]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        System.out.println(8);

    }
}
