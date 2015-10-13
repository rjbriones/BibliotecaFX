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
public class Ejemplar {
    private String localizacion;

    public Ejemplar(String localizacion) {
        this.localizacion = localizacion;
    }

    public Ejemplar() {
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
                
                ejemplar.setLocalizacion(rs.getString("localizacion"));

                
                ejemplares.add(ejemplar);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error obtener la lista de ejemplares", e);
            error.showAndWait();
        }
        
        return ejemplares;
    }
}
