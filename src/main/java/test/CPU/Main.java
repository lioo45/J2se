package test.CPU;

import java.util.HashMap;

/**
 * Created by pro on 16/12/14.
 */
public class Main {
    public static void main(String[] args) {

        int j=0;
        while(true){
            for(int i=0;i<1000000;++i)
                j++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
