package test.testDeadLoop;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

/**
 * Created by pro on 17/3/16.
 */
public class Main {

    public static void main(String[] args) {
        int i=0;
        while(true){
            i++;
        }
    }
}
