package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {
	private Conexion micon;
	private PreparedStatement comando;
	private ResultSet rs;
	private Usuario usuarios;
	private int id_usuario;
	private String usuario, password,correo_e,tipo_usuario;
	private Boolean estatus;
	//Contructores
	public Usuario(){
		this.id_usuario=0;
		this.usuario=password=correo_e=tipo_usuario="";
		this.estatus=false;
		micon=new Conexion();
	}
	


	public Usuario(int id_usuario, String usuario, String password, String correo_e, String tipo_usuario, Boolean estatus){
		super();
		this.id_usuario= id_usuario;
		this.usuario=usuario;
		this.password=password;
		this.correo_e=correo_e;
		this.tipo_usuario=tipo_usuario;
		this.estatus=estatus;
	}



	public int getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getCorreo_e() {
		return correo_e;
	}



	public void setCorreo_e(String correo_e) {
		this.correo_e = correo_e;
	}



	public String getTipo_usuario() {
		return tipo_usuario;
	}



	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}



	public Boolean getEstatus() {
		return estatus;
	}



	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	

	
	public Usuario validarUsuario(Usuario u){
		try {
			micon.conectar();
			String consulta ="select * from usuario where usuario=? and password=?";
			comando=micon.getCon().prepareStatement(consulta);
			comando.setString(1, u.getUsuario());
			comando.setString(2, u.getPassword());
			rs = comando.executeQuery();
			while(rs.next()){
				usuarios = new Usuario();
				usuarios.setUsuario(rs.getString("usuario"));
				usuarios.setPassword(rs.getString("contrasenia"));
				usuarios.setCorreo_e(rs.getString("correo_e"));
				usuarios.setTipo_usuario(rs.getString("tipo_usuario"));
				usuarios.setId_usuario(rs.getInt("id_usuario"));
				usuarios.setEstatus(rs.getBoolean("estatus"));
				
			}
		} catch (Exception e) {
		 e.printStackTrace();	
		 usuarios=null;
		}
		finally{
			micon.desconectar();
		}
		return usuarios;
	}
	
}