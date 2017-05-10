package xiaozhao.ali;

import java.util.Scanner;

/**
 * Created by pro on 17/4/26.
 */
public class Main {
//    200-trade-done
//    200-?*-done
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            String patterm=sc.next();
            patterm=deal(patterm);
            System.out.println(patterm);
//            System.out.println(str+"   match   "+patterm+"  :"+match(str,patterm));
            System.out.println(match(str,patterm)?1:0);
        }
    }

    private static String deal(String patterm) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <patterm.length() ; i++) {
            if(i<patterm.length()-1) {
                if (!(patterm.charAt(i) == '*' && patterm.charAt(i + 1) == '*')) {
                    sb.append(patterm.charAt(i));
                }
            }
        }
            sb.append(patterm.charAt(patterm.length()-1));
        return sb.toString();
    }

    public static boolean  match(String str,String patterm){
        if(str==null||patterm==null)
            return false;
        if(str.isEmpty()){
            if (patterm.isEmpty() || patterm.length() == 1 && patterm.charAt(0) == '*')
                return true;
            else
                return false;
        }
        if(!patterm.isEmpty()) {
            char p = patterm.charAt(0);
            String s = str.substring(1);
            if (p == '?') {
                return match(s, patterm.substring(1));
            } else if (p == '*') {
                return match(s, patterm) ||match(str,patterm.substring(1));
            } else if (str.charAt(0) == patterm.charAt(0))
                return match(s, patterm.substring(1));
        }

        return false;
    }
}
