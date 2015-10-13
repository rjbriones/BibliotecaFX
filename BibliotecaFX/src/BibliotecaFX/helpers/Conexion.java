/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BibliotecaFX.helpers;

/**
 *
 * @author Marco
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection conexion;
	private Statement enunciado;
	private static Conexion instancia;
	
	public static Conexion getInstancia(){
		if(instancia == null)
			instancia = new Conexion();
		return instancia;
	}
	
	public Connection getConexion(){
		return conexion;
	}
	
	public ResultSet hacerConsulta(String consulta){
		ResultSet resultado = null;
		try {
			resultado = enunciado.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void ejecutarConsulta(String sql){
		try {
			enunciado.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Conexion(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			System.out.println("¡Instancio el controlador correctamente!");
			conexion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQL2013344:1433;databaseName=BibliotecaFX; user=kinal;password=sa");
			System.out.println("¡Conexión realizada con exito!");
			enunciado = conexion.createStatement();
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}

