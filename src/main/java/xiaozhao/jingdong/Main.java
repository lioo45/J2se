package xiaozhao.jingdong;

import java.util.Scanner;

/**
 * Created by pro on 17/4/7.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();

            int buffer=k+(k+1);
            int x=n/buffer;
            int result=x*buffer;
            int num=2*x;
            result+=k;
            if(result<=n){
                num++;
            }
            System.out.println(num);
        }
    }
}
