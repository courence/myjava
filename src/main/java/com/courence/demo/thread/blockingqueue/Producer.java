package com.courence.demo.thread.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<String> queue;
	private final String flag;
	public Producer(BlockingQueue<String> queue,String flag){
		this.queue = queue;
		this.flag = flag;
	}
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}
	private void produce() throws InterruptedException{
		Random random = new Random();
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String str = flag+"-"+i;
			queue.put(str);
			System.out.println("Producer："+str);
		}
	}

}
