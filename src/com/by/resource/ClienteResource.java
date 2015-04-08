package com.by.resource;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.by.dao.TouristDAO;
import com.by.model.Tourist;


/**
 * 
 * @author liujianzhong
 *
 */
@Path("/touristDetail")
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
	@Path("/register")
	@Produces("application/json")
	public String listarTodos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Tourist tourist = new Tourist();
		tourist.setIdentify("skdfskjdfklsdjfklsd");
		tourist.setUsername("gange");
		tourist.setPassword("Aa123456");
		TouristDAO touristDao = new TouristDAO();
		touristDao.insertAnserObject(tourist);
//		ArrayList<Tourist> pp = new ClienteController().listarTodos();
		return "OK";
	}

/**
 * 
 */


	 
}
