package com.by.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.by.factory.ConnectionFactory;
import com.by.model.Tourist;

/**
 * 
 * @author liujianzhong
 *
 */
public class TouristDAO extends ConnectionFactory{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TouristDAO touristDAO = new TouristDAO();
		
		Tourist tourist = new Tourist();
		tourist.setIdentify("1233243453455");
		tourist.setName("建中1");
		touristDAO.updateTouristWithObject(tourist);
		System.out.println(touristDAO.getAllTourist());
	}
	
	/**
	 * 新增导游信息
	 * @param tourist
	 */
	public void insertTouristObject(Tourist tourist) {
		Connection connect = null;

		String sql = "INSERT INTO tourist(username,password,token ,gender ,birthday," +
				"nuckname,name,icon,email,phone,signature,servicearea,language,price,pricedetail," +
				"servicedetail,images,star,usertype,userlat,userlng,otherinfoid,ordernumber,registerdate,tag,identify,commentnumber,messagenumber) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.print(sql);
		connect = createConnect();
		ResultSet rs = null;
		try {				
				pstmt =	connect.prepareStatement(sql);
				pstmt.setString(1, tourist.getUsername());
				pstmt.setString(2, tourist.getPassword());
				pstmt.setString(3, tourist.getToken());
				pstmt.setInt(4, tourist.getGender());
				pstmt.setInt(5, tourist.getBirthday());
				pstmt.setString(6, tourist.getNuckname());
				pstmt.setString(7, tourist.getName());
				pstmt.setString(8, tourist.getIcon());
				pstmt.setString(9, tourist.getEmail());
				pstmt.setString(10, tourist.getPhone());
				pstmt.setString(11, tourist.getSignature());
				pstmt.setString(12, tourist.getServicearea());
				pstmt.setString(13, tourist.getLanguage());
				pstmt.setString(14, tourist.getPrice());
				pstmt.setString(15, tourist.getPricedetail());
				pstmt.setString(16, tourist.getServicedetail());
				pstmt.setString(17, tourist.getImages());
				pstmt.setFloat(18, tourist.getStar());
				pstmt.setInt(19, tourist.getUsertype());
				pstmt.setFloat(20, tourist.getUserlat());
				pstmt.setFloat(21, tourist.getUserlng());
				pstmt.setString(22, tourist.getOtherinfoid());
				pstmt.setInt(23, tourist.getOrdernumber());
				pstmt.setInt(24, tourist.getRegisterdate());
				pstmt.setString(25, tourist.getTag());
				pstmt.setString(26, tourist.getIdentify());
				pstmt.setInt(27, tourist.getCommentnumber());
				pstmt.setInt(28, tourist.getMessagenumber());
				pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			releaseConnect(connect, pstmt, rs);
			
		}
	}
	
	/***
	 * 获取所有导游列表
	 * @return
	 */
	public ArrayList<Tourist> getAllTourist (){
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Tourist> touristList = null;
		
		connect = createConnect();
		touristList = new ArrayList<Tourist>();
		String sql = "select * from tourist";
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Tourist tourist = new Tourist();
				tourist.setIdentify(rs.getString("identify"));
				tourist.setName(rs.getString("name"));
				tourist.setUserlat(rs.getInt("userlat"));
				tourist.setUsername(rs.getString("username"));
				tourist.setPassword(rs.getString("password"));
				tourist.setToken(rs.getString("token"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setBirthday(rs.getInt("birthday"));
				tourist.setNuckname(rs.getString("nuckname"));
				tourist.setIcon(rs.getString("icon"));
				tourist.setEmail(rs.getString("email"));
				tourist.setPhone(rs.getString("phone"));
				tourist.setSignature(rs.getString("signature"));
				tourist.setServicearea(rs.getString("servicearea"));
				tourist.setServicedetail(rs.getString("servicedetail"));
				tourist.setLanguage(rs.getString("language"));
				tourist.setPrice(rs.getString("price"));
				tourist.setPricedetail(rs.getString("pricedetail"));
				tourist.setImages(rs.getString("images"));
				tourist.setStar(rs.getInt("star"));
				tourist.setUsertype(rs.getInt("usertype"));
				tourist.setUserlng(rs.getInt("userlng"));
				tourist.setOtherinfoid(rs.getString("otherinfoid"));
				tourist.setOrdernumber(rs.getInt("ordernumber"));
				tourist.setRegisterdate(rs.getInt("registerdate"));
				tourist.setTag(rs.getString("tag"));
				tourist.setCommentnumber(rs.getInt("commentnumber"));
				tourist.setMessagenumber(rs.getInt("messagenumber"));
				touristList.add(tourist);
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
	 * 获取所有导游列表
	 * @return
	 */
	public ArrayList<Tourist> getTouristByName (String name) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Tourist> touristList = null;
		
		connect = createConnect();
		touristList = new ArrayList<Tourist>();
		String sql = "select * from tourist where like "+ "\'%" +name+"%\'";
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Tourist tourist = new Tourist();
				tourist.setIdentify(rs.getString("identify"));
				tourist.setName(rs.getString("name"));
				tourist.setUserlat(rs.getInt("userlat"));
				tourist.setUsername(rs.getString("username"));
				tourist.setPassword(rs.getString("password"));
				tourist.setToken(rs.getString("token"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setBirthday(rs.getInt("birthday"));
				tourist.setNuckname(rs.getString("nuckname"));
				tourist.setIcon(rs.getString("icon"));
				tourist.setEmail(rs.getString("email"));
				tourist.setPhone(rs.getString("phone"));
				tourist.setSignature(rs.getString("signature"));
				tourist.setServicearea(rs.getString("servicearea"));
				tourist.setServicedetail(rs.getString("servicedetail"));
				tourist.setLanguage(rs.getString("language"));
				tourist.setPrice(rs.getString("price"));
				tourist.setPricedetail(rs.getString("pricedetail"));
				tourist.setImages(rs.getString("images"));
				tourist.setStar(rs.getInt("star"));
				tourist.setUsertype(rs.getInt("usertype"));
				tourist.setUserlng(rs.getInt("userlng"));
				tourist.setOtherinfoid(rs.getString("otherinfoid"));
				tourist.setOrdernumber(rs.getInt("ordernumber"));
				tourist.setRegisterdate(rs.getInt("registerdate"));
				tourist.setTag(rs.getString("tag"));
				tourist.setCommentnumber(rs.getInt("commentnumber"));
				tourist.setMessagenumber(rs.getInt("messagenumber"));
				touristList.add(tourist);
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
	 * 通过导游id查询导游
	 * @return
	 */
	public Tourist getTouristByIdentify (String identify) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Tourist tourist = new Tourist();		
		connect = createConnect();
		String sql = "select * from tourist where identify = " + identify;
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				tourist.setIdentify(rs.getString("identify"));
				tourist.setName(rs.getString("name"));
				tourist.setUserlat(rs.getInt("userlat"));
				tourist.setUsername(rs.getString("username"));
				tourist.setPassword(rs.getString("password"));
				tourist.setToken(rs.getString("token"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setBirthday(rs.getInt("birthday"));
				tourist.setNuckname(rs.getString("nuckname"));
				tourist.setIcon(rs.getString("icon"));
				tourist.setEmail(rs.getString("email"));
				tourist.setPhone(rs.getString("phone"));
				tourist.setSignature(rs.getString("signature"));
				tourist.setServicearea(rs.getString("servicearea"));
				tourist.setServicedetail(rs.getString("servicedetail"));
				tourist.setLanguage(rs.getString("language"));
				tourist.setPrice(rs.getString("price"));
				tourist.setPricedetail(rs.getString("pricedetail"));
				tourist.setImages(rs.getString("images"));
				tourist.setStar(rs.getInt("star"));
				tourist.setUsertype(rs.getInt("usertype"));
				tourist.setUserlng(rs.getInt("userlng"));
				tourist.setOtherinfoid(rs.getString("otherinfoid"));
				tourist.setOrdernumber(rs.getInt("ordernumber"));
				tourist.setRegisterdate(rs.getInt("registerdate"));
				tourist.setTag(rs.getString("tag"));
				tourist.setCommentnumber(rs.getInt("commentnumber"));
				tourist.setMessagenumber(rs.getInt("messagenumber"));
			}		
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os anser: " + e);
			e.printStackTrace();
		} finally {
			releaseConnect(connect, pstmt, rs);
		}
		return tourist;
	}	
/***
 * 更新导游信息	
 * @param tourist
 * @return
 */
	public Boolean updateTouristWithObject(Tourist tourist) {
		Boolean status = true;
		Connection connect = null;
		String sql = "update tourist set username = ?,password = ?,token = ? ,gender = ? ,birthday = ?," +
				"nuckname = ?,name = ?,icon = ?,email = ?,phone = ?,signature = ?,servicearea = ?,language = ?,price = ?,pricedetail = ?," +
				"servicedetail = ?,images = ?,star = ?,usertype = ?,userlat = ?,userlng = ?,otherinfoid = ?,ordernumber = ?,registerdate = ?,tag = ?,commentnumber = ?, messagenumber = ? where identify = ?";
		PreparedStatement pstmt = null;
		System.out.print(sql);
		connect = createConnect();
		ResultSet rs = null;
		try {
			pstmt = connect.prepareStatement(sql);
			pstmt.setString(1, tourist.getUsername());
			pstmt.setString(2, tourist.getPassword());
			pstmt.setString(3, tourist.getToken());
			pstmt.setInt(4, tourist.getGender());
			pstmt.setInt(5, tourist.getBirthday());
			pstmt.setString(6, tourist.getNuckname());
			pstmt.setString(7, tourist.getName());
			pstmt.setString(8, tourist.getIcon());
			pstmt.setString(9, tourist.getEmail());
			pstmt.setString(10, tourist.getPhone());
			pstmt.setString(11, tourist.getSignature());
			pstmt.setString(12, tourist.getServicearea());
			pstmt.setString(13, tourist.getLanguage());
			pstmt.setString(14, tourist.getPrice());
			pstmt.setString(15, tourist.getPricedetail());
			pstmt.setString(16, tourist.getServicedetail());
			pstmt.setString(17, tourist.getImages());
			pstmt.setFloat(18, tourist.getStar());
			pstmt.setInt(19, tourist.getUsertype());
			pstmt.setFloat(20, tourist.getUserlat());
			pstmt.setFloat(21, tourist.getUserlng());
			pstmt.setString(22, tourist.getOtherinfoid());
			pstmt.setInt(23, tourist.getOrdernumber());
			pstmt.setInt(24, tourist.getRegisterdate());
			pstmt.setString(25, tourist.getTag());
			pstmt.setInt(26, tourist.getCommentnumber());
			pstmt.setInt(27, tourist.getMessagenumber());
			pstmt.setString(28, tourist.getIdentify());
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
	 * 通过城市名获取服务该城市的导游
	 * @return
	 */
	public ArrayList<Tourist> getTouristByCityName (String cityname) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Tourist> touristList = null;
		
		connect = createConnect();
		touristList = new ArrayList<Tourist>();
		String sql = "select * from tourist where servicearea like"+ "\'%" +cityname+"%\'";
		System.out.println(sql);
		try {
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Tourist tourist = new Tourist();
				tourist.setIdentify(rs.getString("identify"));
				tourist.setName(rs.getString("name"));
				tourist.setUserlat(rs.getInt("userlat"));
				tourist.setUsername(rs.getString("username"));
				tourist.setPassword(rs.getString("password"));
				tourist.setToken(rs.getString("token"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setBirthday(rs.getInt("birthday"));
				tourist.setNuckname(rs.getString("nuckname"));
				tourist.setIcon(rs.getString("icon"));
				tourist.setEmail(rs.getString("email"));
				tourist.setPhone(rs.getString("phone"));
				tourist.setSignature(rs.getString("signature"));
				tourist.setServicearea(rs.getString("servicearea"));
				tourist.setServicedetail(rs.getString("servicedetail"));
				tourist.setLanguage(rs.getString("language"));
				tourist.setPrice(rs.getString("price"));
				tourist.setPricedetail(rs.getString("pricedetail"));
				tourist.setImages(rs.getString("images"));
				tourist.setStar(rs.getInt("star"));
				tourist.setUsertype(rs.getInt("usertype"));
				tourist.setUserlng(rs.getInt("userlng"));
				tourist.setOtherinfoid(rs.getString("otherinfoid"));
				tourist.setOrdernumber(rs.getInt("ordernumber"));
				tourist.setRegisterdate(rs.getInt("registerdate"));
				tourist.setTag(rs.getString("tag"));
				tourist.setCommentnumber(rs.getInt("commentnumber"));
				tourist.setMessagenumber(rs.getInt("messagenumber"));
				touristList.add(tourist);
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
	 * 给导游的评论数加1	
	 * @param tourist
	 * @return
	 */
		public Boolean updateTouristCommentNumber(Tourist tourist) {
			Boolean status = true;
			Connection connect = null;
			String sql = "update tourist set username = ?,password = ?,token = ? ,gender = ? ,birthday = ?," +
					"nuckname = ?,name = ?,icon = ?,email = ?,phone = ?,signature = ?,servicearea = ?,language = ?,price = ?,pricedetail = ?," +
					"servicedetail = ?,images = ?,star = ?,usertype = ?,userlat = ?,userlng = ?,otherinfoid = ?,ordernumber = ?,registerdate = ?,tag = ?,messagenumber = ?,commentnumber = ? where identify = ?";
			PreparedStatement pstmt = null;
			System.out.print(sql);
			connect = createConnect();
			ResultSet rs = null;
			try {
				pstmt = connect.prepareStatement(sql);
				pstmt.setString(1, tourist.getUsername());
				pstmt.setString(2, tourist.getPassword());
				pstmt.setString(3, tourist.getToken());
				pstmt.setInt(4, tourist.getGender());
				pstmt.setInt(5, tourist.getBirthday());
				pstmt.setString(6, tourist.getNuckname());
				pstmt.setString(7, tourist.getName());
				pstmt.setString(8, tourist.getIcon());
				pstmt.setString(9, tourist.getEmail());
				pstmt.setString(10, tourist.getPhone());
				pstmt.setString(11, tourist.getSignature());
				pstmt.setString(12, tourist.getServicearea());
				pstmt.setString(13, tourist.getLanguage());
				pstmt.setString(14, tourist.getPrice());
				pstmt.setString(15, tourist.getPricedetail());
				pstmt.setString(16, tourist.getServicedetail());
				pstmt.setString(17, tourist.getImages());
				pstmt.setFloat(18, tourist.getStar());
				pstmt.setInt(19, tourist.getUsertype());
				pstmt.setFloat(20, tourist.getUserlat());
				pstmt.setFloat(21, tourist.getUserlng());
				pstmt.setString(22, tourist.getOtherinfoid());
				pstmt.setInt(23, tourist.getOrdernumber());
				pstmt.setInt(24, tourist.getRegisterdate());
				pstmt.setString(25, tourist.getTag());
				pstmt.setInt(26, tourist.getMessagenumber());
				pstmt.setInt(27, tourist.getCommentnumber() + 1);
				pstmt.setString(28, tourist.getIdentify());
				
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
		 * 给导游的留言数加1	
		 * @param tourist
		 * @return
		 */
			public Boolean updateTouristMessageNumber(Tourist tourist) {
				Boolean status = true;
				Connection connect = null;
				String sql = "update tourist set username = ?,password = ?,token = ? ,gender = ? ,birthday = ?," +
						"nuckname = ?,name = ?,icon = ?,email = ?,phone = ?,signature = ?,servicearea = ?,language = ?,price = ?,pricedetail = ?," +
						"servicedetail = ?,images = ?,star = ?,usertype = ?,userlat = ?,userlng = ?,otherinfoid = ?,ordernumber = ?,registerdate = ?,tag = ?,messagenumber = ?,commentnumber = ? where identify = ?";
				PreparedStatement pstmt = null;
				System.out.print(sql);
				connect = createConnect();
				ResultSet rs = null;
				try {
					pstmt = connect.prepareStatement(sql);
					pstmt.setString(1, tourist.getUsername());
					pstmt.setString(2, tourist.getPassword());
					pstmt.setString(3, tourist.getToken());
					pstmt.setInt(4, tourist.getGender());
					pstmt.setInt(5, tourist.getBirthday());
					pstmt.setString(6, tourist.getNuckname());
					pstmt.setString(7, tourist.getName());
					pstmt.setString(8, tourist.getIcon());
					pstmt.setString(9, tourist.getEmail());
					pstmt.setString(10, tourist.getPhone());
					pstmt.setString(11, tourist.getSignature());
					pstmt.setString(12, tourist.getServicearea());
					pstmt.setString(13, tourist.getLanguage());
					pstmt.setString(14, tourist.getPrice());
					pstmt.setString(15, tourist.getPricedetail());
					pstmt.setString(16, tourist.getServicedetail());
					pstmt.setString(17, tourist.getImages());
					pstmt.setFloat(18, tourist.getStar());
					pstmt.setInt(19, tourist.getUsertype());
					pstmt.setFloat(20, tourist.getUserlat());
					pstmt.setFloat(21, tourist.getUserlng());
					pstmt.setString(22, tourist.getOtherinfoid());
					pstmt.setInt(23, tourist.getOrdernumber());
					pstmt.setInt(24, tourist.getRegisterdate());
					pstmt.setString(25, tourist.getTag());
					pstmt.setInt(26, tourist.getMessagenumber() + 1);
					pstmt.setInt(27, tourist.getCommentnumber());
					pstmt.setString(28, tourist.getIdentify());
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
}
