package Chuzu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.joda.time.DateTime;

public class RsCore extends Core {
	
	@Override
	protected boolean dateIsSuitable(BufferedReader bufferReader)
			throws IOException {
		String s;
		String date;
		while((s=bufferReader.readLine())!=null){
			if(s.contains("2016")){
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
