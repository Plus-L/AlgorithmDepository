package LeetCode;

/**
 * @program: AlgorithmDepository
 * @description: 剑指 Offer 16. 数值的整数次方
 * @author: PlusL
 * @create: 2022-09-16 19:54
 **/
public class LeetCodeOffer_16 {

    public static void main (String[] args) {
        double x = 2;
        int n = -2;

        System.out.println(1 / x);
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return myPow(1 / x, -n);
        }

        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }

    }
}
