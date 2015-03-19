package br.com.restful.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SinaDataBaseDao {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String URL="jdbc:mysql://swweaper5.mysql.rds.aliyuncs.com:3306/cookfoodshare";
		String Username="swweaper5";
		String Password="a051226";
		String Driver="com.mysql.jdbc.Driver";
		Class.forName(Driver).newInstance();
		System.out.println("===");
		Connection con=DriverManager.getConnection(URL,Username,Password);
		PreparedStatement pstmt = con.prepareStatement("select * from testtable");
		ResultSet rs = (ResultSet) pstmt.executeQuery();
		while(rs.next()){
			System.out.println("===identify:"+rs.getInt("identify")+"===="+"name+"+rs.getString("name"));
		}
	}

}
