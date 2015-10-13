    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.BASELINE_CENTER;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import BibliotecaFX.models.Autor;
import BibliotecaFX.models.Editorial;
import BibliotecaFX.models.Libro;
import BibliotecaFX.models.Prestamo;
import BibliotecaFX.models.Usuario;
import BibliotecaFX.controllers.AutorController;
import BibliotecaFX.controllers.LibroController;
import BibliotecaFX.controllers.EditorialController;
import BibliotecaFX.controllers.PrestamoController;
import BibliotecaFX.controllers.UsuarioController;
/**
 *
 * @author rjavi
 */
public class Ventana {
    static ObservableList<Usuario> olUsuario;
    static TableView<Usuario> resultadosUsuario;

    static ObservableList<Autor> olAutor;
    static TableView<Autor> resultadosAutor;

    static TableView<Editorial> resultadosEditorial;
 
    static ObservableList<Editorial> olEditorial;
    static ObservableList<Libro> olLibro;
    static TableView<Libro> resultadosLibro;
    static ObservableList<Prestamo> olPrestamo;
    static TableView<Prestamo> resultadosPrestamo;
    
    public static boolean verificadorTextoNumero(String valor) {
		try {
			Integer.parseInt(valor);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}

    //@Override
    public static void ventana(Stage primaryStage, int valorDelRango) {
        StackPane root = new StackPane();
        Stage secondaryStage = new Stage();
        primaryStage.setMinWidth(435.00);
        primaryStage.setMaxWidth(435.00);
        primaryStage.setMinHeight(555.00);
        primaryStage.setMaxHeight(555.00);
        
        String modulo = "usuario";

        VBox cajaPrincipal = new VBox();
        HBox caja1 = new HBox(20);
        VBox caja2 = new VBox(10);
        VBox caja3 = new VBox(10);
        VBox caja4 = new VBox(10);
        HBox caja5 = new HBox();
        
        HBox caja6 = new HBox(25);
        HBox caja7 = new HBox(10);
        HBox caja8 = new HBox(40);
        HBox caja9 = new HBox(30);
        HBox caja10 = new HBox(25);
        HBox caja11 = new HBox(40);
        HBox caja12 = new HBox(33);
        HBox caja13 = new HBox(30);
        HBox caja14 = new HBox(10);
        HBox caja15 = new HBox(30);
        HBox caja16 = new HBox(33);
        HBox caja17 = new HBox(25);
        HBox cajaOK = new HBox();

        MenuBar menuBar = new MenuBar();
        Label title = new Label("Usuario");
        title.setFont(Font.font("Arial", 35));
        Label accion = new Label("");
        accion.setFont(Font.font("Arial", 32));
        
        Label lbNombre = new Label("Nombre:");
        Label lbNombreLibro = new Label("Nombre:");
        Label lbAutor = new Label("Autor:");
        Label lbGenero = new Label("Género:");
        Label lbEditorial = new Label("Editorial:");
        Label lbPrecio = new Label("Páginas:");
        Label lbIsbn = new Label("ISBN:");
        Label lbAlumno = new Label("Alumno:");
        Label lbDevolucion = new Label("Devolución:");
        Label lbEntrega = new Label("Entrega:");
        //Campos de texto
        TextField txtSearch = new TextField();
        TextField txtNombre = new TextField(); //General
        PasswordField txtPass = new PasswordField(); //Usuario
        ComboBox txtAutor = new ComboBox(FXCollections.observableArrayList(AutorController.getInstancia().getListaNombreAutor())); //Libro
        ComboBox txtEditorial = new ComboBox(FXCollections.observableArrayList(EditorialController.getInstancia().getListaNombreEditorial())); //Libro
        TextField txtPrecio = new TextField(); //Libro
        TextField txtIsbn = new TextField(); //Libro
        ComboBox txtLibroPrestado = new ComboBox(FXCollections.observableArrayList(LibroController.getInstancia().getListaNombreLibro())); //Prestamo
        TextField txtDevolucion = new TextField(); //Prestamo
        TextField txtEntrega = new TextField(); //Prestamo
        ComboBox<String> txtRango = new ComboBox();
        txtRango.getItems().addAll("Administrador", "Editor", "Visualizador");
        //Botones
        Button btnSearch = new Button("Buscar");
        btnSearch.setStyle("-fx-font: 14 arial; -fx-base: #f2e1bf;");
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setPrefSize(82.00, 40.00);
        btnAgregar.setStyle("-fx-font: 14 arial; -fx-base: #bfc3f2;");
        Button btnModificar = new Button("Modificar");
        btnModificar.setPrefSize(82.00, 40.00);
        btnModificar.setStyle("-fx-font: 14 arial; -fx-base: #f2f2bf;");
        Button btnBorrar = new Button("Borrar");
        btnBorrar.setPrefSize(82.00, 40.00);
        btnBorrar.setStyle("-fx-font: 14 arial; -fx-base: #f2bfbf;");
        Button btnOK = new Button("OK");
        btnOK.setPrefSize(80.00, 60.00);
        btnOK.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        
        olUsuario = FXCollections.observableArrayList(UsuarioController.getInstancia().getListaUsuario());
             

        olAutor = FXCollections.observableArrayList(AutorController.getInstancia().getListaAutor());
        olEditorial = FXCollections.observableArrayList(EditorialController.getInstancia().getListaEditorial());
        olLibro = FXCollections.observableArrayList(LibroController.getInstancia().getListaLibro());
        olPrestamo = FXCollections.observableArrayList(PrestamoController.getInstancia().getListaPrestamo());
        
        //Tablas
        //----------------------
        TableColumn<Usuario, Integer> tcIdUsuario = new TableColumn<>("ID");
        tcIdUsuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        
        TableColumn<Usuario,String> tcNombreUsuario = new TableColumn<>("Nombre");
        tcNombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
              
       
        TableColumn<Autor, Integer> tcIdAutor = new TableColumn<>("ID");
        tcIdAutor.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
        
        TableColumn<Autor,String> tcNombreAutor = new TableColumn<>("Nombre");
        tcNombreAutor.setCellValueFactory(new PropertyValueFactory<>("nombreAutor"));
        
        
        TableColumn<Editorial, Integer> tcIdEditorial = new TableColumn<>("ID");
        tcIdEditorial.setCellValueFactory(new PropertyValueFactory<>("idEditorial"));
        
        TableColumn<Editorial,String> tcNombreEditorial = new TableColumn<>("Nombre");
        tcNombreEditorial.setCellValueFactory(new PropertyValueFactory<>("nombreEditorial"));
        
        TableColumn<Libro, Integer> tcIdLibro = new TableColumn<>("ID");
        tcIdLibro.setCellValueFactory(new PropertyValueFactory<>("idLibro"));
        
        TableColumn<Libro,String> tcNombreLibro = new TableColumn<>("Nombre");
        tcNombreLibro.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        
        TableColumn<Libro, String> tcGeneroLibro = new TableColumn<>("Género");
        tcGeneroLibro.setCellValueFactory(new PropertyValueFactory<>("Genero"));
        
        TableColumn<Libro, String> tcEditorialLibro = new TableColumn<>("Editorial");
        tcEditorialLibro.setCellValueFactory(new PropertyValueFactory<>("Editorial"));
        
        TableColumn<Libro, Double> tcPrecio = new TableColumn<>("Páginas");
        tcPrecio.setCellValueFactory(new PropertyValueFactory<>("paginas"));
        
        TableColumn<Libro, String> tcIsbn = new TableColumn<>("ISBN");
        tcIsbn.setCellValueFactory(new PropertyValueFactory<>("isbnLibro"));
        
        TableColumn<Libro, String> tcAutorLibro = new TableColumn<>("Autor");
        tcAutorLibro.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        
        
        TableColumn<Prestamo, String> tcCarne = new TableColumn<>("Carné");
        tcCarne.setCellValueFactory(new PropertyValueFactory<>("Alumno"));
        
        TableColumn<Prestamo, String> tcLibroPrestamo = new TableColumn<>("Libro");
        tcLibroPrestamo.setCellValueFactory(new PropertyValueFactory<>("Libro"));
        
        TableColumn<Prestamo, Date> tcFechaPrestamo = new TableColumn<>("Fecha Préstamo");
        tcFechaPrestamo.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        
        TableColumn<Prestamo, Date> tcFechaDevolucion = new TableColumn<>("Fecha Devolución");
        tcFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        
        TableColumn<Prestamo, Date> tcFechaEntrega = new TableColumn<>("Fecha Entrega");
        tcFechaEntrega.setCellValueFactory(new PropertyValueFactory<>("fechaEntrega"));
        
        TableColumn<Prestamo, Boolean> tcEntrega = new TableColumn<>("Entrega");
        tcEntrega.setCellValueFactory(new PropertyValueFactory<>("entrega"));
        
        resultadosUsuario = new TableView(olUsuario);
        //resultadosUsuario.setItems(olUsuario);
        resultadosUsuario.getColumns().addAll(tcIdUsuario, tcNombreUsuario);
        /*
        TableView<Usuario> resultadosIdUsuario = new TableView();
        resultadosUsuario.setItems(olIdUsuario);
        resultadosUsuario.getColumns().addAll(tcIdIdUsuario, tcIdNombreUsuario, tcIdRangoUsuario, tcIdClaveUsuario);
        
        TableView<Usuario> resultadosNombreUsuario = new TableView();
        resultadosUsuario.setItems(olNombreUsuario);
        resultadosUsuario.getColumns().addAll(tcNombreIdUsuario, tcNombreNombreUsuario, tcNombreRangoUsuario, tcNombreClaveUsuario);
        */

        
        resultadosAutor = new TableView(olAutor);
        resultadosAutor.getColumns().addAll(tcIdAutor, tcNombreAutor);
        

        
        resultadosEditorial = new TableView(olEditorial);
        resultadosEditorial.getColumns().addAll(tcIdEditorial, tcNombreEditorial);
        
        resultadosLibro = new TableView(olLibro);
        resultadosLibro.getColumns().addAll(tcIdLibro, tcNombreLibro, tcIsbn, tcEditorialLibro, tcPrecio);
        
        resultadosPrestamo = new TableView(olPrestamo);
        resultadosPrestamo.getColumns().addAll(tcLibroPrestamo, tcFechaPrestamo, tcFechaDevolucion, tcFechaEntrega, tcEntrega);
        
        //final Label message = new Label("Ingresar usuario y contraseña:");
        //message.setTextFill(Color.rgb(21, 117, 84));
        //Button btn = new Button();
        //TextField txtUser = new TextField();
        //PasswordField txtPass = new PasswordField();
        //txtUser.setAlignment(CENTER);
        //txtUser.setPrefSize(80.00, 30.00);
        //txtPass.setAlignment(CENTER);
        //btn.setPrefSize(60.00, 40.00);
        //txtPass.setPrefSize(80.00, 30.00);
        //btn.setText("Login");
   
        Menu menuFile = new Menu("Programa");
        MenuItem menuClose = new MenuItem("Cerrar Programa");
        menuClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });

