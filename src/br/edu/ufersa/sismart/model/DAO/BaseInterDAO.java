package br.edu.ufersa.sismart.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO<VO> {
	public void inserir(VO value) throws SQLException;
	public void remover(VO value) throws SQLException;
	public void atualizar(VO value) throws SQLException;
	public ResultSet listar() throws SQLException;
	public ResultSet listarPorId() throws SQLException;

}
