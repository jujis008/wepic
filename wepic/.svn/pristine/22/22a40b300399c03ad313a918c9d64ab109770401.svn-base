package com.wetuo.wepic.core.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
    	
    	ActionContext actionContext = invocation.getInvocationContext();
    	
    	//
		HttpServletRequest request=ServletActionContext.getRequest();
		String path=request.getRequestURI();
		String actionPath=".."+path.substring(9);
		//
		String queryInfo=request.getQueryString();
		if(queryInfo!=null && (!queryInfo.equals("")) ){
			actionPath=actionPath+"?"+queryInfo;
		}
		//logger.debug(":"+actionPath);
		ActionContext.getContext().getSession().put("userPath", actionPath);
		//
		if(actionPath.indexOf("login") > -1){
			return invocation.invoke();
		}
    	
        Map session = invocation.getInvocationContext().getSession();
        String userName = (String) session.get("username");
//        String user = (String) session.get("user");
        if (null != userName ) {
            System.out.println("-normal login-");
            return invocation.invoke();
        } 
        else {
        	System.out.println("--userName = null--");
            //return Action.LOGIN;
            return invocation.invoke();
        }
        
        
    	
        
    }//end intercept()
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}//end class
