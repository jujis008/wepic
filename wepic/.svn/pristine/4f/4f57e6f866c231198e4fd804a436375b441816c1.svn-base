package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.User;
 
public class AssessComplaint  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User complainantAssessor;
	protected User admin;
	private String complaint;
	private Integer complaintType;
	private String assess;
	private String assessType;
	private Integer handleType;
	private String handleOpinion;
 
	////start OneToMany
	private Publish publish;//
	public Publish getPublish() {
		return publish;
	}//end get()
	public void setPublish(Publish publish) {
		this.publish = publish;
	}//end set()
	/////////constructor//////////////////
	
	public AssessComplaint(Integer id,User complainantAssessor,User admin,String complaint,Integer complaintType,String assess,String assessType,Integer handleType,String handleOpinion) {
		this.id = id;
		this.complainantAssessor = complainantAssessor;
		this.admin = admin;
		this.complaint = complaint;
		this.complaintType = complaintType;
		this.assess = assess;
		this.assessType = assessType;
		this.handleType = handleType;
		this.handleOpinion = handleOpinion;
	}//
	
	public AssessComplaint(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String  getComplaint(){
		return this.complaint;
	}
	public void  setComplaint(String complaint){
		this.complaint = complaint ;
	}
	public Integer  getComplaintType(){
		return this.complaintType;
	}
	public void  setComplaintType(Integer complaintType){
		this.complaintType = complaintType ;
	}
	public String  getAssess(){
		return this.assess;
	}
	public void  setAssess(String assess){
		this.assess = assess ;
	}
	public String  getAssessType(){
		return this.assessType;
	}
	public void  setAssessType(String assessType){
		this.assessType = assessType ;
	}
	public Integer  getHandleType(){
		return this.handleType;
	}
	public void  setHandleType(Integer handleType){
		this.handleType = handleType ;
	}
	public String  getHandleOpinion(){
		return this.handleOpinion;
	}
	public void  setHandleOpinion(String handleOpinion){
		this.handleOpinion = handleOpinion ;
	}

	public User getComplainantAssessor() {
		return complainantAssessor;
	}

	public void setComplainantAssessor(User complainantAssessor) {
		this.complainantAssessor = complainantAssessor;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
	
 
}//end class
