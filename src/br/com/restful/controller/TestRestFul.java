package br.com.restful.controller;

import java.sql.SQLException;

import br.com.restful.resource.ClienteResource;

public class TestRestFul {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//访问地址如下：
		//http://am-201306130905:8080/Restful/cliente/listarTodos
		System.out.println(new	ClienteResource().listarTodos());
//	new	ClienteResource().listarTodos();
	}

}
