package xiaozhao.jingdong;

import java.util.Scanner;

/**
 * Created by pro on 17/4/7.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int len=sc.nextInt();
            int a[]=new int[len];
            sc.nextLine();
            String s=sc.nextLine();

            for (int i = 0; i <len ; i++) {
                char c=s.charAt(i);
                //正常人
                if(c=='#')
                    a[i]=-1;
                //小偷
                if(c=='X')
                    a[i]=-2;
                else{
                    a[i]=c-'0';
                }

            }
            int sum=0;
            for (int i = 0; i <len ; i++) {
                if(a[i]>0){
                    int left=i-a[i];
                    int right=i+a[i];
                    sum+=count(a,left,right);

                }
            }
            System.out.println(sum);

        }
    }

    public static int count(int[] a,int left,int right){
        if(left<0)
            left=0;
        if(right>=a.length)
            right=a.length-1;
        int num=0;
        while(left<=right){
            if(a[left]==-2) {
                num++;
                a[left]=-1;
            }
            left++;
        }
        return num;
    }
}
