package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Conexion;
import model.Usuario;

public class DAOUsuarios {
	private Conexion micon;
	private PreparedStatement comando;
	private ResultSet rs;
	private Usuario usuario;
	
	public DAOUsuarios(){
		micon=new Conexion();
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
				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setCorreo_e(rs.getString("correo_e"));
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setEstatus(rs.getBoolean("estatus"));
				
			}
		} catch (Exception e) {
		 e.printStackTrace();	
		 usuario=null;
		}
		finally{
			micon.desconectar();
		}
		return usuario;
	}
	
	
}
