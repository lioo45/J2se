package com.DesignPattern.Component;

import java.util.List;

public interface Unit {
	public String getInfo();
	public List<Unit> getChildren();
	public void addChild(Unit unit);
	public void remove(Unit unit);
}
