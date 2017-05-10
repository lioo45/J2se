package xiaozhao.toutiao.online;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pro on 17/4/11.
 */

    public class Main1{
        public static void main(String[] args ){
//            String s="({()})";
            String s1="({}";
//            System.out.println(isMatch(s));
            System.out.println(isMatch(s1));

        }

        public static boolean isMatch(String s){
            if(s==null||s.isEmpty())
                return false;
            Stack<Character> stack=new Stack<Character>();
            int len=s.length();
            for(int i=0;i<len;++i){
                char c=s.charAt(i);
                if(c=='('||c=='{'||c=='[')
                    stack.push(c);
                else{
                    if(c==')'){
                        if(stack==null&&stack.pop()!='(')
                            return false;
                    }

                    else if(c=='}'){
                        if(stack==null&&stack.pop()!='{')
                            return false;
                    }
                    if(c==']'){
                        if(stack==null&&stack.pop()!='[')
                            return false;
                    }
                }
            }
            return true;
        }
    }
