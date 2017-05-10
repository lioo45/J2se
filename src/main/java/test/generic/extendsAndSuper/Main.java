package test.generic.extendsAndSuper;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 16/12/13.
 */
public class Main {
    public static void main(String[] args) {
        test1();
        testSub();
        testSubSub();
        String s="1234";
        s=s.substring(0,s.length()-1);
        System.out.println(s);
    }

    public static void test1(){
        List<Test> list=new ArrayList<Test>();
        list.add(new Test(1));
        list.add(new Test(3));
        list.add(new Test(7));
        list.add(new Test(2));
        list.add(new Test(4));
        Test max=Generic.max(list);
        System.out.println(max.getNum());
    }

    public static void testSub(){
        List<TestSub> list=new ArrayList<TestSub>();
        list.add(new TestSub(1));
        list.add(new TestSub(3));
        list.add(new TestSub(7));
        list.add(new TestSub(2));
        list.add(new TestSub(4));
        //无法通过编译 因为TestSub没有实现Comparable接口(父类实现)
//        TestSub max=Generic.max(list);
        TestSub max=Generic.max1(list);
        System.out.println(max.getNum());
    }

    public static void testSubSub(){
        List<SubSub> list=new ArrayList<SubSub>();
        list.add(new SubSub(1));
        list.add(new SubSub(3));
        list.add(new SubSub(7));
        list.add(new SubSub(2));
        list.add(new SubSub(4));
//        TestSub max=Generic.max1(list);

        SubSub max=Generic.max1(list);
        System.out.println(max.getNum());
    }
}
