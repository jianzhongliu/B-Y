package com.by.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.by.dao.CommentDao;
import com.by.dao.MessageDao;
import com.by.dao.TouristDAO;
import com.by.model.Comment;
import com.by.model.Message;
import com.by.model.Tourist;
import com.by.response.TouristResponseObject;
import com.by.utils.MD5Util;


/**
 * 
 * @author liujianzhong
 *
 */
@Path("/tourist")
public class TouristResource {
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	/***
	 * 导游详情，拉取导游的评论和留言
	 * 通过城市id搜索出全城导游
	 * sign = md5(date+identify)
	 * @param info
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws UnsupportedEncodingException
	 */
		@GET
		@Path("/getCommentByTouristId")
		@Produces("application/json")
		public TouristResponseObject searchScenaryByCityId(@Context UriInfo info)
				throws InstantiationException, IllegalAccessException,
				ClassNotFoundException, SQLException, UnsupportedEncodingException {
			TouristResponseObject resp = new TouristResponseObject();
			String identify = this.uriInfo.getQueryParameters().getFirst("identify");
			String date = this.uriInfo.getQueryParameters().getFirst("date");
			String sign = this.uriInfo.getQueryParameters().getFirst("sign");
			System.out.println("out======="+ sign+"=="+date+"==="+MD5Util.MD5(date + identify));
			if (sign.equals(MD5Util.MD5(date + identify))){
				StringBuffer errorMSG = new StringBuffer();
				errorMSG.append("");
				resp.setType(0);
				//导游的评论列表
				CommentDao commentDao = new CommentDao();
				ArrayList<Comment> commentList = commentDao.getAllCommentByTouristId(identify);
				resp.setCommentArray(commentList);
				//导游的留言列表
				MessageDao messageDao = new MessageDao();
				ArrayList<Message> messageList = messageDao.getAllMessageByTouristId(identify);
				resp.setMessageArray(messageList);
				
				resp.setErrorMSG(errorMSG);
				resp.setStatus("1");
				return resp;
			}else {
				resp.setStatus("0");
				return resp;
			}
		}
		/***
		 * 导游详情，拉取导游的评论和留言
		 * 通过城市id搜索出全城导游
		 * sign = md5(date + userid)
		 * @param info
		 * @return status = 1表示成功
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 * @throws UnsupportedEncodingException
		 */
			@GET
			@Path("/getCommentByUserId")
			@Produces("application/json")
			public TouristResponseObject getCommentByUserId(@Context UriInfo info)
					throws InstantiationException, IllegalAccessException,
					ClassNotFoundException, SQLException, UnsupportedEncodingException {
				TouristResponseObject resp = new TouristResponseObject();
				String userid = this.uriInfo.getQueryParameters().getFirst("userid");
				String date = this.uriInfo.getQueryParameters().getFirst("date");
				String sign = this.uriInfo.getQueryParameters().getFirst("sign");
				System.out.println("out======="+ sign+"=="+date+"==="+MD5Util.MD5(date + userid));
				if (sign.equals(MD5Util.MD5(date + userid))){
					StringBuffer errorMSG = new StringBuffer();
					errorMSG.append("");
					resp.setType(0);
					//用户的评论列表
					CommentDao commentDao = new CommentDao();
					ArrayList<Comment> commentList = commentDao.getAllCommentByUserId(userid);
					resp.setCommentArray(commentList);
					//用户的留言列表
					MessageDao messageDao = new MessageDao();
					ArrayList<Message> messageList = messageDao.getAllMessageByUserId(userid);
					resp.setMessageArray(messageList);
					resp.setErrorMSG(errorMSG);
					resp.setStatus("1");
					return resp;
				}else {
					resp.setStatus("0");
					return resp;
				}
			}
			/***
			 * 导游详情页，添加评论
			 * sign = md5(commentdate + userid)
			 * @param info
			 * @return status = 1表示成功
			 * @throws InstantiationException
			 * @throws IllegalAccessException
			 * @throws ClassNotFoundException
			 * @throws SQLException
			 * @throws UnsupportedEncodingException
			 */
				@GET
				@Path("/addComment")
				@Produces("application/json")
				public TouristResponseObject addComment(@Context UriInfo info)
						throws InstantiationException, IllegalAccessException,
						ClassNotFoundException, SQLException, UnsupportedEncodingException {
					TouristResponseObject resp = new TouristResponseObject();
					String identify = this.uriInfo.getQueryParameters().getFirst("identify");
					String commentdate = this.uriInfo.getQueryParameters().getFirst("commentdate");
					String userid = this.uriInfo.getQueryParameters().getFirst("userid");
					String touristid = this.uriInfo.getQueryParameters().getFirst("touristid");
					String content = this.uriInfo.getQueryParameters().getFirst("content");
					String score = this.uriInfo.getQueryParameters().getFirst("score");
					String sign = this.uriInfo.getQueryParameters().getFirst("sign");
					
					System.out.println("out======="+ sign+"=="+commentdate+"==="+MD5Util.MD5(identify + commentdate));
					if (sign.equals(MD5Util.MD5(commentdate + userid))){
						content = URLDecoder.decode(content, "utf-8");
						StringBuffer errorMSG = new StringBuffer();
						errorMSG.append("");
						resp.setType(0);

						Comment comment = new Comment();
						comment.setIdentify(Integer.parseInt(identify));
						comment.setUserid(userid);
						comment.setTouristid(touristid);
						comment.setContent(content);
						comment.setCommentdate(Integer.parseInt(commentdate));
						comment.setScore(Integer.parseInt(score));
						
						CommentDao commentDao = new CommentDao();
						boolean  status = commentDao.insertCommentObject(comment);
						if (status) {
							errorMSG.append("添加成功");
						} else {
							errorMSG.append("添加评论失败，请重试！");
						}
						
						resp.setErrorMSG(errorMSG);
						resp.setStatus("1");
						return resp;
					}else {
						resp.setStatus("0");
						return resp;
					}
				}
				
