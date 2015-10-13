/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX.controllers;

import BibliotecaFX.MainApp;
import BibliotecaFX.models.Usuario;
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
public class UsuarioController implements Initializable {

    @FXML
    private TableView<Usuario> tbvUsuarios;
    @FXML
    private TableColumn<Usuario, String> tbcID;
    @FXML
    private TableColumn<Usuario, String> tbcNombre;
    @FXML
    private TableColumn<Usuario, String> tbcApellido;
    
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvUsuarios.setItems(mainApp.getUsuariosList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
