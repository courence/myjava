package com.courence.demo.thread;

public class InterruptTest implements Runnable{

	public static void main(String[] args) {
		Thread t = new Thread(new InterruptTest());
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		t.interrupt();
//		t.start();
		System.out.println("interrupt");

	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			System.out.println("running");
		}
		System.out.println("end");
		
	}

}
