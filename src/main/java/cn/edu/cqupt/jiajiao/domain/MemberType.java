package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 会员组
 * @author liuqiang
 *
 */
public class MemberType implements Serializable{

	private Long id;
	private String typename;		//会员组名字
	private Integer sort;			//会员组排序
	private Integer moneypt;		//每次查看消耗的积分
	private Float discount;			//账户充值时的折扣
	private Integer	expense;		//购买会员所需费用
	private Integer	validperiod;	//会员有效期
	
	public MemberType(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getMoneypt() {
		return moneypt;
	}

	public void setMoneypt(Integer moneypt) {
		this.moneypt = moneypt;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getExpense() {
		return expense;
	}

	public void setExpense(Integer expense) {
		this.expense = expense;
	}

	public Integer getValidperiod() {
		return validperiod;
	}

	public void setValidperiod(Integer validperiod) {
		this.validperiod = validperiod;
	}

	
	
}
