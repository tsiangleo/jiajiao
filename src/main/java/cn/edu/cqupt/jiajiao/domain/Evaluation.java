package cn.edu.cqupt.jiajiao.domain;

/**
 * 评价表
 * @author Michael
 *
 */
public class Evaluation {
	private Long id;
	private Long teacherid;		//教员id
	private String totalevaluation;	//总体评价
	private String content;		//评价内容
	private String author;		//评价者（学员用户名）
	private String time;		//评价时间
	private String reply;		//教员回复
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
	public String getTotalevaluation() {
		return totalevaluation;
	}
	public void setTotalevaluation(String totalevaluation) {
		this.totalevaluation = totalevaluation;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	
}
