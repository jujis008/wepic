package com.wetuo.wepic.deal.test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {  
 private String name = "Jhon";  

 private String city = "new york";  

 public String getCity() {  
  return city;  
 }  

 public void setCity(String city) {  
  this.city = city;  
 }  

 public String getName() {  
  return name;  
 }  

 public void setName(String name) {  
  this.name = name;  
 }  

 public static void main(String args[]) {  
  ReflectionTest tfpt = new ReflectionTest();  
  try {  
   Class reClass = Class  .forName("com.wetuo.wepic.deal.test.ReflectionTest");  
   //通过Method获取
   Method methods[] = reClass.getDeclaredMethods();  
   for (int i = 0; i < methods.length; i++) {  
    if (methods[i].getName().startsWith("get")) {  
     Object retobj = methods[i].invoke(tfpt, null);  
     System.out.println(methods[i].getName() + "=" 
       + (String) retobj);  
    }
   }
   //通过Field获取
   Field field[] = reClass.getDeclaredFields();
   for (int i = 0; i < field.length; i++) { 
	   field[i].set(tfpt,"1");
     Object retobj = field[i].get(tfpt);
     System.out.println(field[i].getName() + "="
       + retobj);  
   }
  } catch (ClassNotFoundException e) {  
   e.printStackTrace();  
  } catch (IllegalArgumentException e) {  
   e.printStackTrace();  
  } catch (IllegalAccessException e) {  
   e.printStackTrace();  
  } catch (InvocationTargetException e) {  
   e.printStackTrace();  
  }  
 }  
}
