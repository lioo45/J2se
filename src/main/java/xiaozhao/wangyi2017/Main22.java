package xiaozhao.wangyi2017;

import java.util.Scanner;

/**
 * Created by pro on 17/3/25.
 */
public class Main22 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext()){
            //选择男生在左
            String s=sc.nextLine();
            char c1[]=s.toCharArray();
            int spend1=0;
            for (int i = 0, boyIndex=0; i <c1.length ; i++) {
                if(c1[i]=='B'){
                    spend1+=i-boyIndex;
                    char t=c1[boyIndex];
                    c1[boyIndex]=c1[i];
                    c1[i]=t;
                    boyIndex++;
                    continue;
                }
            }
            char c2[]=s.toCharArray();
            int spend2=0;
            for (int i = 0, girlIndex=0; i <c2.length ; i++) {
                if(c2[i]=='G'){
                    spend2+=i-girlIndex;
                    char t=c2[girlIndex];
                    c2[girlIndex]=c2[i];
                    c2[i]=t;
                    girlIndex++;
                    continue;
                }
            }
            //选择男生在右
            int min=spend1<spend2?spend1:spend2;
            System.out.println(min);
        }
    }
}