				/***
				 * 导游详情页，导游回复评论
				 * sign = md5(replydate + userid)
				 * @param info
				 * @return status = 1表示成功
				 * @throws InstantiationException
				 * @throws IllegalAccessException
				 * @throws ClassNotFoundException
				 * @throws SQLException
				 * @throws UnsupportedEncodingException
				 */
					@GET
					@Path("/replyComment")
					@Produces("application/json")
					public TouristResponseObject replyComment(@Context UriInfo info)
							throws InstantiationException, IllegalAccessException,
							ClassNotFoundException, SQLException, UnsupportedEncodingException {
						TouristResponseObject resp = new TouristResponseObject();
						String identify = this.uriInfo.getQueryParameters().getFirst("identify");
						String replydate = this.uriInfo.getQueryParameters().getFirst("replydate");
						String userid = this.uriInfo.getQueryParameters().getFirst("userid");
						String touristid = this.uriInfo.getQueryParameters().getFirst("touristid");
						String replycontent = this.uriInfo.getQueryParameters().getFirst("replycontent");
						String sign = this.uriInfo.getQueryParameters().getFirst("sign");
						
						System.out.println("out======="+ sign+"=="+replydate+"==="+MD5Util.MD5(identify + replydate));
						if (sign.equals(MD5Util.MD5(replydate + userid))){
							replycontent = URLDecoder.decode(replycontent, "utf-8");
							StringBuffer errorMSG = new StringBuffer();
							errorMSG.append("");
							resp.setType(0);

							Comment comment = new Comment();
							comment.setIdentify(Integer.parseInt(identify));
							comment.setUserid(userid);
							comment.setTouristid(touristid);
							comment.setReplycontent(replycontent);
							comment.setReplydate(Integer.parseInt(replydate));
							
							CommentDao commentDao = new CommentDao();
							boolean  status = commentDao.updateCommentByTourist(comment);
							if (status) {
								errorMSG.append("回复评论成功");
								TouristDAO touristDAO = new TouristDAO();
								Tourist tourist = touristDAO.getTouristByIdentify(touristid);
								touristDAO.updateTouristCommentNumber(tourist);
							} else {
								errorMSG.append("回复评论失败，请重试！");
							}
							resp.setErrorMSG(errorMSG);
							resp.setStatus("1");
							return resp;
						}else {
							resp.setStatus("0");
							return resp;
						}
					}	

