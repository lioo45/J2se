package com.testJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public class M {
	public static void main(String[] args) {
		
		Bean b1=new Bean("小明","测试测试!!!");
		Bean b2=new Bean("小明","测试测试!!!");
		Bean b3=new Bean("小明","测试测试!!!");
		Map<String ,Object> map=new HashMap<String, Object>();
//		map.put("一", b1);
//		map.put("二", b2);
//		map.put("三", b3);
		List<Bean> list=new ArrayList<Bean>();

		List<Bean> list2=new ArrayList<Bean>();
		list.add(b1);
		list.add(b2);
		list2.add(b3);
		map.put("aa", list);
		map.put("bb", list2);
		ContainBean c=new ContainBean();
		c.setSesc("lalla");
		c.setMap(map);
		JSONArray jsonArray=JSONArray.fromObject(c);
		String json=jsonArray.toString();
		System.out.println(json);
	}
}
