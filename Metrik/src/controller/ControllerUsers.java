/**
 *@This controller is for saving or editing user data
 *@author Jesus Lozano - 0line
 *@version 0.1 03/02/17
 * **/
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerUsers implements Initializable{
	@FXML private JFXTextField txtname,txtuser,txtemail;
	@FXML private JFXPasswordField txtpsw;
	@FXML private JFXComboBox<String> cmbtype;
	@FXML
	private JFXButton btnNuevo, btnCancel,btnSave;
	private ControladorVentanas instancia;
	
	//Method save data
	@FXML public void save(){
		instancia = ControladorVentanas.getInstancia();
		instancia.closeEscena();
	}
	
	//Method for cancel
	@FXML public void cancel(){
		instancia = ControladorVentanas.getInstancia();
		instancia.closeEscena();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbtype.getItems().add("Administrador");
		cmbtype.getItems().add("Lider");
		cmbtype.getItems().add("Miembro");
		
	}
}
