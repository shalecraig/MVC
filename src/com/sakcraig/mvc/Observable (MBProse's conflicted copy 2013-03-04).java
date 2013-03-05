package com.sakcraig.mvc;

import java.util.LinkedList;
import java.util.List;

public class Observable {
	
	private List<Observer> observers;
	public Observable(){
		this.observers = new LinkedList<Observer>();
	}
	
	public void observe(Observer o) {
		this.observers.add(o);
	}
}
