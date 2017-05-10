package myDataStructure.RBT;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by pro on 17/3/21.
 */
public class Test {
    public static void main(String[] args) {
        int testNum=1000000;
        Random random=new Random();
        int i;
        Set<Integer> a=new HashSet<Integer>();
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(10000000)+random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100);
            a.add(rand);
        }
//        for (int j = testNum; j >=0; j--) {
//            a.add(j);
//        }
        int[] array=new int[a.size()];
        i=0;
        for(Integer v:a){
            System.out.print(v+",");
            array[i]=v;
            ++i;
        }

        testRBT(array,new RedBlackTree());

//        test();
    }

    public static void test(){
//        int[] a={75,42,25,61,11,30,39,86,96,85};
//        int []a={31,34,66,37,53,52,19,21,71,73};
//        int[] a={79,47,40,28,63,25,30,81,53,75};
        int[] a={49,74,36,89,31,97,53,57,22,98};

        Set<Integer> set=new HashSet<Integer>();
//
//        for(int i:a){
//            set.add(i);
//        }
        RedBlackTree root=new RedBlackTree();
        testRBT(a,root);
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
        int j=0;

        int[] array=new int[a.size()];
        int i=0;
        for(Integer v:a){
            array[i]=v;
            ++i;
        }
        int len=array.length/2;
        for (int k = 0; k <len; k++) {
            root.remove(array[k]);
            a.remove(array[k]);
//            System.out.println("a.size:"+a.size());
            for(Integer v:a){
                if(!root.contains(v)){
                    System.out.println("this is false 不包含:"+v);
                }
            }
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


    public static void testRBT(int[] a,RedBlackTree root){
        System.out.println();
        long RBT_PutBegin=System.currentTimeMillis();
        for (int j = 0; j <a.length ; j++) {
//            System.out.println("insert :"+a[j]);
            root.put(a[j]);
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
        }
//        root.traval();
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
//            System.out.println("删除"+a[i]+"后 遍历:");
//            System.out.println("----------------------------------------------------------------");
//            root.traval();
//            System.out.println("----------------------------------------------------------------");

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


}
