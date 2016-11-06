package com.testEnum;

import java.util.EnumMap;
import java.util.Map;

public class Context{
	public static void main(String[] args) {
		Caculator c=Caculator.SUB;
		System.out.println(Caculator.values()[1].value);
	}
	private enum Caculator {
		//当使用到其中一个美剧之后时,会初始化所有的枚举值
		//每一个枚举值都是不同的策略
		ADD("+"){
			public int exec(int a,int b){
				return a+b;
			}
		},
		SUB("-"){
			public int exec(int a,int b){
				return a-b;
			}
		};
		String value="";
		
		Caculator(String value){
			this.value=value;
			System.out.println(value);
		}
		//相当于策略接口
		public abstract int exec(int a,int b);
	}
}