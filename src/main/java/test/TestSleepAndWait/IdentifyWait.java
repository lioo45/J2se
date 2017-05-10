package test.TestSleepAndWait;

/**
 * Created by pro on 17/3/2.
 */
public class IdentifyWait implements Runnable {
    private  Foo f;

    public IdentifyWait(Foo f) {
        this.f = f;
    }

    @Override
    public void run() {
        synchronized (f){
            System.out.println("如果这行出现在wait end!!之前");
            System.out.println("则说明wait会释放对象锁,否则反之...");
            f.notify();
        }
    }
}
