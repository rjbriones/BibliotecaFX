/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.controllers;

import BibliotecaFX.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
/**
 *
 * @author informatica
 */
public class RootLayoutController implements Initializable {
    
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void usuariosView(){
        this.mainApp.mostrarVistaUsuarios();
    }
    
    @FXML
    private void librosView(){
        this.mainApp.mostrarVistaLibros();
    }
    
    @FXML
    private void autoresView(){
        this.mainApp.mostrarVistaAutores();
    }
    
    @FXML
    private void ejemplaresView(){
        this.mainApp.mostrarVistaEjemplares();
    }
}
