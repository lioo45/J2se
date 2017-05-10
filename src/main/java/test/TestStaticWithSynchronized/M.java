package test.TestStaticWithSynchronized;

/**
 * Created by pro on 17/3/2.
 * 关于一个对象的synchronized方法,
 * 如果这个方法是非静态的,那么其他所以非静态的synchronized方法需要等到该方法运行完才能运行,
 * 但是其他的静态synchronized方法可以并发运行.
 * 说明静态synchronized方法的锁是类Class对象
 * 而非静态方法的锁是对象实例本身.
 */
public class M {
    public static void main(String[] args) {
//        Woo w=new Woo();
//        Thread t1=new Thread(new Run(w));
//        t1.start();
//        Thread t2=new Thread(new Run2(w));
//        t2.start();
//        //确保t2在后面的代码之前执行
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (Woo.class){
//            System.out.println("如果这行出现在t2退出之后,则说明静态synchronized方法的锁是类Class对象");
//        }
        int x=1;
        M m=new M();
        final Hold hold=m.new Hold();
        final int finalX = x;
        Thread tt=new Thread(new Runnable() {
            @Override
            public void run() {
                hold.a=finalX+1;
                System.out.println("!!!!!"+ finalX);
            }
        });
        x++;
        tt.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hold.a);
    }
     class Hold{
        int a=0;
    }
}
