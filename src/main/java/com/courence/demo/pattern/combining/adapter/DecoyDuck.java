package com.courence.demo.pattern.combining.adapter;

public class DecoyDuck implements Quackable {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
