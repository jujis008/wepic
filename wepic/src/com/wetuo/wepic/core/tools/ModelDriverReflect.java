package com.wetuo.wepic.core.tools;

import java.lang.reflect.Field;

import com.wetuo.wepic.core.beans.User;
/*
 * 通过反射把  值对像的的东西copy目标对象
 */
public class ModelDriverReflect {
	public Object Reflect(String classurl,Object object1,Object object2){
		//object1 目标对象
		//object2值对像
		//
		 try {
			Class reClass = Class.forName(classurl);
			Field field[] = reClass.getDeclaredFields();
			   for (int i = 0; i < field.length; i++) { 
				 field[i].setAccessible(true);
			     Object retobj = field[i].get(object1);
			     Object retobj2 = field[i].get(object2);
			     if(retobj2!=null&&field[i].getType().toString().equals("class java.lang.String")){
			    	 field[i].set(object1, retobj2);		    	 
			     }
			     if(retobj2!=null&&field[i].getType().toString().equals("class java.lang.Integer")){
			    	 System.out.println(field[i].getType().toString().equals("class java.lang.Integer"));
			    	 field[i].set(object1, retobj2);		    	 
			     }
			     
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		
		return object1;
	}
	
	public static void main(String[] args) {
		ModelDriverReflect driverReflect=new ModelDriverReflect();
		User user=new User();
		user.setAddress("上海");
		User user2=new User();
		user2.setBachelorSchool("上海大学");
		User out=(User)driverReflect.Reflect("com.wetuo.wepic.core.beans.User",user2 ,user);
		System.out.println(out.getAddress());
		
		
		
	}
	
}
