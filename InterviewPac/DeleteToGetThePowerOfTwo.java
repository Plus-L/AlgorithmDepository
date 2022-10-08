package InterviewPac;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 腾讯音乐笔试题：小红的二进制删数字
 * @author: PlusL
 * @create: 2022-09-01 20:00
 **/
public class DeleteToGetThePowerOfTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minCnt(s));
    }

    public static int minCnt (String s) {
        // 2的幂其实就是1 10 100 1000 ....
        // 也就是说除了第一个1，其他的1都要删掉
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                count++;
            }
        }

        return count;
    }
}
