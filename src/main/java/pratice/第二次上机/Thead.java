package pratice.第二次上机;

/**
 * Created by pro on 17/4/17.
 */
import java.net.URL;
import java.io.*;
public class Thead {
    public static void main(String[] args) {
        FileOutputStream fos=null;
        Reader r=null;
        InputStream is=null;
        try {
            URL u = new URL("http://www.sina.com.cn");
            is = u.openStream();
            is = new BufferedInputStream(is);
            r = new InputStreamReader(is);
            fos = new FileOutputStream("sina.html");
            int c = 0;
            while((c = r.read())!=-1){
                fos.write(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                r.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}