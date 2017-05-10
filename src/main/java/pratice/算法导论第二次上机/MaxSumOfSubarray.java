package pratice.算法导论第二次上机;

/**
 * Created by pro on 17/4/18.
 */
public class MaxSumOfSubarray {
    public static void main(String[] args) {
        int[] a={-2,11,-4,13,-5,-2};
        System.out.print("数组:");
        for(int i:a){
            System.out.print(i+",");
        }
        System.out.println("的结果为");
        System.out.println(getMax(a));

    }

    /*
        线性时间复杂度求最大连续子数组的和

        首先扫描一遍数组,得到数组里最大的元素max.
        如果max<=0,那么结果就是max.
        如果max>0,那么进行以下处理.
        首先,已知a[n-1]的结果,设left,right为最大连续子数组的左下标和右下标,sum为其和.求a[n]
        其结果要么为a[left~right],要么为[k~n],  right<k<=n.
    */
    //记得考虑输入全为负数的情况
    public static Integer getMax(int a[]){
        if(a==null||a.length<=0)
            return null;
        //找到数组中最大的数
        int max=a[0];
        for (int i = 1; i <a.length ; i++) {
            if(max<a[i])
                max =a[i];
        }
        //        int[] a={-2,11,-4,13,-5,-2};

        if(max<=0){
            return max;
        }else{
            //找到第一个大于0的数
            int i = 0;
            for (; i <a.length ; i++) {
                if(a[i]>0)
                    break;
            }
            int maxSum=a[i],right=i;
            int bufferMaxSum=a[i];
            ++i;
            for(;i<a.length;++i){
                if(right==i-1) {
                    int t = maxSum + a[i];
                    if (t > maxSum) {
                        maxSum = t;
                        right++;
                    }
                }
                bufferMaxSum+=a[i];
                if(bufferMaxSum<0)
                    bufferMaxSum=0;
                if(bufferMaxSum>maxSum){
                    maxSum=bufferMaxSum;
                    right=i;
                }
            }
            return  maxSum;
        }
    }
}
