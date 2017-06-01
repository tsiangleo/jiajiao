package cn.edu.cqupt.jiajiao.domain;

import java.util.Date;

/**
 * 学员的收藏夹
 * @author liuqiang
 *
 */
public class Collection {
	
	private Long id;			//收藏编号
	private Long memberid;		//学员id
	private Long teacherid;		//教员id
	private String time;		//收藏时间

	public Collection(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
