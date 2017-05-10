package test.testAnonymousInnterClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by pro on 17/3/19.
 */
public class Test {

    private volatile boolean stoped;

    public void test(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(!stoped) {
                    ++i;
                }
            }
        });
        t.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stoped=true;
    }

}
