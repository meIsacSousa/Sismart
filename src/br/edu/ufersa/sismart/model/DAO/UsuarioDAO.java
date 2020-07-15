package br.edu.ufersa.sismart.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sismart.model.VO.UsuarioVO;

public class UsuarioDAO <VO extends UsuarioVO> extends PessoaDAO <VO>{
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
