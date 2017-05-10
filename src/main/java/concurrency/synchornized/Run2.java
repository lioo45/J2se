package concurrency.synchornized;

/**
 * Created by pro on 17/1/10.
 */
public class Run2 implements Runnable{
    public Test1 t1;
    Main main;

    public Run2(Test1 t1) {
        this.t1 = t1;
    }

    public Run2(Test1 t1, Main main) {
        this.t1 = t1;
        this.main = main;
    }

    @Override
    public void run() {
        for (int i = 0; i <100000000 ; i++) {
            t1.down();
        }
        t1.r2Finished=true;
        synchronized (main) {
            main.notify();
        }
    }
}
