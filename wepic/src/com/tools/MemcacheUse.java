package com.tools;

import java.io.IOException;   
import java.io.Serializable;   
import java.net.InetSocketAddress;   
import java.util.Date;   
  
import net.spy.memcached.MemcachedClient;   
  
public class MemcacheUse {   
  
    private static class MyData implements Serializable {   
        private static final long serialVersionUID = 1L;   
        private long d = new Date().getTime();   
        public String toString() {   
            return "my data ["+d+"]";   
        } 
        public long getD(){
        	return d;
        }
    }   
  
    public static void main(String[] args) throws IOException {   
        MyData myData = new MyData();   
  
        MemcachedClient c = new MemcachedClient(new InetSocketAddress("211.152.43.67", 11211));   
        // Store a value (async) for one hour     
        c.set("someKey", 3600, myData);     
        // Retrieve a value (synchronously).   
        Object myObject=c.get("someKey");    
        MyData myData2 = (MyData)myObject;
        c.shutdown();     
        System.out.println(myObject); 
        System.out.println(myData2.getD()); 
        
  
    }   
  
}  
