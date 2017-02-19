package controller;
	

import controller.ControladorVentanas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	private ControladorVentanas instancia;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			instancia = ControladorVentanas.getInstancia();
			instancia.setPrimaryStage(primaryStage);
			VBox root = FXMLLoader.load(getClass().getResource("../views/fxml/login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
