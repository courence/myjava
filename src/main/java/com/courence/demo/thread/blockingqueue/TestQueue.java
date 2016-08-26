package com.courence.demo.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestQueue {
	public static void main(String[] args){
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		for(int i=0;i<5;i++){
			new Thread(new Producer(queue,"P"+i)).start();
		}
		
		for(int i=0;i<2;i++){
			new Thread(new Consumer(queue,"C"+i)).start();
		}
	}
}
