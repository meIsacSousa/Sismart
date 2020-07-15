package br.edu.ufersa.sismart.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sismart.model.VO.PessoaVO;

public class pessoaDAO<VO extends PessoaVO> extends BaseDAO<VO> {

	@Override
	public ResultSet listarPorId() throws SQLException {

		return null;
	}

	@Override
	public void inserir(VO value) throws SQLException {
		String sql = "insert into pessoa (nome, cpf, email, telefone) values (?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, value.getNome());
			ptst.setString(2, value.getCpf());
			ptst.setString(3, value.getEmail());
			ptst.setString(4, value.getTelefone());
			
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
		String sql = "delete from pessoa where id = ?";
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
		
	}

	@Override
	public ResultSet listar() throws SQLException {
		return null;
	}

	@Override
	public ResultSet listarPorId(VO value) throws SQLException {
		return null;
	}
	
}
