package br.edu.ufersa.sismart.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sismart.model.VO.UsuarioVO;

public class UsuarioDAO <VO extends UsuarioVO> extends PessoaDAO <VO> implements UsuarioInterDAO<VO>{
	@Override
	public void inserir(VO value) {
		try {
			super.inserir(value);
			String sql = "insert into usuario (login, senha, id_pessoa) values (?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, value.getLogin());
			ptst.setString(2, value.getSenha());
			ptst.setLong(3, value.getIdPessoa());
			int affectedRows = ptst.executeUpdate();
	        if (affectedRows == 0) {
	        	throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
		    }
		    ResultSet generatedKeys = ptst.getGeneratedKeys();
		    if (generatedKeys.next()) {
		    	value.setIdUsu(generatedKeys.getLong(1));
		    }
		    else {
		       throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
		    }
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet listarPorId(VO value) {
		String sql = "select * from pessoa where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, value.getIdUsu());
			rs = ptst.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet buscarPorLogin(VO value) {
		String sql = "select p.id as pessoaId, p.nome as nome,p.cpf as cpf, "
				+ "p.telefone as telefone, p.email as email, u.id as usuarioId, "
				+ "u.login as login, u.senha as senha from Pessoa p, Usuario u "
				+ "where u.login = ? and p.id = u.id_pessoa";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value.getLogin());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorIdPessoa(VO value) {
		String sql = "select * from gerente where id_pessoa = ?";
		PreparedStatement ptst;
		ResultSet rs= null;
		System.out.println(value.getIdPessoa())	;	
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, value.getIdPessoa());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}
