/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaFX;
import BibliotecaFX.controllers.AutorController;
import BibliotecaFX.controllers.EjemplarController;
import BibliotecaFX.controllers.LibroController;
import BibliotecaFX.controllers.RootLayoutController;
import BibliotecaFX.controllers.UsuarioController;
import BibliotecaFX.helpers.Dialogs;
import BibliotecaFX.models.Autor;
import BibliotecaFX.models.Ejemplar;
import BibliotecaFX.models.Libro;
import BibliotecaFX.models.Usuario;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author angelchanquin
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Libro> librosList = FXCollections.observableArrayList();
    private ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();
    private ObservableList<Autor>  autoresList = FXCollections.observableArrayList();
    private ObservableList<Ejemplar> ejemplaresList = FXCollections.observableArrayList();
    
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
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }        
        this.librosList = Libro.getLibrosList();
    }

    public void mostrarVistaLibros(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Libros.fxml"));
            AnchorPane librosPane = (AnchorPane) loader.load();
            LibroController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(librosPane);

        } catch (Exception e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }

    }
    
    public void mostrarVistaUsuarios(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Usuario.fxml"));
            AnchorPane instructoresPane = (AnchorPane) loader.load();
            UsuarioController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(instructoresPane);

        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }

    }
    
    public void mostrarVistaAutores(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Autor.fxml"));
            AnchorPane instructoresPane = (AnchorPane) loader.load();
            AutorController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(instructoresPane);

        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }

    }
    
    public void mostrarVistaEjemplares(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Ejemplar.fxml"));
            AnchorPane instructoresPane = (AnchorPane) loader.load();
            EjemplarController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(instructoresPane);

        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca", null, "Error al cargar el archivo FXML", e);
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
    
    public ObservableList<Autor> getAutoresList() {
        return autoresList;
    } 
        
    public ObservableList<Usuario> getUsuariosList() {
        return usuariosList;
    } 
            
    public ObservableList<Ejemplar> getEjemplaresList() {
        return ejemplaresList;
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}