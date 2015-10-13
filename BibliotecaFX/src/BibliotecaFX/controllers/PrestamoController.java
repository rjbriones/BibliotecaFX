/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import BibliotecaFX.models.Prestamo;
import BibliotecaFX.helpers.Conexion;


/**
 *
 * @author Marco
 */
public class PrestamoController {
   
	private Prestamo alumno = null;
	private ArrayList<Prestamo> listaPrestamo;
	private static PrestamoController instancia;
        private ArrayList<String> listaNombrePrestamo;
	
	private PrestamoController() {
		listaPrestamo = new ArrayList<Prestamo>();
                listaNombrePrestamo = new ArrayList<String>();
	}
	
	public static PrestamoController getInstancia() {
		if (instancia == null) {
			instancia = new PrestamoController();
		}
		return instancia;
	}
	
	public Prestamo getPrestamo() {
		return alumno;
	}
        
     
	public ArrayList<Prestamo> getListaPrestamo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
                listaPrestamo.clear();
		ResultSet resultadoPrestamos = Conexion.getInstancia().hacerConsulta("SELECT * FROM VistaPrestamo");
		if (resultadoPrestamos != null) {
			try {
				while (resultadoPrestamos.next()) {
					int idPrestamo = resultadoPrestamos.getInt("idPrestamo");
                                        int idLibro = resultadoPrestamos.getInt("idLibro");
					String nombreLibro = resultadoPrestamos.getString("Libro");
                                        String fechaPrestamo = resultadoPrestamos.getString("fechaPrestamo");
                                        String fechaEntrega = resultadoPrestamos.getString("fechaEntrega");
                                        String fechaDevolucion = resultadoPrestamos.getString("fechaDevolucion");
                                        boolean entrega = resultadoPrestamos.getBoolean("entrega");
					Prestamo usuario = new Prestamo(idPrestamo, nombreLibro, fechaPrestamo, fechaDevolucion, entrega);
					listaPrestamo.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaPrestamo;
	}

	public ArrayList<Prestamo> getListaIdPrestamo(String texto) {
		listaPrestamo.clear();
		ResultSet resultadoPrestamos = Conexion.getInstancia().hacerConsulta("SELECT * FROM VistaPrestamo WHERE idPrestamo = '" + texto + "'");
		if (resultadoPrestamos != null) {
			try {
				while (resultadoPrestamos.next()) {
					int idPrestamo = resultadoPrestamos.getInt("idPrestamo");
                                        int idLibro = resultadoPrestamos.getInt("idLibro");
					String nombreLibro = resultadoPrestamos.getString("Libro");
                                        String fechaPrestamo = resultadoPrestamos.getString("fechaPrestamo");
                                        String fechaEntrega = resultadoPrestamos.getString("fechaEntrega");
                                        String fechaDevolucion = resultadoPrestamos.getString("fechaDevolucion");
                                        boolean entrega = resultadoPrestamos.getBoolean("entrega");
					Prestamo usuario = new Prestamo(idPrestamo, nombreLibro, fechaPrestamo, fechaDevolucion, entrega);
					listaPrestamo.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaPrestamo;
	}
        
        public ArrayList<Prestamo> getListaNombrePrestamo(String texto) {
		listaPrestamo.clear();
		ResultSet resultadoPrestamos = Conexion.getInstancia().hacerConsulta("SELECT * FROM VistaPrestamo WHERE Libro LIKE '%" + texto + "%'");
		if (resultadoPrestamos != null) {
			try {
				while (resultadoPrestamos.next()) {
					int idPrestamo = resultadoPrestamos.getInt("idPrestamo");
                                        int idLibro = resultadoPrestamos.getInt("idLibro");
					String nombreLibro = resultadoPrestamos.getString("Libro");
                                        String fechaPrestamo = resultadoPrestamos.getString("fechaPrestamo");
                                        String fechaEntrega = resultadoPrestamos.getString("fechaEntrega");
                                        String fechaDevolucion = resultadoPrestamos.getString("fechaDevolucion");
                                        boolean entrega = resultadoPrestamos.getBoolean("entrega");
					Prestamo usuario = new Prestamo(idPrestamo, nombreLibro, fechaPrestamo, fechaDevolucion, entrega);
					listaPrestamo.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaPrestamo;
	}
        
        
        
        public void desautenticarPrestamo() {
		this.alumno = null;
	}
	
	public void agregarPrestamo(Prestamo usuario) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
                String idLibro = usuario.getIdLibro();
                String fechaPrestamo = sdf.format(new Date());
                String fechaFin = usuario.getFechaFin();
		Conexion.getInstancia().ejecutarConsulta("EXEC CrearPrestamo " + LibroController.getInstancia().devolverIdLibro(idLibro) + ", " + fechaPrestamo + "', '" + fechaFin + "'");
	}
	
	public void devolverPrestamo(int idPrestamo, int id) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
		Conexion.getInstancia().ejecutarConsulta("EXEC DevolverLibro " + idPrestamo + ", " +id + " ,'" + sdf.format(new Date()) + "'");
	}

	public void eliminarPrestamo(int id) {
		//Conexion.getInstancia().ejecutarConsulta("EXEC EliminarPrestamo " + id);  
		}
}


    
    
   
