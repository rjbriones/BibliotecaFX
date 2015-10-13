/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.models;

import BibliotecaFX.helpers.DBHelper;
import BibliotecaFX.helpers.Dialogs;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author angelchanquin
 */
public class Libro{
    
    private String titulo;
    private String isbn;
    private String editorial;
    private String paginas;

    public Libro(String titulo, String isbn, String editorial, String paginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }
    
    public static ObservableList<Libro> getLibrosList(){
        ObservableList<Libro> libros = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM libro";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Libro libro = new Libro();
                
                libro.setTitulo(rs.getString("titulo"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setPaginas(rs.getString("direccion"));
                
                libros.add(libro);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error obtener la lista de libros", e);
            error.showAndWait();
        }
        
        return libros;
    }
}
