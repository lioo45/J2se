package test.testParentDelegate;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pro on 17/3/17.
 */
public class Main {
    public static void main(String[] args) {
        MyClassLoader m=new MyClassLoader();
        //说明普通类的顶层是ExtClassLoad
        //而不是BootStrapClassLoad
        System.out.println(m.getParent().getParent());
        System.out.println(m.getParent().getParent().getParent());

        //Object类是BootStrapClassLoad加载的
        //但是它是JVM加载工作需要的类来服务自身的
        Object ob=new Object();
        System.out.println(ob.getClass().getClassLoader());
    }
}
