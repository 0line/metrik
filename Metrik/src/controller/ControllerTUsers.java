/**
 *@This controller is for viewing users data and open user registry view
 *@author Jesus Lozano - 0line
 *@version 0.1 28/02/17
 * **/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.DAOUsuarios;
import model.Usuario;

public class ControllerTUsers implements Initializable {
	@FXML
	private JFXHamburger btnmenu;
	@FXML
	private GridPane GPpanel;
	@FXML
	private JFXDrawersStack drawmenu;
	@FXML
	private JFXDrawer listmenu;
	@FXML
	private JFXButton btnNuevo;	
	private ControladorVentanas instancia;
	@FXML private TableView<Usuario> tvUsers;
	@FXML private TableColumn<Usuario, Integer>tvcid;
	@FXML private TableColumn<Usuario, String>tvcname,tvcuser,tvcpsw,tvcemail,tvctypeuser;
	@FXML private Pagination pagTUsers;
	private TableColumn<Usuario, Boolean> tvcstatus;
	private ObservableList<Usuario> listusers;
	private DAOUsuarios DAOusers;	
	private Usuario user;
	public ControllerTUsers() {
		listusers= FXCollections.observableArrayList();
		DAOusers= new DAOUsuarios();
		user= new Usuario();
	}

	@FXML
	public void newData() {
		instancia = ControladorVentanas.getInstancia();
		instancia.asignarEscena("../views/fxml/users.fxml", "Registro Usuarios");
	}
	@FXML public void setDataTablet(Boolean status){
		listusers.clear();
		addColumns();
		if (status != false) {
			listusers = DAOusers.consultarUsers(("Select *from usuario where estatus='1' order by id_usuario"));
		} else {
			listusers = DAOusers.consultarUsers(("Select * from usuario where estatus='0' order by id_usuario"));
		}
		int numOfPages = 1;
		if (listusers.size() % 16 == 0) {
		  numOfPages = listusers.size() / 16;
		} else if (listusers.size() > 16) {
		  numOfPages = listusers.size() / 16 + 1;
		}
		
		pagTUsers.setPageCount(numOfPages);
		pagTUsers.setPageFactory(new Callback<Integer, Node>() {

			public Node call(Integer pageIndex) {
				if (listusers.size()<16) {
					tvUsers.setItems(listusers);
				} else {
					int lastIndex = 0;
			        int displace = listusers.size() % 16;
			        if (displace > 0) {
			            lastIndex = listusers.size() / 16;
			        } else {
			            lastIndex = listusers.size() / 16 - 1;

			        }
			        int page = pageIndex * 1;
			        for (int i = page; i < page + 1; i++) {
			        	if (listusers.size()<=16) {
							tvUsers.setItems(listusers);
						} else {
							if (lastIndex == pageIndex) {
				                tvUsers.setItems(FXCollections.observableArrayList(listusers.subList(pageIndex * 16, (pageIndex * 16 + displace))));
							} else {
				            	tvUsers.setItems(FXCollections.observableArrayList(listusers.subList(pageIndex * 16, (pageIndex * 16 + 16))));
							}
						}
			        }
				} 
				return tvUsers;
			}
		});
	}
	
	
	@FXML public void addColumns(){
		tvcid.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("id_usuario"));
		tvcname.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
		tvcuser.setCellValueFactory(new PropertyValueFactory<Usuario, String>("usuario"));
		tvcpsw.setCellValueFactory(new PropertyValueFactory<Usuario, String>("password"));
		tvcemail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("correo_e"));
		tvctypeuser.setCellValueFactory(new PropertyValueFactory<Usuario, String>("tipo_usuario"));
		tvcstatus.setCellValueFactory(new PropertyValueFactory<Usuario, Boolean>("estatus"));
		/*tvcstatus.setCellValueFactory(cellData -> {
		 user = cellData.getValue();
			Boolean v = (user.getEstatus());
			return new ReadOnlyBooleanWrapper(v);
		});
		tvcstatus.setCellFactory(CheckBoxTableCell.<Usuario> forTableColumn(tvcstatus));*/
	}


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			VBox menuitems = FXMLLoader.load(getClass().getResource("../views/fxml/menu_buttons.fxml"));
			listmenu.setSidePane(menuitems);
			HamburgerBasicCloseTransition menu = new HamburgerBasicCloseTransition(btnmenu);
			menu.setRate(-1);
			btnmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
				menu.setRate(menu.getRate() * -1);
				menu.play();
				if (listmenu.isShown()) {
					listmenu.close();
				} else
					listmenu.open();

			});
			setDataTablet(true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
