package test.TestStaticWithSynchronized;

/**
 * Created by pro on 17/3/2.
 */
public class Run2 implements Runnable {
    Woo w;

    public Run2(Woo w) {
        this.w = w;
    }

    @Override
    public void run() {
        w.t2();
    }
}
