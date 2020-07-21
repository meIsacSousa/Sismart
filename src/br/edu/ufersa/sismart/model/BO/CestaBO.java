package br.edu.ufersa.sismart.model.BO;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.CestaDAO;
import br.edu.ufersa.sismart.model.DAO.ItemDAO;
import br.edu.ufersa.sismart.model.VO.CestaVO;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.NotaVO;

public class CestaBO extends BaseBO<CestaVO> {
	private static CestaDAO<CestaVO> cDAO = new CestaDAO<CestaVO>();
	private static ItemDAO iDAO = new ItemDAO();
	private static NotaBO nBO = new NotaBO();
	static long idGenerator = 1;
	
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
			idGenerator++;
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

	public void gerarNota(CestaVO value) throws InsertException {
		NotaVO nota = new NotaVO();
		
		nota.setCesta(value);
		nota.setIdCesta(idGenerator);
		nBO.cadastrar(nota);
		
		idGenerator++;
	}
	
	public void trocarProduto(ItemVO value) throws InsertException{
		value.setIdCesta(idGenerator);
		try {
			iDAO.atualizar(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cancelarProduto (ItemVO value) throws InsertException {
		value.setIdCesta(1);
		try {
			iDAO.atualizar(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
}
