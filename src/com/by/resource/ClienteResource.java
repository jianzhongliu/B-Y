package com.by.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import net.sf.json.JSONArray;

import com.by.dao.TouristDAO;
import com.by.model.Tourist;
import com.by.response.ScenaryResponseObject;
import com.google.gson.JsonObject;


/**
 * 
 * @author liujianzhong
 *
 */
@Path("/tourist")
public class ClienteResource {
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	/**
	 * 
	 * M�todo respons�vel por fazer chamada ao controller汉子
	 *
	 * @return ArrayList<Cliente> 
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:07:08
	 * @version 1.0
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 */
	@GET
	@Path("/getAllTourist")
	@Produces("application/json")
	public ScenaryResponseObject listarTodos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
//		Tourist tourist = new Tourist();
//		tourist.setIdentify("skdfskjdfklsdjfklsd");
//		tourist.setUsername("gange");
//		tourist.setPassword("Aa123456");
		TouristDAO touristDao = new TouristDAO();
	ArrayList<Tourist> touristList = touristDao.getAllTourist();
	ScenaryResponseObject  response = new ScenaryResponseObject();
	JsonObject object = new JsonObject();
	System.out.println(response);
//		ArrayList<Tourist> pp = new ClienteController().listarTodos();
//		JsonArray 
		return response;
	}

/**
 * 
 */


	 
}
