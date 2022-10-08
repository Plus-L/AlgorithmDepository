package Test;

/**
 * @program: AlgorithmDepository
 * @description: 测试Lambda语法
 * @author: PlusL
 * @create: 2022-06-13 15:14
 **/
public class LambdaTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中run被执行了");
            }
        }).start();
        //lambda不关注匿名内部类的名字以及方法的名字，仅关注传入的参数
        new Thread(()->{
            System.out.println("lambda执行");
        }).start();

    }
}
