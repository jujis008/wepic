	
package com.wetuo.wepic.common.util ;
 
import  java.io.Serializable;
import  java.net.InetAddress;
	
public class  UUIDGenerator {
	private static final int IP;
	public static int IptoInt( byte[] bytes ) {
		int result = 0;	
		for (int i=0; i<4; i++) {
			result = ( result << 8 ) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}
	
	static {  
		int ipadd;	
		try{
			ipadd = IptoInt( InetAddress.getLocalHost().getAddress() );
		}catch(Exception e){
			ipadd = 0; 
		
		}//end catch
		IP = ipadd;
	} 
//@#$%
		private static short counter = (short) 0; 
		private static final int JVM = (int) ( System.currentTimeMillis() >>> 8 ); 
		
		public UUIDGenerator() {	}
		
		protected int getJVM() {  return JVM;	}
		
		protected short getCount() {
			synchronized(UUIDGenerator.class) { 
			if (counter<0) counter=0; 
				return counter++; 
			} 
		} 
		
		protected int getIP() {	return IP;	} 
		
		protected short getHiTime() {		return (short) ( System.currentTimeMillis() >>> 32 );	}
		
		protected int getLoTime() {		return (int) System.currentTimeMillis();	}
		
		private final static String sep = ""; 
		
		protected String format(int intval) { 
			String formatted = Integer.toHexString(intval); 
			StringBuffer buf = new StringBuffer("00000000"); 
			buf.replace( 8-formatted.length(), 8, formatted ); 
			return buf.toString(); 
		}
		
		protected String format(short shortval) {
			String formatted = Integer.toHexString(shortval);
			StringBuffer buf = new StringBuffer("0000"); 
			buf.replace( 4-formatted.length(), 4, formatted ); 
			return buf.toString(); 
		} 
		
		public Serializable generate() { 
			return new StringBuffer(36)
			.append( format( getIP() ) ).append(sep)
			.append( format( getJVM() ) ).append(sep) 
			.append( format( getHiTime() ) ).append(sep) 
			.append( format( getLoTime() ) ).append(sep) 
			.append( format( getCount() ) ) 
			.toString(); 
		} 
		
		public static void main(String[] args){//����
			UUIDGenerator u = new UUIDGenerator();
			String id = String.valueOf(u.generate());
			String id1 = String.valueOf(u.generate()); 
			System.out.println(id);
			System.out.println(id1);
		} 
		
}//end class
