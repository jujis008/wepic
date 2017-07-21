package com.wetuo.wepic.core.actions;

public class PageNumber {
	public int[] getRount(int Max,int pageCount,int showPage){   
		int[] inter=new int[2];//定义一个具有两个元素的数组       
		int rount=pageCount-Max+1;      
		if(rount>0){         
			if(rount>Max){             
				if(showPage>=Max&&showPage<=rount){             
					inter[0]=showPage;           
					inter[1]=Max+showPage-1;           
					}  else if(showPage>rount&&showPage<=pageCount){
						inter[0]=rount;             
						inter[1]=pageCount;            
						}        
					else{         
						inter[0]=1;   
						inter[1]=Max; 
						}
				}    else{              
					if(showPage>=Max){   
						inter[0]=rount;   
						inter[1]=pageCount;    
						}            
					else{             
						inter[0]=1;     
						inter[1]=Max;      
						}           
					}       
			}        else{    
				inter[0] = 1;       
				inter[1] =pageCount;     
				}      
		return inter;  

}
	public static void main(String[] args) {
		 int max=8;    //自己定义 
         int pagecount=18;    //你总有办法获取的 
         int showpage=15;   //难不到你 
           PageNumber number=new PageNumber();      //getRount()方法所在的类 
         int[] inter=number.getRount(max,pagecount,showpage);
         for(int i=inter[0];i<=inter[1];i++){
        	 
        	 System.out.println(i);
         }
         
		
	}
}