        menuFile.getItems().addAll(menuClose);
        
        Menu menuAyuda = new Menu("Ayuda");
        MenuItem menuFecha = new MenuItem("Formato de fecha: año-mes-día");
        menuAyuda.getItems().addAll(menuFecha);
        
        // --- Menu Ver
        Menu menuView = new Menu("Ver");
        MenuItem verUsuario = new MenuItem("Usuario");
        MenuItem verLibro = new MenuItem("Libros");
        MenuItem verEditorial = new MenuItem("Editoriales");
        MenuItem verAutores = new MenuItem("Autores");
        MenuItem verPrestamos = new MenuItem("Préstamos");
        if (valorDelRango == 3) {
            menuView.getItems().addAll(verUsuario, verLibro, verEditorial, verAutores, verPrestamos);
        }else if (valorDelRango == 2) {
            menuView.getItems().addAll( verLibro, verEditorial, verAutores, verPrestamos);
        } else {
            menuView.getItems().addAll(verLibro, verEditorial, verAutores, verPrestamos);
        }
        menuBar.getMenus().addAll(menuFile, menuView, menuAyuda);
        
        /*---------------Estructura cajas--------------------*/
        caja1.setAlignment(CENTER);
        caja2.setAlignment(CENTER);
        caja3.setAlignment(CENTER);
        caja4.setAlignment(CENTER);
        cajaOK.setAlignment(CENTER);
        
