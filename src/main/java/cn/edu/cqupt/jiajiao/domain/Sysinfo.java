package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 网站平台相关信息
 * @author liuqiang
 *
 */
public class Sysinfo implements Serializable{

	private Long id;
	private String sitename;	//网站名称
	private String sitelogo;	//网站logo
	private	String siteurl;		//网站URL
	private	String keywords;	//关键字
	private	String description;	//网站描述
	private	String serviceqq;	//客服QQ
	private	String adminemail;	//管理员邮箱
	private	String ICP;			//网站备案信息代码
	private	String copyright;	//版权信息
	private	String aboutus;		//关于我们
	private	String contactus;	//联系我们
	
	public Sysinfo(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getSitelogo() {
		return sitelogo;
	}

	public void setSitelogo(String sitelogo) {
		this.sitelogo = sitelogo;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceqq() {
		return serviceqq;
	}

	public void setServiceqq(String serviceqq) {
		this.serviceqq = serviceqq;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getICP() {
		return ICP;
	}

	public void setICP(String iCP) {
		ICP = iCP;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAboutus() {
		return aboutus;
	}

	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}

	public String getContactus() {
		return contactus;
	}

	public void setContactus(String contactus) {
		this.contactus = contactus;
	}

	
	
}
