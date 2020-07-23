package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.ItemDAO;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.TipoVO;

public class ItemBO extends BaseBO<ItemVO> {
	private static ItemDAO iDAO = new ItemDAO();
	static long idGenerator = 0;
	
	@Override
	public void cadastrar(ItemVO value) throws InsertException {
		try {
			ResultSet ItemAunt = iDAO.listarPorNome(value.getNome());	

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
			ResultSet ItemAunt = iDAO.listarPorNome(value.getNome());
		
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
		List<ItemVO> listItem = new ArrayList<ItemVO>();
		
		try {
			ResultSet itemAunt = iDAO.listar();
			TipoBO tbo = new TipoBO();
			TipoVO tvo = new TipoVO();
			while (itemAunt.next()) {
				ItemVO ivo = new ItemVO();
				ivo.setId(itemAunt.getLong(1));
				ivo.setNome(itemAunt.getString(2));
				ivo.setMarca(itemAunt.getString(3));
				ivo.setCodigoDeBarras(itemAunt.getString(4));
				ivo.setQuantidadeEmEstoque(itemAunt.getInt(5));
				ivo.setPreco(itemAunt.getDouble(6));
				ivo.setQuantidadeCompra(itemAunt.getInt(7));
				tvo.setId(itemAunt.getLong(8)); // setando o id para pegar o tipo
				try {
					ivo.setTipo(tbo.buscarPorId(tvo.getId()));
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
				listItem.add(ivo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listItem;
	}

	@Override
	public ItemVO buscarPorId(long value) throws NotFoundException {
		TipoVO tvo = new TipoVO();
		ItemVO ivo = new ItemVO();
		TipoBO tbo = new TipoBO();
		try {
			ResultSet itemAunt = iDAO.listarPorId(value);
			if(itemAunt.next()) {
				ivo.setId(itemAunt.getLong(1));
				ivo.setNome(itemAunt.getString(2));
				ivo.setMarca(itemAunt.getString(3));
				ivo.setCodigoDeBarras(itemAunt.getString(4));
				ivo.setQuantidadeEmEstoque(itemAunt.getInt(5));
				ivo.setPreco(itemAunt.getDouble(6));
				ivo.setQuantidadeCompra(itemAunt.getInt(7));
				tvo.setId(itemAunt.getLong(8)); // setando o id para pegar o tipo
				try {
					ivo.setTipo(tbo.buscarPorId(tvo.getId()));
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
			} else {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ivo;
	}

	
	public List<ItemVO> listarPorNome(String value) throws NotFoundException {
		List<ItemVO> listItem = new ArrayList<ItemVO>();
		
		try {
			ResultSet itemAunt = iDAO.listarPorNome(value);
			TipoBO tbo = new TipoBO();
			TipoVO tvo = new TipoVO();
			while (itemAunt.next()) {
				ItemVO ivo = new ItemVO();
				ivo.setId(itemAunt.getLong(1));
				ivo.setNome(itemAunt.getString(2));
				ivo.setMarca(itemAunt.getString(3));
				ivo.setCodigoDeBarras(itemAunt.getString(4));
				ivo.setQuantidadeEmEstoque(itemAunt.getInt(5));
				ivo.setPreco(itemAunt.getDouble(6));
				ivo.setQuantidadeCompra(itemAunt.getInt(7));
				tvo.setId(itemAunt.getLong(8)); // setando o id para pegar o tipo
				try {
					ivo.setTipo(tbo.buscarPorId(tvo.getId()));
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
				listItem.add(ivo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listItem;
	} 
	
	public List<ItemVO> listarPorCodigoDeBarras(String value) throws NotFoundException {
		List<ItemVO> listItem = new ArrayList<ItemVO>();
		
		try {
			ResultSet itemAunt = iDAO.listarPorCodigoDeBarras(value);
			TipoBO tbo = new TipoBO();
			TipoVO tvo = new TipoVO();
			while (itemAunt.next()) {
				ItemVO ivo = new ItemVO();
				ivo.setId(itemAunt.getLong(1));
				ivo.setNome(itemAunt.getString(2));
				ivo.setMarca(itemAunt.getString(3));
				ivo.setCodigoDeBarras(itemAunt.getString(4));
				ivo.setQuantidadeEmEstoque(itemAunt.getInt(5));
				ivo.setPreco(itemAunt.getDouble(6));
				ivo.setQuantidadeCompra(itemAunt.getInt(7));
				tvo.setId(itemAunt.getLong(8)); // setando o id para pegar o tipo
				try {
					ivo.setTipo(tbo.buscarPorId(tvo.getId()));
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
				listItem.add(ivo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listItem;
	}

	public void comprar(ItemVO value) throws NotFoundException {
		try {
			ResultSet itemAunt = iDAO.listarPorId(value.getId());
			if (itemAunt.next()) {
				value.setIdCesta(CestaBO.idGenerator); // ?
				value.setQuantidadeEmEstoque(value.getQuantidadeCompra() + value.getQuantidadeEmEstoque());
				iDAO.atualizar(value);
				
			} else {
				throw new NotFoundException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException();
		}		
	}
	
	public void vender(ItemVO value) throws NotFoundException {
		try {
			ResultSet itemAunt = iDAO.listarPorId(value.getId());
			if (itemAunt.next() && value.getQuantidadeEmEstoque() > value.getQuantidadeCompra()) {
				value.setIdCesta(CestaBO.idGenerator);
				value.setQuantidadeEmEstoque(value.getQuantidadeEmEstoque() - value.getQuantidadeCompra());
				iDAO.atualizar(value);
			} else {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		}		
	}
	
	
}

