package com.testThreadExceptionHandler;

/**
 * Created by pro on 16/11/26.
 */
public class M {
    public static void main(String[] args) {
        int sum=0;
        try{
            for (int i = 0; i <10 ; i++) {
                sum+=0;
            }
            Thread.sleep(5000);
            Thread.setDefaultUncaughtExceptionHandler(new Handler());
            throw new RuntimeException("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(sum);
        }
    }
}
