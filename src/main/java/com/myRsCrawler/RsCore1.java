package com.myRsCrawler;

import java.io.BufferedReader;
import java.io.IOException;

import org.joda.time.DateTime;

public class RsCore1 extends Core1 {
	@Override
	protected boolean dateIsSuitable(BufferedReader bufferReader)
			throws IOException {
		String s;
		String date;
		while((s=bufferReader.readLine())!=null){
			if(s.contains("qiuzhao2016")||s.contains("2017")){
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
