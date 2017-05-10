package pratice.算法第一次上机.four;

/**
 * Created by pro on 17/3/22.
 */
public class Main {

    //满足1,3的
    public static void sort13(int[] a){
        if(a==null||a.length<=0)
            return ;
        for (int i = 0,j=0; i <a.length ; i++) {
            if(a[i]==0)
                continue;
            else {
                if(j==0)
                    j=i+1;
                for (; j <a.length ; j++) {
                    if(a[j]==0){
                        a[j]=1;
                        a[i]=0;
                        break;
                    }
                }
                if(j>=a.length)
                    break;
            }
        }
    }

    //满足12的
    public static void sort12(int[] a){
        if(a==null||a.length<=0)
            return ;
        int zeroNum=0;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]==0)
                zeroNum++;
        }
        for (int i = a.length-1; i >=0 ; i--) {
            if(a[i]==0&&zeroNum>0){
                int t=a[zeroNum-1];
                a[zeroNum-1]=a[i];
                a[i]=t;
                zeroNum--;
            }
        }

    }
    //满足23的
    public static void sort23(int[] a){
        if(a==null||a.length<=0)
            return ;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]==0)
                continue;
            for (int j =i+1; j<a.length ; j++) {
                if(a[j]==1)
                    continue;
                int t=a[j];
                for (int k = j; k >i ; k--) {
                    a[k]=a[k-1];
                }
                a[i]=t;
                break;
            }
        }
    }


}
