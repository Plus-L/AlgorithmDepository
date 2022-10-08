package InterviewPac;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description:
 * 勇仕网络 笔试题1：题意 有两个版本号 version1 和 verSion2. 例如：1.01   1.001    1.1.1.1
 * 要求version1 和 version2哪个更大，比较的方式是每个部分进行比较。
 * 比如：1.01 和 1.02.1做比较，首先1和1比较，然后01和02比较，发现02大，那么返回-1
 * version1 > version2返回1  小于返回-1.   等于返回0
 * 没写出来
 * @author: PlusL
 * @create: 2022-09-14 21:01
 **/
public class yongshi_1 {

    public static void main(String[] args) {

        // 题意十分简单，难在如何处理String、Char、int数据之间的转换，很麻烦
        Scanner sc = new Scanner(System.in);
        String version1 = sc.next();
        String version2 = sc.next();

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int length = Math.min(split1.length, split2.length);

        boolean flag = false;
        for (int i = 0; i < length; i++) {
            // 这里Integer的get方法获取不到，返回NullPointer，时间不够了
            // 还有个方法，可以将String转换为 Char数组，然后去除那些为0的，再调用这个方法就ok，但是没时间了
            int v1 = Integer.getInteger(split1[i]);
            int v2 = Integer.getInteger(split2[i]);

            if (v1 > v2) {
                System.out.println(1);
                flag = true;
                break;
            }
            if (v1 < v2) {
                System.out.println(-1);
                flag = true;
                break;
            }

        }

        if (flag == false) {
            System.out.println(0);
        }

    }
}
