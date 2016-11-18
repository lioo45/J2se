

import java.nio.channels.Pipe;
import java.util.*;


import org.joda.time.DateTime;
import sun.tools.java.BinaryCode;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n;
        while((n=sc.nextInt())!=0) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (Integer i : a) {
                Integer v = map.get(i);
                if (v == null)
                    map.put(i, 1);
                else
                    map.put(i, ++v);
            }
            Integer max = 0;
            Integer reuslt = Integer.MAX_VALUE;
            for (Integer i : a) {
                Integer times = map.get(i);
                if (times >= max) {
                    if (times == max) {
                        if (times < reuslt)
                            reuslt = i;
                        continue;
                    }
                    max = times;
                    reuslt = i;

                }
            }
            System.out.println(reuslt);
        }
    }

}