					/***
					 * 导游详情页，添加留言
					 * sign = md5(commentdate + userid)
					 * @param info
					 * @return status = 1表示成功
					 * @throws InstantiationException
					 * @throws IllegalAccessException
					 * @throws ClassNotFoundException
					 * @throws SQLException
					 * @throws UnsupportedEncodingException
					 */
						@GET
						@Path("/addMessage")
						@Produces("application/json")
						public TouristResponseObject addMessage(@Context UriInfo info)
								throws InstantiationException, IllegalAccessException,
								ClassNotFoundException, SQLException, UnsupportedEncodingException {
							TouristResponseObject resp = new TouristResponseObject();
							String identify = this.uriInfo.getQueryParameters().getFirst("identify");
							String commentdate = this.uriInfo.getQueryParameters().getFirst("commentdate");
							String userid = this.uriInfo.getQueryParameters().getFirst("userid");
							String touristid = this.uriInfo.getQueryParameters().getFirst("touristid");
							String content = this.uriInfo.getQueryParameters().getFirst("content");
							String phonenumber = this.uriInfo.getQueryParameters().getFirst("phonenumber");
							String sign = this.uriInfo.getQueryParameters().getFirst("sign");
							
							System.out.println("out======="+ sign+"=="+commentdate+"==="+MD5Util.MD5(identify + commentdate));
							if (sign.equals(MD5Util.MD5(commentdate + userid))){
								content = URLDecoder.decode(content, "utf-8");
								StringBuffer errorMSG = new StringBuffer();
								errorMSG.append("");
								resp.setType(0);

								Message message = new Message();
								message.setIdentify(Integer.parseInt(identify));
								message.setUserid(userid);
								message.setTouristid(touristid);
								message.setContent(content);
								message.setCommentdate(Integer.parseInt(commentdate));
								message.setPhonenumber(phonenumber);
								
								MessageDao messageDao = new MessageDao();
								boolean  status = messageDao.insertMessageObject(message);
								if (status) {
									errorMSG.append("留言成功");
									TouristDAO touristDAO = new TouristDAO();
									Tourist tourist = touristDAO.getTouristByIdentify(touristid);
									touristDAO.updateTouristMessageNumber(tourist);
								} else {
									errorMSG.append("留言失败，请重试，谢谢！");
								}
								
								resp.setErrorMSG(errorMSG);
								resp.setStatus("1");
								return resp;
							}else {
								resp.setStatus("0");
								return resp;
							}
						}
						
						/***
						 * 导游详情页，导游回复留言
						 * sign = md5(replydate + userid)
						 * @param info
						 * @return status = 1表示成功
						 * @throws InstantiationException
						 * @throws IllegalAccessException
						 * @throws ClassNotFoundException
						 * @throws SQLException
						 * @throws UnsupportedEncodingException
						 */
							@GET
							@Path("/replyMessage")
							@Produces("application/json")
							public TouristResponseObject replyMessage(@Context UriInfo info)
									throws InstantiationException, IllegalAccessException,
									ClassNotFoundException, SQLException, UnsupportedEncodingException {
								TouristResponseObject resp = new TouristResponseObject();
								String identify = this.uriInfo.getQueryParameters().getFirst("identify");
								String replydate = this.uriInfo.getQueryParameters().getFirst("replydate");
								String userid = this.uriInfo.getQueryParameters().getFirst("userid");
								String touristid = this.uriInfo.getQueryParameters().getFirst("touristid");
								String replycontent = this.uriInfo.getQueryParameters().getFirst("replycontent");
								String sign = this.uriInfo.getQueryParameters().getFirst("sign");
								
								System.out.println("out======="+ sign+"=="+replydate+"==="+MD5Util.MD5(identify + replydate));
								if (sign.equals(MD5Util.MD5(replydate + userid))){
									replycontent = URLDecoder.decode(replycontent, "utf-8");
									StringBuffer errorMSG = new StringBuffer();
									errorMSG.append("");
									resp.setType(0);

									Message message = new Message();
									message.setIdentify(Integer.parseInt(identify));
									message.setUserid(userid);
									message.setTouristid(touristid);
									message.setReplycontent(replycontent);
									message.setReplaydate(Integer.parseInt(replydate));
									
									MessageDao messageDao = new MessageDao();
									boolean  status = messageDao.updateMessageByTourist(message);
									if (status) {
										errorMSG.append("回复成功");
									} else {
										errorMSG.append("回复留言失败,请重试！");
									}
									resp.setErrorMSG(errorMSG);
									resp.setStatus("1");
									return resp;
								}else {
									resp.setStatus("0");
									return resp;
								}
							}	
							
}
