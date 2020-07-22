package br.edu.ufersa.sismart.controller;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.model.BO.UsuarioBO;
import br.edu.ufersa.sismart.model.BO.UsuarioInterBO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;
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

	public void voltar(ActionEvent event) throws Exception {

	}
	
	public void sair(ActionEvent event) throws Exception {

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
			if (autenticado instanceof FuncionarioVO) {
				// ir para a tela principal de Funcionario
			} else {
				// ir para a tela principal de Gerente
			}
		} catch (AutenticationException e) {
			erroLogin.setText("Usuário ou senha inválidos");
			erroLogin.setVisible(true);
		}
	}
	
	public void pesquisarPor(MouseEvent event) throws Exception {
		pesquisarPor.setItems(pesquisarPorList);
	}
	
	public void receberPesquisa(ActionEvent event) throws Exception {
		
	}
	
	public void pesquisar(ActionEvent event) throws Exception {

	}
	
	public void goToCadastrarItem(ActionEvent event) throws Exception {

	}
	
	public void goToCadastrarTipo(ActionEvent event) throws Exception {

	}
	public void goToCesta(ActionEvent event) throws Exception {

	}
	public void gerarNota(ActionEvent event) throws Exception {

	}
	public void voltarCesta(ActionEvent event) throws Exception {

	}
	public void imprimirNota(ActionEvent event) throws Exception {
		
	}
}
