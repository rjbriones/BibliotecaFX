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
public class Libro{
    
   private int idLibro;
	private String isbn;
	private String nombre;
	private String editorial;
	private int paginas;	
	private boolean disponible = true;
	
	public Libro(int variable0, String value, String bookName, String editorialName, int page) {
		idLibro = variable0;
		isbn = value;
		nombre = bookName;
		editorial = editorialName;
		paginas = page;
	}
	
	public void setIdLibro(int valor) {
		idLibro = valor;
	}
	
	public void setNombre(String valor) {
		nombre = valor;
	}
	
	public void setIsbnLibro(String valor) {
		isbn = valor;
	}
	

	
	public void setEditorial(String valor) {
		editorial = valor;
	}
	
	
	public void setPaginas(int valor) {
		paginas = valor;
	}
	
	public void setDisponible(boolean valor) {
		disponible = valor;
	}
	
	public int getIdLibro() {
		return idLibro;
	}
	
	public String getIsbnLibro() {
		return isbn;
	}
	
	public String getNombre() {
		return nombre;
	}

	
	public String getEditorial() {
		return editorial;
	}
	
	
	public int getPaginas() {
		return paginas;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
}
