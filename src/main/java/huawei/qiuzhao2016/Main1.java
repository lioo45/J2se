package huawei.qiuzhao2016;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.Scanner;

/**
 * Created by pro on 17/3/23.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] score=new int[n+1];
            for (int i = 1; i <score.length ; i++) {
                score[i]=sc.nextInt();
            }
            for (int i = 0; i <m ; i++) {
                char   c=sc.next().charAt(0);
                if(c=='Q') {
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    System.out.println(max(score,a,b ));
                }
                else if(c=='U'){
                    int id=sc.nextInt();
                    int scoreOfStudent=sc.nextInt();
                    score[id]=scoreOfStudent;
                }
            }
        }
    }

    private static int max(int[] score, int a, int b) {
        if (a > b) {
            int t=a;
            a=b;
            b=t;
        }
        int max=score[a];
        for (int i = a+1; i <=b ; i++) {
            if(score[i]>max)
                max=score[i];
        }
        return max;
    }
}
