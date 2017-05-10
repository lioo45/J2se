package concurrency.synchornized;


/**
 * Created by pro on 17/1/10.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Test1 t=new Test1();
        Main main=new Main();
        Thread th1=new Thread(new Run1(t,main));
        Thread th2=new Thread(new Run2(t,main));
        th1.start();
        th2.start();
        while(true) {
            synchronized (main) {
                main.wait();
            }
            if(t.r1Finished&&t.r2Finished) {
                System.out.println(t.num);
                break;
            }
        }

    }

}
