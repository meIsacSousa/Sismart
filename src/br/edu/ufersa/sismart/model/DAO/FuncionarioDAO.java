package br.edu.ufersa.sismart.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sismart.model.VO.FuncionarioVO;

public class FuncionarioDAO extends UsuarioDAO<FuncionarioVO>  implements UsuarioInterDAO<FuncionarioVO>{
	
	@Override
	public void inserir(FuncionarioVO value) {
		try {
			super.inserir(value);
			String sql = "insert into funcionario (id_pessoa, id_usuario) values (?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, value.getIdPessoa());
			ptst.setLong(2, value.getIdUsu());
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
	        	throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
		    }
		    ResultSet generatedKeys = ptst.getGeneratedKeys();
		    if (generatedKeys.next()) {
		         value.setId(generatedKeys.getLong(1));
		    }
		    else {
		       throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
