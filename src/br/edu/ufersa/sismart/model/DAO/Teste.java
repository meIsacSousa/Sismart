package br.edu.ufersa.sismart.model.DAO;

import java.sql.SQLException;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;
import br.edu.ufersa.sismart.model.BO.CestaBO;
import br.edu.ufersa.sismart.model.BO.FuncionarioBO;
import br.edu.ufersa.sismart.model.BO.GerenteBO;
import br.edu.ufersa.sismart.model.BO.ItemBO;
import br.edu.ufersa.sismart.model.BO.NotaBO;
import br.edu.ufersa.sismart.model.BO.TipoBO;
import br.edu.ufersa.sismart.model.BO.UsuarioBO;
import br.edu.ufersa.sismart.model.VO.CestaVO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.GerenteVO;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.NotaVO;
import br.edu.ufersa.sismart.model.VO.PessoaVO;
import br.edu.ufersa.sismart.model.VO.TipoVO;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;

@SuppressWarnings("unused")
public class Teste {

	public static void main(String[] args) {
		
		 ItemVO iVO = new ItemVO();
		 ItemBO iBO = new ItemBO();
		 TipoVO tVO = new TipoVO();
		 TipoBO tBO = new TipoBO();
		 CestaVO cVO = new CestaVO();
		 CestaBO cBO = new CestaBO();
		 NotaVO nvo = new NotaVO();
		 NotaBO nbo = new NotaBO();
		 
		try {
			iBO.comprar(iBO.buscarPorId(17), 5);
			iBO.comprar(iBO.buscarPorId(20), 10);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			 //nbo.finalizarCompra(7);

		 
		
	}
}
