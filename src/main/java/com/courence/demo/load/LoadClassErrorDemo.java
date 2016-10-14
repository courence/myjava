package com.courence.demo.load;

public class LoadClassErrorDemo {
	public static void main(String[] args){
//		new Thread(new Runnable(){
//			public void run(){
//				try {
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				B.getInstance().test2();
//			}
//			
//		}).start();
//		new Thread(new Runnable(){
//			public void run(){
//				try {
//					Thread.sleep(400);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				B.getInstance().test2();
//			}
//			
//		}).start();
		T.getInstance().test2();
	}
}
abstract class A{
	public A(){
		list();
	}
	public void list(){
		test();
	}
	abstract void test();
}

class B extends A{
	private final static B instance = new B();
	public static B getInstance(){return instance;}
	public void test(){
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		instance.test2();
	}
	public void test2(){}
}

class T{
	private static T t = new T();
	public static T getInstance(){return t;}
	T(){
		t.test2();
	}
	public void test2(){
		System.out.println("test2");
	}
}