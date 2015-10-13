/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.controllers;

import BibliotecaFX.MainApp;
import BibliotecaFX.models.Ejemplar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author rjavi
 */
public class EjemplarController implements Initializable {

    @FXML
    private TableView<Ejemplar> tbvEjemplares;
    @FXML
    private TableColumn<Ejemplar, String> tbcID;
    
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvEjemplares.setItems(mainApp.getEjemplaresList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
