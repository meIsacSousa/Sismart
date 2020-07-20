package br.edu.ufersa.sismart.model.BO;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.NotaDAO;
import br.edu.ufersa.sismart.model.VO.NotaVO;

public class NotaBO extends BaseBO<NotaVO> {
	private static NotaDAO<NotaVO> nDAO = new NotaDAO<NotaVO>();
	static long idGenerator = 0;
	
	@Override
	public void cadastrar(NotaVO value) throws InsertException {
		try {
			nDAO.inserir(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(NotaVO value) throws InsertException {
		try {
			nDAO.remover(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(NotaVO value) throws InsertException {
		try {
			nDAO.atualizar(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NotaVO> listar() throws InsertException {

		return null;
	}

	@Override
	public NotaVO buscarPorId(NotaVO vo) throws NotFoundException {

		return null;
	}

}
