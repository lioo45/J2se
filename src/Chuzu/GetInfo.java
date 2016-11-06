package Chuzu;



public class GetInfo {
	public static void main(String[] args) throws InterruptedException {
//		Core haowang=new Core();
//		RsCore rs=new RsCore();
		Core1 haowang=new Core1();
		RsCore1 rs=new RsCore1();
		haowang.setRequestUrl("http://club.xdnice.com/forum.php?mod=forumdisplay&fid=118&page=1&mobile=no");
		haowang.setPrefix("http://club.xdnice.com/");
		haowang.setEncoding("gbk");
		haowang.setConditionConfUrl("E:/myConfig/chuzu/conditions.txt");
		//设置保存帖子tid的文件路径
		haowang.setFileUrl("E:/myConfig/chuzu/niceTid.txt");
		
		rs.setEncoding("utf-8");
		rs.setRequestUrl("http://rs.xidian.edu.cn/forum.php?mod=forumdisplay&fid=546&mobile=no");
		rs.setPrefix("http://rs.xidian.edu.cn/");
		rs.setConditionConfUrl("E:/myConfig/chuzu/conditions.txt");
		//设置保存帖子tid的文件路径
		rs.setFileUrl("E:/myConfig/chuzu/rsTid.txt");
		while(true){
			haowang.go();
			rs.go();
			//每30秒运行一次 
			Thread.sleep(30000);
		}
	
	}
}
