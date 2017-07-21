package com.wetuo.wepic.common.struts ;
	
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;
import com.wetuo.wepic.common.struts.Constants;
	
public class AuthorizationInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 2575538469018873724L;
	
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
	
		Map session = invocation.getInvocationContext().getSession();
		String username = (String) session.get(Constants.USERNAME_KEY);
	
		if (null != username && !username.equals("")) {
			// ??????
			return invocation.invoke();
		} else {
			System.out.println("11111111111111111111111111111111");
			return Action.LOGIN;
		}
	
	}//end intercept()
}//end class
