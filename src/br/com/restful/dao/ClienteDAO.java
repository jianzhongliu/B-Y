package br.com.restful.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Cliente;

/**
 * 
 * */
public class ClienteDAO extends ConnectionFactory {

	private static ClienteDAO instance;
	
	
	/**
	 * 
	 *
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 */
	public static ClienteDAO getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		if(instance == null)
			instance = new ClienteDAO();
		return instance;
	}
	
	public ArrayList<Cliente> listarTodos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.print("jdbc:mysql://swweaper5.mysql.rds.aliyuncs.com:3306/cookfoodshare");
		try{
			String URL="jdbc:mysql://swweaper5.mysql.rds.aliyuncs.com:3306/cookfoodshare";
			String Username="swweaper5";
			String Password="a051226";
			String Driver="com.mysql.jdbc.Driver";
			Class.forName(Driver).newInstance();
			con=DriverManager.getConnection(URL,Username,Password);
			pstmt = con.prepareStatement("select * from testtable");
			rs = (ResultSet) pstmt.executeQuery();
				while(rs.next()){
					System.out.println("===identify:"+rs.getInt("identify")+"===="+"name+"+rs.getString("name"));
					Cliente cliente = new Cliente();
					
					cliente.setId(rs.getInt("identify"));
					cliente.setNome(rs.getString("name"));
//					cliente.setCpf(rs.getString("cpf"));
//					cliente.setEndereco(rs.getString("endereco"));
					clientes.add(cliente);
				}
		}finally{
				if(con != null){
					con.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(rs != null){
					rs.close();
				}

		}
		return clientes;
	}
}
