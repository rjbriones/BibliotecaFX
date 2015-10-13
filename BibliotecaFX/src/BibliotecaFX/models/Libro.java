/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.models;

import BibliotecaFX.helpers.DBHelper;
import BibliotecaFX.helpers.Dialogs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author angelchanquin
 */
public class Libro{
    
    private String codigo;
    private String titulo;
    private String isbn;
    private String editorial;
    private String paginas;

    public Libro(String codigo, String titulo, String isbn, String editorial, String paginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
    }

    public Libro() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
                
                libro.setCodigo(rs.getString("codigo"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setPaginas(rs.getString("paginas"));
                
                libros.add(libro);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error obtener la lista de libros", e);
            error.showAndWait();
        }
        
        return libros;
    }
    
        public static boolean insertarLibro(Libro nuevoLibro){
        
        String insertSQL =  "INSERT INTO libro (codigo, titulo, isbn, editorial, direccion) "
                + "VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement insertStatement = DBHelper.getConnection().prepareStatement(insertSQL);
            
            insertStatement.setString(1, nuevoLibro.getCodigo());
            insertStatement.setString(2, nuevoLibro.getTitulo());
            insertStatement.setString(2, nuevoLibro.getIsbn());
            insertStatement.setString(2, nuevoLibro.getEditorial());
            insertStatement.setString(2, nuevoLibro.getPaginas());
           
            insertStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al insertar libro", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
    
    public static boolean editarLibro(Libro nuevoLibro){
        String updateSQL = "UPDATE libro"
                + " SET titulo = ?, isbn = ?, editorial = ?, paginas = ? "
                + " WHERE codigo = ?";
        
        try{
            PreparedStatement updateStatement = DBHelper.getConnection().prepareStatement(updateSQL);
            
            updateStatement.setString(1, nuevoLibro.getCodigo());
            updateStatement.setString(2, nuevoLibro.getTitulo());
            updateStatement.setString(2, nuevoLibro.getIsbn());
            updateStatement.setString(2, nuevoLibro.getEditorial());
            updateStatement.setString(2, nuevoLibro.getPaginas());
            
            updateStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al actualizar libros", ex);
            error.showAndWait();
            return false;
        }
        
        return true;
    }
    
    public static boolean eliminarLibro(Libro libro){
        String deleteSQL = "DELETE FROM libro "
                + "WHERE codigo = ?";
        try{
            PreparedStatement deleteStatement = DBHelper.getConnection().prepareStatement(deleteSQL);
            deleteStatement.setString(1, libro.getCodigo());
            
            deleteStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al eliminar un libro", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
}
