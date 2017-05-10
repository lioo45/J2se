package xiaozhao.wangyi2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pro on 17/3/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] cycle=new int[n];
            for (int i = 0; i <n ; i++) {
                cycle[i]=sc.nextInt();
            }
            int []copy= Arrays.copyOf(cycle,cycle.length);
            int sum=0;

            for (int i = 0; i <n ; i++) {
                sum+=cycle[i];
            }
            //用map缓存结果
            Map<Integer,Integer> map=new HashMap<Integer, Integer>();
            map.put(sum,0);
            for (int i = 0; i <k ; i++) {
                int first=cycle[0];
                sum=0;
                for (int j = 0; j <n ; j++) {
                    if(j==n-1){
                        cycle[j]=(cycle[j]+first)%100;
                    }
                    else
                        cycle[j]=(cycle[j]+cycle[j+1])%100;
                    sum+=cycle[j];
                }
                    Integer v = map.get(sum);
                    if (v == null)
                        map.put(sum, i);
                    else {
                        k = k % (i - v);
                        i = 0;
                    }

                //判读是否与copy相等
//                if(equalCopy(cycle,copy)) {
//                    k =k%(i+1);
//                    i=0;
//                }
            }
            for (int i = 0; i <n ; i++) {
                if(i<n-1)
                    System.out.print(cycle[i]+" ");
                else
                    System.out.print(cycle[i]);

            }
        }
    }

    public static boolean equalCopy(int origin[],int[]copy){
        for (int i = 0; i <origin.length ; i++) {
            if(origin[i]!=copy[i])
                return false;

        }
        return true;
    }
}
