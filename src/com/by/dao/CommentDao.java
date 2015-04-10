package com.by.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.by.factory.ConnectionFactory;
import com.by.model.Comment;

public class CommentDao extends ConnectionFactory{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Comment comment = new Comment();
comment.setIdentify(1234578);
comment.setUserid("123");
comment.setTouristid("13333");
comment.setContent("没什么内容");
comment.setCommentdate(20151021);
comment.setScore(5);
comment.setReplydate(20151021);
comment.setReplycontent("那就不回复了");
CommentDao commentDao = new CommentDao();
//commentDao.updateCommentByTourist(comment);
//System.out.println(commentDao.getAllCommentByUserId("123"));
//System.out.println(commentDao.getAllTouristByTouristId("13333"));
	}
	/**
	 * 新增评论
	 * @param tourist
	 */
	public boolean insertCommentObject(Comment comment) {
		Boolean status = true;
		Connection connect = null;
		String sql = "INSERT INTO comment(identify,userid, touristid, content,commentdate,score) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.print(sql);
		connect = createConnect();
		ResultSet rs = null;
		try {				
				pstmt =	connect.prepareStatement(sql);
				pstmt.setInt(1, comment.getIdentify());
				pstmt.setString(2, comment.getUserid());
				pstmt.setString(3, comment.getTouristid());
				pstmt.setString(4, comment.getContent());
				pstmt.setInt(5, comment.getCommentdate());
				pstmt.setInt(6, comment.getScore());
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
	public ArrayList<Comment> getAllCommentByTouristId (String identify) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Comment> touristList = null;
		
		connect = createConnect();
		touristList = new ArrayList<Comment>();
		String sql = "select * from comment where touristid = "+identify;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Comment tourist = new Comment();
//				identify,userid, touristid, content, replycontent,  commentdate , replaydate
				tourist.setIdentify(rs.getInt("identify"));
				tourist.setUserid(rs.getString("userid"));
				tourist.setTouristid(rs.getString("touristid"));
				tourist.setContent(rs.getString("content"));
				tourist.setReplycontent(rs.getString("replycontent"));
				tourist.setCommentdate(rs.getInt("commentdate"));
				tourist.setReplydate(rs.getInt("replydate"));
				tourist.setScore(rs.getInt("score"));
				touristList.add(tourist);
//				System.out.println(touristList);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return touristList;
	}
	
	/***
	 * 获取用户评论列表
	 * @return
	 */
	public ArrayList<Comment> getAllCommentByUserId (String userId) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Comment> touristList = null;
		
		connect = createConnect();
		touristList = new ArrayList<Comment>();
		String sql = "select * from comment where userid = "+userId;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Comment tourist = new Comment();
//				identify,userid, touristid, content, replycontent,  commentdate , replaydate
				tourist.setIdentify(rs.getInt("identify"));
				tourist.setUserid(rs.getString("userid"));
				tourist.setTouristid(rs.getString("touristid"));
				tourist.setContent(rs.getString("content"));
				tourist.setReplycontent(rs.getString("replycontent"));
				tourist.setCommentdate(rs.getInt("commentdate"));
				tourist.setReplydate(rs.getInt("replydate"));
				touristList.add(tourist);
//				System.out.println(touristList);
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return touristList;
	}
	
	/***
	 * 导游回复评论	
	 * @param tourist
	 * @return
	 */
		public Boolean updateCommentByTourist(Comment comment) {
			Boolean status = true;
			Connection connect = null;
			String sql = "update comment set userid = ?,touristid = ?,replycontent = ? ,replydate = ? where identify = ?";
			PreparedStatement pstmt = null;
			System.out.print(sql);
			connect = createConnect();
			ResultSet rs = null;
			try {
				pstmt = connect.prepareStatement(sql);
				pstmt.setString(1, comment.getUserid());
				pstmt.setString(2, comment.getTouristid());
				pstmt.setString(3, comment.getReplycontent());
				pstmt.setInt(4, comment.getReplydate());
				pstmt.setInt(5, comment.getIdentify());
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
