package CCF;

import java.util.Scanner;

/**
 * @program: AlgorithmDepository
 * @description: 202104-1灰度直方图
 * @author: PlusL
 * @create: 2022-06-05 20:21
 **/
public class CCF202104_1 {
    public static void main(String [] args){
        run();
    }
    public static void run(){
        //输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        int[] h = new int[l];
        int[] ele = new int[n*m];
        for(int i=0;i<n*m;i++){
            ele[i]=scanner.nextInt();
        }
        //计算
        for(int i=0;i<h.length;i++){
            int z=0;
            for(int j=0;j<ele.length;j++){
                if (i==ele[j]){
                    z++;
                }
            }
            h[i]=z;
        }
        //输出
        for(int i=0;i<h.length;i++){
            if (i==h.length-1){
                System.out.print(h[i]);
            }else {
                System.out.print(h[i]+" ");
            }
        }
    }
}
