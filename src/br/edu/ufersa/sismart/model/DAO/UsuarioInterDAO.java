package br.edu.ufersa.sismart.model.DAO;

import java.sql.ResultSet;

import br.edu.ufersa.sismart.model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> extends BaseInterDAO<VO>{
	public ResultSet listarPorId(VO value);
	public ResultSet buscarPorLogin(VO value);
	public ResultSet buscarPorIdPessoa(VO value);
}
