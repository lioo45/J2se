package com.DesignPattern.Component;

import java.util.List;

public class Persion implements Unit{
	private String name;

	@Override
	public String getInfo() {
		return name;
	}

	@Override
	public List<Unit> getChildren() {
		
		return null;
	}

	@Override
	public void addChild(Unit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Unit unit) {
		// TODO Auto-generated method stub
		
	}
	
}
