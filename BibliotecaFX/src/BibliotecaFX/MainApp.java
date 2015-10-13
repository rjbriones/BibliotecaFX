/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX;
import bibliotecafx.controllers.AutorController;
import bibliotecafx.controllers.LibroController;
import bibliotecafx.controllers.RootLayoutController;
import bibliotecafx.helpers.DBHelper;
import bibliotecafx.helpers.Dialogs;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author angelchanquin
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Libro> librosList = FXCollections.observableArrayList();
    private Usuario usuarioAutenticado;
    public enum CRUDOperation {None, Create, Read, Update, Delete};
    
    public MainApp(){
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Biblioteca");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
       // mostrarLogin();
        
        this.librosList = Libro.getLibrosList();
    }
    
    private void mostrarLogin(){
        boolean loginExitoso = false;
        do{
            Dialog login = Dialogs.getLoginDialog();
            Optional<Usuario> result = login.showAndWait();
            if(result.equals(Optional.empty())){
                System.exit(0);
            }else if(result.isPresent()){                
                usuarioAutenticado = result.get();
                if(usuarioAutenticado.getPassword().length() > 0){
                    DBHelper.setMainApp(this);
                    try {
                        if(!DBHelper.getConnection().isClosed()){
                            loginExitoso = true;
                            Alert welcome = Dialogs.getDialog(Alert.AlertType.INFORMATION, "CET Kinal", null, "Bienvenido al sistema " + usuarioAutenticado.getUser());
                            welcome.showAndWait();
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Error al establecer una conexion a la base de datos", ex);
                        error.showAndWait();
                    }
                }
                else{
                    Alert error = Dialogs.getDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Datos incorrectos, debe ingresar una contraseña");
                    error.showAndWait();
                }
            }
        }while(loginExitoso == false);
        
    }

    public void mostrarVistaLibros(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Libros.fxml"));
            AnchorPane librosPane = (AnchorPane) loader.load();
            LibrosController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(librosPane);

        } catch (Exception e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }

    }
    
    public void mostrarVistaInstructores(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Instructores.fxml"));
            AnchorPane instructoresPane = (AnchorPane) loader.load();
            InstructoresController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(instructoresPane);

        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Libro> getLibrosList() {
        return librosList;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}