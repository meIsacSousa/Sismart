package br.edu.ufersa.sismart.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaEdicaoItens extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("VE/telaEdicaoDeItens.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Sismart");
		primaryStage.setScene(cena);
		primaryStage.show();
		
		
	}
}
