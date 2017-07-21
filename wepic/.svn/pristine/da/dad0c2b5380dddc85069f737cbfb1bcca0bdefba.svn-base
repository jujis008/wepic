package com.wetuo.wepic.publish.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.wetuo.wepic.core.beans.User;
public class Story  implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String storydescription;//摄影故事描述
	private String cover;
	private String storycxt;
	private Timestamp uploadTime;
	private Timestamp checkTime;
	private Timestamp publishTime;
	private Timestamp deltime;
	private Integer hit;
	private Integer buynum;
	private Integer recommend;//推荐次数
	private User user;
	private Integer copyright;// 0 使用权 1 版权
	private Integer statu; //0 未发布为可出售  1发布为可出售审核中(未发布)(不确定是否审核通过) 2 审核未通过 (未发布)  3 审核通过 4 下架(未发布) 5 删除
	private Integer storytype;
	private Integer passstatu;
	private String nopasscause;
	private String nopassration;
	private String writereason;
	private String remark;
	private String moneyType;
	private Integer copyrightPrice;
	private Integer usagePrice;
	private String copyrightArea; //授权区域
	private String copyrightProperty; //版权属性
	private Integer publishid;
	private String copyrightres;
	private PublishSpecialCat publishSpecialCat;//
	private String tags;
	private Integer saleNum;
	private PublishStatus publishStatus;
	private Integer detailpicNum;
	private Integer detailtextNum;
	private String specialWords;
	private String soldoutreason;
	private Set<StoryDetail> storyDetailSet  = new HashSet<StoryDetail>();//
	public Set<StoryDetail> getStoryDetailSet() {
		return storyDetailSet;
	}

	public void setStoryDetailSet(Set<StoryDetail> storyDetailSet) {
		this.storyDetailSet = storyDetailSet;
	}


	public String getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	public PublishSpecialCat getPublishSpecialCat() {
		return publishSpecialCat;
	}//end get()
	public void setPublishSpecialCat(PublishSpecialCat publishSpecialCat) {
		this.publishSpecialCat = publishSpecialCat;
	}//end set()
	public Story(Integer id,String title,String cover,String storycxt,Timestamp uploadTime,Timestamp checkTime,
			Integer hit,Integer buynum,Integer recommend,User user,Integer copyright,Integer statu,Integer storytype,String nopassreason,
			String remark,String moneyType,Integer copyrightPrice,Integer usagePrice,String copyrightArea,String copyrightProperty) {
		this.id = id;
		this.title=title;
		this.cover=cover;
		this.storycxt=storycxt;
		this.uploadTime=uploadTime;
		this.checkTime=checkTime;
		this.hit=hit;
		this.buynum=buynum;
		this.recommend=recommend;
		this.user=user;
		this.copyright=copyright;
		this.statu=statu;
		this.storytype=storytype;
		this.nopassration=nopassreason;
		this.remark=remark;
		this.moneyType=moneyType;
		this.copyrightPrice=copyrightPrice;
		this.usagePrice=usagePrice;
		this.copyrightArea=copyrightArea;
		this.copyrightProperty=copyrightProperty;
	}//
	
	public Story(){
		super();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStorydescription() {
		return storydescription;
	}

	public void setStorydescription(String storydescription) {
		this.storydescription = storydescription;
	}

	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getStorycxt() {
		return storycxt;
	}
	public void setStorycxt(String storycxt) {
		this.storycxt = storycxt;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Timestamp getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public Integer getBuynum() {
		return buynum;
	}
	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getCopyright() {
		return copyright;
	}
	public void setCopyright(Integer copyright) {
		this.copyright = copyright;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	public Integer getStorytype() {
		return storytype;
	}
	public void setStorytype(Integer storytype) {
		this.storytype = storytype;
	}
	public String getNopassration() {
		return nopassration;
	}

	public void setNopassration(String nopassration) {
		this.nopassration = nopassration;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCopyrightPrice() {
		return copyrightPrice;
	}

	public void setCopyrightPrice(Integer copyrightPrice) {
		this.copyrightPrice = copyrightPrice;
	}

	public Integer getPublishid() {
		return publishid;
	}

	public void setPublishid(Integer publishid) {
		this.publishid = publishid;
	}

	public Integer getUsagePrice() {
		return usagePrice;
	}

	public void setUsagePrice(Integer usagePrice) {
		this.usagePrice = usagePrice;
	}

	public String getCopyrightArea() {
		return copyrightArea;
	}

	public void setCopyrightArea(String copyrightArea) {
		this.copyrightArea = copyrightArea;
	}

	public String getCopyrightProperty() {
		return copyrightProperty;
	}

	public void setCopyrightProperty(String copyrightProperty) {
		this.copyrightProperty = copyrightProperty;
	}

	public String getCopyrightres() {
		return copyrightres;
	}

	public void setCopyrightres(String copyrightres) {
		this.copyrightres = copyrightres;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public PublishStatus getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(PublishStatus publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Integer getDetailpicNum() {
		return detailpicNum;
	}

	public void setDetailpicNum(Integer detailpicNum) {
		this.detailpicNum = detailpicNum;
	}

	public Integer getDetailtextNum() {
		return detailtextNum;
	}

	public void setDetailtextNum(Integer detailtextNum) {
		this.detailtextNum = detailtextNum;
	}
	public String getNopasscause() {
		return nopasscause;
	}

	public void setNopasscause(String nopasscause) {
		this.nopasscause = nopasscause;
	}

	public Integer getPassstatu() {
		return passstatu;
	}

	public void setPassstatu(Integer passstatu) {
		this.passstatu = passstatu;
	}

	public String getWritereason() {
		return writereason;
	}

	public void setWritereason(String writereason) {
		this.writereason = writereason;
	}

	public String getSpecialWords() {
		return specialWords;
	}

	public void setSpecialWords(String specialWords) {
		this.specialWords = specialWords;
	}

	public String getSoldoutreason() {
		return soldoutreason;
	}

	public void setSoldoutreason(String soldoutreason) {
		this.soldoutreason = soldoutreason;
	}

	public Timestamp getDeltime() {
		return deltime;
	}

	public void setDeltime(Timestamp deltime) {
		this.deltime = deltime;
	}
}
