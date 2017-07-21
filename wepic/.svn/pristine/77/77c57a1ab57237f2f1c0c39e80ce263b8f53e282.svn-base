package com.wetuo.wepic.deal.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.deal.beans.BidCat;
import com.wetuo.wepic.deal.service.BidCatservice;

public class BidCatAction extends PageAction {
    private BidCatservice bidCatservice; 
    private List<BidCat> bidcats;
    private BidCat bidCat;
    private List<BidCat> parentBid; 
    private String backMsg;//返回信息,ok成功error失败,login登录;
    private List<BidCat> parentBidStyle; 
	public BidCatAction(String className) {
		try{
	model=Class.forName(className).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public String saveBidCat(){
		String string="酒吧、城市、校园、公园、私房、汽车、废旧工厂";
		String[] strings=string.split("、");
		for(int i=0;i<strings.length;i++){
			BidCat bidCat=new BidCat();
			//bidCat.setId(id)
			bidCat.setName(strings[i]);
			bidCat.setpId(26);
			bidCat.setType("childnode");
			bidCatservice.savebidCat(bidCat);
			
		}
		//bidCatservice.savebidCat((BidCat)model); 
		
		
		
		return "saveBidCat";
	}
	
	
	
	public String updateBidCat(){
		
		bidCatservice.updateBidCat((BidCat)model);
		
		
		
		return "updateBidCat";
	}
	
	
	public String deleteBidCat(){
		bidCatservice.deleteBidCat(((BidCat)model).getId());		
		return "deleteBidCat";
	}

	public String findByDetacheCriteria(){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidCat.class);
		bidcats=bidCatservice.findDetaCheCriteria(detachedCriteria);
		return "findByDetacheCriteria";
	}

	
	public String findByrootType(){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidCat.class);
		detachedCriteria.add(Restrictions.eq("type", "root"));
		bidcats=bidCatservice.findDetaCheCriteria(detachedCriteria);
		return "findByrootType";
	}
     public String findByParentId(){
    	 BidCat bidCat= (BidCat)model;
    	 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidCat.class);
 		detachedCriteria.add(Restrictions.eq("pId", bidCat.getId()));
 		detachedCriteria.add(Restrictions.not(Restrictions.eq("discription", "videoClip")));
 		bidcats=bidCatservice.findDetaCheCriteria(detachedCriteria);
    	 
    	 
 		return "findByParentId";
     }
	
	public String publishBid(){
		 BidCat cat=(BidCat)model;
		 bidCat=bidCatservice.findById(cat.getId());
		 bidCat.setBidName(covetString(cat.getBidName()));
		 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidCat.class);
	 	 detachedCriteria.add(Restrictions.eq("pId", bidCat.getId()));
	 	 //detachedCriteria.add(Restrictions.eq("type", "personNode"));
	 	 detachedCriteria.add(Restrictions.or(Restrictions.eq("type", "personNode"),Restrictions.eq("type","childnode")));
	 	 int id=super.getLonginUserId();
	 	 User user=new User();
	 	 user.setId(id);
	 	 detachedCriteria.add(Restrictions.or(Restrictions.eq("pId", bidCat.getId()),Restrictions.eq("user",user)));
	 	// 
	 	 bidcats=bidCatservice.findDetaCheCriteria(detachedCriteria);
	 	 DetachedCriteria detachedCriteria2=DetachedCriteria.forClass(BidCat.class);
	 	 detachedCriteria2.add(Restrictions.eq("pId", bidCat.getpId()));
	 	 detachedCriteria2.add(Restrictions.not(Restrictions.eq("discription", "videoClip")));
	 	 parentBid=bidCatservice.findDetaCheCriteria(detachedCriteria2);
	 		
	 	
	 	
	 	
	 	
	 	 DetachedCriteria detachedCriteria3=DetachedCriteria.forClass(BidCat.class);
	 	 detachedCriteria3.add(Restrictions.eq("pId", bidCat.getId()));
	 	 detachedCriteria3.add(Restrictions.eq("type", "personNodeStyle"));
	 	 //detachedCriteria3.add(Restrictions.or(Restrictions.eq("type", "personNode"),Restrictions.eq("type","childnode")));
	 	
	 	// user.setId(id);
	 	 detachedCriteria3.add(Restrictions.or(Restrictions.eq("pId", bidCat.getId()),Restrictions.eq("user",user)));
	 	 parentBidStyle=bidCatservice.findDetaCheCriteria(detachedCriteria3);
	 	 
	 	 
	 	 
		 return bidCat.getDiscription().trim();
	}
	
	public String covetString(String str){
		String string = "";
		if(str==null||str==""){
			
			return string;
		}
		
		try {
			string=toGb2312(str);
		//	String string2=new String(str.getBytes("utf-8"), "gbk");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return string;
		
	}
	
	
	private  static  String  toGb2312(String  str)  { 
        if  (str  ==  null)  return  null; 
        String  retStr  =  str; 
        byte  b[]; 
        try  { 
                b  =  str.getBytes("ISO8859_1");
                for  (int  i  =  0;  i  <  b.length;  i++)  { 
                        byte  b1  =  b[i]; 
                        if  (b1  ==  63) 
                                break;    //1 
                        else  if  (b1  >  0) 
                                continue;//2 
                        else  if  (b1  <  0)  {        //不可能为0，0为字符串结束符
//小于0乱码
                                retStr  =  new  String(b,  "GB2312"); 
                                if(isMessyCode(retStr)){
                                	
                                	 retStr  =  new  String(b,  "utf-8"); 
                                	
                                }
                                break; 
                        } 
                } 
        }  catch  (UnsupportedEncodingException  e)  { 
                //  e.printStackTrace();  
        } 
        return  retStr; 
} 
		  
	
	public String addpersonCat(){
		int userId=super.getLonginUserId();
		if(userId==0){
	    backMsg="login";
	     return "addpersonCat";
		}
		BidCat bidCat=(BidCat)model;
		bidCat.setType("personNode");
		User user=new User();
		user.setId(userId);
		bidCat.setUser(user);
		backMsg="error";
		
		if(bidCatservice.savebidCat(bidCat))backMsg="ok";
		
		return "addpersonCat";
	}
	
	public String deletepersonCat(){
		int id=super.getLonginUserId();
		if(id==0){
			backMsg="login";
			return "deletepersonCat";
		}
		backMsg="error";
		if(bidCatservice.deleteBidCat(((BidCat)model).getId())){
			backMsg="ok";	
		}
		return "deletepersonCat";
	}
	//添加模特风格
    public String addpersonCatStyle(){
    	int userId=super.getLonginUserId();
		if(userId==0){
	    backMsg="login";
	     return "addpersonCat";
		}
		BidCat bidCat=(BidCat)model;
		bidCat.setType("personNodeStyle");
		User user=new User();
		user.setId(userId);
		bidCat.setUser(user);
		backMsg="error";
		
		if(bidCatservice.savebidCat(bidCat))backMsg="ok";
		
		return "addpersonCat";
		
	}
    //删除模特风格
    public String deletepersonCatStyle(){
    	
    	int id=super.getLonginUserId();
		if(id==0){
			backMsg="login";
			return "deletepersonCat";
		}
		backMsg="error";
		if(bidCatservice.deleteBidCat(((BidCat)model).getId())){
			backMsg="ok";	
		}
		return "deletepersonCat";
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    public static boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
          return true;  
        }  
        return false;  
      }  
      
      public static boolean isMessyCode(String strName) {  
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");  
        Matcher m = p.matcher(strName);  
        String after = m.replaceAll("");  
        String temp = after.replaceAll("\\p{P}", "");  
        char[] ch = temp.trim().toCharArray();  
        float chLength = ch.length;  
        float count = 0;  
        for (int i = 0; i < ch.length; i++) {  
          char c = ch[i];  
          if (!Character.isLetterOrDigit(c)) {  
      
            if (!isChinese(c)) {  
              count = count + 1;  
              System.out.print(c);  
            }  
          }  
        }  
        float result = count / chLength;  
        if (result > 0.4) {  
          return true;  
        } else {  
          return false;  
        }  
      
      }  
    
    
    

	public BidCatservice getBidCatservice() {
		return bidCatservice;
	}

	public void setBidCatservice(BidCatservice bidCatservice) {
		this.bidCatservice = bidCatservice;
	}

	public List<BidCat> getBidcats() {
		return bidcats;
	}

	public void setBidcats(List<BidCat> bidcats) {
		this.bidcats = bidcats;
	}

	public BidCat getBidCat() {
		return bidCat;
	}

	public void setBidCat(BidCat bidCat) {
		this.bidCat = bidCat;
	}

	public List<BidCat> getParentBid() {
		return parentBid;
	}

	public void setParentBid(List<BidCat> parentBid) {
		this.parentBid = parentBid;
	}
	
	public String getBackMsg() {
		return backMsg;
	}

	public void setBackMsg(String backMsg) {
		this.backMsg = backMsg;
	}

	public List<BidCat> getParentBidStyle() {
		return parentBidStyle;
	}

	public void setParentBidStyle(List<BidCat> parentBidStyle) {
		this.parentBidStyle = parentBidStyle;
	}

	
	
}
