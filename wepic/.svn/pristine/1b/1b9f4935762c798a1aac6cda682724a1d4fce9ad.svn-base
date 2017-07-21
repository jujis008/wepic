package com.wetuo.wepic.common.hibernate ;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
public class Pager implements Serializable {
 
	protected Integer[] pageSizeList = { 20 };
	protected Integer pageSize = 25;
	protected Integer pageNo = 1;
	protected Integer rowCount = 0;
	protected Integer pageCount = 1;
	protected Integer startIndex = 1;
	protected Integer endIndex = 1;
	protected Integer firstPageNo = 1;
	protected Integer prePageNo = 1;
	protected Integer nextPageNo = 1;
	protected Integer lastPageNo = 1;
	protected List<?> resultList;
	protected String meString=null;
	private int startPage;
	private int endPage;
	public String getMeString() {
		return meString;
	}
	public void setMeString(String meString) {
		this.meString = meString;
	}
	public Pager(Integer pageSize, Integer pageNo, Integer rowCount, List<?> resultList) {
		
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.rowCount = rowCount;
		this.resultList = resultList;
		if (rowCount % pageSize == 0) {
			this.pageCount = rowCount / pageSize;
		} else {
			this.pageCount = rowCount / pageSize + 1;
		}
		this.startIndex = pageSize * (pageNo - 1);
		this.endIndex = this.startIndex + resultList.size();
		this.lastPageNo = this.pageCount;
		if (this.pageNo > 1) this.prePageNo = this.pageNo -1;
		if (this.pageNo == this.lastPageNo){
			this.nextPageNo = this.lastPageNo;
		} else {
			this.nextPageNo = this.pageNo + 1;
		}
		getRount();
	}//end Pager()
	public Pager(List list) {
		this.resultList=list;
	}
	public Object[] getPageSizeIndexs() {
		List<String> result = new ArrayList<String>(pageSizeList.length);
		for (Integer i = 0; i < pageSizeList.length; i++) {
			result.add(String.valueOf(pageSizeList[i]));
		}//end for
		Object[] indexs = (result.toArray());
		return indexs;
	}//end getPageSizeIndexs()
	public Object[] getPageNoIndexs() {
		List<String> result = new ArrayList<String>(pageCount);
		for (Integer i = 0; i < pageCount; i++) {
			result.add(String.valueOf(i + 1));
		}//end for
		Object[] indexs = (result.toArray());
		return indexs;
	}//end getPageNoIndexs()
	public Integer getEndIndex() {
		return endIndex;
	}//end getPageNoIndexs()
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}//end setEndIndex()
	public Integer getPageCount() {
		return pageCount;
	}//end getPageCount()
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}//end getPageCount()
	public Integer getPageNo() {
		return pageNo;
	}//end getPageCount()
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}//end setPageNo()
	public Integer getPageSize() {
		return pageSize;
	}//end getPageSize()
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}//end setPageSize()
	public Integer[] getPageSizeList() {
		return pageSizeList;
	}//end getPageSizeList()
	public void setPageSizeList(Integer[] pageSizeList) {
		this.pageSizeList = pageSizeList;
	}//end setPageSize()
	public List<?> getResultList() {
		return resultList;
	}//end getResultList()
	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}//end setResultList()
	public Integer getRowCount() {
		return rowCount;
	}//end getRowCount()
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}//end setRowCount()
	public Integer getStartIndex() {
		return startIndex;
	}//end getStartIndex()
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}//end setStartIndex()
	public Integer getFirstPageNo() {
		return firstPageNo;
	}//end getFirstPageNo()
	public void setFirstPageNo(Integer firstPageNo) {
		this.firstPageNo = firstPageNo;
	}//end setFirstPageNo()
	public Integer getLastPageNo() {
		return lastPageNo;
	}//end getLastPageNo()
	public void setLastPageNo(Integer lastPageNo) {
		this.lastPageNo = lastPageNo;
	}//end setLastPageNo()
	public Integer getNextPageNo() {
		return nextPageNo;
	}//end getLastPageNo()
	public void setNextPageNo(Integer nextPageNo) {
		this.nextPageNo = nextPageNo;
	}//end setLastPageNo()
	public Integer getPrePageNo() {
		return prePageNo;
	}//end getPrePageNo()
	public void setPrePageNo(Integer prePageNo) {
		this.prePageNo = prePageNo;
	}//end setPrePageNo()
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	//数字分页
	public int[] getRount(){   
		int Max=10;
		int[] inter=new int[2];//定义一个具有两个元素的数组       
		int rount=pageCount-Max+1;      
		if(rount>0){         
			if(rount>Max){             
				if(prePageNo>=Max&&prePageNo<=rount){             
					startPage=prePageNo;           
					endPage=Max+prePageNo-1;           
					}  else if(prePageNo>rount&&prePageNo<=pageCount){
						startPage=rount;             
						endPage=pageCount;            
						}        
					else{         
						startPage=1;   
						endPage=Max; 
						}
				}    else{              
					if(prePageNo>=Max){   
						startPage=rount;   
						endPage=pageCount;    
						}            
					else{             
						startPage=1;     
						endPage=Max;      
						}           
					}       
			}        else{    
				startPage = 1;       
				endPage =pageCount;     
				}      
		return inter;  

}

	
	
	
 
}//end class
