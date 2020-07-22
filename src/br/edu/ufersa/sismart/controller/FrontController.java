package br.edu.ufersa.sismart.controller;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.model.BO.UsuarioBO;
import br.edu.ufersa.sismart.model.BO.UsuarioInterBO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.GerenteVO;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;
import br.edu.ufersa.sismart.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FrontController {
	UsuarioInterBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
	ObservableList<String> pesquisarPorList = FXCollections.
			observableArrayList("Nome", "Marca", "Codigo");

	@FXML
	private Label erroLogin;
	@FXML
	private TextField email;
	@FXML
	private TextField senha;
	
	
	@FXML
	private ChoiceBox<String> pesquisarPor;
	

	public void cadastrarItem(ActionEvent event) throws Exception {

	}
	
	public void cadastrarTipo(ActionEvent event) throws Exception {

	}

	public void alterarItem(ActionEvent event) throws Exception {

	}

	public void autenticar(ActionEvent event) throws Exception {
		UsuarioVO vo = new UsuarioVO();
		try {
			vo.setLogin(email.getText());
			vo.setSenha(senha.getText());
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			UsuarioVO autenticado = usuBO.autenticar(vo);
			if (autenticado instanceof GerenteVO) {
				Telas.telaInicialGerente();
				//Telas.telaInicialFuncionario();
			} else {
				//Telas.telaInicialGerente();
				Telas.telaInicialFuncionario();
			}
		} catch (AutenticationException e) {
			erroLogin.setText("Usuário ou senha inválidos");
			erroLogin.setVisible(true);
		}
	}
	
	public void goToCadastrarItem(ActionEvent event) throws Exception {
		Telas.telaCadastroItens();
	}
	
	public void goToCadastrarTipo(ActionEvent event) throws Exception {
		Telas.telaCadastroTipos();
	}
	
	public void pesquisarPor(MouseEvent event) throws Exception {
		pesquisarPor.setItems(pesquisarPorList);
	}
	
	public void receberPesquisa(ActionEvent event) throws Exception {
		
	}
	
	public void pesquisar(ActionEvent event) throws Exception {

	}
	
	public void voltar(ActionEvent event) throws Exception {
		Telas.telaInicialGerente();
	}
	
	public void voltarFunc(ActionEvent event) throws Exception {
		Telas.telaInicialFuncionario();
	}
	
	public void sair(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	
	public void goToCesta(MouseEvent event) throws Exception {
		Telas.telaCesta();
	}
	public void goToCestaFunc(MouseEvent event) throws Exception {
		Telas.telaCestaFunc();
	}
	public void gerarNota(ActionEvent event) throws Exception {
		Telas.telaNota();
	}
	public void gerarNotaFunc(ActionEvent event) throws Exception {
		Telas.telaNotaFunc();
	}
	public void voltarCesta(ActionEvent event) throws Exception {
		Telas.telaCesta();
	}
	public void imprimirNota(ActionEvent event) throws Exception {
		
	}
}