        cajaPrincipal.getChildren().add(menuBar);
        cajaPrincipal.getChildren().add(caja1);
        
        caja1.getChildren().add(caja2);
        if (valorDelRango > 1) {
        caja1.getChildren().add(caja3);
        }
        //caja1.getChildren().add(caja4);
        
        caja2.getChildren().add(title);
        caja2.getChildren().add(caja5);
        caja5.setAlignment(BASELINE_CENTER);
        caja5.getChildren().add(txtSearch);
        caja5.getChildren().add(btnSearch);
        caja2.getChildren().add(resultadosUsuario);
        
        caja3.getChildren().add(btnAgregar);
        caja3.getChildren().add(btnModificar);
        caja3.getChildren().add(btnBorrar);
        
        caja4.getChildren().clear();
        caja4.getChildren().add(accion);
        caja4.getChildren().add(caja6);
        caja4.getChildren().add(caja7);
        caja4.getChildren().add(caja16);
        caja4.getChildren().add(cajaOK);
        
        //caja4.getChildren().add(caja8);
        //caja4.getChildren().add(caja9);
        //caja4.getChildren().add(caja10);
        //caja4.getChildren().add(caja11);
        //caja4.getChildren().add(caja12);
        //caja4.getChildren().add(caja13);
        caja8.setPadding(new Insets(5));
        caja8.getChildren().add(lbAutor);
        caja8.getChildren().add(txtAutor);
        
        
        
