package test.effectiveJava;

import java.util.concurrent.TimeUnit;

/**
 * Created by pro on 17/1/1.
 * 后台线程将永远循环下去
 * 因为虚拟机做的优化将
 * while(!isStop)
 *
 */
public class TestP230 {

    private static boolean isStop=false;

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(!isStop)
                    i++;
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);

        isStop=true;

/**
 * 后台线程将永远循环下去
 * 因为虚拟机做的优化将
 * while(!isStop)
 *  i++;
 *  优化成
 *  if(!isStop)
 *      while(true)
 *          i++;
 */
        //解决办法之一 将isStop设置成volatile
        //二
        //同步访问isStop域
    }
}
