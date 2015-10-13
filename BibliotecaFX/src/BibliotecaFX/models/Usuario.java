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
public class Usuario {
    protected String codigo;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String direccion;

    public Usuario(String codigo, String nombre, String apellido, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public Usuario(){
        
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public static ObservableList<Usuario> getUsuariosList(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setCodigo(rs.getString("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                
                usuarios.add(usuario);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al obtener la lista de usuarios", e);
            error.showAndWait();
        }
        
        return usuarios;
    }
    
    public static boolean insertarUsuario(Usuario nuevoUsuario){
        
        String insertSQL =  "INSERT INTO usuario (codigo, nombre, apellido, telefono, direccion) "
                + "VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement insertStatement = DBHelper.getConnection().prepareStatement(insertSQL);
            
            insertStatement.setString(1, nuevoUsuario.getCodigo());
            insertStatement.setString(2, nuevoUsuario.getNombre());
            insertStatement.setString(2, nuevoUsuario.getApellido());
            insertStatement.setString(2, nuevoUsuario.getTelefono());
            insertStatement.setString(2, nuevoUsuario.getDireccion());
           
            insertStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al insertar usuario", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
    
    public static boolean editarUsuario(Usuario nuevoUsuario){
        String updateSQL = "UPDATE usuario"
                + " SET nombre = ?, apellido = ?, telefono = ?, direccion = ?"
                + " WHERE codigo = ?";
        
        try{
            PreparedStatement updateStatement = DBHelper.getConnection().prepareStatement(updateSQL);
            
            updateStatement.setString(1, nuevoUsuario.getCodigo());
            updateStatement.setString(2, nuevoUsuario.getNombre());
            updateStatement.setString(2, nuevoUsuario.getApellido());
            updateStatement.setString(2, nuevoUsuario.getTelefono());
            updateStatement.setString(2, nuevoUsuario.getDireccion());
            
            updateStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al actualizar usuarios", ex);
            error.showAndWait();
            return false;
        }
        
        return true;
    }
    
    public static boolean eliminarUsuario(Usuario usuario){
        String deleteSQL = "DELETE FROM usuario "
                + "WHERE codigo = ?";
        try{
            PreparedStatement deleteStatement = DBHelper.getConnection().prepareStatement(deleteSQL);
            deleteStatement.setString(1, usuario.getCodigo());
            
            deleteStatement.executeUpdate();
            
        }catch( SQLException | ClassNotFoundException ex){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al eliminar un usuario", ex);
            error.showAndWait();
            return false;
        }
        return true;
    }
}