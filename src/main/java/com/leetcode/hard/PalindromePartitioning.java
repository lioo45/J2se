package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String s="aab123321bb";
		List list=partition(s);
		System.out.println(list.size());
	}
	public static List<List<String>> partition(String s) {
		//先构造出所有回文字串  isp[i][j]=true 表示 s[i~j]是回文
		int length=s.length();
		boolean[][] isp=new boolean[length][length];
		for(int i=0;i<length;++i){
			isp[i][i]=true;
			if(i<length-1)
				isp[i][i+1]=s.charAt(i+1)==s.charAt(i)?true:false;
		}
		for(int i=2;i<length;++i)
			for(int j=i;j<length;++j)
				isp[j-i][j]=s.charAt(j-i)==s.charAt(j)?isp[j-i+1][j-1]:false;
		List<List<String>> list=new ArrayList<List<String>>();
		//然后深搜构造所有组合
//		DFSFormat(isp, 0, s, list, new ArrayList());
		for(int i=0;i<s.length();++i)
			System.out.print("  "+i);
		System.out.println();;
		System.out.println("-----------------------------------");
		for(int i=0;i<s.length();++i){
			System.out.print(i+"| ");
			for(int j=0;j<s.length();++j){
				System.out.print(isp[i][j]==true?1:0);
				System.out.print("  ");
			}
			System.out.println();
		}
				
		return list;
	}
	public static void DFSFormat(boolean[][] isp,int curLine,String s,List list,List result){
		for(int i=curLine;i<s.length();++i){
			if(isp[curLine][i]){
//				List<String> result=new ArrayList<String>();
				result.add(s.substring(curLine,i+1));
				if(i==s.length()-1){
					list.add(new ArrayList(result));
					result.remove(result.size()-1);
					return ;
				}
				DFSFormat(isp, i+1, s, list, result);
				result.remove(result.size()-1);
			}
				
		}
		
	}


}