package JVM;

/**
 * Created by pro on 16/11/19.
 * JAVA语言 方法重载的特征签名为方法名 参数列表,参数顺序,返回值可同可不同
 *
 * 但是在JVM识别的class文件里
 * 方法重载的特征签名为描述符(返回值 参数列表等等)
 * 也就是说在class文件里 方法重载有相同的参数列表 不同的返回值
 */

public class TestOverLoad {

    public static void main(String[] args) {
        System.out.println(test(3,5));
        System.out.println(test("aa"));
    }

    public static int test(int a,int b){
        return a+b;
    }
    public static String test(String a){
        return a;
    }
    //can't compile
//    public static float test(int a,int b){}
}
