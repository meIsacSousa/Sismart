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
			try {
				// criando cesta
				System.out.println("point1");
				cBO.cadastrar(cVO); 
				System.out.println("point2");
			} catch (InsertException e) {
				e.printStackTrace();
			}
			
			//selecionando produtos
			System.out.println("point3");
			iBO.vender(iBO.buscarPorId(20), 10); 
			iBO.vender(iBO.buscarPorId(17), 10);

			System.out.println("point4");
			//gerando nota
			try {
				CestaBO.AtualizarId();
				long idCesta = CestaBO.idGenerator; //ultima cesta gerada
				System.out.println(idCesta);
				cVO.setId(idCesta);
				cBO.gerarNota(cVO);
				
				//finalizando venda
				nbo.finalizarVenda(idCesta);
				
			} catch (InsertException e) {
				e.printStackTrace();
			}
			
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Execução finalizada!");
		
	}
}
