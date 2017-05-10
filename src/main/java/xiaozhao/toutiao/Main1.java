package xiaozhao.toutiao;
import java.util.Scanner;

public class Main1 {
    //3 2 1 2 3 2 1 4 6 4 2 1
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int a[]=new int[n];
            for (int i = 0; i <n ; i++) {
                a[i]=sc.nextInt();
            }
            int bufferLeft=0,bufferRight=0;
            int left=0,right=0;
            boolean flag1=false,flag2=false;
            int i=1;
            if(n<=2)
                System.out.println("-1 -1");
            while(i<n){
                int j = i;
                left=i-1;

                for (; j <n&&i<n ; j++,++i) {
                    if(a[j]<a[j-1]) {
                        flag1=true;
                        break;
                    }
                }
                int k = j;
                for (; k <n&&i<n ; k++,++i) {
                    if(a[k]>a[k-1]) {
                        right=k-1;
                        flag2=true;
                        break;
                    }
                    if(k>=n-1)
                        right=k;
                }

                if((right-left)>(bufferRight-bufferLeft)){
                    bufferLeft=left;
                    bufferRight=right;
                }

            }
            if(right>0&&flag1&&flag2)
                System.out.println(bufferLeft+" "+bufferRight);
            else
                System.out.println("-1 -1");
        }
    }


}
