import org.junit.Test;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 17/4/23.
 */
public class T2 {


    @Test
    public void t2(){
        String s="";
        System.out.println(s.charAt(0));
    }

    @Test
    public void test(){
        String fileName="/Users/pro/test.txt";

        List<String> list=new ArrayList<>();

        list= FileUtil.readFile(fileName);

        System.out.println(list.size());
        int s[]=getNumbers(list.get(0));

        System.out.println("len:"+s.length);
        for(int i:s)
            System.out.println(i);

    }


    private int[] getNumbers(String s){
        if(s==null||s.isEmpty())
            return null;
        int[]  numbers=new int[3];
        String num="";
        for (int i = 0,j=0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c>='0'&&c<='9')
                num+=c;
            else{
                if(!num.isEmpty()) {
                    numbers[j] = new Integer(num);
                    num = "";
                    j++;
                }
            }
            if(j==3)
                break;
        }
        if(!num.isEmpty())
            numbers[2]=new Integer(num);
        return numbers;
    }
}
