/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.controllers;

import BibliotecaFX.MainApp;
import BibliotecaFX.models.Libro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author informatica
 */
public class LibroController implements Initializable {

    @FXML
    private TableView<Libro> tbvLibros;
    @FXML
    private TableColumn<Libro, String> tbcID;
    @FXML
    private TableColumn<Libro, String> tbcTitulo;
    
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvLibros.setItems(mainApp.getLibrosList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
