package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 新闻
 * @author liuqiang
 *
 */
public class News implements Serializable{

	private Long id;
	private String title;
	private String content;
	private String source;		//来源
	private String publishtime;	//发布时间
	private int click;		//点击数
	private String type;	//新闻种类
	
	public News(){}

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	


	
	
	
}
