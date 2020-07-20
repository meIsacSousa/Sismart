package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.GerenteDAO;
import br.edu.ufersa.sismart.model.VO.GerenteVO;

public class GerenteBO extends BaseBO<GerenteVO> {
	private static GerenteDAO<GerenteVO> gerDAO = new GerenteDAO<GerenteVO>();

	@Override
	public void cadastrar(GerenteVO value) throws InsertException {
		ResultSet gerrs = gerDAO.buscarPorCPF(value);
		
		try {
			if(gerrs.next()) {
				throw new InsertException("Já cadastrado em sistema");
			} else {
				gerDAO.inserir(value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(GerenteVO value) throws InsertException {
		
	}

	@Override
	public void alterar(GerenteVO value) throws InsertException {
		
	}

	@Override
	public List<GerenteVO> listar() throws InsertException {
		return null;
	}

	@Override
	public GerenteVO buscarPorId(GerenteVO value) throws NotFoundException {
		return null;
	}
	
	
}
