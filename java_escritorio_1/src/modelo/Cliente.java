/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programador
 */
public class Cliente extends Persona {
    Conexion cn;
    private int id; // 1
    private String nit;
   

    public Cliente() {
    }
                    // 2
    public Cliente(int id,String nit, String cui, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(cui, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id; // 3
        this.nit = nit;
        
    }
    // 4
    public int getId() {
        return id;
    }
    // 5
    public void setId(int id) {
        this.id = id;
    }
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
  public DefaultTableModel leer(){
  DefaultTableModel tabla = new DefaultTableModel();
  try{
     cn = new Conexion();
     cn.abrir_conexion();
     String query = "select * from clientes;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
     String encabezado[] = {"id_cliente","cui","nit","nombres","apellidos","direccion","telefono","nacimiento"};
     tabla.setColumnIdentifiers(encabezado);
     String datos[] = new String[8];
     while(consulta.next()){
         datos[0] = consulta.getString("id_cliente");
         datos[1] = consulta.getString("cui");
         datos[2] = consulta.getString("nit");
         datos[3] = consulta.getString("nombres");
         datos[4] = consulta.getString("apellidos");
         datos[5] = consulta.getString("direccion");
         datos[6] = consulta.getString("telefono");
         datos[7] = consulta.getString("fecha_nacimiento");
         tabla.addRow(datos);
     }
     cn.cerrar_conexion();
  }catch(SQLException ex){
      System.out.println("Error: " + ex.getMessage());
  }
  return tabla;
  }
    @Override
 public void crear(){
     try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         String query = "insert into clientes(cui,nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) values(?,?,?,?,?,?,?);";
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, this.getCui());
         parametro.setString(2, this.getNit());
         parametro.setString(3, this.getNombres());
         parametro.setString(4, this.getApellidos());
         parametro.setString(5, this.getDireccion());
         parametro.setString(6, this.getTelefono());
         parametro.setString(7, this.getFecha_nacimiento());
         parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
         System.out.println("Error:" + ex.getMessage());
     }
 } 
    @Override
    public void actualizar(){
         try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         String query = "update clientes set cui = ?,nit = ?,nombres = ?,apellidos = ?,direccion = ?,telefono = ?,fecha_nacimiento =? where id_cliente = ?;";
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, this.getCui());
         parametro.setString(2, this.getNit());
         parametro.setString(3, this.getNombres());
         parametro.setString(4, this.getApellidos());
         parametro.setString(5, this.getDireccion());
         parametro.setString(6, this.getTelefono());
         parametro.setString(7, this.getFecha_nacimiento());
         parametro.setInt(8, this.getId());
         parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
         System.out.println("Error:" + ex.getMessage());
     }  
} 

    @Override
    public void borrar(){
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         String query = "delete from clientes where id_cliente = ?;";
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, this.getId());
         parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
         System.out.println("Error:" + ex.getMessage());
     }  
        
}   
}
