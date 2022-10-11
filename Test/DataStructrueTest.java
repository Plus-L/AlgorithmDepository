package Test;

import java.util.LinkedList;

/**
 * @program: AlgorithmDepository
 * @description: 数据结构测试
 * @author: PlusL
 * @create: 2022-10-11 15:26
 **/
public class DataStructrueTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("莫伊");
        list.add("成全");
        list.add("碧海");
        list.add("蓝天");
        list.addFirst("11");
        list.addLast("末尾");

        System.out.println(list);
    }

}
