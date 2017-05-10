package com.myRsCrawler;
public class Main {
	public static void main(String[] args) {
		RsCore1 rs=new RsCore1();
		rs.setEncoding("utf-8");
		rs.setFileUrl("/Users/pro/Documents/rsCrawer/rsTids.txt");
		rs.setRequestUrl("http://rs.xidian.edu.cn/forum.php?mod=forumdisplay&fid=110&mobile=no");
		rs.setPrefix("http://rs.xidian.edu.cn/");
		rs.setConditionConfUrl("/Users/pro/Documents/rsCrawer/conditions.txt");
		while(true){
			rs.go();	 
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
	}
}