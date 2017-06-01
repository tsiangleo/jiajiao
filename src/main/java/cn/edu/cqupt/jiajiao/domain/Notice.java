package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 公告实体
 * @author liuqiang
 *
 */
public class Notice implements Serializable{

	private Long id;
	private String title;
	private String content;
	private String publishtime;
	
	public Notice(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	
	
}
