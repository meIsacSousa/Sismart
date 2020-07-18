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
			// verificado se login foi encontrado
			if (usuAunt.next()) {
				// verificando se senha está correta
				if(usuAunt.getString("senha").equals(value.getSenha())) {
					
					GerenteVO ger = new GerenteVO();
					ger.setIdPessoa(usuAunt.getLong("pessoaId"));
					
					ResultSet gerVerification = genDAO.buscarPorIdPessoa(ger);
					if(gerVerification.next()) {
						//é um gerente
						ger.setLogin(value.getLogin());
						ger.setCpf(usuAunt.getString("cpf"));
						ger.setEmail(usuAunt.getString("email"));
						ger.setNome(usuAunt.getString("nome"));
						ger.setTelefone(usuAunt.getString("telefone"));
						ger.setIdUsu(usuAunt.getLong("usuId"));
						return ger;
					} else {
						//tem que ser um responsavel. vamos pegar os dados dele no banco.
						FuncionarioVO func = new FuncionarioVO();
						func.setIdPessoa(usuAunt.getLong("pessoaId"));
						
						ResultSet resRS = funDAO.buscarPorIdPessoa(func);
						if(resRS.next()) {//cumprir o protocolo por desencargo de consciência
							func.setLogin(value.getLogin());
							func.setCpf(usuAunt.getString("cpf"));
							func.setEmail(usuAunt.getString("email"));
							func.setNome(usuAunt.getString("nome"));
							func.setNome(usuAunt.getString("telefone"));
							func.setIdUsu(usuAunt.getLong("usuId"));
	
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
		
	}

	@Override
	public void deletar(UsuarioVO value) throws InsertException {
		
	}

	@Override
	public void alterar(UsuarioVO value) throws InsertException {
		
	}

	@Override
	public List<VO> listar(UsuarioVO Value) throws InsertException {

		return null;
	}

	@Override
	public VO buscarPorId(UsuarioVO value) throws NotFoundException {
		return null;
	}

	
}
