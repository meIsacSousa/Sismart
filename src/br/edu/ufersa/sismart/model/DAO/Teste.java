package br.edu.ufersa.sismart.model.DAO;

import java.sql.SQLException;

import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.TipoVO;

public class Teste {

	public static void main(String[] args) {
		ItemDAO idao = new ItemDAO();
		ItemVO ivo = new ItemVO();
		TipoVO tvo = new TipoVO();
		tvo.setId(1);
		
		ivo.setNome("Isac");
		ivo.setMarca("Sousa");
		ivo.setCodigoDeBarras("3333333333333");
		ivo.setPreco(200);
		ivo.setQuantidadeEmEstoque(20);
		ivo.setQuantidadeCompra(10);
		ivo.setIdCesta(1);
		ivo.setTipo(tvo);

		
		
		
		try {
			idao.inserir(ivo);
			System.out.print("foi!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
