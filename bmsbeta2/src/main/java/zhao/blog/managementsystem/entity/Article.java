package zhao.blog.managementsystem.entity;
// Generated 2017-7-24 20:10:01 by Hibernate Tools 4.0.0.Final

import java.util.Date;

/**
 * Article generated by hbm2java
 */
public class Article implements java.io.Serializable {

	private Integer id;
	private String title;
	private String content;
	private String image;
	private Date time;
	private Date finaltime;
	private String editer;
	private int watch;
	private int replys;
	private String type;
	private String recommend;
	private String keywords;
	private String source;

	public Article() {
	}

	public Article(String title, String content, Date time, Date finaltime, String editer, int watch, int replys) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.finaltime = finaltime;
		this.editer = editer;
		this.watch = watch;
		this.replys = replys;
	}

	public Article(String title, String content, String image, Date time, Date finaltime, String editer, int watch,
			int replys, String type, String recommend, String keywords, String source) {
		this.title = title;
		this.content = content;
		this.image = image;
		this.time = time;
		this.finaltime = finaltime;
		this.editer = editer;
		this.watch = watch;
		this.replys = replys;
		this.type = type;
		this.recommend = recommend;
		this.keywords = keywords;
		this.source = source;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getFinaltime() {
		return this.finaltime;
	}

	public void setFinaltime(Date finaltime) {
		this.finaltime = finaltime;
	}

	public String getEditer() {
		return this.editer;
	}

	public void setEditer(String editer) {
		this.editer = editer;
	}

	public int getWatch() {
		return this.watch;
	}

	public void setWatch(int watch) {
		this.watch = watch;
	}

	public int getReplys() {
		return this.replys;
	}

	public void setReplys(int replys) {
		this.replys = replys;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
