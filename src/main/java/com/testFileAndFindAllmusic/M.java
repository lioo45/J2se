package com.testFileAndFindAllmusic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* decription:this program can copy the all file that
 *  you specify a directory to a directory you specify;
 *  @args: url : the src dir
 *  	  s   : the target folder
 *  @author: lwz1995
 *  
 */
public class M {
	public static void main(String[] args) throws IOException {
		// 
		/*获得所以文件夹下的所有File的名
		 * 遍历这个list
		 * 若是文件夹,则展开
		 * 若是文件,则拷贝到一个新的地方
		 * 
		 */
		String url="F:/91UserData/Backup/20150416210617(HUAWEI P7-L00)/Music";
		String s="D:/musicPlayer/musicFromHuaWei/";
//		String url="H:/test1";
		work(url,s);
	}
	
	public static void work(String url,String s) throws IOException{
		File file=new File(url);
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isDirectory()){
				String newUrl=url+"/"+f.getName();
				work(newUrl,s);
			}
			if(f.isFile()){
				String newUrl=s+f.getName();
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f));
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newUrl));
				byte[] b=new byte[1024];
				int len;
				while((len=bis.read(b, 0, b.length))!=-1){
					bos.write(b, 0, len);
				}
				bis.close();
				bos.close();
			}
				
		}
	}
}
