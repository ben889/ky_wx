package com.framework.domain;

/**
 * Tabs entity. @author MyEclipse Persistence Tools
 */

public class Tabs implements java.io.Serializable {

	// Fields
	private Integer tabid;
	private String tabname;
	private String taburl;
	private Integer parentid;
	private Integer level;
	private Integer orderby;
	private String icon;
	private Boolean display;
	private String tabkey;

	// Constructors

	/** default constructor */
	public Tabs() {
	}

	/** full constructor */
	public Tabs(String tabname, String taburl, Integer parentid, Integer level,
			Integer orderby, String icon, Boolean display, String tabkey) {
		this.tabname = tabname;
		this.taburl = taburl;
		this.parentid = parentid;
		this.level = level;
		this.orderby = orderby;
		this.icon = icon;
		this.display = display;
		this.tabkey = tabkey;
	}
	

	// Property accessors
	public Integer getTabid() {
		return this.tabid;
	}

	public void setTabid(Integer tabid) {
		this.tabid = tabid;
	}

	public String getTabname() {
		return this.tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

	public String getTaburl() {
		return this.taburl;
	}

	public void setTaburl(String taburl) {
		this.taburl = taburl;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getDisplay() {
		return this.display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public String getTabkey() {
		return this.tabkey;
	}

	public void setTabkey(String tabkey) {
		this.tabkey = tabkey;
	}

}