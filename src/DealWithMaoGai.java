import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class DealWithMaoGai {
	public static void main(String[] args) throws Exception {
		
			FileReader fileReader=new FileReader("E:\\Ã«¸Å.txt");
			BufferedReader reader=new BufferedReader(fileReader);
			String s;
			FileWriter fw=new FileWriter("E:\\´ð°¸01.txt");
		
			int i=0;
			int m=409,m1=569;
			while((s=reader.readLine())!=null){
				if(s.contains("´ð°¸")){
					++i;
					s=s.replace("¡¾´ð°¸¡¿","");
					System.out.println(s);
					String s1=String.valueOf(i);
					String result=s1+"."+s;
					int n;
					n=14-result.length();
					for(int k=0;k<n;++k){
						result+=" ";
					}
					fw.write(result);
					
					if(i%6==0){
						fw.write("\r\n");
					}
					if(i==m){
						i=0;
						m=m1;
						fw.write("\r\n");
					}
				}
					
			}
			reader.close();
			fileReader.close();
			fw.close();
		

	}
}
