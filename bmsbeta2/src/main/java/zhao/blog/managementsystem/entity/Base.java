package zhao.blog.managementsystem.entity;
// Generated 2017-7-24 20:10:01 by Hibernate Tools 4.0.0.Final

import java.util.Date;

/**
 * Base generated by hbm2java
 */
public class Base implements java.io.Serializable {

	private Integer id;
	private String title;
	private String stitle;
	private int visite;
	private Date runtime;

	public Base() {
	}

	public Base(String title, String stitle, int visite, Date runtime) {
		this.title = title;
		this.stitle = stitle;
		this.visite = visite;
		this.runtime = runtime;
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

	public String getStitle() {
		return this.stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public int getVisite() {
		return this.visite;
	}

	public void setVisite(int visite) {
		this.visite = visite;
	}

	public Date getRuntime() {
		return this.runtime;
	}

	public void setRuntime(Date runtime) {
		this.runtime = runtime;
	}

}