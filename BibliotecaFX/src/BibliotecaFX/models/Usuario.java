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
public class Usuario {
        private int idUsuario;
	private String nombre;
		
	public Usuario(int r1, String r2) {
		nombre = r2;
		idUsuario = r1;
	}
	
	public void setIdUsuario(int valor) {
		idUsuario = valor;
	}
	
	public void setNombreUsuario(String valor) {
		nombre = valor;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getNombreUsuario() {
		return nombre;
	}

}