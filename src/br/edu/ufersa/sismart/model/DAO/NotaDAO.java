package br.edu.ufersa.sismart.model.DAO;

import br.edu.ufersa.sismart.model.VO.NotaVO;
import br.edu.ufersa.sismart.model.DAO.BaseDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class NotaDAO <VO extends NotaVO> extends BaseDAO <VO>{
	@Override
	public void inserir(VO value) throws SQLException {
		String sql = "insert into nota (id_cesta) values (?)";
		PreparedStatement ptst;
		try {
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, value.getIdCesta());
			
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
	public void remover(VO value) throws SQLException {
		String sql = "delete from nota where id = ?";
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
	public void atualizar(VO value) throws SQLException {
		String sql = "update nota set id_cesta = ? where id= ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, value.getIdCesta());
			ptst.setLong(2, value.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from nota";
		Statement st;
		ResultSet rs = null;
				
 		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet listarPorId(long value) throws SQLException {
		String sql = "select * from nota where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,value);
			System.out.println(ptst);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
