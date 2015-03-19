package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe responsável por conter os metodos criar e fechar o banco de dados.
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 01:54:02
 * @version 1.0
 */
public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://swweaper5.mysql.rds.aliyuncs.com:3306/cookfoodshare";
	private static final String USUARIO = "swweaper5";
	private static final String SENHA = "a051226";
	

	/**
	 * 
	 * Método responsável por criar uma conexao com o banco 
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 01:51:54
	 * @version 1.0
	 */
	public Connection createConnect(){

		Connection conexao = null;
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public void releaseConnect(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Erro: " + URL);
		}
	}
}

