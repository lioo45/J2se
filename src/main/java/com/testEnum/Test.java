package com.testEnum;

/**
 * Created by pro on 17/3/2.
 */
public class Test extends Context{
    public void test(){
        Test t=new Test();
        System.out.println(t.getClass());
        System.out.println(super.getClass());
        System.out.println(t.getClass().getSuperclass());
    }
}
