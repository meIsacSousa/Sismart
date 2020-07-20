package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.TipoDAO;
import br.edu.ufersa.sismart.model.VO.TipoVO;

public class TipoBO extends BaseBO<TipoVO> {
	private static TipoDAO tDAO = new TipoDAO();
	static long idGenerator = 0;
	
	
	@Override
	public void cadastrar(TipoVO value) throws InsertException {
		try {
			ResultSet tipoAunt = tDAO.listarPorNome(value);
		
				if (tipoAunt.next()) {
					
					throw new InsertException("Tipo já cadastrado");
				
				} else {	
					tDAO.inserir(value);
					idGenerator++;	
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deletar(TipoVO value) throws InsertException {
		try {
			ResultSet tipoAunt = tDAO.listarPorNome(value);
		
				if (tipoAunt.next()) {
					
					tDAO.remover(value);
					
				} else {	
					throw new InsertException("Tipo informado não existe");
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(TipoVO value) throws InsertException {
		try {		
			tDAO.atualizar(value);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TipoVO> listar() throws InsertException {
		return null;
	}

	@Override
	public TipoVO buscarPorId(TipoVO value) throws NotFoundException {
		return value;
	}

}
