package br.edu.ufersa.sismart.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sismart.model.VO.PessoaVO;

public class PessoaDAO<VO extends PessoaVO> extends BaseDAO<VO> {

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
				value.setIdPessoa(generatedKey.getLong(1));
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
			psts.setLong(1, value.getIdPessoa());
			psts.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(VO value) throws SQLException {
		String sql = "update pessoa set nome = ?, cpf = ?, email = ?, telefone = ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value.getNome());
			ptst.setString(2, value.getCpf());
			ptst.setString(3, value.getEmail());
			ptst.setString(4, value.getTelefone());
			ptst.setLong(5, value.getIdPessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from pessoa";
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
	public ResultSet listarPorId(VO value) throws SQLException {
		String sql = "select * from pessoa where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,value.getIdPessoa());
			System.out.println(ptst);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorCPF(VO value){
		String sql = "select * from pessoa where cpf = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value.getCpf());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
