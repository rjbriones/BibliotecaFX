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
import BibliotecaFX.models.Editorial;


/**
 *
 * @author rjavi
 */
public class EditorialController {
   
	private Editorial editorial = null;
	private ArrayList<Editorial> listaEditorial;
        private ArrayList<String> listaNombreEditorial;
	private static EditorialController instancia;
	
	private EditorialController() {
		listaEditorial = new ArrayList<Editorial>();
                listaNombreEditorial = new ArrayList<String>();
	}
	
	public static EditorialController getInstancia() {
		if (instancia == null) {
			instancia = new EditorialController();
		}
		return instancia;
	}
	
	public Editorial getEditorial() {
		return editorial;
	}
        
        public ArrayList<String> getListaNombreEditorial() {
		listaNombreEditorial.clear();
		ResultSet resultadoEditoriales = Conexion.getInstancia().hacerConsulta("SELECT * FROM Editorial");
		if (resultadoEditoriales != null) {
			try {
				while (resultadoEditoriales.next()) {
					int idEditorial = resultadoEditoriales.getInt("idEditorial");
					String nombreEditorial = resultadoEditoriales.getString("nombreEditorial");
					String autor = new String(nombreEditorial);
					listaNombreEditorial.add(autor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
		return listaNombreEditorial;
	}
        
        
        
        
        public int buscarIdEditorial(String var0) {
		int variableRetorno = -1;
		if (1 == listaEditorial.size()) {
			int var1 = Integer.parseInt(var0);
				if (listaEditorial.get(0).getIdEditorial() == var1) {
				variableRetorno = 0;
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaEditorial.size()) {
			int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaEditorial.size(); numerillo++) {
				if (listaEditorial.get(numerillo).getIdEditorial() == var1) {
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
        
        
        public int devolverIdEditorial(String var0) {
		int variableRetorno = -1;
		if (1 == listaEditorial.size()) {
			//int var1 = Integer.parseInt(var0);
				if (listaEditorial.get(0).getNombreEditorial().equalsIgnoreCase(var0)) {
				variableRetorno = listaEditorial.get(0).getIdEditorial();
				} else {
				//No hay ninguna coincidencia
				}
		} else if (1 < listaEditorial.size()) {
			//int var1 = Integer.parseInt(var0);
			for(int numerillo=0; numerillo < listaEditorial.size(); numerillo++) {
				if (listaEditorial.get(numerillo).getNombreEditorial().equalsIgnoreCase(var0)) {
					variableRetorno = listaEditorial.get(numerillo).getIdEditorial();
				
                } else {
					//No hay ninguna coincidencia;
				}
			}
		} else {
			//No hay nada ingresado;
		}
		return variableRetorno;
	}
        
        
        
	public ArrayList<Editorial> getListaEditorial() {
		listaEditorial.clear();
		ResultSet resultadoEditoriales = Conexion.getInstancia().hacerConsulta("SELECT * FROM Editorial");
		if (resultadoEditoriales != null) {
			try {
				while (resultadoEditoriales.next()) {
					int idEditorial = resultadoEditoriales.getInt("idEditorial");
					String nombreEditorial = resultadoEditoriales.getString("nombreEditorial");
					Editorial editorial = new Editorial(idEditorial, nombreEditorial);
					listaEditorial.add(editorial);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEditorial;
	}
        
        public ArrayList<Editorial> getListaIdEditorial(String texto) {
		listaEditorial.clear();
		ResultSet resultadoEditorials = Conexion.getInstancia().hacerConsulta("SELECT * FROM Editorial WHERE idEditorial = '" + texto + "'");
		if (resultadoEditorials != null) {
			try {
				while (resultadoEditorials.next()) {
					int idEditorial = resultadoEditorials.getInt("idEditorial");
					String nombreEditorial = resultadoEditorials.getString("nombreEditorial");
					Editorial usuario = new Editorial(idEditorial, nombreEditorial);
					listaEditorial.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEditorial;
	}
        
        public ArrayList<Editorial> getListaNombreEditorial(String texto) {
		listaEditorial.clear();
		ResultSet resultadoEditorials = Conexion.getInstancia().hacerConsulta("SELECT * FROM Editorial WHERE nombreEditorial LIKE '%" + texto + "%'");
		if (resultadoEditorials != null) {
			try {
				while (resultadoEditorials.next()) {
					int idEditorial = resultadoEditorials.getInt("idEditorial");
					String nombreEditorial = resultadoEditorials.getString("nombreEditorial");
					Editorial usuario = new Editorial(idEditorial, nombreEditorial);
					listaEditorial.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEditorial;
	}
        

	public void desautenticarEditorial() {
		this.editorial = null;
	}
	
	public void agregarEditorial(Editorial usuario) {
		String nick = usuario.getNombreEditorial(); 
		Conexion.getInstancia().ejecutarConsulta("EXEC CrearEditorial '" + nick + "'");
	}
	
	public void editarEditorial(int id, String nickEditorial) {
		Conexion.getInstancia().ejecutarConsulta("EXEC ModificarEditorial '" + nickEditorial + "' ," + id + "");
	}

	public void eliminarEditorial(int id) {
		Conexion.getInstancia().ejecutarConsulta("EXEC EliminarEditorial " + id);  
		}
}


    
    
   
