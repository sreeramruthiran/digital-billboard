package com.threecdc.billboard.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.threecdc.billboard.dto.Billboard;

public class BillboardManager {
	public Billboard addBillboard(Billboard newBillboard){
		return null;
	}
	public Billboard saveBillboard(Billboard b){
		return null;
	}
	public Billboard getBillboard(int id){
		return null;
	}
	public void deleteBillboard(int id){
		
	}

	public static List<Billboard> getAllBillboards(){
		List<Billboard> results = new ArrayList<Billboard>();
		Connection conn = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from billboard Order By createDate";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()){
				Billboard billboardb = new Billboard();
				billboardb.setId(rs.getInt("id"));
				billboardb.setDisplayText(rs.getString("displayText"));
				billboardb.setCreateDate(rs.getDate("createDate"));
				billboardb.setVisable(rs.getBoolean("isVisable"));
				billboardb.setOwnerName(rs.getString("ownerName"));
				
				results.add(billboardb);
			}
		} catch (SQLException exc){
			System.err.println("Get All Billboard Failed to retrieve from database");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Returned " + results.size() + " Billboards");
		return results;
	}
	
	
	
}
