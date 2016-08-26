/**
 * 
 */
package com.courence.demo.thread;

import java.util.TimerTask;

/**
 * 
 * date: Aug 15, 2016 10:00:01 AM <br/> 
 * @author jh <br/> 
 */
public class Test {


	public static void main(String[] args) throws InterruptedException {
		long startTime = System.nanoTime();
		   // ... the code being measured ...
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);
		Thread.sleep(1);
	}
	
	static class ThrowTask extends TimerTask{

		@Override
		public void run() {
			System.out.println(111);
//			throw new RuntimeException();
//			throw launderTrowable(null);
		}
		
	}
	


}
