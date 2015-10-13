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
import BibliotecaFX.models.Libro;


/**
 *
 * @author rjavi
 */
public class LibroController {
   
	private Libro libro = null;
	private ArrayList<Libro> listaLibro;
        private ArrayList<String> listaNombreLibro;
	private static LibroController instancia;
	
	private LibroController() {
		listaLibro = new ArrayList<Libro>();
                listaNombreLibro = new ArrayList<String>();
	}
	
	public static LibroController getInstancia() {
		if (instancia == null) {
			instancia = new LibroController();
		}
		return instancia;
	}
	
	public Libro getLibro() {
		return libro;
	}
        
        
        public ArrayList<String> getListaNombreLibro() {
		listaNombreLibro.clear();
		ResultSet resultadoLibros = Conexion.getInstancia().hacerConsulta("SELECT Nombre FROM VistaLibro WHERE disponible = '1'");
		if (resultadoLibros != null) {
			try {
				while (resultadoLibros.next()) {
					String nombreLibro = resultadoLibros.getString("Nombre");
					String autor = new String(nombreLibro);;
					listaNombreLibro.add(autor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
		return listaNombreLibro;
	}
        
        
        public int devolverIdLibro(String var0) {
		int variableRetorno = -1;
		if (1 == listaLibro.size()) {
			//int var1 = Integer.parseInt(var0);
				if (listaLibro.get(0).getNombre().equalsIgnoreCase(var0)) {
				variableRetorno = listaLibro.get(0).getIdLibro();
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaLibro.size()) {
			//int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaLibro.size(); numerillo++) {
				if (listaLibro.get(numerillo).getNombre().equalsIgnoreCase(var0)) {
					variableRetorno = listaLibro.get(numerillo).getIdLibro();
				
                } else {
					//No hay ninguna coincidencia;
				}
			}
		} else {
			//No hay nada ingresado;
		}
		return variableRetorno;
	}
        
        
        
        public String mostrarNombreLibro(int var0) {
            int numerillo;
            String var1 = null; 
            for(numerillo = 0; numerillo < listaLibro.size(); numerillo++) {
                if (listaLibro.get(numerillo).getIdLibro() == var0) {
                    var1 = listaLibro.get(numerillo).getNombre();
                }
            }
            return var1;
	}
        
        
        
        
	public ArrayList<Libro> getListaLibro() {
		listaLibro.clear();
		ResultSet resultadoLibros = Conexion.getInstancia().hacerConsulta("SELECT * FROM VistaLibro");
		if (resultadoLibros != null) {
			try {
				while (resultadoLibros.next()) {
					int idLibro = resultadoLibros.getInt("idLibro");
                                        String isbnLibro = resultadoLibros.getString("isbn");
					String nombreLibro = resultadoLibros.getString("Nombre");
                                        String editorialLibro = resultadoLibros.getString("Editorial");
                                        int paginasLibro = resultadoLibros.getInt("paginas");
					Libro libro = new Libro(idLibro, isbnLibro, nombreLibro , editorialLibro, paginasLibro);
					listaLibro.add(libro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaLibro;
	}
        
        
        public ArrayList<Libro> getListaIdLibro(String texto) {
		listaLibro.clear();
		ResultSet resultadoLibros = Conexion.getInstancia().hacerConsulta("SELECT * FROM VistaLibro WHERE isbn LIKE '%" + texto + "%'");
		if (resultadoLibros != null) {
			try {
				while (resultadoLibros.next()) {
					int idLibro = resultadoLibros.getInt("idLibro");
                                        String isbnLibro = resultadoLibros.getString("isbn");
					String nombreLibro = resultadoLibros.getString("Nombre");
                                        String editorialLibro = resultadoLibros.getString("Editorial");
                                        int paginasLibro = resultadoLibros.getInt("paginas");
					Libro libro = new Libro(idLibro, isbnLibro, nombreLibro , editorialLibro, paginasLibro);
					listaLibro.add(libro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaLibro;
	}
        
        public ArrayList<Libro> getListaNombreLibro(String texto) {
		listaLibro.clear();
		ResultSet resultadoLibros = Conexion.getInstancia().hacerConsulta("SELECT * FROM VistaLibro WHERE Nombre LIKE '%" + texto + "%'");
		if (resultadoLibros != null) {
			try {
				while (resultadoLibros.next()) {
					int idLibro = resultadoLibros.getInt("idLibro");
                                        String isbnLibro = resultadoLibros.getString("isbn");
					String nombreLibro = resultadoLibros.getString("Nombre");
                                        String editorialLibro = resultadoLibros.getString("Editorial");
                                        int paginasLibro = resultadoLibros.getInt("paginas");
					Libro libro = new Libro(idLibro, isbnLibro, nombreLibro , editorialLibro, paginasLibro);
					listaLibro.add(libro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaLibro;
	}
        
        
        
        

	public void desautenticarLibro() {
		this.libro = null;
	}
	
	public void agregarLibro(Libro libro) {
		Conexion.getInstancia().ejecutarConsulta("EXEC CrearLibro '" + libro.getNombre() + "', '" + libro.getIsbnLibro() + "', "  + EditorialController.getInstancia().devolverIdEditorial(libro.getEditorial()) + ", " + libro.getPaginas());
	}
	
	public void editarLibro(int id, String a, String c, String d, int f) {
		Conexion.getInstancia().ejecutarConsulta("EXEC ModificarLibro " + id + " ,'" + a + "' ,'" + c + "' ,'" + d + "','" + "' ," + f);
	}

	public void eliminarLibro(int id) {
		Conexion.getInstancia().ejecutarConsulta("EXEC EliminarLibro " + id);  
		}
}


    
    
   
