package com.wetuo.wepic.common.struts ;
	
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
	
public class PageAction extends BaseAction implements ModelDriven{
	protected Object model; 
	
	private static final long serialVersionUID = -7509152655359967096L;
	protected int pageSize = Constants.pageSize;
	protected int pageNo = Constants.pageNo;
	protected Pager pager;
	protected Map<String, String> errorMap;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Object getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public Map<String, String> getErrorMap() {
		return errorMap;
	}
	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	
	
}//end class