        caja10.setPadding(new Insets(5));
        caja10.getChildren().add(lbEditorial);
        caja10.getChildren().add(txtEditorial);
        
        caja11.setPadding(new Insets(5));
        caja11.getChildren().add(lbIsbn);
        caja11.getChildren().add(txtIsbn);
        
        caja12.setPadding(new Insets(5));
        caja12.getChildren().add(lbPrecio);
        caja12.getChildren().add(txtPrecio);
        
        
        caja14.setPadding(new Insets(5));
        caja14.getChildren().add(lbDevolucion);
        caja14.getChildren().add(txtDevolucion);
        
        caja15.setPadding(new Insets(5));
        caja15.getChildren().add(lbEntrega);
        caja15.getChildren().add(txtEntrega);
        
        
        caja6.setPadding(new Insets(5));
        caja6.getChildren().add(lbNombre);
        caja6.getChildren().add(txtNombre);
        
        
        caja17.setPadding(new Insets(5));
        caja17.getChildren().add(lbNombreLibro);
        caja17.getChildren().add(txtLibroPrestado);
        
        cajaOK.getChildren().add(btnOK);
        
        /*------------Acciones Botones----------------*/
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if (title.getText().equals("Usuario")) {    
                    if (Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olUsuario = FXCollections.observableArrayList(UsuarioController.getInstancia().getListaIdUsuario(txtSearch.getText()));
                        resultadosUsuario.getItems().clear();
                        resultadosUsuario.setItems(olUsuario);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosUsuario);
                    
                    } else if (!Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olUsuario = FXCollections.observableArrayList(UsuarioController.getInstancia().getListaNombreUsuario(txtSearch.getText()));
                        resultadosUsuario.getItems().clear();
                        resultadosUsuario.setItems(olUsuario);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosUsuario);
                    }
                } else if (title.getText().equals("Autor")) {
                    if (Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olAutor = FXCollections.observableArrayList(AutorController.getInstancia().getListaIdAutor(txtSearch.getText()));
                        resultadosAutor.getItems().clear();
                        resultadosAutor.setItems(olAutor);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosAutor);
                    
                    } else if (!Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olAutor = FXCollections.observableArrayList(AutorController.getInstancia().getListaNombreAutor(txtSearch.getText()));
                        resultadosAutor.getItems().clear();
                        resultadosAutor.setItems(olAutor);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosAutor);
                    }
                
                } else if (title.getText().equals("Editorial")) {
                    if (Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olEditorial = FXCollections.observableArrayList(EditorialController.getInstancia().getListaIdEditorial(txtSearch.getText()));
                        resultadosEditorial.getItems().clear();
                        resultadosEditorial.setItems(olEditorial);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosEditorial);
                    
                    } else if (!Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olEditorial = FXCollections.observableArrayList(EditorialController.getInstancia().getListaNombreEditorial(txtSearch.getText()));
                        resultadosEditorial.getItems().clear();
                        resultadosEditorial.setItems(olEditorial);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosEditorial);
                    }
                
                }  else if (title.getText().equals("Libro")) {
                    if (Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olLibro = FXCollections.observableArrayList(LibroController.getInstancia().getListaIdLibro(txtSearch.getText()));
                        resultadosLibro.getItems().clear();
                        resultadosLibro.setItems(olLibro);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosLibro);
                    
                    } else if (!Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olLibro = FXCollections.observableArrayList(LibroController.getInstancia().getListaNombreLibro(txtSearch.getText()));
                        resultadosLibro.getItems().clear();
                        resultadosLibro.setItems(olLibro);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosLibro);
                    }
                
                }   else if (title.getText().equals("Préstamo")) {
                    if (Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olPrestamo = FXCollections.observableArrayList(PrestamoController.getInstancia().getListaIdPrestamo(txtSearch.getText()));
                        resultadosPrestamo.getItems().clear();
                        resultadosPrestamo.setItems(olPrestamo);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosPrestamo);
                    
                    } else if (!Ventana.verificadorTextoNumero(txtSearch.getText())) {
                        olPrestamo = FXCollections.observableArrayList(PrestamoController.getInstancia().getListaNombrePrestamo(txtSearch.getText()));
                        resultadosPrestamo.getItems().clear();
                        resultadosPrestamo.setItems(olPrestamo);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosPrestamo);
                    }
                
                }
                }
            
        });
        
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if (title.getText().equals("Usuario")) {
                        if(accion.getText().equals("Agregar")) {
                            int numero = UsuarioController.getInstancia().getArrayList().size() + 1;
                            Usuario agregarUserBD = new Usuario(numero, txtNombre.getText());
                            UsuarioController.getInstancia().agregarUsuario(agregarUserBD);
                        } else if(accion.getText().equals("Modificar")) {
                            int numero = resultadosUsuario.getSelectionModel().getSelectedItem().getIdUsuario();
                            System.out.println(numero);
                            UsuarioController.getInstancia().editarUsuario(numero, txtNombre.getText());
                        }
                    olUsuario = FXCollections.observableArrayList(UsuarioController.getInstancia().getListaUsuario());
                        resultadosUsuario.getItems().clear();
                        resultadosUsuario.setItems(olUsuario);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosUsuario);
            } else if (title.getText().equals("Editorial")) {
                        if(accion.getText().equals("Agregar")) {
                            int numero = EditorialController.getInstancia().getListaEditorial().size() + 1;
                            Editorial agregarUserBD = new Editorial(numero, txtNombre.getText());
                            EditorialController.getInstancia().agregarEditorial(agregarUserBD);
                        } else if(accion.getText().equals("Modificar")) {
                            int numero = resultadosEditorial.getSelectionModel().getSelectedItem().getIdEditorial();
                            EditorialController.getInstancia().editarEditorial(numero, txtNombre.getText());
                            
                        }
                        olEditorial = FXCollections.observableArrayList(EditorialController.getInstancia().getListaEditorial());
                            resultadosEditorial.getItems().clear();
                            resultadosEditorial.setItems(olEditorial);
                            caja2.getChildren().clear();
                            caja2.getChildren().add(title);
                            caja2.getChildren().add(caja5);
                            caja2.getChildren().add(resultadosEditorial);
                    
            } else if (title.getText().equals("Autores")) {
                        if(accion.getText().equals("Agregar")) {
                            int numero = AutorController.getInstancia().getListaAutor().size() + 1;
                            Autor agregarUserBD = new Autor(numero, txtNombre.getText());
                            AutorController.getInstancia().agregarAutor(agregarUserBD);
                        } else if(accion.getText().equals("Modificar")) {
                            int numero = resultadosAutor.getSelectionModel().getSelectedItem().getIdAutor();
                            AutorController.getInstancia().editarAutor(numero, txtNombre.getText());
                        }
                        olAutor = FXCollections.observableArrayList(AutorController.getInstancia().getListaAutor());
                        resultadosAutor.getItems().clear();
                        resultadosAutor.setItems(olAutor);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosAutor);
                    
            } else if (title.getText().equals("Libros")) {
                        if(accion.getText().equals("Agregar")) {
                            int numero = LibroController.getInstancia().getListaLibro().size() + 1;
                            Libro agregarUserBD = new Libro(numero, txtNombre.getText(), txtEditorial.getPromptText(), txtIsbn.getText(), Integer.parseInt(txtPrecio.getText()));
                            LibroController.getInstancia().agregarLibro(agregarUserBD);
                        } else if(accion.getText().equals("Modificar")) {
                            int numero = resultadosLibro.getSelectionModel().getSelectedItem().getIdLibro();
                            LibroController.getInstancia().editarLibro(numero, txtNombre.getText(), txtEditorial.getPromptText(), txtIsbn.getText(), Integer.parseInt(txtPrecio.getText()));
                            
                        
                        }
                        olLibro = FXCollections.observableArrayList(LibroController.getInstancia().getListaLibro());
                            resultadosLibro.getItems().clear();
                            resultadosLibro.setItems(olLibro);
                            caja2.getChildren().clear();
                            caja2.getChildren().add(title);
                            caja2.getChildren().add(caja5);
                            caja2.getChildren().add(resultadosLibro);
                    
            }  else if (title.getText().equals("Prestamos")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
                        if(accion.getText().equals("Agregar")) {
                            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy MMM dd");
                            int numero = PrestamoController.getInstancia().getListaPrestamo().size() + 1;
                            Prestamo agregarUserBD = new Prestamo(0, txtLibroPrestado.getPromptText(), sdf.format(new Date()), txtDevolucion.getText(), true);
                            PrestamoController.getInstancia().agregarPrestamo(agregarUserBD);
                        } else if(accion.getText().equals("Devolver")) {
                            int numero = resultadosPrestamo.getSelectionModel().getSelectedItem().getIdPrestamo();
                            int numero1 = LibroController.getInstancia().devolverIdLibro(resultadosPrestamo.getSelectionModel().getSelectedItem().getIdLibro());
                            PrestamoController.getInstancia().devolverPrestamo(numero, numero1);
                        }
                    olPrestamo = FXCollections.observableArrayList(PrestamoController.getInstancia().getListaPrestamo());
                        resultadosPrestamo.getItems().clear();
                        resultadosPrestamo.setItems(olPrestamo);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosPrestamo);
                    
            }
            }        
                
            
        });
        
        btnBorrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if (title.getText().equals("Usuario") && resultadosUsuario.getSelectionModel().getSelectedItem() != null) {
                        int numero = resultadosUsuario.getSelectionModel().getSelectedItem().getIdUsuario();
                        UsuarioController.getInstancia().eliminarUsuario(numero);
                        olUsuario = FXCollections.observableArrayList(UsuarioController.getInstancia().getListaUsuario());
                        resultadosUsuario.getItems().clear();
                        resultadosUsuario.setItems(olUsuario);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosUsuario);
                } else if (title.getText().equals("Editorial") && resultadosEditorial.getSelectionModel().getSelectedItem() != null) {
                        int numero = resultadosEditorial.getSelectionModel().getSelectedItem().getIdEditorial();
                        EditorialController.getInstancia().eliminarEditorial(numero);   
                        olEditorial = FXCollections.observableArrayList(EditorialController.getInstancia().getListaEditorial());
                            resultadosEditorial.getItems().clear();
                            resultadosEditorial.setItems(olEditorial);
                            caja2.getChildren().clear();
                            caja2.getChildren().add(title);
                            caja2.getChildren().add(caja5);
                            caja2.getChildren().add(resultadosEditorial);
                } else if (title.getText().equals("Autores") && resultadosAutor.getSelectionModel().getSelectedItem() != null) {
                        int numero = resultadosAutor.getSelectionModel().getSelectedItem().getIdAutor();
                        AutorController.getInstancia().eliminarAutor(numero);
                        olAutor = FXCollections.observableArrayList(AutorController.getInstancia().getListaAutor());
                        resultadosAutor.getItems().clear();
                        resultadosAutor.setItems(olAutor);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosAutor);
                } else if (title.getText().equals("Libros") && resultadosLibro.getSelectionModel().getSelectedItem() != null) {
                        int numero = resultadosLibro.getSelectionModel().getSelectedItem().getIdLibro();
                        LibroController.getInstancia().eliminarLibro(numero);
                            resultadosLibro.getItems().clear();
                            resultadosLibro.setItems(olLibro);
                            caja2.getChildren().clear();
                            caja2.getChildren().add(title);
                            caja2.getChildren().add(caja5);
                            caja2.getChildren().add(resultadosLibro);
                } else if (title.getText().equals("Préstamo")) {
                        //int numero = resultadosLibro.getSelectionModel().getSelectedItem().getIdLibro();
                        //PrestamoController.getInstancia().eliminarPrestamo(numero);   
                        olPrestamo = FXCollections.observableArrayList(PrestamoController.getInstancia().getListaPrestamo());
                        resultadosPrestamo.getItems().clear();
                        resultadosPrestamo.setItems(olPrestamo);
                        caja2.getChildren().clear();
                        caja2.getChildren().add(title);
                        caja2.getChildren().add(caja5);
                        caja2.getChildren().add(resultadosPrestamo);
                }
            }
        });
        
        
        
        
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                root.resize(900, 500);
                primaryStage.setMinWidth(905.00);
                primaryStage.setMaxWidth(905.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                caja1.getChildren().add(caja2);
                caja1.getChildren().add(caja3);
                accion.setText("Agregar");
                caja1.getChildren().add(caja4);
                if (title.getText().equals("Préstamo")) {
                    caja4.getChildren().clear();
                    caja4.getChildren().add(accion);
                    caja4.getChildren().add(caja17);
                    caja4.getChildren().add(caja13);
                    caja4.getChildren().add(caja14);
                    caja4.getChildren().add(cajaOK);
                    
                }
            }
        });
        
        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if (resultadosUsuario.getSelectionModel().getSelectedItem() != null || resultadosEditorial.getSelectionModel().getSelectedItem() != null || resultadosAutor.getSelectionModel().getSelectedItem() != null || resultadosLibro.getSelectionModel().getSelectedItem() != null) {
                    root.resize(900, 500);
                primaryStage.setMinWidth(905.00);
                primaryStage.setMaxWidth(905.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                caja1.getChildren().add(caja2);
                caja1.getChildren().add(caja3);
                accion.setText("Modificar");
                caja1.getChildren().add(caja4);
                if (title.getText().equals("Préstamo")) {
                    caja4.getChildren().clear();
                    accion.setText("Devolver");
                    btnModificar.setText("Devolver");
                    //caja4.getChildren().add(accion);
                    //caja4.getChildren().add(caja17);
                    //caja4.getChildren().add(caja13);
                    //caja4.getChildren().add(caja14);
                    //caja4.getChildren().add(caja15);
                    //caja4.getChildren().add(cajaOK);
                    
                }
            }
            }
        });
                
        /*---------------Acciones Menú Ver-----------*/
        verUsuario.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                root.resize(480, 500);
                primaryStage.setMinWidth(495.00);
                primaryStage.setMaxWidth(495.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                title.setText("Usuario");
                btnModificar.setText("Modificar");
                caja1.getChildren().add(caja2);
                caja2.getChildren().clear();
                caja2.getChildren().add(title);
                caja2.getChildren().add(caja5);
                caja2.getChildren().add(resultadosUsuario);
                if (valorDelRango > 1) {
                    caja1.getChildren().add(caja3);
                }
                caja4.getChildren().clear();
                caja4.getChildren().add(accion);
                    caja4.getChildren().add(caja6);
                    caja4.getChildren().add(caja7);
                    caja4.getChildren().add(caja16);
                    caja4.getChildren().add(cajaOK);
                }
        });
        
        verLibro.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                root.resize(690, 500);
                primaryStage.setMinWidth(705.00);
                primaryStage.setMaxWidth(705.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                title.setText("Libro");
                btnModificar.setText("Modificar");
                caja2.getChildren().clear();
                caja2.getChildren().add(title);
                caja2.getChildren().add(caja5);
                caja2.getChildren().add(resultadosLibro);
                caja1.getChildren().add(caja2);
                if (valorDelRango > 1) {
                    caja1.getChildren().add(caja3);
                }
                caja4.getChildren().clear();
                caja4.getChildren().add(accion);
                caja4.getChildren().add(caja6); //nombre
                caja4.getChildren().add(caja8); //autor
                caja4.getChildren().add(caja9); //género
                caja4.getChildren().add(caja10); //editorial
                caja4.getChildren().add(caja11); //isbn
                caja4.getChildren().add(caja12); //precio
                caja4.getChildren().add(cajaOK);
                
                
                }
        });
        
        verAutores.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                root.resize(480, 500);
                primaryStage.setMinWidth(495.00);
                primaryStage.setMaxWidth(495.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                title.setText("Autores");
                caja1.getChildren().add(caja2);
                caja2.getChildren().clear();
                caja2.getChildren().add(title);
                caja2.getChildren().add(caja5);
                btnModificar.setText("Modificar");
                caja2.getChildren().add(resultadosAutor);
                if (valorDelRango > 1) {
                    caja1.getChildren().add(caja3);
                }
                caja4.getChildren().clear();
                    caja4.getChildren().add(accion);
                    caja4.getChildren().add(caja6);
                    caja4.getChildren().add(cajaOK);
                    
                }
        });
        
        verEditorial.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                root.resize(480, 500);
                primaryStage.setMinWidth(495.00);
                primaryStage.setMaxWidth(495.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                title.setText("Editorial");
                caja2.getChildren().clear();
                caja2.getChildren().add(title);
                caja2.getChildren().add(caja5);
                caja2.getChildren().add(resultadosEditorial);
                caja1.getChildren().add(caja2);
                if (valorDelRango > 1) {
                    caja1.getChildren().add(caja3);
                }
                btnModificar.setText("Modificar");
                caja4.getChildren().clear();
                    caja4.getChildren().add(accion);
                    caja4.getChildren().add(caja6);
                    caja4.getChildren().add(cajaOK);
                   
                }
        });
        
        
        
         verPrestamos.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                root.resize(690, 500);
                primaryStage.setMinWidth(705.00);
                primaryStage.setMaxWidth(705.00);
                primaryStage.setMinHeight(545.00);
                primaryStage.setMaxHeight(545.00);
                caja1.getChildren().clear();
                title.setText("Préstamo");
                caja1.getChildren().add(caja2);
                caja2.getChildren().clear();
                caja2.getChildren().add(title);
                caja2.getChildren().add(caja5);
                btnModificar.setText("Devolver");
                caja2.getChildren().add(resultadosPrestamo);
                if (valorDelRango > 1) {
                    caja1.getChildren().add(caja3);
                }
                caja4.getChildren().clear();
                    caja4.getChildren().add(accion);
                    caja4.getChildren().add(caja17);
                    caja4.getChildren().add(caja13);
                    caja4.getChildren().add(caja14);
                    caja4.getChildren().add(cajaOK);

                }
        });
         
        
        
        
        
        
        root.resize(480, 500);
        root.getChildren().add(cajaPrincipal);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ventana");
        primaryStage.setMinWidth(495.00);
        primaryStage.setMaxWidth(495.00);
        primaryStage.setMinHeight(545.00);
        primaryStage.setMaxHeight(545.00);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }    
}
