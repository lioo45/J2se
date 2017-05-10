package test.jdk8.deaultKey;

/**
 * Created by pro on 16/12/13.
 */
public interface Int1 {

    default void test(){
        System.out.println("Int1 test");
    }

    void hadUsed();

}
