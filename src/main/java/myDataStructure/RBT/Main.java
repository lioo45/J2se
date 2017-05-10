package myDataStructure.RBT;

import myDataStructure.SkipList.SkipList;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by pro on 17/3/14.
 */
public class Main {

    static RedBlackTree root=new RedBlackTree();
    static SkipList sl=new SkipList();
    static Set<Integer> set = new TreeSet<Integer>();
    static Set<Integer> css=new ConcurrentSkipListSet<Integer>();
    static int g;

    public static void main(String[] args) {
        int testNum=100000;
        Random random=new Random();
        int i;
        Set<Integer> a=new HashSet<Integer>();
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(10000000)+random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100);
            a.add(rand);
        }


        testRBT(a,root);
//        root.traval();
//        testTreeMap(a);

//        testSkipList(a,sl);

//        testConcurrentSkipList(a);

//        testConcurrentSkipList(a);

//
//        while(true){
//
//        }
    }

    public static void testSkipList(int[] a, SkipList sl){
        System.out.println();
        long putBegin=System.currentTimeMillis();
        for (int j = 0; j <a.length ; j++) {
//            System.out.println("insert :"+a[j]);
            sl.add(a[j]);
        }
        long put_end=System.currentTimeMillis();
        System.out.println("put运行了"+(put_end-putBegin));
//	traval(rbt.root,rbt);
        long getBegin=System.currentTimeMillis();
//        root.traval();
        for (int j = 0; j <a.length ; j++) {
            if(!sl.contains(a[j])){
                System.out.println("false 不包含:"+a[j]);
            }
        }
        long getEnd=System.currentTimeMillis();
        System.out.println("get 运行了"+(getEnd-getBegin));

    }

    public static void testRBT(int[] a,RedBlackTree root){
        System.out.println();
        long RBT_PutBegin=System.currentTimeMillis();
        for (int j = 0; j <a.length ; j++) {
//            System.out.println("insert :"+a[j]);
            root.put(a[j]);
            g=a[j];
        }
        long RBT_Put_end=System.currentTimeMillis();
        System.out.println("put运行了"+(RBT_Put_end-RBT_PutBegin));
//	traval(rbt.root,rbt);
        long RBT_GetBegin=System.currentTimeMillis();
//        root.traval();
        for (int j = 0; j <a.length ; j++) {
            if(!root.contains(a[j])){
                System.out.println("false 不包含:"+a[j]);
            }
            g=a[j];
        }
        long RBT_GetEnd=System.currentTimeMillis();
        System.out.println("get 运行了"+(RBT_GetEnd-RBT_GetBegin));

        System.out.println("hight:"+root.getHigh());
        System.out.println("size: "+root.size());
        System.out.println(("numOfSpin:"+root.getNumOfSpin()));

        System.out.println("运行remove之前 树是否正确:"+root.isCorrect());
        long rmStart=System.currentTimeMillis();
        System.out.println("测试remove");
        int len=a.length/2;
        for (int i = 0; i <len ; i++) {
            root.remove(a[i]);
        }
        long rmEnd=System.currentTimeMillis();
        System.out.println("rm运行了:"+(rmEnd-rmStart));
        System.out.println("hight:"+root.getHigh());
        System.out.println("size: "+root.size());
        System.out.println(root.isCorrect());

//        for (int i = a.length/2; i <a.length ; i++) {
//            if(!root.contains(a[i])){
//                System.out.println("false 不包含:"+a[i]);
//            }
//        }
    }

    public static void testRBT(Set<Integer> a,RedBlackTree root){
        System.out.println();
        long RBT_PutBegin=System.currentTimeMillis();
        for (Integer i:a) {
            root.put(i);
        }
        long RBT_Put_end=System.currentTimeMillis();
        System.out.println("put运行了"+(RBT_Put_end-RBT_PutBegin));
//	traval(rbt.root,rbt);
        long RBT_GetBegin=System.currentTimeMillis();
//        root.traval();
        for(Integer j:a){
            if(!root.contains(j)){
                System.out.println("false 不包含:"+j);
            }
        }
        long RBT_GetEnd=System.currentTimeMillis();
        System.out.println("get 运行了"+(RBT_GetEnd-RBT_GetBegin));

        System.out.println("hight:"+root.getHigh());
        System.out.println("size: "+root.size());
        System.out.println(("numOfSpin:"+root.getNumOfSpin()));

        System.out.println("运行remove之前 树是否正确:"+root.isCorrect());
        long rmStart=System.currentTimeMillis();
        System.out.println("测试remove");
        int len=a.size()/2;
        int j=0;
         for(Integer i:a){
            root.remove(i);
//             j++;
//             if(j==len)
//                 break;
        }
        long rmEnd=System.currentTimeMillis();
        System.out.println("rm运行了:"+(rmEnd-rmStart));
        System.out.println("hight:"+root.getHigh());
        System.out.println("size: "+root.size());
        System.out.println(root.isCorrect());

//        for (int i = a.length/2; i <a.length ; i++) {
//            if(!root.contains(a[i])){
//                System.out.println("false 不包含:"+a[i]);
//            }
//        }
    }

    public static void testTreeMap(int[] a){
        System.out.println();
        long putBegin=System.currentTimeMillis();
        for (int j = 0; j <a.length ; j++) {
//            System.out.println("insert :"+a[j]);
            set.add(a[j]);
        }
        long put_end=System.currentTimeMillis();
        System.out.println("put运行了"+(put_end-putBegin));
//	traval(rbt.root,rbt);
        long getBegin=System.currentTimeMillis();
//        root.traval();
        for (int j = 0; j <a.length ; j++) {
            if(!set.contains(a[j])){
                System.out.println("false 不包含:"+a[j]);
            }
        }
        long getEnd=System.currentTimeMillis();
        System.out.println("get 运行了"+(getEnd-getBegin));
    }

    public  static void testConcurrentSkipList(int[] a){
        System.out.println();
        long putBegin=System.currentTimeMillis();
        for (int j = 0; j <a.length ; j++) {
//            System.out.println("insert :"+a[j]);
            css.add(a[j]);
        }
        long put_end=System.currentTimeMillis();
        System.out.println("put运行了"+(put_end-putBegin));
//	traval(rbt.root,rbt);
        long getBegin=System.currentTimeMillis();
//        root.traval();
        for (int j = 0; j <a.length ; j++) {
            if(!css.contains(a[j])){
                System.out.println("false 不包含:"+a[j]);
            }
        }
        long getEnd=System.currentTimeMillis();
        System.out.println("get 运行了"+(getEnd-getBegin));
    }

    public static  void testConcurrentTreeSet(int[] a){
        System.out.println();
        Set<Integer>  set1= Collections.synchronizedSet(set);
        long putBegin=System.currentTimeMillis();
        for (int j = 0; j <a.length ; j++) {
//            System.out.println("insert :"+a[j]);
            set1.add(a[j]);
        }
        long put_end=System.currentTimeMillis();
        System.out.println("put运行了"+(put_end-putBegin));
        long getBegin=System.currentTimeMillis();
//        root.traval();
        for (int j = 0; j <a.length ; j++) {
            if(!set1.contains(a[j])){
                System.out.println("false 不包含:"+a[j]);
            }
        }
        long getEnd=System.currentTimeMillis();
        System.out.println("get 运行了"+(getEnd-getBegin));
    }

}
