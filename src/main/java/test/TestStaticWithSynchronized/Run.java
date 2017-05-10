package test.TestStaticWithSynchronized;

/**
 * Created by pro on 17/3/2.
 */
public class Run implements Runnable{
    private Woo w;

    public Run(Woo w) {
        this.w = w;
    }

    @Override
    public void run() {
        w.t1();
    }
}
