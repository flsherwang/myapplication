package com.bean;

public class Pic {
	private Integer id;
	private String title;
	private String content;
	private String picture;
	private String album;
	private Integer type1;
	private Integer type2;
	private String createname;
	private long createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public Integer getType1() {
		return type1;
	}
	public void setType1(Integer type1) {
		this.type1 = type1;
	}
	public Integer getType2() {
		return type2;
	}
	public void setType2(Integer type2) {
		this.type2 = type2;
	}
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	public long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}
	public Pic(String title, String content, String picture, String album, Integer type1, Integer type2,
			String createname, long createtime) {
		super();
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.album = album;
		this.type1 = type1;
		this.type2 = type2;
		this.createname = createname;
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Pic [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture + ", album="
				+ album + ", type1=" + type1 + ", type2=" + type2 + ", createname=" + createname + ", createtime="
				+ createtime + "]";
	}
	
}
