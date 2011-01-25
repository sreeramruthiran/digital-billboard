package com.threecdc.billboard.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.threecdc.billboard.dto.TickerText;

public class TickerTextManager {
	public TickerText addTicker(TickerText newTicker){
		return null;
	}
	public TickerText saveTicker(TickerText t){
		return null;
	}
	public TickerText getTicker(int id){
		return null;
	}
	public void deleteTicker(int id){
		
	}
	public TickerText getNextTicker(){
		TickerText tickertextb = new TickerText();
		Connection conn = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from tickertext Where isVisable = true Order By createDate desc";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()){
				
				tickertextb.setId(rs.getInt("id"));
				tickertextb.setTickerText(rs.getString("tickerText"));
				tickertextb.setCreateDate(rs.getDate("createDate"));
				tickertextb.setVisable(rs.getBoolean("isVisable"));
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
	
	
	
}
