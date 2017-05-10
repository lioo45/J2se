import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class TestFile {
	public static void main(String[] args) throws Exception {
		FileReader fileReader=new FileReader("C:/Users/lenovo/Desktop/buffer.txt");
		BufferedReader reader=new BufferedReader(fileReader);
		String s;
		FileWriter fw=new FileWriter("C:/Users/lenovo/Desktop/test.txt",true);
		
		fw.write("2222\r\n");
		fw.flush();
//		while((s=reader.readLine())!=null){
//			System.out.println(s);
//		}
		reader.close();
		fileReader.close();
		fw.close();
	}
}
