package com.threecdc.billboard.dto;

import java.util.Date;

public class Billboard {
	private int id;
	private String displayText;
	private Byte[] imgBytes;
	private Date createDate;
	private boolean isVisable;
	private String ownerName;
	
	//Methods Start
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public Byte[] getImgBytes() {
		return imgBytes;
	}
	public void setImgURL(Byte[] imgBytes) {
		this.imgBytes = imgBytes;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isVisable() {
		return isVisable;
	}
	public void setVisable(boolean isVisable) {
		this.isVisable = isVisable;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	

}
