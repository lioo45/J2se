package com.leetcode.medium;



/**
 * Created by pro on 17/1/7.
 */
public class AdditiveNumber306 {
    public static void main(String[] args) {
        String s="112358";
        String s1="199100199";
        String s2="123456579";// 123 456 579
        String s3="1234563468";//12 3456 3468
        String s4="112";
        String s5="10203";
        String s6="121474836472147483648";
        String s7="101";
        String s8="8917";
        String s9="011235";
        String s10="12122436";
        System.out.println(isAdditiveNumber(s));
        System.out.println(isAdditiveNumber(s1));
        System.out.println(isAdditiveNumber(s2));
        System.out.println(isAdditiveNumber(s3));
        System.out.println(isAdditiveNumber(s4));
        System.out.println(isAdditiveNumber(s5));
        System.out.println(isAdditiveNumber(s6));
        System.out.println(isAdditiveNumber(s7));
        System.out.println(isAdditiveNumber(s8));
        System.out.println(isAdditiveNumber(s9));
        System.out.println(isAdditiveNumber(s10));

    }

    public static boolean isAdditiveNumber(String num) {
        //只用1~n-2  0表示未计算 1真 -1假
        if(num==null||num.isEmpty())
            return false;
        int correct[]=new int[num.length()-1];
        return IANHelp(num,correct,0);
    }

    public static  boolean IANHelp(String num,int correct[],int offset){
        for (int i=1;i<=(num.length()-1)/2;++i){
            String num1=num.substring(0,i);
            int bound=canAdd(num1,num.substring(i));
            if(bound!=-1){
                if(bound+num1.length()==num.length())
                    return true;
                if(correct[offset+i]==0)
                    correct[offset+i]=IANHelp(num.substring(i),correct,offset+i)?1:-1;
                if(correct[offset+i]==1)
                    return true;

            }
        }
        return false;
    }
    //如果可以相加 则返回sum的最后一个字符的索引+1
    //否则返回-1
    public static int canAdd(String num1,String left){
        if(num1.length()>left.length()/2)
            return -1;
        BigInteger biFirst=new BigInteger(num1);
        for(int i=0;i<=left.length()/2-1;++i){
            int num2len=i+1;
            String num2=left.substring(0,num2len);
            if(num2.length()>1&&num2.charAt(0)=='0')
                return -1;
            BigInteger second=new BigInteger(num2);
            int max=Math.max(num1.length(),num2len);
            BigInteger sum1,sum2;
                sum1=new BigInteger(left.substring(num2len,num2len+max));
                sum2=(num2len+max+1)>left.length()?new BigInteger("0")
                        :new BigInteger(left.substring(num2len,num2len+max+1));
            if(biFirst.add(second).equals(sum1))
                return num2len+max;
            if(biFirst.add(second).equals(sum2))
                return num2len+max+1;
        }
        return -1;
    }
    static class BigInteger{
        String num;
        public BigInteger(String num){
            this.num=num;
        }
        public BigInteger add(BigInteger v){
            char[] num1=this.num.toCharArray();
            char[] num2=v.num.toCharArray();
            int len=Math.max(num1.length,num2.length)+1;
            char[] sum=new char[len];
            int i1=num1.length-1,i2=num2.length-1,i3=sum.length-1;
            int carryBit=0;
            while(i1>=0&&i2>=0){
                int value=num1[i1]+num2[i2]+carryBit-'0';
                carryBit=value>'9'?1:0;
                value=carryBit==1?value-10:value;
                sum[i3]= (char) value;
                i3--;i2--;i1--;
            }
            int t=i1>=0?i1:i2;
            char[] buffer=i1>=0?num1:num2;
            while(t>=0) {
                int value=buffer[t]+carryBit;
                carryBit=value>'9'?1:0;
                value=carryBit==1?value-10:value;
                sum[i3]= (char) value;
                i3--;
                t--;
            }
            if(carryBit>0)
                sum[i3]='1';
            return new BigInteger(sum[0]=='1'?new String(sum):new String(sum,1,sum.length-1));
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof BigInteger))
                return false;
            String num2=((BigInteger) obj).num;
            if(num2.length()!=this.num.length())
                return false;
            for (int i = 0; i <this.num.length() ; i++) {
                if(this.num.charAt(i)!=num2.charAt(i))
                    return false;
            }
            return true;
        }
    }
}
