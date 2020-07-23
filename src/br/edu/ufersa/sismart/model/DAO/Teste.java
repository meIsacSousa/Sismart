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
		 
		 
			/*System.out.println(tBO.listar());
			System.out.println(iBO.listar());
			try {
				System.out.println(tBO.buscarPorId(1));
				System.out.println(iBO.buscarPorId(20));
				System.out.println("------------------------------------------------------");
				System.out.println(iBO.listarPorNome("Produto Top"));
				System.out.println("------------------------------------------------------");
				System.out.println(iBO.listarPorCodigoDeBarras("1111111111111"));
				System.out.println("------------------------------------------------------");
				cBO.AtualizarId();
				System.out.println(CestaBO.idGenerator);*/
	/*	
	 try {
		 	try {
				cVO.adicionarItem(iBO.buscarPorId(20));
				cBO.cadastrar(cVO);
			} catch (InsertException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 */

		
	}
}
