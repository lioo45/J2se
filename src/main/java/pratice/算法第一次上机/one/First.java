package pratice.算法第一次上机.one;


import pratice.算法第一次上机.two.PriorityQueue;

/**
 * Created by pro on 17/3/22.
 *
 */
public class First {

    public static void main(String[] args) {
        int[] a={4,2,6,8,56,34,87,34};
        System.out.println(existed(a,64));
        System.out.println(existed(a,6));
        System.out.println(existed(a,40));
        System.out.println(existed(a,91));
    }
    //给定一个数组a[],判断数组中是否存在两数之和等于sum
    public static boolean existed(int[] a,int sum){
        PriorityQueue queue=new PriorityQueue(a);
        for (int i = 0; i <a.length ; i++) {
            a[i]=queue.pop();
        }
        int left=0;
        int right=a.length-1;
        while(left<right){
            if(a[left]+a[right]<sum)
                left++;
            else if(a[left]+a[right]==sum)
                return true;
            else
                right--;
        }
        return false;
    }

}
