package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.UsuarioDAO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.GerenteVO;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> implements UsuarioInterBO<VO> {
	
	private static UsuarioDAO<UsuarioVO> usuDAO = new UsuarioDAO<UsuarioVO>();
	private static UsuarioDAO<FuncionarioVO> funDAO = new UsuarioDAO<FuncionarioVO>();
	private static UsuarioDAO<GerenteVO> genDAO = new UsuarioDAO<GerenteVO>();
	
	
	@Override
	public UsuarioVO autenticar(VO value) throws AutenticationException {
		ResultSet usuAunt = usuDAO.buscarPorLogin(value);
		try {
			
			if (usuAunt.next()) {
				if(usuAunt.getString("senha").equals(value.getSenha())) {
					
					GerenteVO ger = new GerenteVO();
					ger.setIdPessoa(usuAunt.getLong("id_pessoa"));
					
					ResultSet gerVerification = genDAO.buscarPorIdPessoa(ger);
					if(gerVerification.next()) {
				
						ger.setLogin(value.getLogin());
						ger.setCpf(usuAunt.getString("cpf"));
						ger.setEmail(usuAunt.getString("email"));
						ger.setNome(usuAunt.getString("nome"));
						ger.setTelefone(usuAunt.getString("telefone"));
						ger.setIdUsu(usuAunt.getLong("id_usuario"));
						return ger;
					} else {
						
						FuncionarioVO func = new FuncionarioVO();
						func.setIdPessoa(usuAunt.getLong("id_pessoa"));
						
						ResultSet resRS = funDAO.buscarPorIdPessoa(func);
						if(resRS.next()) {
							func.setLogin(value.getLogin());
							func.setCpf(usuAunt.getString("cpf"));
							func.setEmail(usuAunt.getString("email"));
							func.setNome(usuAunt.getString("nome"));
							func.setNome(usuAunt.getString("telefone"));
							func.setIdUsu(usuAunt.getLong("id_usuario"));
	
							return func;
						} else throw new AutenticationException();
					}
					
				} else throw new AutenticationException();
			
			} else throw new AutenticationException();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AutenticationException();
		}
		
	}
	
	@Override
	public void cadastrar(UsuarioVO value) throws InsertException {
		try {
			ResultSet usuAunt = usuDAO.buscarPorLogin(value);

				if (usuAunt.next()) {
					
					throw new InsertException("Login já existe");
				
				} else {				
					usuDAO.inserir(value);	
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deletar(UsuarioVO value) throws InsertException {
		try {
			ResultSet usuAunt = usuDAO.buscarPorLogin(value);
		
				if (usuAunt.next()) {
					
					usuDAO.remover(value);
					
				} else {
					throw new InsertException("Usuario informado não existe");		
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(UsuarioVO value) throws InsertException {
		try {		
			usuDAO.atualizar(value);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<VO> listar() throws InsertException {
		return null;
	}

	@Override
	public VO buscarPorId(UsuarioVO value) throws NotFoundException {
		return null;
	}

	
}
