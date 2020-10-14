/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

        
/**
 *
 * @author Dlope
 */
public class Paciente extends Persona{
    private String dpi_paciente;
    private Conexion cn;
    public Paciente() {}

    public Paciente(String dpi_paciente, int id_paciente, String nombre_paciente, String apellido_paciente, String fecha_nac_paciente, String genero_paciente, String direccion_paciente, String telefono_paciente) {
        super(id_paciente, nombre_paciente, apellido_paciente, fecha_nac_paciente, genero_paciente, direccion_paciente, telefono_paciente);
        this.dpi_paciente = dpi_paciente;
    }
    

  public String getDpi_paciente() {
        return dpi_paciente;
    }

    public void setDpi_paciente(String dpi_paciente) {
        this.dpi_paciente = dpi_paciente;
    }

    
    public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
     String query ="SELECT e.id_paciente as id, e.dpi_paciente,e.nombre_paciente, e.apellido_paciente, e.fecha_nac_paciente,e.genero_paciente,e.direccion_paciente,e.telefono_paciente FROM paciente as e;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
     String encabezado[] = {"id","dpi","nombres","apellidos","nacimiento","genero","direccion","telefono"};
     tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[8];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("dpi_paciente");
          datos[2] = consulta.getString("nombre_paciente");
          datos[3] = consulta.getString("apellido_paciente");
          datos[4] = consulta.getString("fecha_nac_paciente");
          datos[5] = consulta.getString("genero_paciente");
          datos[6] = consulta.getString("direccion_paciente");
          datos[7] = consulta.getString("telefono_paciente");
 
          tabla.addRow(datos);
      
      }
    cn.cerrar_conexion();
    
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    
    return tabla;
    
    }
    @Override
    public int agregar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn = new Conexion();
        String query="INSERT INTO paciente(dpi_paciente,nombre_paciente,apellido_paciente,fecha_nac_paciente,genero_paciente,direccion_paciente,telefono_paciente) VALUES(?,?,?,?,?,?,?) ";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getDpi_paciente());
        parametro.setString(2, getNombre_paciente());
        parametro.setString(3, getApellido_paciente());
        parametro.setString(4, getFecha_nac_paciente());
        parametro.setString(5, getGenero_paciente());
        parametro.setString(6, getDireccion_paciente());
        parametro.setString(7, getTelefono_paciente());
        retorno = parametro.executeUpdate();
        
        cn.cerrar_conexion();
        }
    catch(Exception ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
    return retorno;
         }
    @Override
    public int modificar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn = new Conexion();
        String query="UPDATE paciente set dpi_paciente=?,nombre_paciente=?,apellido_paciente=?,fecha_nac_paciente=?,genero_paciente=?,direccion_paciente=?,telefono_paciente=? where id_paciente=?; ";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getDpi_paciente());
        parametro.setString(2, getNombre_paciente());
        parametro.setString(3, getApellido_paciente());
        parametro.setString(4, getFecha_nac_paciente());
        parametro.setString(5, getGenero_paciente());
        parametro.setString(6, getDireccion_paciente());
        parametro.setString(7, getTelefono_paciente());
        parametro.setInt(8, getId_paciente());
        retorno = parametro.executeUpdate();
        
        cn.cerrar_conexion();
        }
    catch(Exception ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
    return retorno;
         }
    
    @Override
      public int eliminar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn = new Conexion();
        String query="DELETE from paciente where id_paciente =?; ";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
        parametro.setInt(1, getId_paciente());
        retorno = parametro.executeUpdate();
        
        cn.cerrar_conexion();
        }
    catch(Exception ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
    return retorno;
         }

   
 
}