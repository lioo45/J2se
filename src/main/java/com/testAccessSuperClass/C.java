package com.testAccessSuperClass;

import java.lang.reflect.InvocationTargetException;


public class C extends B {
	public void f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException{
		this.getClass().getSuperclass().getSuperclass().getMethod("s").invoke(this.getClass().getSuperclass().getSuperclass().newInstance());
	}
}
