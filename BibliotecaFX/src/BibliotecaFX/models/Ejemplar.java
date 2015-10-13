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
public class Ejemplar {
    private String codigo;
    private String codigoLibro;
    private String localizacion;

    public Ejemplar(String codigo, String codigoLibro, String localizacion) {
        this.codigo = codigo;
        this.codigoLibro = codigoLibro;
        this.localizacion = localizacion;
    }

    public Ejemplar() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
    public static ObservableList<Ejemplar> getEjemplarList(){
        ObservableList<Ejemplar> ejemplares = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM ejemplar";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Ejemplar ejemplar = new Ejemplar();
                
                ejemplar.setCodigo(rs.getString("codigo"));
                ejemplar.setCodigoLibro(rs.getString("codigoLibro"));
                ejemplar.setLocalizacion(rs.getString("localizacion"));

                
                ejemplares.add(ejemplar);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error obtener la lista de ejemplares", e);
            error.showAndWait();
        }
        
        return ejemplares;
    }
    
        public static boolean insertarEjemplar(Ejemplar nuevoEjemplar){
        
        String insertSQL =  "INSERT INTO ejemplar (codigo, codigoLibro, nombre) "
                + "VALUES (?, ?, ?)";
        try{
            PreparedStatement insertStatement = DBHelper.getConnection().prepareStatement(insertSQL);
            
            insertStatement.setString(1, nuevoEjemplar.getCodigo());
            insertStatement.setString(2, nuevoEjemplar.getCodigoLibro());
            insertStatement.setString(2, nuevoEjemplar.getLocalizacion());
           
            insertStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cisne Negro", null, "Error al insertar ejemplar", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
    
    public static boolean editarEjemplar(Ejemplar nuevoEjemplar){
        String updateSQL = "UPDATE ejemplar"
                + " SET codigoLibro = ?, localizacion = ?"
                + " WHERE codigo = ?";
        
        try{
            PreparedStatement updateStatement = DBHelper.getConnection().prepareStatement(updateSQL);
            
            updateStatement.setString(1, nuevoEjemplar.getCodigo());
            updateStatement.setString(2, nuevoEjemplar.getCodigoLibro());
            updateStatement.setString(2, nuevoEjemplar.getLocalizacion());
            
            
            updateStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cisne Negro", null, "Error al actualizar Ejemplar", ex);
            error.showAndWait();
            return false;
        }
        
        return true;
    }
    
    public static boolean eliminarEjemplar(Ejemplar ejemplar){
        String deleteSQL = "DELETE FROM ejemplar "
                + "WHERE codigo = ?";
        try{
            PreparedStatement deleteStatement = DBHelper.getConnection().prepareStatement(deleteSQL);
            deleteStatement.setString(1, ejemplar.getCodigo());
            
            deleteStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Cisne Negro", null, "Error al eliminar un ejemplar", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
}
