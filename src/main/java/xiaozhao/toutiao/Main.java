package xiaozhao.toutiao;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int q=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for (int i = 0; i <n ; i++) {
                a[i]=sc.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                b[i]=sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int i = 0; i <q ; i++) {
                int x=sc.nextInt();
                int y=sc.nextInt();

                int xnum=binarySearch(a,x);
                int ynum=binarySearch(b,y);

                int m=xnum>ynum?xnum:ynum;

                int num=n-m;
                if(xnum==-1||ynum==-1){
                    System.out.println(0);
                }
                else
                    System.out.println(num);
            }

        }
    }

    public static int binarySearch(int[] a,int value){
        int left=0;
        int right=a.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if(a[mid]>value)
                right=mid-1;
            else if(a[mid]<value)
                left=mid+1;
            else{
                for (int i = mid; i >0 ; i--) {
                    if(a[i]!=value)
                        return i+1;
                }
                for (int i = 0; i <a.length ; i++) {
                    if(a[i]>=value)
                        return i;
                }
                return -1;
            }
        }
        if(a[left]>value)
            return left;
        else
            return left<a.length-1?left+1:left;
    }


}
