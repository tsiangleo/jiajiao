package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 友情链接
 * @author liuqiang
 *
 */
public class Link implements Serializable{

	private Long id;
	private String name;
	private String url;
	private String info;
	
	public Link(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
