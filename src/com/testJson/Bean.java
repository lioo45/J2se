package com.testJson;

import java.util.Map;

public class Bean {
	private String name;
	private String desc;
	private Map<String,Object> map;
	public String getName() {
		return name;
	}
	public Bean(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
