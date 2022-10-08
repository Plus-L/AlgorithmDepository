package Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 万能公用测试
 * @author: PlusL
 * @create: 2022-06-22 10:04
 **/
public class TempDepo {

    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            list.clear();
            while (sc.hasNext()) {
                String s = sc.next();
                list.add(new String(s));
            }
            System.out.println(list);
        }
    }
}
