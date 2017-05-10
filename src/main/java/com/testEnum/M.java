package com.testEnum;

public class M {
	public static void main(String[] args) {

		Test t=new Test();
		t.test();

//		String s="xyz";
		String s1=new String("xyz");
//		String s1="xyz";
//		System.out.println(s1==s);
		System.out.println(s1=="xyz");
//		System.out.println(s1.equals(s));
		String x3=new String("xyz");
		System.out.println(s1==x3);
		String s2=s1.intern();
		System.out.println(s1==s2);

		String a="a"+"b"+"c"+"d";
		System.out.println(a=="abcd");
	}
}
