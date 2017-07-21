package com.wetuo.wepic.publish.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.common.struts.PageAction;


public class FileUploadAction extends PageAction {
	private static final String[] ALOWED_FILETYPE = { "text/xml",
			"application/excel", "application/vnd.ms-excel", "text/plain","application/octet-stream" };
	private static final String SERVICEMIX_ROOTPATH = "D:\\apache-servicemix-4.3.0";
	// ///instantce variable//////
	private static final long serialVersionUID = 1L;
	private List<File> ediFile;
	private List<String> ediFileFileName;
	private List<String> ediFileContentType;
	protected String dir;
	private String ediPath ;
	
	private List<String> progressList = new ArrayList<String>();
	private List<String> fileNameList = new ArrayList<String>();
	
	

	// ???????????��????
	public void validate() {
		clearErrorsAndMessages();		
		String queryString = getRequestPath();
		if (queryString.indexOf("fileUpload!upload") != -1) {
			if (ediFile == null || ediFile.size() == 0) {
				addFieldError("notInputFile", "EDIfile must be inputed");
			}else{
				for (int i = 0; i < ediFileContentType.size(); i++) {
					if(ediFile.get(i).length()<=0){
						addFieldError("fileEmpty", "the file"+ediFileFileName.get(i)+" you upload is empty!");
					}
					boolean isSupport = false;
					for (String alowedType : ALOWED_FILETYPE) {
						if (ediFileContentType.get(i).equals(alowedType)) {
							isSupport = true;
						}
					}
					if(!isSupport){
						addFieldError("fileTypeNotSupport", "not supported type:" + ediFileFileName.get(i));
					}
				}
				
			}
			if (dir == null || dir.equals("")) {
				addFieldError("notInputEDIBusiness", "EDIBusiness must be inputed");
			} 
		}
	}// end validate()


	public String upload() throws Exception {
		clearErrorsAndMessages();
//		for (File f : ediFile) {
//			FileUtils.copyFile(f, new File(SERVICEMIX_ROOTPATH + "\\" + dir
//					+ "\\" + f.getName()));
//		}
		for (int i = 0; i < ediFile.size(); i++) {
			File f = ediFile.get(i);
			FileUtils.copyFile(f, new File(SERVICEMIX_ROOTPATH + "\\" + dir
					+ "\\" + ediFileFileName.get(i)));
		}
		addActionMessage("file upload success��");
		//return "input";//init
		if(ediPath != null){
			this.setSession("ediPath", ediPath);
		}
		
		return "init";//		
	}// end list()
	
	@JSON(serialize = false)
	public String retResult(){
		try {		
			System.out.println( "ediPath : " + ediPath );
			if(ediPath == null){
				ediPath = (String) this.getSession("ediPath");
			}else if(ediPath.length()==0 ){
				ediPath = (String) this.getSession("ediPath");
			}			
			
			String ediPathLowCase = ediPath.toLowerCase();
			
			int intBegin = ediPathLowCase.lastIndexOf("\\");
			if(intBegin < 0 ){
				intBegin = ediPathLowCase.lastIndexOf("/");
			}
			intBegin++;
			
			int intEnd = ediPathLowCase.lastIndexOf(".edi");
			if(intBegin < 0 ){
				intBegin = ediPathLowCase.lastIndexOf(".txt");
			}
			
			String strEdiName = ediPath.substring(intBegin).trim(); 
			System.out.println( "strEdiName : " + strEdiName );
			///ediPath : D:\apache-servicemix-4.3.0\input-message-hyb.edi
			////this.getHibernateTemplate().find("from bean.User u where u.name like ?", "%test%");
			String[] strArrInput = new String[1];
			//strArrInput[0] = "%" + strEdiName + "%" ;
			strArrInput[0] = strEdiName;
			
//			strArrInput[1] = getBetween(new Date())[0] ;
//			strArrInput[2] = getBetween(new Date())[1] ;
			
			//List<Log> logList = logService.findPart("fileNameIn like ? and logDate between ? and ? ", strArrInput );	
			//List<Log> logList = logService.findPart("fileNameIn like ?  ", strArrInput );	
//			progressList.add(String.valueOf(new Date().getTime()));
//			progressList.add(String.valueOf(new Date().getTime()));
			System.out.println("--------------------------------------------------------");
			return "retResult";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String[] getBetween(Date date){
		long before = date.getTime()-100;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sim.format(new Date(before))+"------"+sim.format(date));
		return new String[]{sim.format(new Date(before)),sim.format(date)};
	}
	
	// ///getter////setter//////

	public List<File> getEdiFile() {
		return ediFile;
	}

	public void setEdiFile(List<File> ediFile) {
		this.ediFile = ediFile;
	}

	public List<String> getEdiFileFileName() {
		return ediFileFileName;
	}

	public void setEdiFileFileName(List<String> ediFileFileName) {
		this.ediFileFileName = ediFileFileName;
	}

	public List<String> getEdiFileContentType() {
		return ediFileContentType;
	}

	public void setEdiFileContentType(List<String> ediFileContentType) {
		this.ediFileContentType = ediFileContentType;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	private void reset() {
		setEdiFile(null);
		setEdiFileContentType(null);
		setEdiFileFileName(null);
		setDir(null);
	}//end reset()
	
	public String getEdiPath() {
		return ediPath;
	}
	public void setEdiPath(String ediPath) {
		this.ediPath = ediPath;
	}
	public List<String> getProgressList() {
		return progressList;
	}
	public void setProgressList(List<String> progressList) {
		this.progressList = progressList;
	}
	
	public List<String> getFileNameList() {
		return fileNameList;
	}
	public void setFileNameList(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}

}// end class
