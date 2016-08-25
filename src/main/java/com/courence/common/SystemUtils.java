/**
 * 
 */
package com.courence.common;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * @Description 系统工具
 * @author Administrator
 * @date 2016年8月24日
 *
 */
public class SystemUtils {
	
	private static OperatingSystemMXBean osmb = ManagementFactory.getOperatingSystemMXBean();

	
	public static void main(String[] args) {
		System.out.println(getOSName());
		
		System.out.println(getOSArch());
		System.out.println(getOSVersion());
		System.out.println(getAvailableProcessors());
		System.out.println(getSystemLoadAverage());
		
	}
	/**
	 * Returns the operating system name 
	 */
	public static String getOSName(){
		return osmb.getName();
	}
	
	/**
	 * Returns the operating system architecture
	 */
	public static String getOSArch(){
		return osmb.getArch();
	}
	
	/**
	 * Returns the operating system version
	 */
	public static java.lang.String getOSVersion(){
		return osmb.getVersion();
	}
	  
	/**
	 * Returns the number of processors available to the Java virtual machine
	 */
	public static int getAvailableProcessors(){
		return osmb.getAvailableProcessors();
	}
	  
	/**
	 * Returns the system load average for the last minute. 
	 * If the load average is not available, a negative value is returned. 
	 */
	public static double getSystemLoadAverage(){
		return osmb.getSystemLoadAverage();
	}
}
