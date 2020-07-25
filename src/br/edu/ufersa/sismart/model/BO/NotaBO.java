package br.edu.ufersa.sismart.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.DAO.ItemDAO;
import br.edu.ufersa.sismart.model.DAO.NotaDAO;
import br.edu.ufersa.sismart.model.VO.CestaVO;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.NotaVO;

public class NotaBO extends BaseBO<NotaVO> {
	private static CestaBO cBO = new CestaBO();
	private static NotaDAO nDAO = new NotaDAO();
	private static NotaBO nBO = new NotaBO();
	private static ItemDAO iDAO = new ItemDAO();
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
	public NotaVO buscarPorId(long value) throws NotFoundException {
		NotaVO nvo = new NotaVO();
		CestaBO cbo = new CestaBO();
		try {
			ResultSet tipoAunt = nDAO.listarPorId(value);
			if(tipoAunt.next()) {
				nvo.setId(tipoAunt.getLong(1));
				nvo.setIdCesta(tipoAunt.getLong(2));
				nvo.setCesta(cbo.buscarPorId(nvo.getIdCesta()));
			} else {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nvo;
	}

	public void AjustarCompra(ItemVO value, Long idNota) throws NotFoundException {

        try {
        	value.setIdCesta(nBO.buscarPorId(idNota).getIdCesta());
           // iBO.vender(value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajustarVenda(ItemVO value, Long idNota) throws NotFoundException {
        try {
            value.setIdCesta(nBO.buscarPorId(idNota).getIdCesta());
            //iBO.comprar(value);
        } catch (InsertException e) {
            e.printStackTrace();
        }

    }
	
    // finalizar compra/venda
    public void finalizarVenda(long idCesta) {
    	try {
    		
    		// pegando valor total e atualizando estoque
    		List<ItemVO> produtos = new ArrayList<ItemVO>();
    		try {
				produtos = iBO.listarPorCarrinho(idCesta);
			} catch (NotFoundException e) {
				
				e.printStackTrace();
			}
    		int valorTotal = 0;
    		for(int i = 0; i < produtos.size(); i++) {
    			produtos.get(i).setQuantidadeEmEstoque(produtos.get(i).getQuantidadeEmEstoque() - produtos.get(i).getQuantidadeCompra());
    			valorTotal += produtos.get(i).getQuantidadeCompra() * produtos.get(i).getPreco();
    			produtos.get(i).setIdCesta(1);
				produtos.get(i).setQuantidadeCompra(0);
				iDAO.atualizar(produtos.get(i));
				
    		}	
    		
    		try {
    			CestaVO cestaTemp = cBO.buscarPorId(idCesta);
				cestaTemp.setValorTotal(valorTotal);
				cBO.alterar(cestaTemp);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void finalizarCompra(long idCesta) {
    	try {
    		
    		// pegando valor total e atualizando estoque
    		List<ItemVO> produtos = new ArrayList<ItemVO>();
    		try {
				produtos = iBO.listarPorCarrinho(idCesta);
			} catch (NotFoundException e) {
				
				e.printStackTrace();
			}
    		int valorTotal = 0;
    		for(int i = 0; i < produtos.size(); i++) {
				produtos.get(i).setQuantidadeEmEstoque(produtos.get(i).getQuantidadeEmEstoque() + produtos.get(i).getQuantidadeCompra());
				valorTotal += produtos.get(i).getQuantidadeCompra() * produtos.get(i).getPreco();
				produtos.get(i).setIdCesta(1);
				produtos.get(i).setQuantidadeCompra(0);
				iDAO.atualizar(produtos.get(i));		
    		}
			CestaVO cestaTemp;
			try {
				cestaTemp = cBO.buscarPorId(idCesta);
				cestaTemp.setValorTotal(-valorTotal);
				cBO.alterar(cestaTemp);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
