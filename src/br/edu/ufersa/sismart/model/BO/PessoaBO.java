package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.PessoaDAO;
import br.edu.ufersa.sismart.model.VO.PessoaVO;

public class PessoaBO extends BaseBO<PessoaVO> {
	private static PessoaDAO<PessoaVO> pDAO = new PessoaDAO<PessoaVO>();
	
	@Override
	public void cadastrar(PessoaVO value) throws InsertException {
		
		ResultSet pessoaAunt = pDAO.buscarPorCPF(value);
		
		try {
			if(pessoaAunt.next()) {
				throw new InsertException("Já possui cadastro em sistema");
			} else {
				pDAO.inserir(value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletar(PessoaVO value) throws InsertException {
		ResultSet pessoaAunt = pDAO.buscarPorCPF(value);
		
		try {
			if(pessoaAunt.next()) {
				pDAO.remover(value);
			} else {
				throw new InsertException("Não possui cadastrado em sistema");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(PessoaVO value) throws InsertException {
		
		try {
			pDAO.atualizar(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PessoaVO> listar() throws InsertException {
		
		try {
			ResultSet rs = pDAO.listar();
			@SuppressWarnings("unused")
			List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
			
			//PessoaVO pessoa = new ();
			
			while (rs.next()) {
					
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public PessoaVO buscarPorId(long value) throws NotFoundException {
		
		return null;
	}

}
