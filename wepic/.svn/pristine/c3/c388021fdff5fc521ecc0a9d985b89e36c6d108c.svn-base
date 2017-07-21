package com.tools;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class MemcachedUtil {
	
	public static Object getCache(String ip,int port,String key){
		Object obj = null;
		//MemcachedClient c = new MemcachedClient(new InetSocketAddress("211.152.43.67", 11211));   
		MemcachedClient c = null;
		try {
			c = new MemcachedClient(new InetSocketAddress(ip, port));
			obj = c.get(key);
			
		} catch (IOException e) {
			e.printStackTrace();
			obj = null;
			//return ifHasCache ;
		}finally{
			if(c!= null){
				c.shutdown();    
			}
			c = null;
		} 
		return obj ;
	}//end 
	
	public static boolean judgeIfHasCache(String ip,int port,String key){
		boolean ifHasCache = false;
		//MemcachedClient c = new MemcachedClient(new InetSocketAddress("211.152.43.67", 11211));   
		MemcachedClient c = null;
		try {
			c = new MemcachedClient(new InetSocketAddress(ip, port));
			Object myObject = c.get(key);
			if( myObject != null ){
				ifHasCache = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			ifHasCache = false;
			//return ifHasCache ;
		}finally{
			if(c!= null){
				c.shutdown();    
			}
			c = null;
		} 
		return ifHasCache ;
	}//end 
	
	public static boolean setCache(String ip,int port,int numSecond ,String key, Object obj){
		boolean ifSucceed = false;
		
		MemcachedClient c = null;
		try {
			c = new MemcachedClient(new InetSocketAddress(ip, port));
			// Store a value (async) for one hour     
			//c.set("someKey", 3600, myData);     
			c.set(key, numSecond, obj);   
			
	        // Retrieve a value (synchronously).   
	        Object myObject = c.get(key);    
	        //MyData myData2 = (MyData)myObject;
			if( myObject != null ){
				ifSucceed = true;
			}
		} catch (IOException e) {
			ifSucceed = false;
			e.printStackTrace();
		} finally{
			if(c!= null){
				c.shutdown();    
			}
			c = null;
		} 
		return ifSucceed ;
	}//end 

	
	
	
	
	
	
	public static boolean checkedMemcachedOpen(String ip,int port){
       boolean ifSucceed = false;
		
		MemcachedClient c = null;
		try {
			c = new MemcachedClient(new InetSocketAddress(ip, port));
			ifSucceed = false;
		} catch (IOException e) {
			ifSucceed = false;
			e.printStackTrace();
		} finally{
			if(c!= null){
				c.shutdown();    
			}
			c = null;
		} 
		return ifSucceed ;
	}
	
	public static boolean checkedMemcachedOpennew(String ip,int port){
 	       boolean ifSucceed = false;
			
			MemcachedClient c = null;
			try {
				c = new MemcachedClient(new InetSocketAddress(ip, port));
				ifSucceed = true;
			} catch (IOException e) {
				e.printStackTrace();
			return	ifSucceed = false;
				
			} finally{
				if(c!= null){
					c.shutdown();    
				}
				c = null;
			} 
			return ifSucceed ;
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}//end class
