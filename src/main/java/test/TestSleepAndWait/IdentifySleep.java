package test.TestSleepAndWait;

/**
 * Created by pro on 17/3/2.
 */
public class IdentifySleep implements Runnable
{
    private Foo f;

    public IdentifySleep(Foo f) {
        this.f = f;
    }

    @Override
    public void run() {
        synchronized (f){
            System.out.println("如果这行出现在RunSleep 结束之前,则说明sleep会释放锁");
            System.out.println("否则说明sleep不释放锁");
        }
    }
}
