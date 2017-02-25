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

public class ControllerJFXHamburguer implements Initializable {
	@FXML private JFXHamburger  btnmenu;
	@FXML private GridPane GPpanel;
	@FXML private JFXDrawersStack drawmenu;
	@FXML private JFXDrawer listmenu;
	private ControladorVentanas instancia;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			VBox menuitems = FXMLLoader.load(getClass().getResource("../views/fxml/menu_buttons.fxml"));
			listmenu.setSidePane(menuitems);
			HamburgerBasicCloseTransition menu= new  HamburgerBasicCloseTransition(btnmenu);
			menu.setRate(-1);
			btnmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
				menu.setRate(menu.getRate()*-1);
				menu.play();	
				 if(listmenu.isShown())
		            {
					 listmenu.close();
		            }else
		            	listmenu.open();
				 
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
