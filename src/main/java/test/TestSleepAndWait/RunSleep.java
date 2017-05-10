package test.TestSleepAndWait;

import java.nio.channels.Pipe;

/**
 * Created by pro on 17/3/2.
 */
public class RunSleep implements Runnable {
    private Foo foo;

    public RunSleep(Foo f){
        foo=f;
    }
    @Override
    public void run() {
        synchronized (foo){
            System.out.println("RunSleep!!!  start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RunSleep!!!    end");
        }
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}
