/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.controllers;

import BibliotecaFX.MainApp;
import BibliotecaFX.models.Autor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author informatica
 */
public class AutorController implements Initializable {

    @FXML
    private TableView<Autor> tbvAutores;
    @FXML
    private TableColumn<Autor, String> tbcID;
    @FXML
    private TableColumn<Autor, String> tbcNombre;
    
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvAutores.setItems(mainApp.getAutoresList());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tbcID.setCellValueFactory(new PropertyValueFactory<Autor, String>("codigo"));
        tbcNombre.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombre"));
        
        tbvAutores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }    
}