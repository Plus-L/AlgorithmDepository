package CCF;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 201709-1打酱油
 * @author: PlusL
 * @create: 2022-06-02 17:33
 **/
public class SoySauce201709_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();

        int count50 = money / 50;
        int res50 = money % 50;
        int count30 = res50 / 30;

        int res = count50 * 2 + count30 + money / 10;
        System.out.println(res);

    }

}
