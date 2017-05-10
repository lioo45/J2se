package xiaozhao.wangyi2017;

import java.util.Scanner;

/**
 * Created by pro on 17/3/25.
 */
public class Main11 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            Node chuzu[]=new Node[num];
            //初始化出租车坐标
            int tx[]=new int[num];
            for (int i = 0; i <num ; i++) {
                tx[i]=in.nextInt();
            }
            for (int i = 0; i <num ; i++) {
                int cy=in.nextInt();
                chuzu[i]=new Node(tx[i],cy);
            }
            //公司的
            int x=in.nextInt();
            int y=in.nextInt();

            int walkTime=in.nextInt();
            int taixiTime=in.nextInt();
            int minTime=Integer.MAX_VALUE;
            for (int i = 0; i <num ; i++) {
                Node node=chuzu[i];
                int current=0;
                int walkNum=Math.abs(node.x)+Math.abs(node.y);
                current=current+walkNum*walkTime;
                int taxiNum=Math.abs(node.x-x)+Math.abs(node.y-y);
                current=current+taxiNum*taixiTime;
                if(current<minTime)
                    minTime=current;
            }
            int tt=(Math.abs(x)+Math.abs(y))*walkTime;
            if(tt<minTime)
                minTime=tt;
            System.out.println(minTime);

        }
    }



}
