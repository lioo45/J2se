package com.leetcode;

public class PalindromePartitioning2 {
	public static void main(String[] args) {
//		String s="ab123321ab";
		long start=System.currentTimeMillis();
		String s="fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		int k=minCut(s);
		System.out.println(k);
		System.out.println(System.currentTimeMillis()-start);
	}
	
//	public static int minCut(String s){
//		boolean isp[][]=partition(s);
//		if(isp[0][s.length()-1])
//			return 0;
//		Queue<Integer> q1=new LinkedList<Integer>();
//		Queue<Integer> q2=new LinkedList<Integer>();
//		int curLine=0;
//		int min=1;
//		for(int i=curLine;i<s.length();++i){
//			if(isp[curLine][i])
//				q1.add(i);
//		}
//		while(!q1.isEmpty()){
//			curLine=q1.remove();
//			if(isp[curLine+1][s.length()-1])
//				return min;
//			for(int i=curLine;i<s.length();++i){
//				if(isp[curLine+1][i])
//					q2.add(i);
//				}
//			if(q1.isEmpty()){
//				Queue<Integer> t=q1;
//				q1=q2;
//				q2=t;
//				++min;
//			}
//		}
//		return min;
//	}

	public static int minCut(String s) {
		int length = s.length();
		char c[]=s.toCharArray();
		boolean[][] isp = new boolean[length][length];
		int dp[]=new int[length];
		for(int i=length-1;i>=0;--i){
			dp[i]=i<length-1?1+dp[i+1]:0;
			for(int j=i;j<length;++j){
				if(c[i]==c[j]){
					isp[i][j]=j-i>2?isp[i+1][j-1]:true;
					if(isp[i][j]){
						int curLineMin=j<length-1?1+dp[j+1]:0;
						dp[i]=Math.min(curLineMin, dp[i]);
					}
				}
				else
					isp[i][j]=false;
			}
		}
		return dp[0];
	}

}
