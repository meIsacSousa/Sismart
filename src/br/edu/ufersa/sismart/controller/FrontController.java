package br.edu.ufersa.sismart.controller;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.model.BO.UsuarioBO;
import br.edu.ufersa.sismart.model.BO.UsuarioInterBO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;
import br.edu.ufersa.sismart.view.TelaLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FrontController {
	@FXML private Label erroLogin;
	@FXML private TextField email;
	@FXML private TextField senha;
	
	UsuarioInterBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
	
	public void cadastrarItem(ActionEvent event) throws Exception{
		
	}
	
	public void voltar(ActionEvent event) throws Exception{
		
	}
	
	public void alterarItem(ActionEvent event) throws Exception{
		
	}
	
	public void autenticar(ActionEvent event) throws Exception{
		UsuarioVO vo = new UsuarioVO();
		try {
			vo.setLogin(email.getText());
			vo.setSenha(senha.getText());
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Chegou at� aqui");
		/*try
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
			erroLogin.setText("Usu�rio ou senha inv�lidos!");
			erroLogin.setVisible(true);
		}*/
	}
}
