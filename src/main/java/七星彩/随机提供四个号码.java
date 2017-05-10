package 七星彩;



import java.util.Random;

/**
 * Created by pro on 17/2/5.
 */
public class 随机提供四个号码 {
    public static void main(String[] args) {
        Random random=new Random();
        int r1=(first()+random.nextInt(10))%10;
        int r2=(second()+random.nextInt(10))%10;
        int r3=(third()+random.nextInt(10))%10;
        int r4=(last()+random.nextInt(10))%10;
        System.out.print(r1);
        System.out.print(r2);
        System.out.print(r3);
        System.out.println(r4);
    }

    //第一位,随机生成1000个数相加
    //然后将各个数位循环相乘,
    public static int first(){
        long result=1;
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            result+=random.nextInt(1000);
        }

        return getResult(result,1);
    }
    //第二位,随机生成1000个数相加,
    //然后将各个数位循环相加,

    public static int second(){
        long result=0;
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            result+=random.nextInt(1000);
        }
        return getResult(result,0);
    }
    //第三位,随机生成1000个数异或
    //然后将各个数位循环相加,
    public static int third(){
        long result=0;
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            result^=random.nextInt(1000);
        }
        return getResult(result,0);
    }
    //第四位,随机生成1000个数异或
    public static int last(){
        long result=0;
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            result^=random.nextInt(1000);
        }
        return getResult(result,1);
    }

    //然后将各个数位循环相加*,直至得到<10的数
    public static int getResult(long origin,int sign){
        if(origin<0)
            return -1;
        int result=0;
        long  a=origin;
        while(a!=0){
            switch (sign){
                case 0:
                    result+=(int) (a%10);
                    break;
                case 1:
                    result+=1;
                    result*=(int)(a%10);
                    break;
            }
            a=a/10;
            if(a==0&&result>=10) {
                a = result;
                result=0;
            }
        }
        return result;
    }
}
