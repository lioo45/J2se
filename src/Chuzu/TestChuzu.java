package Chuzu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.joda.time.DateTime;


public class TestChuzu {
	public static void main(String[] args) {
//		String s="http://rs.xidian.edu.cn/search.php?mod=forum&srchtxt=10&formhash=1539b2ee&searchsubmit=true";
//		String s="http://rs.xidian.edu.cn";
		String s="http://rs.xidian.edu.cn/forum.php?mod=forumdisplay&fid=110&filter=typeid&typeid=2&mobile=no";
//		String s="http://club.xdnice.com/forum.php?mod=viewthread&amp;tid=1421126&amp;extra=page%3D1%26filter%3Dsortid%26sortid%3D252&amp;mobile=no";
		s=s.replaceAll("&amp;","&");
		URL url;
		try {
			url = new URL(s);
			
//			HttpURLConnection httpConn=(HttpURLConnection) url.openConnection();
//			InputStreamReader ireader=new InputStreamReader(httpConn.getInputStream(),"utf-8");
			InputStreamReader ireader=new InputStreamReader(url.openStream(),"utf-8"); 

			BufferedReader bufferReader=new BufferedReader(ireader);
			String line;
			String subject=null;
			String link=null;
			while((line=bufferReader.readLine())!=null){
				if(line.contains("atarget(this")){
					subject=getSubject(line);
					link=dealWithLink(line,"http://rs.xidian.edu.cn/");
					System.out.println(subject);
					System.out.println(link);
				}
				
			}
			
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	public static String getSubject(String line){
		String s=line.substring(line.indexOf("atarget(this)"));
		s=s.substring(s.indexOf(">")+1);
		s=s.substring(0,s.lastIndexOf("<"));
		return s;
	}
	//处理该行成一个可用链接
	public static  String dealWithLink(String link,String pre){
		String s=null;
		s=link.substring(0,link.lastIndexOf("onclick")-2);
		s=s.substring(s.lastIndexOf("\"")+1);
		s=s.replaceAll("&amp;", "&");
		s=pre+s;
		return s;
	}
	
	//获得链接的tid
	private String getTid(String link){
		String s=link.substring(link.indexOf("tid="));
		s=s.substring(4);
		s=s.substring(0,s.indexOf("&"));
		return s;
	}
	
	//验证发帖日期,如果是今天或者昨天返回true
	private boolean dateIsSuitable(BufferedReader bufferReader) throws IOException{
		String line;
		String s=null;
		while((line=bufferReader.readLine())!=null){
			if(line.contains("title=\"2016")){
				s=line;
				break;
			}
		}
		DateTime d=new DateTime();
		String wantTime=d.getYear()+"-"+d.getMonthOfYear()+"-"+
				d.getDayOfMonth();
		if(s.contains(wantTime)||s.contains("昨天"))
			return true;
		return false;
	}
}
