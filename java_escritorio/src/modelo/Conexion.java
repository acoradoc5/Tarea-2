/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Programador
 */
public class Conexion {
    public Connection conexionBD;
    private final String urlConexion= "jdbc:mysql://localhost:3306/db_empresa?serverTimezone=UTC";
    private final String usuario = "root";
    private final String contra = "Aaco3521@$";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion, usuario, contra);
            System.out.println("Conexion Exitosa");

        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
   
     public void cerrar_conexion(){
     try{
         conexionBD.close();
     }catch(SQLException ex){
         System.out.println("Error:" + ex.getMessage());
     
     }
    }
}
