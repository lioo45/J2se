package xiaozhao.huawei2017;//package huawei;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by pro on 17/3/24.
// */
//public class Main {
//
//    public static void main(String[] args) {
//        //初始矩阵
//        int a[][]= {
//                {0,      2,      10,     5,      3,      1000},
//                {1000,   0,      12,     1000,   1000,   10},
//                {1000,   1000,   0,      1000,   7,      1000},
//                {2,      1000,   1000,   0,      2,      1000},
//                {4,      1000,   1000,   1,      0,      1000},
//                {3,      1000,   1,      1000,   2,      0}
//        };
//
//
//
//
//
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int m=sc.nextInt();
//            if(n==m){
//                System.out.println("[]");
//                continue;
//            }
//        }
//    }
//
//    //迪杰斯特拉最短路径
//    public static int[] minMoney(int[][] a,int x,int y){
//        //更改矩阵
//        for (int i = 0; i <a.length ; i++) {
//            a[y][i]=1000;
//            a[i][y]=1000;
//        }
//        //
//        int minSpend[]={
//                1000,1000,1000,1000,0,1000,
//        };
//        //初始只有第五个城市
//        int[] s=new int[6];
//        s[0]=5;
//        int sIndex=1;
//        //初始未选城市
//        boolean[] city={
//                true,true,true,true,false,true
//        };
//        boolean continued=true;
//        //开始执行并松弛
//        while(continued) {
//            continued=false;
//            int select[] = selectMinPath(s, city, a);
//            if (select != null) {
//                s[sIndex]=select[1];
//                city[select[1]]=false;
//
//                //
//                int[] arrcied=getArrive(a,select[1]);
//
//                //松弛操作
//                songChi(minSpend,);
//
//            }
//
//            for (int i = 0; i <6 ; i++) {
//                if(city[i]) {
//                    continued=true;
//                    break;
//                }
//            }
//
//        }
//    }
//
//    //返回选择的路径下表 fromIndex toIndex
//    private static int[] selectMinPath(int[] s, boolean[] city,int a[][]) {
//        int min=10000;
//        int fromIndex=-1;
//        int toIndex=-1;
//        for(int i:s){
//            fromIndex=i;
//            for (int j = 0; j <6 ; j++) {
//                if(a[i][j]==1000)
//                    continue;
//                if(min>a[i][j]){
//                    min=a[i][j];
//                    toIndex=j;
//                }
//            }
//        }
//        if(min>=1000)
//            return null;
//        int result[]={
//                fromIndex,toIndex
//        };
//        return result;
//    }
//
//    public static int[] getArrive(int a[][],int index){
//        ArrayList<Integer> list=new ArrayList<Integer>();
//        for (int i = 0; i <6; i++) {
//            if(a[i][index]!=1000){
//                list.add(index);
//            }
//        }
//        if(list.size()==0)
//            return null;
//        int []r=new int[list.size()];
//        for (int i = 0; i <r.length ; i++) {
//            r[i]=list.get(i);
//        }
//        return r;
//    }
//
//
//}
