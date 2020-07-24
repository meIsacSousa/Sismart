package br.edu.ufersa.sismart.view;

import br.edu.ufersa.sismart.controller.FrontController;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Telas extends Application{
private static Stage primaryStage;
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Sistema SEQUENCE");
		primaryStage.show();
		telaLogin();
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDeLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaInicialGerente() throws Exception{
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/telaInicialDoGerente.fxml"));
        Parent root = loader.load();
     	FrontController fc = loader.getController();
		fc.initTable();
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaInicialFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaInicialDoFuncionario.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroItens() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastroDeItens.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaEdicaoItens() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaEdicaoDeItens.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastroTipos() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastroDeTipos.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	public static void telaCesta() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDeCesta.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	public static void telaCestaFunc() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDeCestaFunc.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	public static void telaNota() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDeNota.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaNotaFunc() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDeNotaFunc.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
