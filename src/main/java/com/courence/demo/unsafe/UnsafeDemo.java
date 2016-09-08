package com.courence.demo.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeDemo {  
	static Player p;
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {  
        Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal reference  
        f.setAccessible(true);  
        Unsafe unsafe = (Unsafe) f.get(null);  
        
  
        // This creates an instance of player class without any initialization  
        p = (Player) unsafe.allocateInstance(Player.class);  
        p.setState("a");
        
        new Thread(new Runnable(){

			public void run() {
				System.out.println(p.getState());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(p.getState());
			}
        	
        }).start();
        System.out.println(p.getState());
        p.setState("b");
//        p.casState("a","b");
    }  
}  
  
class Player {  
	private static final long stateOffset;
	private static final Unsafe unsafe;
	static {
        try {
        	Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal reference  
            f.setAccessible(true);  
            unsafe = (Unsafe) f.get(null);  
            stateOffset = unsafe.objectFieldOffset
                (Player.class.getDeclaredField("state"));


        } catch (Exception ex) { 
        	ex.printStackTrace();
        	throw new Error(ex); 
        }
    }
	
	public boolean casState(String a,String b){
		return unsafe.compareAndSwapObject(this, stateOffset, a, b);
	}
	
    private int age = 12;  
    private  String state;  
  
    private Player() {  
        this.age = 50;  
    }  
  
    public int getAge() {  
        return this.age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}  
	
    
}  