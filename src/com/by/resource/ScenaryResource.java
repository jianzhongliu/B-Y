package com.by.resource;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.by.dao.SceneryDao;
import com.by.dao.TouristDAO;
import com.by.model.Scenery_sopt;
import com.by.model.Tourist;
import com.by.response.ScenaryResponseObject;
import com.by.response.SearchResponseObject;
import com.by.utils.MD5Util;


/**
 * 
 * @author liujianzhong
 *
 */
@Path("/scenary")
public class ScenaryResource {
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

/***
 * 首页获取热点景区API
 * sign = md5(date + userid)
 * @param info
 * @return
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws ClassNotFoundException
 * @throws SQLException
 * @throws UnsupportedEncodingException
 */
	@GET
	@Path("/getHotScenary")
	@Produces("application/json")
	public ScenaryResponseObject getHotScenary(@Context UriInfo info)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, UnsupportedEncodingException {
		ScenaryResponseObject resp = new ScenaryResponseObject();
		String userid = this.uriInfo.getQueryParameters().getFirst("userid");
		String date = this.uriInfo.getQueryParameters().getFirst("date");
		String sign = this.uriInfo.getQueryParameters().getFirst("sign");
		System.out.println("out======="+ sign+"=="+date+"==="+MD5Util.MD5(date + userid));
		if (sign.equals(MD5Util.MD5(date + userid))){
			StringBuffer errorMSG = new StringBuffer();
			errorMSG.append("");
//			String   companyNmae = java.net.URLDecoder.decode(name,"utf-8");
			SceneryDao sceneryDao = new SceneryDao();
			ArrayList<Scenery_sopt> dataArray = sceneryDao.getHotScenneryWithNumber(5);
			resp.setDataArray(dataArray);
			resp.setErrorMSG(errorMSG);
			return resp;
		}else {
			return resp;
		}
	}
	
	/***
	 * 搜索页会用到
	 * sign = md5(date + name)   name搜索关键字
	 * type:1->搜城市，2->搜景点, 3->搜产品，4->搜人
	 * @param info
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws UnsupportedEncodingException
	 */
		@GET
		@Path("/searchObjectWithName")
		@Produces("application/json")
		public SearchResponseObject searchObjectWithName(@Context UriInfo info)
				throws InstantiationException, IllegalAccessException,
				ClassNotFoundException, SQLException, UnsupportedEncodingException {
			SearchResponseObject resp = new SearchResponseObject();
			String name = this.uriInfo.getQueryParameters().getFirst("name");//搜索关键字
			String type = this.uriInfo.getQueryParameters().getFirst("type");
			String date = this.uriInfo.getQueryParameters().getFirst("date");
			String sign = this.uriInfo.getQueryParameters().getFirst("sign");
			System.out.println("out======="+ sign+"=="+date+"==="+MD5Util.MD5(date + name));
			if (sign.equals(MD5Util.MD5(date + name))){
				StringBuffer errorMSG = new StringBuffer();
				errorMSG.append("");
				resp.setType(Integer.parseInt(type));
				name = java.net.URLDecoder.decode(name,"utf-8");

				
				
				switch (Integer.parseInt(type)) {
				case 1:
				{
					//城市直接在客户端完成
				}
					break;
				case 2:
				{
					//通过景点名称搜索
					SceneryDao sceneryDao = new SceneryDao();
					ArrayList<Scenery_sopt> pp = sceneryDao.getAllScenneryBySceneryName(name);
					
					//通过城市名搜景点
					ArrayList<Scenery_sopt> sopt = sceneryDao.getAllScenneryByCityName(name);
					
				    java.util.Iterator<Scenery_sopt> it1 = sopt.iterator();
			        while(it1.hasNext()){
			        	pp.add(it1.next());
			        }
			        resp.setDataArray(pp);
				}
					break;
				case 3:
				{
					
				}
					break;
				case 4:
				{
					TouristDAO touristDAO = new TouristDAO();
					ArrayList<Tourist> tourists = touristDAO.getTouristByName(name);
					resp.setTouristArray(tourists);
					
				}
					break;
				default:
					break;
				}
				resp.setErrorMSG(errorMSG);
				return resp;
			}else {
				return resp;
			}
		}
		
		/***
		 * 首页搜索结果是城市时，需要调用这个借口搜索出服务该城市的导游
		 * 通过城市id搜索出全城导游
		 * sign = md5(date + cityname)
		 * type:1->搜城市，2->搜景点, 3->搜产品，4->搜人
		 * @param info
		 * @return
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 * @throws UnsupportedEncodingException
		 */
			@GET
			@Path("/searchScenaryByCityId")
			@Produces("application/json")
			public SearchResponseObject searchScenaryByCityId(@Context UriInfo info)
					throws InstantiationException, IllegalAccessException,
					ClassNotFoundException, SQLException, UnsupportedEncodingException {
				SearchResponseObject resp = new SearchResponseObject();
				String cityname = this.uriInfo.getQueryParameters().getFirst("cityname");
				String date = this.uriInfo.getQueryParameters().getFirst("date");
				String sign = this.uriInfo.getQueryParameters().getFirst("sign");
				System.out.println("out======="+ sign+"=="+date+"==="+MD5Util.MD5(date + cityname));
				if (sign.equals(MD5Util.MD5(date + cityname))){
					cityname = java.net.URLDecoder.decode(cityname,"utf-8");
					StringBuffer errorMSG = new StringBuffer();
					errorMSG.append("");
					resp.setType(0);
					
					TouristDAO touristDAO = new TouristDAO();
					ArrayList<Tourist> tourists = touristDAO.getTouristByCityName(cityname);
					
					resp.setTouristArray(tourists);
					resp.setErrorMSG(errorMSG);
					return resp;
				}else {
					return resp;
				}
			}
}
