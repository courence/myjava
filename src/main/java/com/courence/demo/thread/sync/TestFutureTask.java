package com.courence.demo.thread.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask
 * @author jh
 *
 */
public class TestFutureTask {
	Callable<String> eval = new Callable<String>(){

		public String call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	private final FutureTask<String> future = 
			new FutureTask<String>(eval);
	private final Thread thread = new Thread(future);
	public void start(){thread.start();}
	
	public String get(){
		try {
			return future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}


class ProductInfo{
	public ProductInfo loadProductInfo(){
//		Executors
		return null;
	}
}