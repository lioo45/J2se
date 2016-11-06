package com.testInstanceOf;

public class M {
	public static void main(String[] args) {
		Father c1=new Child1();
		Father c2=new Child2();
		
		if(c1 instanceof Father){
			System.out.println(c1);
		}
		
	}
}
