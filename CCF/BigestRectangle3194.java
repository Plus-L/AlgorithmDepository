package CCF;

/**
 * @program: AlgorithmDepository
 * @description:
 * @author: PlusL
 * @create: 2022-06-01 19:19
 **/
import java.util.*;

public class BigestRectangle3194 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[1010];
        for (int i = 1; i <= num ; i++) {
            arr[i] = in.nextInt();
        }

        int result = 0;
        for (int i = 1; i <= num ; i++) {
            int left = i;
            int right = i;
            while (left >= 1 && arr[left] >= arr[i]) left--;
            while (right <= num && arr[right] >= arr[i]) right++;
            System.out.println("第"+i+"次循环，left值为："+left);
            System.out.println("第"+i+"次循环，Right值为："+right);
            result = Math.max(result, arr[i] * (right - left - 1));
        }

        System.out.println(result);
    }

}
