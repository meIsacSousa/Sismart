package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.FuncionarioDAO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;

public class FuncionarioBO extends BaseBO<FuncionarioVO> {
	private static FuncionarioDAO funcDAO = new FuncionarioDAO();
	
	
	public void cadastrar(FuncionarioVO value) throws InsertException {
		ResultSet funcrs = funcDAO.buscarPorCPF(value);
		
		try {
			if(funcrs.next()) {
				throw new InsertException("Já cadastrado em sistema");
			} else {
				funcDAO.inserir(value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void deletar(FuncionarioVO value) throws InsertException {
		
	}


	@Override
	public void alterar(FuncionarioVO value) throws InsertException {
		try {
			funcDAO.atualizar(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<FuncionarioVO> listar() throws InsertException {
		return null;
	}


	@Override
	public FuncionarioVO buscarPorId(long value) throws NotFoundException {
		return null;
	}


}
