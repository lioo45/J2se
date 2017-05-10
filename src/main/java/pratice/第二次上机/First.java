package pratice.第二次上机;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pro on 17/4/17.
 */
public class First {
    public static void main(String[] args){
        String f = "test.txt";
        double q[] = {1.23,69.88,34.45,67.98,2345.67};
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            for(int i = 0; i<q.length; i++){
                fos.write((char)q[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
