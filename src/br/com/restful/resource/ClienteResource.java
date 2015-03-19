package br.com.restful.resource;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import br.com.restful.dao.TouristDAO;
import br.com.restful.model.Tourist;

/**
 * 
 * Classe respons�vel por conter os metodos REST de acesso ao webservice
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:05:23
 * @version 1.0
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
 * @return
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws ClassNotFoundException
 * @throws SQLException
 */
//	@GET
////	@Path("/get12306ValueByKey")
//	@Path(value="/get12306ValueByKey/{key}")
//	@Produces("application/json")
//	public String get12306ValueByKey(@PathParam("key") String key) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
//		String pp = new ClienteController().get12306KeyValue(key);
//		return pp;
//	}

	 
}
