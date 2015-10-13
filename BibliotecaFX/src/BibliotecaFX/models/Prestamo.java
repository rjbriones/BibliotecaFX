/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.models;

import java.text.SimpleDateFormat;

/**
 *
 * @author Marco
 */
public class Prestamo {
    SimpleDateFormat simpledf = new SimpleDateFormat("yyyy MMM dd");	
	
	private String idPrestamo;
	private String idLibro;
	private String fechaInicio;
	private String fechaFin;
	private String fechaEntrega = null;
	private boolean devuelto = false;
	
	public Prestamo(String r0, String r1, String r2, String r3, boolean r4) {
		idPrestamo = r0;
		idLibro = r1;
		fechaInicio = r2;
		fechaFin = r3;
                devuelto = r4;
	}

	public void setIdPrestamo(String valor) {
		idPrestamo = valor;
	}
	
	
	public void setIdLibro(String valor) {
		idLibro = valor;
	}
	
	public void setFechaInicio(String valor) {
		fechaInicio = valor;
	}
	
	public void setFechaFin(String valor) {
		fechaFin = valor;
	}
	
	public void setFechaEntrega(String valor) {
		fechaEntrega = valor;
	}
	
	public void setDevolucion(boolean valor) {
		devuelto = valor;
	}
	
	//GET
	public String getIdPrestamo() {
		return idPrestamo;
	}
	
	
	public String getIdLibro() {
		return idLibro;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	
	public boolean getDevolucion() {
		return devuelto;
	}
	
	
	
}