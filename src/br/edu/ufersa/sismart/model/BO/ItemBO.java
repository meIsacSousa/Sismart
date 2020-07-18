package br.edu.ufersa.sismart.model.BO;

import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.ItemDAO;
import br.edu.ufersa.sismart.model.VO.ItemVO;

public class ItemBO extends BaseBO<ItemVO> {
	static private ItemDAO iDAO = new ItemDAO();
	static long IdGenerator = 1;
	
	@Override
	public void cadastrar(ItemVO value) throws InsertException {
		
		
	}

	@Override
	public void deletar(ItemVO value) throws InsertException {
		
		
	}

	@Override
	public void alterar(ItemVO value) throws InsertException {
		
		
	}


	@Override
	public List<ItemVO> listar(ItemVO value) throws InsertException {
		
		return null;
	}

	@Override
	public ItemVO buscarPorId(ItemVO value) throws NotFoundException {
		
		return null;
	}

}
