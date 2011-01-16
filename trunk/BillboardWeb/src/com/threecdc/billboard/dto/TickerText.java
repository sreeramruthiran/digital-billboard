package com.threecdc.billboard.dto;

import java.util.Date;

public class TickerText {
	private int id;
	private String tickerText;
	private Date createDate;
	private boolean isVisable;
	
	//Methods start
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTickerText() {
		return tickerText;
	}
	public void setTickerText(String tickerText) {
		this.tickerText = tickerText;
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
	

}
