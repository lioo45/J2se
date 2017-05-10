package xiaozhao.qunaer;

import java.util.Scanner;

/**
 * Created by pro on 17/4/1.
 */
public class Main4 {
    int x=1;
    public static void main(String[] args) {
        Main4 m=new Main4();
        System.out.println(m.te());
        System.out.println(m.x);
    }

    public  int te(){
        Main4 m=new Main4();
        try{
            m.x=5;
            x=m.x;
            return m.x;
        }catch (Exception e){
            m.x=7;
            x=m.x;
            return m.x;
        }finally {
            m.x=6;
            x=m.x;
        }
    }
}
