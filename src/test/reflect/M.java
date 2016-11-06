package test.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class M {
	public static void main(String[] args) {
		w w1=new w();
		w1.m();
		System.out.println(w1.name);
	}
}
