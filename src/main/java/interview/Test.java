package interview;

/**
 * Created by pro on 17/3/5.
 */
public class Test {
    public static void main(String[] args) {
        int a[]={2,5,1,1,1,1,4,1,7,3,7};
        int b[]={10,2,11,13,1,1,1,1,1};
        int c[]={1,2,3,4,3,5,5,7,3,2,5,9,9,1};
        System.out.println(resolve(a));
        System.out.println(resolve(b));
        System.out.println(resolve(c));
    }

    static boolean resolve(int a[]){
        if(a.length<7)
            return false;
        int m1=1,m2=3,m3=5;
        int sum=0;
        for (int i = 0; i <a.length ; i++)
            sum+=a[i];
        int avg=sum/4;
        int sum1=0,sum2=0,sum3=0,sum4=0;
        for (; m1 <=a.length-6 &&sum1<avg; m1++) {
            sum1+=a[m1-1];
            if(sum2>0)
                sum2-=a[m1];
            for(m2=m2<m1+2?m1+2:m2;m2<=a.length-4&&sum2<avg;m2++){
                if(sum3>0)
                    sum3-=a[m2];
                if(sum2<0)
                    sum2=0;
                sum2+=a[m2-1];
                if(sum2>sum1){
                    sum2-=a[m2-1];
                    sum2-=a[m1+1];
                    m2--;
                    break;
                }
                else if(sum2==sum1){
                    for(m3=m3<m2+2?m2+2:m3;m3<=a.length-2&&sum3<avg;++m3){
                        sum3=sum3>0?sum3:0;
                        sum3+=a[m3-1];
                        if(sum4>0)
                            sum4-=a[m3];
                        if(sum3>sum2){
                            sum3-=a[m3-1];
                            sum3-=a[m2+1];
                            m3--;
                            break;
                        }
                        else if(sum3==sum2){
                            if(sum4==0){
                                for(int i=m3+1;i<a.length;++i)
                                    sum4+=a[i];
                                if(sum4==sum3)
                                    return true;
                            }
                            else if(sum4==sum3)
                                return true;

                        }
                    }


                }
            }

        }
        return false;
    }


}
