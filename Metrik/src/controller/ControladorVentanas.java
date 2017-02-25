package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorVentanas{
	private static ControladorVentanas instancia;
	private Stage primaryStage;
	private VBox contenedorDialog;
	
	
	private ControladorVentanas(){
		
	}
	
	public static ControladorVentanas getInstancia(){
		if(instancia==null){
			instancia= new ControladorVentanas();
		}
		return instancia;
	}
	
	public void setPrimaryStage(Stage primaryStage){
		this.primaryStage= primaryStage;
	}
	
	public void asignarEscena(String ruta, String titulo){
		try {
			FXMLLoader interfaz = new FXMLLoader(getClass().getResource(ruta));
			contenedorDialog = (VBox)interfaz.load();
			Stage dialogEscenario = new Stage();
			dialogEscenario.setTitle(titulo);
			dialogEscenario.initModality(Modality.WINDOW_MODAL);
			dialogEscenario.initOwner(primaryStage);
			Scene escena = new Scene(contenedorDialog);
			escena.getStylesheets().add(getClass().getResource("/views/css/style.css").toExternalForm());
			dialogEscenario.setScene(escena);
			dialogEscenario.show();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void asignarMenu(String ruta, String titulo){
		try {
			FXMLLoader interfaz = new FXMLLoader(getClass().getResource(ruta));
			GridPane contenedorDialog = (GridPane) interfaz.load();
			Scene scene = new Scene(contenedorDialog);
			scene.getStylesheets().add(getClass().getResource("/views/css/style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.setMaximized(true);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	

	public void asignarLogin(String ruta, String titulo){
		try {
			FXMLLoader interfaz = new FXMLLoader(getClass().getResource(ruta));
			contenedorDialog = (VBox)interfaz.load();
			Scene scene = new Scene(contenedorDialog);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}