package test.TestSleepAndWait;

/**
 * Created by pro on 17/3/2.
 */
public class RunWait implements  Runnable{
    private Foo f;

    public RunWait(Foo f) {
        this.f = f;
    }

    @Override
    public void run() {
        synchronized (f){
            System.out.println("wait start!!!!");
            try {
                f.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait end!!!");
        }
    }
}
