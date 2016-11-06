package com.poj1166;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//初始化数组
		int a[]=new int[10];
		for(int i=1;i<10;++i)
			a[i]=scanner.nextInt();
		int s[]=new int[10];
		for(int i=1;i<s.length;++i)
			s[i]=1;
		int r[]=new int[10];
		work(a,s,r);
		
	}
	
	public static boolean work(int[] a,int s[],int[] r){
		if(isOK(a)){
			for(int i=1;i<r.length;++i)
				if(r[i]!=0)
					System.out.print(i+" ");
			return true;
		}
		int copyA[];
		int result[];
		int selective[]=Arrays.copyOf(s, s.length);
		int selective2[];
		for(int i=1;i<a.length;++i){
			if(a[i]==0)
				removeIncludeIt(selective,i);
		}
		if(!haveStrategy(selective))
			return false;
		//选择策略并生效 递归
		for(int i=1;i<s.length;++i){
			copyA=Arrays.copyOf(a, a.length);
			result=Arrays.copyOf(r,r.length);
			selective2=Arrays.copyOf(selective, selective.length);
			if(s[i]!=0){
				selective2[i]=0;
				execute(copyA,i);
				result[i]=1;
				if(work(copyA,selective2,result)==true)
					return true;
			}
		}
		return false;
	}
	
	//调用策略
	private static void execute(int[] a,int i){
		Context context=Context.values()[i-1];
		context.setA(a);
		context.strategy();
	
	}
	private static boolean haveStrategy(int[] selective){
		int haveStrategy=0;
		for(int i=1;i<selective.length;++i){
			haveStrategy|=selective[i];
		}
		if(haveStrategy==0)
			return false;
		return true;
	}
	private static void removeIncludeIt(int[] selective,int i) {
		//不需要break;
		Context[] contexts=Context.values();
		for(Context c:contexts){
			if(c.includeIt(i))
				selective[c.ordinal()+1]=0;
		}
	}
	//判断数组是否符合条件
	public static boolean isOK(int[] a){
		for(int i=1;i<a.length;++i){
			if(a[i]!=0)
				return false;
		}
		return true;
	}
	
	enum Context {
		Case1(1,2,4,5),
		Case2(1,2,3),
		Case3(2,3,5,6),
		Case4(1,4,7),
		Case5(2,4,5,6,8),
		Case6(3,6,9),
		Case7(4,5,7,8),
		Case8(7,8,9),
		Case9(5,6,8,9);
		private int[] have;
		private int[] a;
		private Context(){
			
		}
		public boolean includeIt(int value){
			for(int i=0;i<have.length;++i){
				if(have[i]==value)
					return true;
			}
			return false;
		}
		public void setA(int a[]){
			this.a=a;
		}
		private Context(int... have){
			this.have=have;
		}
		public  void strategy(){
			for(int i=0;i<have.length;++i)
				a[have[i]]=(++a[have[i]])%4;
		}
	}

}
