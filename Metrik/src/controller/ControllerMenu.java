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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ControllerMenu{
	private ControladorVentanas instancia;
	
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

	
	

}