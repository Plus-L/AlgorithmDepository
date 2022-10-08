package examination;

import java.util.concurrent.TimeUnit;

/**
 * @program: AlgorithmDepository
 * @description:
 * @author: PlusL
 * @create: 2022-09-08 21:03
 **/
public class Test {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            try {
                data.func1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            data.func2();
        }).start();
    }

}

/**
 * 创建一个对象，用于测试锁的到底是谁
 */
class Data {

    synchronized void func1() throws InterruptedException {
        // 睡个三秒
        TimeUnit.SECONDS.sleep(3);
        System.out.println("执行了方法 1 ~~~");
    }

    synchronized void func2() {
        System.out.println("执行了方法 2 ~~~");
    }

}
