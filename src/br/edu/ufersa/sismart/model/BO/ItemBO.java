package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.ItemDAO;
import br.edu.ufersa.sismart.model.VO.ItemVO;

public class ItemBO extends BaseBO<ItemVO> {
	private static ItemDAO iDAO = new ItemDAO();
	static long idGenerator = 0;
	
	@Override
	public void cadastrar(ItemVO value) throws InsertException {
		try {
			ResultSet ItemAunt = iDAO.listarPorNome(value);	

				if (ItemAunt.next()) {
					throw new InsertException("Item já cadastrado");		
				} else{				
					iDAO.inserir(value);
					idGenerator++;					
				} 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(ItemVO value) throws InsertException {
		try {
			ResultSet ItemAunt = iDAO.listarPorNome(value);
		
				if (ItemAunt.next()) {
					
					iDAO.remover(value);
					
				} else if (ItemAunt.isLast()) {
					
					throw new InsertException("Item informado não existe");
				
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(ItemVO value) throws InsertException {
		try {		
			iDAO.atualizar(value);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<ItemVO> listar() throws InsertException {
		
		return null;
	}

	@Override
	public ItemVO buscarPorId(ItemVO value) throws NotFoundException {
		
		return null;
	}

}
