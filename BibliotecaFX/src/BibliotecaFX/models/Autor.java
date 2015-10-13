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
 * @author rjavi
 */
public class Autor { 
    private String codigo;
    private String nombre;

    public Autor(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Autor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
       
    
    public static ObservableList<Autor> getAutoresList(){
        ObservableList<Autor> autores = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM autor";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Autor autor = new Autor();
                
                autor.setCodigo(rs.getString("codigo"));
                autor.setNombre(rs.getString("nombre"));
                
                autores.add(autor);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error obtener la lista de autores", e);
            error.showAndWait();
        }
        
        return autores;
    }
    
    public static boolean insertarAutor(Autor nuevoAutor){
        
        String insertSQL =  "INSERT INTO autor (codigo, nombre) "
                + "VALUES (?, ?)";
        try{
            PreparedStatement insertStatement = DBHelper.getConnection().prepareStatement(insertSQL);
            
            insertStatement.setString(1, nuevoAutor.getCodigo());
            insertStatement.setString(2, nuevoAutor.getNombre());
           
            insertStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cisne Negro", null, "Error al insertar autor", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
    
    public static boolean editarAutor(Autor nuevoAutor){
        String updateSQL = "UPDATE autor"
                + " SET nombre = ?"
                + " WHERE codigo = ?";
        
        try{
            PreparedStatement updateStatement = DBHelper.getConnection().prepareStatement(updateSQL);
            
            updateStatement.setString(1, nuevoAutor.getCodigo());
            updateStatement.setString(2, nuevoAutor.getNombre());
            
            updateStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cisne Negro", null, "Error al actualizar autor", ex);
            error.showAndWait();
            return false;
        }
        
        return true;
    }
    
    public static boolean eliminarAutor(Autor autor){
        String deleteSQL = "DELETE FROM autor "
                + "WHERE codigo = ?";
        try{
            PreparedStatement deleteStatement = DBHelper.getConnection().prepareStatement(deleteSQL);
            deleteStatement.setString(1, autor.getCodigo());
            
            deleteStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cisne Negro", null, "Error al eliminar un autor", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
}