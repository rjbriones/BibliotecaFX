/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.controllers;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import BibliotecaFX.helpers.Conexion;
import BibliotecaFX.models.Usuario;



/**
 *
 * @author rjavi
 */
public class UsuarioController {
   
	private Usuario usuario = null;
	private ArrayList<Usuario> listaUsuario;
	private static UsuarioController instancia;
	
	private UsuarioController() {
		listaUsuario = new ArrayList<Usuario>();
	}
	
	public static UsuarioController getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioController();
		}
		return instancia;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
        
        public ArrayList<Usuario> getArrayList() {
            return listaUsuario;
        
        }
        
        public int buscarEspacioUsuario(String var0) {
		int variableRetorno = -1;
		if (1 == listaUsuario.size()) {
			int var1 = Integer.parseInt(var0);
				if (listaUsuario.get(0).getIdUsuario() == var1) {
				variableRetorno = 0;
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaUsuario.size()) {
			int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaUsuario.size(); numerillo++) {
				if (listaUsuario.get(numerillo).getIdUsuario() == var1) {
					variableRetorno = numerillo;
				
                } else {
					//No hay ninguna coincidencia;
				}
			}
		} else {
			//No hay nada ingresado;
		}
		return variableRetorno;
	}
        
	public ArrayList<Usuario> getListaUsuario() {
		listaUsuario.clear();
		ResultSet resultadoUsuarios = Conexion.getInstancia().hacerConsulta("SELECT * FROM Usuario");
		if (resultadoUsuarios != null) {
			try {
				while (resultadoUsuarios.next()) {
					int idUsuario = resultadoUsuarios.getInt("idUsuario");
					String nombreUsuario = resultadoUsuarios.getString("nombreUsuario");
					Usuario usuario = new Usuario(idUsuario, nombreUsuario);
					listaUsuario.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
        
        
        public ArrayList<Usuario> getListaIdUsuario(String texto) {
		listaUsuario.clear();
		ResultSet resultadoUsuarios = Conexion.getInstancia().hacerConsulta("SELECT * FROM Usuario WHERE idUsuario = '" + texto + "'");
		if (resultadoUsuarios != null) {
			try {
				while (resultadoUsuarios.next()) {
					int idUsuario = resultadoUsuarios.getInt("idUsuario");
					String nombreUsuario = resultadoUsuarios.getString("nombreUsuario");
					Usuario usuario = new Usuario(idUsuario, nombreUsuario);
					listaUsuario.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
        
        public ArrayList<Usuario> getListaNombreUsuario(String texto) {
		listaUsuario.clear();
		ResultSet resultadoUsuarios = Conexion.getInstancia().hacerConsulta("SELECT * FROM Usuario WHERE nombreUsuario LIKE '%" + texto + "%'");
		if (resultadoUsuarios != null) {
			try {
				while (resultadoUsuarios.next()) {
					int idUsuario = resultadoUsuarios.getInt("idUsuario");
					String nombreUsuario = resultadoUsuarios.getString("nombreUsuario");
					Usuario usuario = new Usuario(idUsuario, nombreUsuario);
					listaUsuario.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}       
        
	public void desautenticarUsuario() {
		this.usuario = null;
	}
	
	public void agregarUsuario(Usuario usuario) {
		String nick = usuario.getNombreUsuario(); 
		Conexion.getInstancia().ejecutarConsulta("EXEC CrearUsuario " + nick );
	}
	
	public void editarUsuario(int id, String nickUsuario) {
		Conexion.getInstancia().ejecutarConsulta("EXEC ModificarUsuario '" + nickUsuario + "', "+  id);
	}

	public void eliminarUsuario(int id) {
		Conexion.getInstancia().ejecutarConsulta("EXEC EliminarUsuario " + id);
		}
}
