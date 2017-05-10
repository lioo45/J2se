package com.testJson;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

public class M2 {
	public static void main(String[] args) {
		Map<Object,Object> map=new HashMap<Object, Object>();
		Bean b1=new Bean("小明","测试测试!!!");
		Bean b2=new Bean("小明","测试测试!!!");
		Bean b3=new Bean("小明","测试测试!!!");
		map.put(b1, b2);
		JSONArray ja=JSONArray.fromObject(map);
		String s=ja.toString();
		System.out.println(s);
	}
}
