package com.courence.demo.pattern.observer.weather;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
