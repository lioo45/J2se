package interview;

/**
 * Created by pro on 17/3/4.
 * 来自剑指offer
 */
public class OfferP154_28 {

    public static void main(String[] args) {
        printAll("abcd");
    }

    public static void printAll(String s){
        printAll(s,0,new StringBuilder());
    }

    public static void printAll(String s,int index,StringBuilder sb){
        if(index>=s.length()-1) {
            sb.append(s.charAt(s.length()-1));
            System.out.println(sb);
            sb.deleteCharAt(sb.length()-1);
            return ;
        }
        for (int i = index; i <s.length() ; i++) {
            char[] str=s.toCharArray();
            str[index] = s.charAt(i);
            str[i] = s.charAt(index);
            sb.append(str[index]);
            printAll(new String(str),index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }



}
