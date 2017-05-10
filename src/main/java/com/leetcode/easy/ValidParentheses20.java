package com.leetcode.easy;

import sun.java2d.pipe.SpanIterator;

import java.util.Stack;

/**
 * Created by pro on 17/3/2.
 */
public class ValidParentheses20 {

    public static void main(String[] args) {
        System.out.println(isValid("{[([])]}"));
        System.out.println(isValid("({})"));
        System.out.println(isValid(")"));
        System.out.println(isValid("["));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                switch (c){
                    case ')':
                        if(stack.pop()!='(')
                            return false;
                        break;
                    case ']':
                        if(stack.pop()!='[')
                            return false;
                        break;
                    case '}':
                        if(stack.pop()!='{')
                            return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }

}
