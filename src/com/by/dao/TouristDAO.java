package com.by.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.by.factory.ConnectionFactory;
import com.by.model.Tourist;

/**
 * 
 * @author liujianzhong
 *
 */
public class TouristDAO extends ConnectionFactory{
	
	/**
	 * 
	 * @param tourist
	 */
	public void insertAnserObject(Tourist tourist) {
		Connection connect = null;

		String sql = "INSERT INTO tourist(identify,username,password) VALUES (?,?,?)";
		PreparedStatement pstmt = null;
		System.out.print(sql);
		connect = createConnect();
		ResultSet rs = null;
		try {				
				pstmt =	connect.prepareStatement(sql);
				pstmt.setString(1, tourist.getIdentify());
				pstmt.setString(2, tourist.getUsername());
				pstmt.setString(3, tourist.getPassword());
//				pstmt.addBatch();
				pstmt.executeBatch();
//				pstmt.clearBatch();
				pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseConnect(connect, pstmt, rs);
			
		}
	}
}
