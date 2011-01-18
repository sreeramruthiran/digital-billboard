package com.threecdc.billboard.manager;

public class DbManager {
	private String Connection;
	private String releaseConnection;
	
	
	//Methods Start
	public String getConnection() {
		return Connection;
	}
	public void setConnection(String connection) {
		Connection = connection;
	}
	public String getReleaseConnection() {
		return releaseConnection;
	}
	public void setReleaseConnection(String releaseConnection) {
		this.releaseConnection = releaseConnection;
	}
	
}
