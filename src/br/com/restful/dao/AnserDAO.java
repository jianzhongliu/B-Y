package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Date;

import br.com.restful.model.Anser;

import br.com.restful.factory.ConnectionFactory;

public class AnserDAO extends ConnectionFactory{
public static void main (String[] arg)
{
	Anser tempanser = new Anser();
	tempanser.setContent("hanguo");
	tempanser.setAuid(123);
	tempanser.setIdentify(306);
	tempanser.setQid(45);
	tempanser.setScore(45);
	tempanser.setStatus(0);
	tempanser.setAdate(new Date(0));
//	tempanser.setIdentify(null);
	
	ArrayList<Integer> tempInter = new ArrayList<Integer>();
	tempInter.add(299);
	tempInter.add(301);
	new AnserDAO().updateAnserObject(tempanser);
	
//System.out.println(new AnserDAO().allAnserObject());	
}
	private static AnserDAO instance;
	public static AnserDAO getInstance(){
		if(instance == null)
			instance = new AnserDAO();
		return instance;
	}
	//select * from anser order by identify
public ArrayList<Anser> allAnserObject(String sql) {
	Connection connect = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	ArrayList<Anser> ansers = null;
	
	connect = createConnect();
	ansers = new ArrayList<Anser>();

	try {
		pstmt = connect.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			Anser anser = new Anser();
			anser.setIdentify(rs.getInt("identify"));
			anser.setContent(rs.getString("content"));
			anser.setAuid(rs.getInt("auid"));
			anser.setQid(rs.getInt("quid"));
			anser.setStatus(rs.getInt("status"));
			anser.setScore(rs.getInt("score"));
			anser.setAdate(rs.getDate("adate"));
			ansers.add(anser);
		}		
	} catch (Exception e) {
		System.out.println("Erro ao listar todos os anser: " + e);
		e.printStackTrace();
	} finally {
		releaseConnect(connect, pstmt, rs);
	}
	return ansers;
}

public void insertAnserObject(Anser anser) {
	Connection connect = null;

	String sql = "INSERT INTO anser(auid,quid,status,score,content,adate) VALUES (?,?,?,?,?,?)";
	PreparedStatement pstmt = null;
	System.out.print(sql);
	connect = createConnect();
	ResultSet rs = null;
	try {
		for (int i = 0; i<1 ; i++){
			
			pstmt =	connect.prepareStatement(sql);
//			pstmt.setInt(1, anser.getIdentify());
			pstmt.setInt(1, anser.getAuid());
			pstmt.setInt(2, anser.getQid());
			pstmt.setInt(3, anser.getStatus());
			pstmt.setInt(4, anser.getScore());
			pstmt.setString(5, anser.getContent());
			pstmt.setDate(6, anser.getAdate());
			pstmt.addBatch();//可以执行多次
			pstmt.executeBatch();
			
			pstmt.clearBatch();
		}

//	pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.print(e);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		releaseConnect(connect, pstmt, rs);
		
	}
}

public void insertAnserObjectList(ArrayList<Anser> anserList) {
	Connection connect = null;
	ResultSet rs = null;
	String sql = "INSERT INTO anser(auid,quid,status,score,content,adate) VALUES (?,?,?,?,?,?)";
	PreparedStatement pstmt = null;
	System.out.print(sql);
	connect = createConnect();
	try {
		Iterator<Anser> iterator = anserList.listIterator();
		while (iterator.hasNext()) {
			Anser anser = iterator.next();
			pstmt =	connect.prepareStatement(sql);
//			pstmt.setInt(1, anser.getIdentify());
			pstmt.setInt(1, anser.getAuid());
			pstmt.setInt(2, anser.getQid());
			pstmt.setInt(3, anser.getStatus());
			pstmt.setInt(4, anser.getScore());
			pstmt.setString(5, anser.getContent());
			pstmt.setDate(6, anser.getAdate());
			pstmt.addBatch();//可以执行多次
			pstmt.executeBatch();
			pstmt.clearBatch();
		}
	} catch (SQLException e) {
		System.out.print(e);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
		releaseConnect(connect, pstmt, rs);
	}
}
public void deleteAnserObject(Integer identify) {
	Connection connect = null;

	String sql = "delete from anser where identify = "+identify;
	PreparedStatement pstmt = null;
	System.out.print(sql);
	connect = createConnect();
	ResultSet rs = null;
	try {
		pstmt = connect.prepareStatement(sql);
		pstmt.executeUpdate();

//	pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.print(e);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		releaseConnect(connect, pstmt, rs);
		
	}
}

public void deleteAnserObjectList(ArrayList<Integer> identifyList) {
	Connection connect = null;

	String sql = "delete from anser where identify = ?";
	PreparedStatement pstmt = null;
	System.out.print(sql);
	connect = createConnect();
	ResultSet rs = null;
	try {
		
		Iterator<Integer> index = identifyList.iterator();
		while (index.hasNext()){
			pstmt =	connect.prepareStatement(sql);
			pstmt.setInt(1, index.next());
			pstmt.addBatch();//可以执行多次
			pstmt.executeBatch();
			pstmt.clearBatch();
		}
//	pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.print(e);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		releaseConnect(connect, pstmt, rs);
		
	}
}
public void updateAnserObject(Anser anser) {
	Connection connect = null;
	String sql = "update anser set auid = ?,quid = ?,status = ?,score = ? ,content = ? ,adate = ? where identify = ?";
	PreparedStatement pstmt = null;
	System.out.print(sql);
	connect = createConnect();
	ResultSet rs = null;
	try {
		pstmt = connect.prepareStatement(sql);
		pstmt.setInt(1, anser.getAuid());
		pstmt.setInt(2, anser.getQid());
		pstmt.setInt(3, anser.getStatus());
		pstmt.setFloat(4, anser.getScore());
		pstmt.setString(5, anser.getContent());
		pstmt.setDate(6, anser.getAdate());
		pstmt.setInt(7, anser.getIdentify());
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
