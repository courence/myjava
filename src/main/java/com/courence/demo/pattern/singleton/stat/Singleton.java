package com.courence.demo.pattern.singleton.stat;

public class Singleton {
	private static Singleton uniqueInstance = new Singleton();
 
	private Singleton() {}
 
	public static Singleton getInstance() {
		return uniqueInstance;
	}
}
