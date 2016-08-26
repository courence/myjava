package com.courence.demo.thread.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<String> queue;
	private final String flag;
	public Consumer(BlockingQueue<String> queue,String flag){
		this.queue = queue;
		this.flag = flag;
	}
	public void run() {
		try {
			while(true)
				consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}
	
	private void consume() throws InterruptedException{
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String str = flag+"-"+queue.take();
		System.out.println("Consumer："+str);
	}

}
