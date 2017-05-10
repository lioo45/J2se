package xiaozhao.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        Stack<Integer> number=new Stack<>();
        for (int i = 0; i <expr.length() ; i++) {
            char c=expr.charAt(i);
            if(c=='^'||c=='*'||c=='+') {
                if(c=='^'){
                    if(number.size()>=1) {
                        int num = number.pop();
                        num++;
                        number.push(num);
                    }else
                        return -1;
                }else if(c=='*'){
                    if(number.size()>=2) {
                        int num1 = number.pop();
                        int num2 = number.pop();
                        number.push(num1*num2);
                    }else{
                        return -1;
                    }
                }else if(c=='+'){
                    if(number.size()>=2) {
                        int num1 = number.pop();
                        int num2 = number.pop();
                        number.push(num1 + num2);
                    }else
                        return -1;
                }
            }
            else if(c>='0'&&c<='9') {
                if(number.size()>=16)
                    return -2;
                number.push(new Integer(c - '0'));
            }
        }
        return number.pop();
    }
}