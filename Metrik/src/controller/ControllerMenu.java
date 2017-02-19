package controller;

import javafx.fxml.FXML;

public class ControllerMenu {
	private ControladorVentanas instancia;
	
	@FXML public void Projects(){
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarEscena("../views/fxml/projects.fxml", "Gesti�n de Proyectos");
		
	}
	
	@FXML public void Users(){
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarEscena("../views/fxml/user.fxml", "Gesti�n de Usuarios");
	}
	

}