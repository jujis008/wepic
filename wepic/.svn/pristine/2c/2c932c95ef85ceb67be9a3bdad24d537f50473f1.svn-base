	
package com.wetuo.wepic.common.util ;
 
import java.lang.reflect.*;
	
public class  XgSseUtil {
	public String converFromOtherToStr(Object obj){
		String strResult = obj.toString();	
		return strResult;
	}
	
	public Object converFromStringToObjType(String strInput,Object obj){  
		Object objResult = null;	
		try{
			Method[] arrMethord = obj.getClass().getMethods();
			for(Method method:arrMethord){
				if(method.getName().indexOf("valueOf") > -1){
					Class<?>[] arrClass = method.getParameterTypes();
					if(arrClass.length == 1  && arrClass[0].getName().equalsIgnoreCase("java.lang.String")){
						//System.out.println(method.toString());
						//System.out.println( arrClass[0].getName() );
						Object[] arrObj = {strInput};
						objResult =  method.invoke(obj, arrObj) ;
						//System.out.println( objResult );	
						
					}//end if(arrClass.length == 1){
				}//end if
			}//end for
		}catch(Exception e){
			e.printStackTrace();
		
		}//end catch
		return  objResult ;
	}//end converFromStringToObjType() 
//@#$%
}//end class
