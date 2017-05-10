package concurrency.synchornized;

/**
 * Created by pro on 17/1/10.
 * synchronized方法默认是锁住this这个对象.
 * 也就是说
 * 同一时刻,一个对象中,只能有一个synchronized方法运行,
 * 其他的synchronized不能并发运行.
 * 非synchronized方法可以并发运行.
 *
 * Main Run1 IdentifySleep Test1 一起验证了这个结论.
 * 首先,down方法是synchronized的 up方法不是
 * Run1调用100000000次up() Run2调用100000000次down()
 * Main的输出是一个不等于9999的数字.
 * 当将up改为synchronized之后
 * Main输出9999
 */
public class Test1 {
    boolean r1Finished=false;
    boolean r2Finished=false;

    int num=9999;


    public synchronized  void down(){
        num--;
    }

//    public void up(){
//        num++;
//
//    }
    public synchronized void up(){
        num++;
    }

}
