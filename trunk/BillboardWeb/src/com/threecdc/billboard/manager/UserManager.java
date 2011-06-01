package com.threecdc.billboard.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.threecdc.billboard.dto.User;

public class UserManager {
	public User addUser(User newUser){
		return null;
	}

	
	public static User authenticateUser(String username,String password){
		Connection conn = null;
		User useru = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from user where username=? and password=?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()){
				useru = new User();
				useru.setId(rs.getInt("id"));
				useru.setUsername(rs.getString("username"));
				useru.setPassword(rs.getString("password"));
			}
		} catch (SQLException exc){
			System.err.println("Get All User Failed to retrieve from database");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Returned " + useru.getId() + " Users");
		return useru;
	}
	
	public static User saveUser(User u){
		Connection conn = null;
		try{
			String sql = null;
			conn = DbManager.getConnection();
			if (u.getId()==0){
				sql="insert into user (username, password) Values (?,?)";
			}
			else {
				sql="update user set password = ? where id = ?";
			}
			PreparedStatement pStatement = conn.prepareStatement(sql);
			if (u.getId()==0){
				pStatement.setString(1, u.getUsername());
				pStatement.setString(2, u.getPassword());
			}
			else {
				pStatement.setString(1, u.getPassword());
				pStatement.setInt(2, u.getId());
				
			}
		
			 pStatement.execute();
			

		} catch (SQLException exc){
			System.err.println("Save User Failed");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Saved " + u.getId() + " Users");
		return u;
	}
	public static User getUser(int id){
		Connection conn = null;
		User useru = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from user where id=?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()){
				useru = new User();
				useru.setId(id);
				useru.setUsername(rs.getString("username"));
				useru.setPassword(rs.getString("password"));
			}
		} catch (SQLException exc){
			System.err.println("Get All User Failed to retrieve from database");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Returned " + useru.getId() + " Users");
		return useru;
	}
	public static void deleteUser(int id){
		Connection conn = null;
		try{
			String sql = null;
			conn = DbManager.getConnection();
				sql="delete from user where id=(?)";
			PreparedStatement pStatement = conn.prepareStatement(sql);
				pStatement.setInt(1, id);
		
			 pStatement.execute();
			

		} catch (SQLException exc){
			System.err.println("Delete User Failed");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Delete " + id + " Users");
	}

	public static List<User> getAllUsers(){
		List<User> results = new ArrayList<User>();
		Connection conn = null;
		try{
			conn = DbManager.getConnection();
			String sql="select * from user Order By username";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()){
				User useru = new User();
				useru.setId(rs.getInt("id"));
				useru.setUsername(rs.getString("username"));
				useru.setPassword(rs.getString("password"));
				results.add(useru);
			}
		} catch (SQLException exc){
			System.err.println("Get All User Failed to retrieve from database");
			exc.printStackTrace();
		} finally {
			DbManager.releaseConnection(conn);
		}
		System.out.println("Returned " + results.size() + " Users");
		return results;
	}
}





