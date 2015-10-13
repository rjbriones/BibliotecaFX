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
 * @author rjavi
 */
public class Autor {
    private String nombre;

    public Autor(String nombre) {
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
    
    
    public static ObservableList<Autor> getAutoresList(){
        ObservableList<Autor> autores = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM autor";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Autor autor = new Autor();
                
                autor.setNombre(rs.getString("nombre"));
                
                autores.add(autor);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error obtener la lista de autores", e);
            error.showAndWait();
        }
        
        return autores;
    }
}