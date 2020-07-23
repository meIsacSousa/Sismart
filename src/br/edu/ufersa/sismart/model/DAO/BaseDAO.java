package br.edu.ufersa.sismart.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
	private static Connection conn = null;
	private static final String url = "jdbc:mariadb://localhost:3306/sismart";
	private static final String user = "admin_sismart";
	private static final String password = "admin";
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
		} else {
			
			return conn;
		}
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void inserir(VO value) throws SQLException;
	public abstract void remover(VO value) throws SQLException;
	public abstract void atualizar(VO value) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
	public abstract ResultSet listarPorId(long value) throws SQLException;
}
