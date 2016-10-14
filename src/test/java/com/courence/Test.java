package com.courence;

public class Test {
	private int size = 1;  
	private int total = 0;
    public void stackLeak(){  
    	total += size;
        size++;  
        stackLeak();  
    }  
    public static void main(String[]args) throws Throwable{  
    	byte[] a = new byte[20*1024*1024];
    	Test gg = new Test();  
        try{  
            gg.stackLeak();  
        }catch(Throwable e){  
            System.out.println(gg.size+" "+ gg.total);  
            //e.printStackTrace();  
        }  
        System.out.println(a[0]);
    }  
}