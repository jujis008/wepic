package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
import java.util.*;
	
public class UserCredit  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private float dealMoney;//交易金额
	private Integer productsNum;//发布的图片
	private Integer bidNum;//应约的约拍
	private Integer bidConfirmedNum;//被确定的次数
	private Integer bidGoodRemarkNum;//好评次数
	private Integer bidBadRemarkNum;//差评次数
	private float totalMark;//得分
	private Integer diamond;//钻
	private Integer star;//星
	private Integer ifCancelMemberQualification;//取消次数
	private float buyPicMoney;
	private float sellPicMoney;
	private float bidGiveMoney;//项目支出
	private float bidGetMoney;//项目收入
	
 
	////start OneToMany
	
	
	private Set<UserCreditHistory> userCreditHistorySet  = new HashSet<UserCreditHistory>();

	public UserCredit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCredit(Integer id, User user, float dealMoney,
			Integer productsNum, Integer bidNum, Integer bidConfirmedNum,
			Integer bidGoodRemarkNum, Integer bidBadRemarkNum, float totalMark,
			Integer diamond, Integer star, Integer ifCancelMemberQualification,
			float buyPicMoney, float sellPicMoney, float bidGiveMoney,
			float bidGetMoney, Set<UserCreditHistory> userCreditHistorySet) {
		super();
		this.id = id;
		this.user = user;
		this.dealMoney = dealMoney;
		this.productsNum = productsNum;
		this.bidNum = bidNum;
		this.bidConfirmedNum = bidConfirmedNum;
		this.bidGoodRemarkNum = bidGoodRemarkNum;
		this.bidBadRemarkNum = bidBadRemarkNum;
		this.totalMark = totalMark;
		this.diamond = diamond;
		this.star = star;
		this.ifCancelMemberQualification = ifCancelMemberQualification;
		this.buyPicMoney = buyPicMoney;
		this.sellPicMoney = sellPicMoney;
		this.bidGiveMoney = bidGiveMoney;
		this.bidGetMoney = bidGetMoney;
		this.userCreditHistorySet = userCreditHistorySet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(float dealMoney) {
		this.dealMoney = dealMoney;
	}

	public Integer getProductsNum() {
		return productsNum;
	}

	public void setProductsNum(Integer productsNum) {
		this.productsNum = productsNum;
	}

	public Integer getBidNum() {
		return bidNum;
	}

	public void setBidNum(Integer bidNum) {
		this.bidNum = bidNum;
	}

	public Integer getBidConfirmedNum() {
		return bidConfirmedNum;
	}

	public void setBidConfirmedNum(Integer bidConfirmedNum) {
		this.bidConfirmedNum = bidConfirmedNum;
	}

	public Integer getBidGoodRemarkNum() {
		return bidGoodRemarkNum;
	}

	public void setBidGoodRemarkNum(Integer bidGoodRemarkNum) {
		this.bidGoodRemarkNum = bidGoodRemarkNum;
	}

	public Integer getBidBadRemarkNum() {
		return bidBadRemarkNum;
	}

	public void setBidBadRemarkNum(Integer bidBadRemarkNum) {
		this.bidBadRemarkNum = bidBadRemarkNum;
	}

	public float getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(float totalMark) {
		this.totalMark = totalMark;
	}

	public Integer getDiamond() {
		return diamond;
	}

	public void setDiamond(Integer diamond) {
		this.diamond = diamond;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getIfCancelMemberQualification() {
		return ifCancelMemberQualification;
	}

	public void setIfCancelMemberQualification(Integer ifCancelMemberQualification) {
		this.ifCancelMemberQualification = ifCancelMemberQualification;
	}

	public float getBuyPicMoney() {
		return buyPicMoney;
	}

	public void setBuyPicMoney(float buyPicMoney) {
		this.buyPicMoney = buyPicMoney;
	}

	public float getSellPicMoney() {
		return sellPicMoney;
	}

	public void setSellPicMoney(float sellPicMoney) {
		this.sellPicMoney = sellPicMoney;
	}

	public float getBidGiveMoney() {
		return bidGiveMoney;
	}

	public void setBidGiveMoney(float bidGiveMoney) {
		this.bidGiveMoney = bidGiveMoney;
	}

	public float getBidGetMoney() {
		return bidGetMoney;
	}

	public void setBidGetMoney(float bidGetMoney) {
		this.bidGetMoney = bidGetMoney;
	}

	public Set<UserCreditHistory> getUserCreditHistorySet() {
		return userCreditHistorySet;
	}

	public void setUserCreditHistorySet(Set<UserCreditHistory> userCreditHistorySet) {
		this.userCreditHistorySet = userCreditHistorySet;
	}// 
}
