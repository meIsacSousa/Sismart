package br.edu.ufersa.sismart.model.BO;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.CestaDAO;
import br.edu.ufersa.sismart.model.VO.CestaVO;

public class CestaBO extends BaseBO<CestaVO> {
	private static CestaDAO<CestaVO> cDAO = new CestaDAO<CestaVO>();
	@SuppressWarnings("unused")
	private static long idGenerator = 1;
	
	@Override
	public void cadastrar(CestaVO value) throws InsertException {
		try {
			cDAO.inserir(value);
			idGenerator++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletar(CestaVO value) throws InsertException {
		try {
			cDAO.remover(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(CestaVO value) throws InsertException {
			try {
				cDAO.atualizar(value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public List<CestaVO> listar() throws InsertException {
		return null;
	}

	@Override
	public CestaVO buscarPorId(CestaVO value) throws NotFoundException {
		return null;
	}

}
