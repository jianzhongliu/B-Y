package com.by.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.by.model.Message;

public class SceneryDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 新增评论
	 * @param tourist
	 */
	public boolean insertMessageObject(Message message) {
		Boolean status = true;
		Connection connect = null;
		String sql = "INSERT INTO scenery_spot(identify,userid, touristid, content,commentdate,phonenumber) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.print(sql);
		connect = createConnect();
		ResultSet rs = null;
		try {				
				pstmt =	connect.prepareStatement(sql);
				pstmt.setInt(1, message.getIdentify());
				pstmt.setString(2, message.getUserid());
				pstmt.setString(3, message.getTouristid());
				pstmt.setString(4, message.getContent());
				pstmt.setInt(5, message.getCommentdate());
				pstmt.setString(6, message.getPhonenumber());
//				pstmt.executeBatch();
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
	 * 获取导游评论列表
	 * @return
	 */
	public ArrayList<Message> getAllMessageByTouristId (String identify) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Message> messageList = null;
		
		connect = createConnect();
		messageList = new ArrayList<Message>();
		String sql = "select * from scenery_spot where touristid = "+identify;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Message message = new Message();
//				identify,userid, touristid, content, replycontent,  commentdate , replaydate
				message.setIdentify(rs.getInt("identify"));
				message.setUserid(rs.getString("userid"));
				message.setTouristid(rs.getString("touristid"));
				message.setContent(rs.getString("content"));
				message.setReplycontent(rs.getString("replycontent"));
				message.setCommentdate(rs.getInt("commentdate"));
				message.setReplaydate(rs.getInt("replydate"));
				message.setPhonenumber(rs.getString("phonenumber"));
				messageList.add(message);
//				System.out.println(touristList);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return messageList;
	}
	
	/***
	 * 获取用户评论列表
	 * @return
	 */
	public ArrayList<Message> getAllMessageByUserId (String userId) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Message> messageList = null;
		
		connect = createConnect();
		messageList = new ArrayList<Message>();
		String sql = "select * from scenery_spot where userid = "+userId;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Message tourist = new Message();
//				identify,userid, touristid, content, replycontent,  commentdate , replaydate
				tourist.setIdentify(rs.getInt("identify"));
				tourist.setUserid(rs.getString("userid"));
				tourist.setTouristid(rs.getString("touristid"));
				tourist.setContent(rs.getString("content"));
				tourist.setReplycontent(rs.getString("replycontent"));
				tourist.setCommentdate(rs.getInt("commentdate"));
				tourist.setReplaydate(rs.getInt("replydate"));
				messageList.add(tourist);
//				System.out.println(touristList);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return messageList;
	}
	
	/***
	 * 导游回复评论	
	 * @param tourist
	 * @return
	 */
		public Boolean updateMessageByTourist(Message message) {
			Boolean status = true;
			Connection connect = null;
			String sql = "update scenery_spot set userid = ?,touristid = ?,replycontent = ? ,replydate = ? where identify = ?";
			PreparedStatement pstmt = null;
			System.out.print(sql);
			connect = createConnect();
			ResultSet rs = null;
			try {
				pstmt = connect.prepareStatement(sql);
				pstmt.setString(1, message.getUserid());
				pstmt.setString(2, message.getTouristid());
				pstmt.setString(3, message.getReplycontent());
				pstmt.setInt(4, message.getReplaydate());
				pstmt.setInt(5, message.getIdentify());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				status = false;
				System.out.print(e);
				e.printStackTrace();
			}finally {
				releaseConnect(connect, pstmt, rs);
			}
			return status;
		}
}
