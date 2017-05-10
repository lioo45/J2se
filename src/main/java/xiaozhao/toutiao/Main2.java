package xiaozhao.toutiao;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            sc.nextLine();
            Map<String,Set<Integer>> map=new HashMap<String, Set<Integer>>();
            String[] stringArray=new String[n];
            for (int i = 0; i <n ; i++) {
                stringArray[i]=sc.nextLine();
                String ss[]=stringArray[i].split(" ");
                for (int j = 0; j <ss.length ; j++) {
                    String cs=ss[j].toLowerCase();
                    Set<Integer> set=map.get(cs);
                    if(set==null) {
                        set=new HashSet<Integer>();
                        set.add(i);
                        map.put(cs,set);
                    }
                    else{
                        set.add(i);
                        map.put(cs,set);
                    }
                }

            }

            for (int i = 0; i <m ; i++) {
                String s=sc.nextLine();
                String ss[]=s.split(" ");
                ss=deleteRepeated(ss);
                int num[]=new int[n];
                for (int j = 0; j <ss.length ; j++) {
                    String cs=ss[j].toLowerCase();
                    Set<Integer> set=map.get(cs);
                    if(set!=null)
                        for(Integer v:set)
                            num[v]++;
                }
                int index=max(num);
                System.out.println(stringArray[index]);
            }
        }
    }

    public static int max(int[] a){
        int index=0;
        int max=a[0];
        for (int i = 1; i <a.length ; i++) {
            if(a[i]>max){
                max=a[i];
                index=i;
            }
        }
        return index;
    }

    public static String[] deleteRepeated(String[] ss){
        Set<String> set=new HashSet<String>();
        for (int i = 0; i <ss.length ; i++) {
            set.add(ss[i]);
        }
        String[] ss1=new String[set.size()];
        int i=0;
        for(String s:set){
            ss1[i]=s;
            ++i;
        }
        return ss1;
    }

}
