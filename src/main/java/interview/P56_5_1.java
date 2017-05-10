package interview;

import java.util.function.BiFunction;

/**
 * Created by pro on 17/2/15.
 */
public class P56_5_1 {
    public static void main(String[] args) {

//        5-1
//        int n=1<<10;
//        System.out.println(n);
//        int m=19;
//        System.out.println(binInsert(n,m,2,6));
//        System.out.println(binInsert(0,1024,10,20));
//        System.out.println(binInsert(4355,4,2,7));
        //5-2
//        System.out.println(printBin(1.0/3));
        //5-3
//        int a[]=getCloseNumber(76351);
//        for (int i = 0; i <a.length ; i++) {
//            System.out.println(a[i]);
//
//        }
        //5-5
//        System.out.println(calcCost(10,5));
        //5-6
        System.out.println(exchangeOddEven(10));

    }
    public static int binInsert(int n, int m, int j, int i) {
        //将m左移i位
        int buffer1=m<<j;
        //将n的i~j位清零
        int a=~((1<<(i-j+1)-1)<<j);
        int buffer2=n&a;
        return buffer1|buffer2;
        //m与n相或
    }
    //5-2
    public static String printBin(double num) {
        // write code here
        StringBuilder sb=new StringBuilder("0.");
        for (int i = 0; i <32 ; i++) {
            num*=2;
            if(num>1) {
                num-=1;
                sb.append(1);
            }
            else if(num<1)
                sb.append(0);
            else {
                sb.append(1);
                return sb.toString();
            }
        }
        return "ERROR";
    }
    //5-3 已经保证答案存在
    public static int[] getCloseNumber(int x) {
        //找大的
        //将二进制表示中最右边的1置0,继续左走直到遇到0,将0置1
        //将这个1的位数记录,之后将最右的0依次与靠近1右边的1替换.
        int bit=0;
        while(!getBit(x,bit))
            bit++;
        int large=clearBit(x,bit);
        while(getBit(x,bit))
            bit++;
        large=setBit(large,bit);
        bit--;
        int bit2=0;
        while(bit>bit2){
            while(getBit(large,bit2)&&bit>bit2)
                bit2++;
            while (!getBit(large,bit)&&bit>bit2) {
                bit--;
            }
            if(bit>bit2) {
                large=setBit(large,bit2);
                large=clearBit(large,bit);
                bit--;
                bit2++;
            }
        }
        //找小的
        //将二进制表示中最左边的0置1,继续左走直到遇到1,将1清零
        //将这个1的位数记录,之后将最右的1依次与靠近1右边的0替换.
        bit=0;
        while(getBit(x,bit))
            bit++;
        int small=setBit(x,bit);
        while(!getBit(x,bit))
            bit++;
        small=clearBit(small,bit);
        bit--;
        bit2=0;
        while(bit>bit2){
            while(!getBit(small,bit2)&&bit>bit2)
                bit2++;
            while (getBit(small,bit)&&bit>bit2) {
                bit--;
            }
            if(bit>bit2) {
                small=clearBit(small,bit2);
                small=setBit(small,bit);
                bit--;
                bit2++;
            }
        }
        int a[]=new int[2];
        a[0]=small;
        a[1]=large;
        return a;
    }


    //5-5
    public static int calcCost(int a, int b) {
        int buffer=a^b;
        int num=0;
        for (int i = 0; i <32 ; i++) {
            if((buffer&(1<<i))!=0)
                num++;
        }
        return num;
    }

    //5-6
    public static int exchangeOddEven(int x) {
        int odd=(x&0xAAAAAAAA)>>1;
        int even=(x&0x55555555)<<1;
        return odd|even;
    }

     //获取第i位 true为1,false为0;
    static boolean getBit(int num,int i){
        return (num&(1<<i))!=0;
    }
    //置第i位为1 返回置位后的数值
    static int setBit(int num,int i){
        return (num|(1<<i));
    }

    //第i位清零 返回第i位清零后的数值
    static int clearBit(int num,int i){
        return (num&(~(1<<i)));
    }



}

