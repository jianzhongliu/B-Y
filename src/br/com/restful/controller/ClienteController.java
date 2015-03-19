package br.com.restful.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

/**
 * 
 * Classe respons�vel por ser o controlador entre o resource e a camada DAO
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:04:21
 * @version 1.0
 */
public class ClienteController {
	
	public ArrayList<Cliente> listarTodos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		System.out.println("Enviando para o GIT");
		return ClienteDAO.getInstance().listarTodos();
	}
/**
 * get 12306 js autoValue by key
 * @param key
 * @return
 */
	public String get12306KeyValue(String key) {
		System.out.println("Enviando para o GIT");
		return DynamicJsUtil.getRandomParamValue(key);
	}
}
