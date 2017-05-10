package xiaozhao.qunaer;

import java.util.*;

/**
 * Created by pro on 17/4/1.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String origin=sc.nextLine();
            String result=sc.nextLine();
            String s=sc.nextLine();
            String[] s1=s.split(" ");
            String[] words=new String[s1.length+1];
            words[0]=origin;
            for (int i = 1; i <words.length ; i++) {
                words[i]=s1[i-1];
            }
            int num=buildPath(words,result);
            System.out.println(num);
        }

    }

//    public static int getResult(String origin,String result){}

    public static int buildPath(String words[],String result){
        Set<Integer> hadArrived=new HashSet<Integer>();
        Set<Integer> hadNotArrived=new HashSet<Integer>();
        hadArrived.add(0);
        for (int i = 1; i <words.length ; i++) {
            hadNotArrived.add(i);
        }
        int num=1;
        Queue<Integer> queue1=new LinkedList<Integer>();
        Queue<Integer> queue2=new LinkedList<Integer>();
        queue1.add(0);
        while(hadArrived.size()<=words.length){
            while(!queue1.isEmpty()) {
                String s=words[queue1.remove()];
                Set<Integer> hadNotArrived1=new HashSet<>(hadNotArrived);

                for (Integer v : hadNotArrived1) {
                    String s1 = words[v];
                    if (canChange(s,s1)&&hadNotArrived.contains(v)){
                        if(s1.equals(result))
                            return num+1;
                        queue2.add(v);
                        hadArrived.add(v);
                        hadNotArrived.remove(v);
                    }
                }
            }
            queue1=new LinkedList<Integer>(queue2);
            queue2.clear();
            num++;
        }
        return -1;
    }


    public static boolean canChange(String s,String s2){
        if(s.length()!=s2.length())
            return false;
        int num=0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)!=s2.charAt(i))
                num++;
            if(num>1)
                return false;
        }
        return true;
    }


}
