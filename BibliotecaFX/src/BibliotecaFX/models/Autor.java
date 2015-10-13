/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.models;

/**
 *
 * @author rjavi
 */
public class Autor {
        private int idAutor;
	private String nombre;
		
	public Autor(int var1, String var2) {
		nombre = var2;
		idAutor = var1;
	}
	

	//Get y Set
	//SET
	public void setIdAutor(int valor) {
		idAutor = valor;
	}
	
	public void setNombreAutor(String valor) {
		nombre = valor;
	}

	//GET
	public int getIdAutor() {
		return idAutor;
	}
	
	public String getNombreAutor() {
		return nombre;
	}
}