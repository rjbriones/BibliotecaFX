/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.views;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author rjavi
 */
public class Principal extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Ventana.ventana(primaryStage, 3);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
