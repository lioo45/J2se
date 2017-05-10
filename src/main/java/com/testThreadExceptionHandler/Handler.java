package com.testThreadExceptionHandler;

/**
 * Created by pro on 16/11/26.
 */
public class Handler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("test");
    }
}
