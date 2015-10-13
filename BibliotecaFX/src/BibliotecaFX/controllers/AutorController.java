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
import BibliotecaFX.models.Autor;

/**
 *
 * @author Marco
 */
public class AutorController {
   
	private Autor autor = null;
	private ArrayList<Autor> listaAutor;
        private ArrayList<String> listaNombreAutor;
	private static AutorController instancia;
	
	private AutorController() {
		listaAutor = new ArrayList<Autor>();
                listaNombreAutor = new ArrayList<String>();
	}
	
	public static AutorController getInstancia() {
		if (instancia == null) {
			instancia = new AutorController();
		}
		return instancia;
	}
	
	public Autor getAutor() {
		return autor;
	}
        
        public int buscarIdAutor(String var0) {
		int variableRetorno = -1;
		if (1 == listaAutor.size()) {
			int var1 = Integer.parseInt(var0);
				if (listaAutor.get(0).getIdAutor() == var1) {
				variableRetorno = 0;
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaAutor.size()) {
			int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaAutor.size(); numerillo++) {
				if (listaAutor.get(numerillo).getIdAutor() == var1) {
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
        
        
        public int devolverIdAutor(String var0) {
		int variableRetorno = -1;
		if (1 == listaAutor.size()) {
			//int var1 = Integer.parseInt(var0);
				if (listaAutor.get(0).getNombreAutor().equalsIgnoreCase(var0)) {
				variableRetorno = listaAutor.get(0).getIdAutor();
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaAutor.size()) {
			//int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaAutor.size(); numerillo++) {
				if (listaAutor.get(numerillo).getNombreAutor().equalsIgnoreCase(var0)) {
					variableRetorno = listaAutor.get(numerillo).getIdAutor();
				
                } else {
					//No hay ninguna coincidencia;
				}
			}
		} else {
			//No hay nada ingresado;
		}
		return variableRetorno;
	}
        
        
        
	public ArrayList<String> getListaNombreAutor() {
		listaNombreAutor.clear();
		ResultSet resultadoAutores = Conexion.getInstancia().hacerConsulta("SELECT * FROM Autor");
		if (resultadoAutores != null) {
			try {
				while (resultadoAutores.next()) {
					int idAutor = resultadoAutores.getInt("idAutor");
					String nombreAutor = resultadoAutores.getString("nombreAutor");
					String autor = new String(nombreAutor);
					listaNombreAutor.add(autor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
		return listaNombreAutor;
	}
        
        
        public ArrayList<Autor> getListaAutor() {
		listaAutor.clear();
		ResultSet resultadoAutores = Conexion.getInstancia().hacerConsulta("SELECT * FROM Autor");
		if (resultadoAutores != null) {
			try {
				while (resultadoAutores.next()) {
					int idAutor = resultadoAutores.getInt("idAutor");
					String nombreAutor = resultadoAutores.getString("nombreAutor");
					Autor autor = new Autor(idAutor, nombreAutor);
					listaAutor.add(autor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
		return listaAutor;
	}
        
        
        
        public ArrayList<Autor> getListaIdAutor(String texto) {
		listaAutor.clear();
		ResultSet resultadoAutors = Conexion.getInstancia().hacerConsulta("SELECT * FROM Autor WHERE idAutor = '" + texto + "'");
		if (resultadoAutors != null) {
			try {
				while (resultadoAutors.next()) {
					int idAutor = resultadoAutors.getInt("idAutor");
					String nombreAutor = resultadoAutors.getString("nombreAutor");
					Autor usuario = new Autor(idAutor, nombreAutor);
					listaAutor.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaAutor;
	}
        
        public ArrayList<Autor> getListaNombreAutor(String texto) {
		listaAutor.clear();
		ResultSet resultadoAutors = Conexion.getInstancia().hacerConsulta("SELECT * FROM Autor WHERE nombreAutor LIKE '%" + texto + "%'");
		if (resultadoAutors != null) {
			try {
				while (resultadoAutors.next()) {
					int idAutor = resultadoAutors.getInt("idAutor");
					String nombreAutor = resultadoAutors.getString("nombreAutor");
					Autor usuario = new Autor(idAutor, nombreAutor);
					listaAutor.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaAutor;
	}
        
        

	public void desautenticarAutor() {
		this.autor = null;
	}
	
	public void agregarAutor(Autor usuario) {
		String nick = usuario.getNombreAutor(); 
		Conexion.getInstancia().ejecutarConsulta("EXEC CrearAutor " + nick);
	}
	
	public void editarAutor(int id, String nickUsuario) {
		Conexion.getInstancia().ejecutarConsulta("EXEC ModificarAutor '" + nickUsuario + "' ," + id + "");
	}

	public void eliminarAutor(int id) {
		Conexion.getInstancia().ejecutarConsulta("EXEC EliminarAutor " + id);  
		}
}


    
    
   
