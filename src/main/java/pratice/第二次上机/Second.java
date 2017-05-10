package pratice.第二次上机;

/**
 * Created by pro on 17/4/17.
 */
import java.io.*;

public class Second {
    public static void main(String args[] ){
        String n = "asdasdasdas";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new
                    FileWriter("test1.txt"));
            bw.write(n);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
