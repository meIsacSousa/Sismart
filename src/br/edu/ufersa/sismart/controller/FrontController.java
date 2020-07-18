package br.edu.ufersa.sismart.controller;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.model.BO.UsuarioBO;
import br.edu.ufersa.sismart.model.BO.UsuarioInterBO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FrontController {
	@FXML private Label erroLogin;
	@FXML private TextField login;
	@FXML private TextField senha;
	
	UsuarioInterBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
	
	public void autenticar(ActionEvent event) throws Exception{
		UsuarioVO vo = new UsuarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		
		try
		{
			UsuarioVO autenticado = usuBO.autenticar(vo);
			if(autenticado instanceof FuncionarioVO) {
				//abrir a janela principal de responsavel
			}
			else {
				//abrir a janela de gerente
			}
		}
		catch(AutenticationException e) {
			erroLogin.setText("Usuário ou senha inválidos!");
			erroLogin.setVisible(true);
		}
	}
}
