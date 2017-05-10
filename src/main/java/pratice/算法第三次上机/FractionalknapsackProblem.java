package pratice.算法第三次上机;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pro on 17/5/3.
 */
public class FractionalknapsackProblem {
    static class Holder implements Comparable<Holder>{
        double valuePerOne;
        int weight;

        public Holder(double valuePerOne, int weight) {
            this.valuePerOne = valuePerOne;
            this.weight = weight;
        }

        @Override
        public int compareTo(Holder o) {
            return this.valuePerOne==o.valuePerOne?0:this.valuePerOne>o.valuePerOne?1:0;
        }
    }

    public static void main(String[] args) {
        int[] weights = {
                50, 30, 45, 25, 5
        };
        int[] values = {
                200, 180, 225, 200, 50
        };
        System.out.println(getMaxValue(100, weights, values));

    }
    public static int getMaxValue(int capacity, int[] weight, int[] values) {
        if (weight == null || values == null || weight.length != values.length)
            return -1;
        Holder[] holders=new Holder[weight.length];
        for (int i = 0; i <weight.length ; i++) {
            holders[i]=new Holder((double)values[i]/weight[i],weight[i]);
        }
        List<Holder> list=Arrays.asList(holders);
        Collections.sort(list);
        int max=0;
        for(Holder h:list)
            System.out.println(h.valuePerOne);
        for (int i = list.size()-1; i >=0 ; i--) {
            Holder holder=holders[i];
            if(capacity>=holder.weight){
                max+=holder.valuePerOne*holder.weight;
                capacity-=holder.weight;
            }else{
                if(capacity>0)
                    max+=holder.valuePerOne*capacity;
                break;
            }
        }
        return max;
    }

}
