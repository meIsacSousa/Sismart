package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
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
	private static CestaDAO cDAO = new CestaDAO();
	private static NotaBO nBO = new NotaBO();
	public static long idGenerator = 1;
	public static ItemDAO iDAO = new ItemDAO();
	public static ItemBO iBO = new ItemBO();
	
	@Override
	public void cadastrar(CestaVO value) throws InsertException {
		try {
			cDAO.inserir(value);	
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
	public CestaVO buscarPorId(long value) throws NotFoundException {
		CestaVO cvo = new CestaVO();
		try {
			ResultSet tipoAunt = cDAO.listarPorId(value);
			if(tipoAunt.next()) {
				cvo.setId(tipoAunt.getLong(1));
				cvo.setValorTotal(tipoAunt.getDouble(2));
			} else {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cvo;
	}

	public void gerarNota(CestaVO value) throws InsertException {
		NotaVO nota = new NotaVO();
		
		nota.setCesta(value);
		nota.setIdCesta(value.getId());
		nBO.cadastrar(nota);
	}
	
	//atualizando o idGenerator de acordo com o banco de dados
	public static void AtualizarId() {
		try {
			ResultSet rs = cDAO.listar();
			while (rs.next()) {
				idGenerator++;
			}
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// tirar produto da cesta.
	public void cancelarProduto (ItemVO value) throws InsertException {
		value.setIdCesta(1);
		try {
			iDAO.atualizar(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
}
