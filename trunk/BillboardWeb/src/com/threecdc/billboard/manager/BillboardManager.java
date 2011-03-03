package com.threecdc.billboard.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.threecdc.billboard.dto.Billboard;

public class BillboardManager {
	public static Billboard addBillboard(Billboard newBillboard){
		return null;
	}
	public static Billboard saveBillboard(Billboard b){
		Connection conn = null;
		try{
			String sql = null;
			conn = DbManager.getConnection();
			if (b.getId()==0){
				sql="insert into billboard (displayText, createDate) Values (?,?)";
			}
			else {
				sql="update billboard set displayText = ? where id = ?";
			}
			PreparedStatement pStatement = conn.prepareStatement(sql);
			if (b.getId()==0){
				pStatement.setString(1, b.getDisplayText());
				pStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			}
			else {
				pStatement.setString(1, b.getDisplayText());
				pStatement.setInt(2, b.getId());
				
			}
		
			 pStatement.execute();
			

		} catch (SQLException exc){
			System.err.println("Save Billboard Failed");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Saved " + b.getId() + " Billboards");
		return b;
	}
	public static Billboard getBillboard(int id){
		Connection conn = null;
		Billboard billboardb = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from billboard where id=?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()){
				billboardb = new Billboard();
				billboardb.setId(rs.getInt("id"));
				billboardb.setDisplayText(rs.getString("displayText"));
				billboardb.setCreateDate(rs.getDate("createDate"));
				billboardb.setVisable(rs.getBoolean("isVisable"));
				billboardb.setOwnerName(rs.getString("ownerName"));
				
			}
		} catch (SQLException exc){
			System.err.println("Get All Billboard Failed to retrieve from database");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Returned " + billboardb.getId() + " Billboards");
		return billboardb;
	}
	public static void deleteBillboard(int id){
		Connection conn = null;
		try{
			String sql = null;
			conn = DbManager.getConnection();
				sql="delete from billboard where id=(?)";
			PreparedStatement pStatement = conn.prepareStatement(sql);
				pStatement.setInt(1, id);
		
			 pStatement.execute();
			

		} catch (SQLException exc){
			System.err.println("Delete Billboard Failed");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Delete " + id + " Billboards");
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
