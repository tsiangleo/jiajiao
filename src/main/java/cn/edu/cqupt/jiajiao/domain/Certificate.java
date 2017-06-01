package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 证书类
 * @author liuqiang
 *
 */
public class Certificate implements Serializable{

	private Long id;
	private Long teacherid;			
	private String idcard;			//身份证
	private String stucard;			//学生证
	private String undergraduate;	//本科毕业证
	private String graduate;	    //研究生毕业证
	private String cet4;		//英语四级
	private String cet6;		//英语六级
	private String tem8;		//专业英语八级
	private String cct;			//计算机等级证书	
	private String toefl;		//托福证书
	private String ielts;		//雅思证书
	
	
	public Certificate(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getStucard() {
		return stucard;
	}

	public void setStucard(String stucard) {
		this.stucard = stucard;
	}

	public String getUndergraduate() {
		return undergraduate;
	}

	public void setUndergraduate(String undergraduate) {
		this.undergraduate = undergraduate;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getCet4() {
		return cet4;
	}

	public void setCet4(String cet4) {
		this.cet4 = cet4;
	}

	public String getCet6() {
		return cet6;
	}

	public void setCet6(String cet6) {
		this.cet6 = cet6;
	}

	public String getTem8() {
		return tem8;
	}

	public void setTem8(String tem8) {
		this.tem8 = tem8;
	}

	public String getCct() {
		return cct;
	}

	public void setCct(String cct) {
		this.cct = cct;
	}

	public String getToefl() {
		return toefl;
	}

	public void setToefl(String toefl) {
		this.toefl = toefl;
	}

	public String getIelts() {
		return ielts;
	}

	public void setIelts(String ielts) {
		this.ielts = ielts;
	}

	
}
