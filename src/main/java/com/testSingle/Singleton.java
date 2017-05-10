package com.testSingle;

public class Singleton {
	
	public static Singleton getInstnace(){
		return realS.get();
	}
	
	private Singleton(){
		
	}
	private static class realS{
		private  static Singleton singleton=new Singleton();
		static{
			System.out.println("私有被创建了!!! ");
		}
		public static Singleton get(){
			return singleton;
		}
		
		
	}
}
