package com.by.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.by.factory.ConnectionFactory;
import com.by.model.Scenery_sopt;

public class SceneryDao extends ConnectionFactory{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
SceneryDao sceneryDao = new SceneryDao();
//System.out.println(sceneryDao.getHotScenneryWithNumber(3));
	System.out.println(sceneryDao.getAllScenneryBySceneryName("东极岛"));
	}
	/**
	 * 新增旅游景点
	 * @param tourist
	 */
	public boolean insertMessageObject(Scenery_sopt scenery_sopt) {
//	 senaryname  cityid cityname imageurl ordernumber touristnumber scenerynumber score  date
		Boolean status = true;
		Connection connect = null;
		String sql = "INSERT INTO scenery_spot(identify,senaryname,cityid,cityname,imageurl,ordernumber,touristnumber,scenerynumber,score,date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.print(sql);
		connect = createConnect();
		ResultSet rs = null;
		try {				
				pstmt =	connect.prepareStatement(sql);
				pstmt.setInt(1, scenery_sopt.getIdentify());
				pstmt.setString(2, scenery_sopt.getSenaryname());
				pstmt.setInt(3, scenery_sopt.getCityid());
				pstmt.setString(4, scenery_sopt.getCityname());
				pstmt.setString(5, scenery_sopt.getImageurl());
				pstmt.setInt(6, scenery_sopt.getOrdernumber());
				pstmt.setInt(7, scenery_sopt.getTouristnumber());
				pstmt.setString(8, scenery_sopt.getSenaryname());
				pstmt.setFloat(9, scenery_sopt.getScore());
				pstmt.setInt(10, scenery_sopt.getDate());
				pstmt.executeUpdate();
		} catch (SQLException e) {
			status = false;
			System.out.print(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseConnect(connect, pstmt, rs);
		}
		return status;
	}
	
	/***
	 * 通过城市id查景点
	 * @return
	 */
	public ArrayList<Scenery_sopt> getAllScenneryByCityId (int cityid) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Scenery_sopt> scenery_soptlist = null;
		
		connect = createConnect();
		scenery_soptlist = new ArrayList<Scenery_sopt>();
		String sql = "select * from scenery_spot where cityid = "+cityid;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Scenery_sopt scenery_sopt = new Scenery_sopt();
				scenery_sopt.setIdentify(rs.getInt("identify"));
				scenery_sopt.setSenaryname(rs.getString("senaryname"));
				scenery_sopt.setCityid(rs.getInt("cityid"));
				scenery_sopt.setCityname(rs.getString("cityname"));
				scenery_sopt.setImageurl(rs.getString("imageurl"));
				scenery_sopt.setOrdernumber(rs.getInt("ordernumber"));
				scenery_sopt.setTouristnumber(rs.getInt("touristnumber"));
				scenery_sopt.setScenerynumber(rs.getInt("scenerynumber"));
				scenery_sopt.setScore(rs.getInt("score"));
				scenery_sopt.setDate(rs.getInt("date"));
				scenery_soptlist.add(scenery_sopt);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return scenery_soptlist;
	}
	
	/***
	 * 通过城市名称查景点
	 * @return
	 */
	public ArrayList<Scenery_sopt> getAllScenneryByCityName (String cityname) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Scenery_sopt> scenery_soptlist = null;
		
		connect = createConnect();
		scenery_soptlist = new ArrayList<Scenery_sopt>();
		String sql = "select * from scenery_spot where cityname like " + "\'%"+cityname+"%\'";
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Scenery_sopt scenery_sopt = new Scenery_sopt();
				scenery_sopt.setIdentify(rs.getInt("identify"));
				scenery_sopt.setSenaryname(rs.getString("senaryname"));
				scenery_sopt.setCityid(rs.getInt("cityid"));
				scenery_sopt.setCityname(rs.getString("cityname"));
				scenery_sopt.setImageurl(rs.getString("imageurl"));
				scenery_sopt.setOrdernumber(rs.getInt("ordernumber"));
				scenery_sopt.setTouristnumber(rs.getInt("touristnumber"));
				scenery_sopt.setScenerynumber(rs.getInt("scenerynumber"));
				scenery_sopt.setScore(rs.getInt("score"));
				scenery_sopt.setDate(rs.getInt("date"));
				scenery_soptlist.add(scenery_sopt);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return scenery_soptlist;
	}
	/***
	 * 通过景点名称查景点
	 * @return
	 */
	public ArrayList<Scenery_sopt> getAllScenneryBySceneryName (String senaryname) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Scenery_sopt> scenery_soptlist = null;
		
		connect = createConnect();
		scenery_soptlist = new ArrayList<Scenery_sopt>();
		String sql = "select * from scenery_spot where senaryname like "+ "\'%" +senaryname+"%\'";
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Scenery_sopt scenery_sopt = new Scenery_sopt();
				scenery_sopt.setIdentify(rs.getInt("identify"));
				scenery_sopt.setSenaryname(rs.getString("senaryname"));
				scenery_sopt.setCityid(rs.getInt("cityid"));
				scenery_sopt.setCityname(rs.getString("cityname"));
				scenery_sopt.setImageurl(rs.getString("imageurl"));
				scenery_sopt.setOrdernumber(rs.getInt("ordernumber"));
				scenery_sopt.setTouristnumber(rs.getInt("touristnumber"));
				scenery_sopt.setScenerynumber(rs.getInt("scenerynumber"));
				scenery_sopt.setScore(rs.getInt("score"));
				scenery_sopt.setDate(rs.getInt("date"));
				scenery_soptlist.add(scenery_sopt);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return scenery_soptlist;
	}	
	/***
	 * 获取热门景点
	 * 按照ordernumber倒序排列，ordernumber越大越排前面
	 * @return
	 */
	public ArrayList<Scenery_sopt> getHotScenneryWithNumber (int number) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Scenery_sopt> scenery_soptlist = null;
		
		connect = createConnect();
		scenery_soptlist = new ArrayList<Scenery_sopt>();
		String sql = "select * from scenery_spot order by ordernumber desc limit "+number;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Scenery_sopt scenery_sopt = new Scenery_sopt();
				scenery_sopt.setIdentify(rs.getInt("identify"));
				scenery_sopt.setSenaryname(rs.getString("senaryname"));
				scenery_sopt.setCityid(rs.getInt("cityid"));
				scenery_sopt.setCityname(rs.getString("cityname"));
				scenery_sopt.setImageurl(rs.getString("imageurl"));
				scenery_sopt.setOrdernumber(rs.getInt("ordernumber"));
				scenery_sopt.setTouristnumber(rs.getInt("touristnumber"));
				scenery_sopt.setScenerynumber(rs.getInt("scenerynumber"));
				scenery_sopt.setScore(rs.getInt("score"));
				scenery_sopt.setDate(rs.getInt("date"));
				scenery_soptlist.add(scenery_sopt);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return scenery_soptlist;
	}

}
