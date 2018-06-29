package com.neuedu.lvcity.model;

public class Banar {
	private int bannarid;
	private String image;
	private int state;
	public Banar() {
		super();
	}
	public Banar(int bannarid, String image, int state) {
		super();
		this.bannarid = bannarid;
		this.image = image;
		this.state = state;
	}
	public int getBannarid() {
		return bannarid;
	}
	public void setBannarid(int bannarid) {
		this.bannarid = bannarid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
