package InterviewPac;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description:
 *
 *  * 小明正在刷栅栏。为了使得栅栏在经过风吹雨打后依然不掉色，需要用两种不同的油漆刷栅栏。
 *  *
 *  * 栅栏被按顺序编号为1到1000000000。每一段栅栏需要至少刷 p 遍的1号油漆和 q 遍的2号油漆后才能保证长时间不掉色。
 *  *
 *  * 每次刷漆都会使用某种类型的油漆，并将编号属于某个区间内的栅栏都刷上这种油漆。
 *  *
 *  * 现在给出每次刷漆的栅栏编号范围和油漆种类，请你求出有多少段栅栏能够长时间不掉色。
 *  *
 *  * 第一行有三个正整数n,p,q(1<=n<=100000,1<=p,q<=n)，代表刷漆的次数，以及两个参数 p 和 q。
 *  *
 *  * 第二到四行给出了一个大小为3*n的矩阵，第 i 列的三个数从上到下记为l,r,t(1<=l,r<=1000000000,1<=t<=2)，代表第i次刷漆将编号在 l 到 r 之间的栅栏刷了一遍 t号油漆。
 *  *
 *  * 输出一个正整数，代表有多少栅栏可以长时间不掉色。
 *  *
 *  * 5 2 2
 *  * 1 1 2 3 2
 *  * 3 5 4 5 4
 *  * 1 2 1 1 2
 *  *
 *  * 3
 * @author: PlusL
 * @create: 2022-09-17 16:20
 **/
public class DiDi_test1 {
    public static void main(String[] args) {
        // 三个特征：
        // 1. 正整数且没有前导0
        // 2. 任意两个相邻数不相同
        // 3. 可以被三整除（也就是每一位数字相加为3的倍数）
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] array = str.toCharArray();
        int length = array.length;
        int count = 0;

        // 两个特殊位置需要处理，第一个是首位，他不能为0，第二个是末位，他必须保证整体能被三整除
        // 处理首位
        if (array[0] == '?') {
            if (array[1] != '1') {
                array[0] = '1';
            } else {
                array[0] = '2';
            }
            count += array[0] - '0';
        }

        // 普通情况，需要判断前一位和后一位，尽量取小
        for (int i = 1; i < length - 1; i++){
            if (array[i] == '?') {
                // 可以简化成四种情况 （1）. 前后分别是0/1 （2）. 前后有0没1 （3）其他
                char front = array[i - 1];
                char next = array[i + 1];
                if ((front == '0' && next == '1') || (front == '1' && next == '0')) {
                    array[i] = '2';
                } else if (front == '0' || next == '0') {
                    array[i] = '1';
                } else {
                    array[i] = '0';
                }
            }

            count = count + (array[i] - '0');
        }

        // 最后一位的处理，要让count % 3 == 0
        if (count % 3 == 0) {
            if (array[length - 2] != '0') {
                array[length - 1] = '0';
            } else {
                array[length - 1] = '3';
            }
        } else {
            int temp = 3 - count % 3;
            if (temp == array[length - 2] - '0') {
                temp += 3;
            }
            array[length - 1] = (char) ('0' + temp);
        }

        String res = String.copyValueOf(array);
        System.out.println(res);

    }
}
