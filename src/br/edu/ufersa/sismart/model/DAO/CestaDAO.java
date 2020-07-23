package br.edu.ufersa.sismart.model.DAO;

import br.edu.ufersa.sismart.model.VO.CestaVO;
import br.edu.ufersa.sismart.model.DAO.BaseDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CestaDAO extends BaseDAO <CestaVO>{
	@Override
	public void inserir(CestaVO value) throws SQLException {
		String sql = "insert into cesta (valor_total) values (?)";
		PreparedStatement ptst;
		try {
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setDouble(1, value.getValorTotal());
			
			// verificando se houve linhas alteradas.
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Nenhuma linha modificada, falha na inserção.");
			}
			
			// verificando se foi gerado um ID.
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				value.setId(generatedKey.getLong(1));
			} else {
				throw new SQLException("Nenhum ID retornado, falha na inserção.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(CestaVO value) throws SQLException {
		String sql = "delete from cesta where id = ?";
		PreparedStatement psts;
		
		try {
			
			psts = getConnection().prepareStatement(sql);
			psts.setLong(1, value.getId());
			psts.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(CestaVO value) throws SQLException {
		String sql = "update cesta set valor_total = ? where id= ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, value.getValorTotal());
			ptst.setLong(2, value.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from cesta";
		Statement st;
		ResultSet rs = null;
				
 		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet listarPorId(long value) throws SQLException {
		String sql = "select * from cesta where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,value);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
