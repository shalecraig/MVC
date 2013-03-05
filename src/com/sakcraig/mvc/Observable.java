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
	
	public void change() {
		long time = System.currentTimeMillis();
		this.change(time);
	}
	
	public void change(long changeTime) {
		this.change(changeTime, Observable.ChangeType.NONE_SPECIFIED);
	}
	
	public void change(ChangeType r) {
		long time = System.currentTimeMillis();
		this.change(time, r);
	}
	
	public void change(long changeTime, ChangeType r) {
		for (Observer observer : this.observers) {
			observer.changed(changeTime, r);
		}
	}
	
	public static class ChangeType implements Comparable<ChangeType> {
		public static final ChangeType NONE_SPECIFIED = new ChangeType();
		
		private int numChangeTypes = 0;
		private int changeNum;
		
		public ChangeType() {
			this.changeNum = numChangeTypes++;
		}
		
		protected int getChangeNum() {
			return this.changeNum;
		}
		
		@Override
		public boolean equals(Object o) {
//			Eclipse is stupid. This cast should be free.
			return o instanceof ChangeType && this.changeNum == ((ChangeType) o).getChangeNum();
		}
		
		@Override
		public int compareTo(ChangeType o) {
//			Leet hax.
			return this.changeNum - o.getChangeNum();
		}
	}
}
