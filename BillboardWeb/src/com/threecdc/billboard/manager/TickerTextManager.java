package com.threecdc.billboard.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.threecdc.billboard.dto.TickerText;

public class TickerTextManager {
	public TickerText addTicker(TickerText newTicker){
		return null;
	}
	public static void saveTickerText(String tickertext, int userid){
		Connection conn = null;
		try{
			deleteTickerText(userid);
			conn = DbManager.getConnection();
			String sql="insert into tickertext (tickertext,createDate,isVisable,userid) Values(?,?,?,?)";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, tickertext);
			pStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			pStatement.setInt(3, 1);
			pStatement.setInt(4, userid);
			pStatement.execute();

		} catch (SQLException exc){
			System.err.println("Failed to Save Ticker Text");
			exc.printStackTrace();
		}
		finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Updated TickerTexts ");
	}
	public TickerText getTicker(int id){
		return null;
	}
	public void deleteTicker(int id){
		
	}
	public static TickerText getNextTicker(int userid){
		TickerText tickertextb = new TickerText();
		Connection conn = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from tickertext Where isVisable = true and userid = ? Order By createDate desc";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, userid);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()){
				
				tickertextb.setId(rs.getInt("id"));
				tickertextb.setTickerText(rs.getString("tickerText"));
				tickertextb.setCreateDate(rs.getDate("createDate"));
				tickertextb.setVisable(rs.getBoolean("isVisable"));
				tickertextb.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException exc){
			System.err.println("Get All TickerTexts Failed to retrieve from database");
			exc.printStackTrace();
		}
		finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Returned TickerTexts " + tickertextb.getId());
		return tickertextb;
	}
	public static void deleteTickerText(int userid){
		Connection conn = null;
		try{
			String sql = null;
			conn = DbManager.getConnection();
				sql="delete from tickertext where userid=(?)";
			PreparedStatement pStatement = conn.prepareStatement(sql);
				pStatement.setInt(1, userid);
		
			 pStatement.execute();
			

		} catch (SQLException exc){
			System.err.println("Delete TickerText Failed");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Delete " + userid + " TickerText");
	}

	
	
}
