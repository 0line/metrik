package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private String bd;
	private String servidor;
	private String usuario;
	private String contrasenia;
	private Connection con;
	public Conexion() {
		bd="metrik";
		usuario="postgres";
		contrasenia="123456";
		servidor="jdbc:postgresql://localhost:5432/";
		con=null;
	}
	
	public Boolean conectar(){
		Boolean result=false;
		try {
			Class.forName("org.postgresql.Driver");
			con= DriverManager.getConnection(servidor+bd, usuario, contrasenia);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}
	
	public Boolean desconectar(){
		try {
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Setters
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void setBd(String bd) {
		this.bd = bd;
	}
	

	
	//Getters
	public Connection getCon() {
		return con;
	}
}
