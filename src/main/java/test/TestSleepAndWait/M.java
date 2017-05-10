package test.TestSleepAndWait;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 17/3/2.
 */
public class M {
    private  List<Integer> list=new ArrayList<Integer>();
    public static void main(String[] args) {
        Foo f=new Foo();
//        Thread t1=new Thread(new RunSleep(f));
//        t1.start();
//        Thread t2=new Thread(new IdentifySleep(f));
//        t2.start();

//        Thread t3=new Thread(new RunWait(f));
//        t3.start();
//        //确保t3已经运行且wait
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread t4=new Thread(new IdentifyWait(f));
//        t4.start();
//        List<Integer> list=new ArrayList<Integer>();
//        for (int i = 0; i <10 ; i++) {
//            list.add(i);
//        }


    }
    public void test(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    list.add(i);
                }
                list.remove(10);
                list=null;
            }
        });
        t.start();
    }
}
