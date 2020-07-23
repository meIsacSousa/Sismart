package br.edu.ufersa.sismart.model.BO;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.ItemDAO;
import br.edu.ufersa.sismart.model.DAO.NotaDAO;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.NotaVO;

public class NotaBO extends BaseBO<NotaVO> {
	private static NotaDAO<NotaVO> nDAO = new NotaDAO<NotaVO>();
	private static ItemBO iBO = new ItemBO();
	static long idGenerator = 0;
	
	@Override
	public void cadastrar(NotaVO value) throws InsertException {
		try {
			nDAO.inserir(value);
			idGenerator++;
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

	public void adicionarItem(ItemVO value, Long idNota) throws NotFoundException {

        try {
            value.setIdCesta(idNota-1);
            iBO.vender(value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerItem(ItemVO value, Long idNota) throws NotFoundException {
        try {
            value.setIdCesta(idNota-1);
            iBO.comprar(value);
        } catch (InsertException e) {
            e.printStackTrace();
        }

    }
	
	
}
