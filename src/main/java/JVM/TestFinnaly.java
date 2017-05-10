package JVM;

import javafx.scene.media.SubtitleTrack;

/**
 * Created by pro on 16/11/21.
 * 事实证明在try catch finally机制里,
 * 无论是否抛异常,或者在try catch里提前返回
 * finally的代码还是会运行
 */

public class TestFinnaly {
    static int x=0;

    public static void main(String[] args) {
        System.out.println("运行test");
        System.out.println(test());
        System.out.println(x);
        x=0;
        System.out.println("运行test1");
        System.out.println(test1());
        System.out.println(x);
    }


    public static int  test(){
        try{
            x=1;
            return x;
        }catch (Exception e){
            x=2;
            return x;
        }finally {
            x=3;
        }
    }

    public static int  test1(){
        try{
            x=1;
            if(x==1)
                throw new RuntimeException();
            return x;
        }catch (Exception e){
            x=2;
            return x;
        }finally {
            x=3;
        }
    }
}
