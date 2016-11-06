package com.DesignPattern.Component;

import java.util.ArrayList;
import java.util.List;

public class Department implements Unit{
	private String name;
	private List<Unit> children=new ArrayList<Unit>();

	public Department(String name){
		this.name=name;
	}

	@Override
	public String getInfo() {
		return name;
	}

	@Override
	public List<Unit> getChildren() {
		return children;
	}

	@Override
	public void addChild(Unit unit) {
		children.add(unit);
	}

	@Override
	public void remove(Unit unit) {
		children.remove(unit);
	}
}
