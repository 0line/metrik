package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Usuario;

public class ControllerMenu implements Initializable{
	private ControladorVentanas instancia;
	private Usuario usuario;
	private String nivel;
	
	public ControllerMenu() {
	usuario=new Usuario();
	}
	
	
	
	private @FXML JFXButton btnInicio,btnProjects,btnUsers,btnMetric;
	@FXML public void Projects(){
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarMenu("../views/fxml/mtprojects.fxml", "Gestión de Proyectos");
	}
	
	@FXML public void Users(){
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarMenu("../views/fxml/mtusuarios.fxml", "Gestión de Usuarios");
	}
	
	@FXML public void Metricas(){
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarMenu("../views/fxml/mtmetricas.fxml", "Gestión de Metricas");
	}
	@FXML public void home(){
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarMenu("../views/fxml/main.fxml", "Inicio");
	}

	public void buttons(String nivel){
		System.out.println(nivel);
		switch (nivel) {
		case "Administrador":
			break;
		case "Lider":
			System.out.println("aqui");
			//btnUsers.setDisable(true);
			break;
		case "Miembro":
			break;
		}
		
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	

	
	

}