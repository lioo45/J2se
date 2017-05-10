package pratice.java第三次上机;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 17/4/24.
 */
public class UseList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();

        //添加
        for (int i = 0; i <100 ; i++) {
            list.add(i);
        }
        System.out.println("size:"+list.size());
        //获取并输出
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+",");
        }
        System.out.println();
        //删除
        while(!list.isEmpty()){
            list.remove(0);
        }

        System.out.println("size: "+list.size());
    }
}
