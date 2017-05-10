package test.TestStaticWithSynchronized;

/**
 * Created by pro on 17/3/2.
 */
public class Woo {

    public synchronized void  t1(){
        System.out.println("进入t1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出t1");
    }

    public synchronized static void  t2(){
        System.out.println("t2进入");
        System.out.println("如果这行出现在t1退出之前,则说明" +
                "一个线程进入一个对象的非静态synchronize方法之后," +
                "另外一个线程还可以进入这个线程的其他静态synchronize方法" +
                "否则不能");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t2退出");
    }


}
