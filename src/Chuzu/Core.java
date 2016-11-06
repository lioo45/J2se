package Chuzu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashSet;

import org.joda.time.DateTime;

public class Core {
		//保存tid防止重复发生邮件
		protected HashSet<String> tids=new HashSet<String>();
		//保存tid的文件路径
		protected String fileUrl;
		protected FileWriter fw;
		//要请求的url
		protected String requestUrl;
		//url前缀
		protected String prefix;
		//设置编码
		protected String encoding;
		//已经发送的邮件数
		protected int mailNumber=0;
		//运行了几次
		protected int times=0;
		public Core(){
			
		}
		//根据文件的内容构造hashset
		public Core(String fileUrl){
			this.fileUrl=fileUrl;
			init();
		}
		private void init(){
			BufferedReader reader=null;
			FileReader fileReader =null;
			try {
				
				 fileReader = new FileReader(fileUrl);
				 reader = new BufferedReader(fileReader);
				String s;
				fw=new FileWriter(fileUrl,true);
				while((s=reader.readLine())!=null){
					tids.add(s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					reader.close();
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
		}
		public void go(){
			times++;
			URL url;
			try {
				url = new URL(requestUrl);
				HttpURLConnection httpConn=(HttpURLConnection) url.openConnection();
				InputStreamReader ireader=new InputStreamReader(httpConn.getInputStream(),encoding);
				BufferedReader bufferReader=new BufferedReader(ireader);
				String line=null;
				String link=null;
				String subject=null;
				String name=null;
				if(this.getClass()==Core.class)
					name="抓取好网出租数据";
				if(this.getClass()==RsCore.class)
					name="抓取睿思出租数组";
				while((line=bufferReader.readLine())!=null){
					//如果该行包含<a href 则读取下一行内容
					if(line.contains("atarget(this)")){
							//获取主题
							subject=getSubject(line);
									
//							System.out.println(line);
						
						//如果包含出租且包含新校区 
						if(subject.contains("出租")||subject.contains("转租")){
							if(subject.contains("新校区")||subject.contains("南校区")||subject.contains("新区")){
								//获取链接
								link=dealWithLink(line,prefix);
								//获得tid并放入set和写入文件
								if(dateIsSuitable(bufferReader)){
									String tid=getTid(link);
									if(!tids.contains(tid)){
										tids.add(tid);
										fw.write(tid+"\r\n");
										fw.flush();
										//发送邮件
										SendMail.send(subject,"这是链接:"+link);
										mailNumber++;
										System.out.println(name+"主题:"+subject);
										System.out.println(name+"链接:"+link);
										System.out.println("当前已发送:"+mailNumber+"封邮件");
//										System.out.println("tid======"+tid);
									}
									else continue;
								}
							}
						}
					}
					
				}
				
				System.out.println("第"+times+"次"+name+"  "+new DateTime().toString());
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
			}
		
		}
			
	

		protected String getSubject(String line){
			String s=line.substring(line.indexOf("atarget(this)"));
			s=s.substring(s.indexOf(">")+1);
			s=s.substring(0,s.lastIndexOf("<"));
			return s;
		}
		//处理该行成一个可用链接
		protected String dealWithLink(String link,String pre){
			String s=link.substring(link.indexOf('"')+1);
			s=s.substring(0,s.lastIndexOf("onclick")-2);
			s=s.replaceAll("&amp;", "&");
			s=pre+s;
			return s;
		}
		
		//获得链接的tid
		protected String getTid(String link){
			String s=link.substring(link.indexOf("tid="));
			s=s.substring(4);
			s=s.substring(0,s.indexOf("&"));
			return s;
		}
		
		//验证发帖日期,如果是今天或者昨天返回true
		protected boolean dateIsSuitable(BufferedReader bufferReader) throws IOException{
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
		public String getFileUrl() {
			return fileUrl;
		}
		public void setFileUrl(String fileUrl) {
			this.fileUrl = fileUrl;
			init();
		}
		public int getMailNumber() {
			return mailNumber;
		}
		public String getRequestUrl() {
			return requestUrl;
		}
		public void setRequestUrl(String requestUrl) {
			this.requestUrl = requestUrl;
		}
		public String getPrefix() {
			return prefix;
		}
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		public String getEncoding() {
			return encoding;
		}
		public void setEncoding(String encoding) {
			this.encoding = encoding;
		}
		
		
	}


