package com.testAccessSuperClass;

import java.lang.reflect.InvocationTargetException;

public class M {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		C c=new C();
		c.f();
	}
}
