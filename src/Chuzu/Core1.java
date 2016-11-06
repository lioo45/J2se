package Chuzu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.joda.time.DateTime;

public class Core1 {
		//保存tid防止重复发生邮件
		private HashSet<String> tids=new HashSet<String>();
		//保存tid的文件路径
		private String fileUrl;
		private FileWriter fw;
		//要请求的url
		private String requestUrl;
		//url前缀
		private String prefix;
		//设置需要满足的条件的配置文件路径
		private String conditionConfUrl;
		//设置编码
		private String encoding;
		//已经发送的邮件数
		private int mailNumber=0;
		//运行了几次
		private int times=0;
		public Core1(){
			
		}
		//根据文件的内容构造hashset
		public Core1(String fileUrl){
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
			InputStreamReader ireader=null;
			HttpURLConnection httpConn=null;
			BufferedReader bufferReader=null;
			try {
				url = new URL(requestUrl);
				httpConn=(HttpURLConnection) url.openConnection();
				ireader=new InputStreamReader(httpConn.getInputStream(),encoding);
				bufferReader=new BufferedReader(ireader);
				String line=null;
				String link=null;
				String subject=null;
				String name=null;
				if(this.getClass()==Core1.class)
					name="抓取好网出租数据";
				if(this.getClass()==RsCore1.class)
					name="抓取睿思出租数组";
				while((line=bufferReader.readLine())!=null){
					//如果该行包含<a href 则读取下一行内容
					if(line.contains("atarget(this)")){
						//获取主题
						System.out.println(line);
						subject=getSubject(line);
						//如果满足配置文件的所有条件
						if(meetAllCondition(subject)){
							//获取链接
							link=dealWithLink(line,prefix);
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
//									System.out.println("tid======"+tid);
								}
								else continue;
							}
						}
					}
					
				}
				
				System.out.println("第"+times+"次"+name+"  "+new DateTime().toString());
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					bufferReader.close();
					ireader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				httpConn.disconnect();
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
		//conditions表示一组相或的条件,
		//如果info满足这一组条件,则返回true否则返回false
		protected boolean meetOneCondition(String conditions,String info){
			//取得每个条件
			String[] ss=conditions.split(",");
			
			for(int i=0;i<ss.length;++i){
				//如果满足条件
				if(info.toLowerCase().contains(ss[i]))
					return true;
			}
			return false;
		}
		//满足所有的条件组则返回true否则返回false
		protected boolean meetAllCondition(String info){
			BufferedReader reader=null;
			FileReader fileReader =null;
			try {
				
				 fileReader = new FileReader(conditionConfUrl);
				 reader = new BufferedReader(fileReader);
				 String s;
				 while((s=reader.readLine())!=null){
				  	 if(!meetOneCondition(s, info))
						 return false;
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{
				try {
					reader.close();
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
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
		public String getConditionConfUrl() {
			return conditionConfUrl;
		}
		public void setConditionConfUrl(String conditionConfUrl) {
			this.conditionConfUrl = conditionConfUrl;
		}
		
		
	}



