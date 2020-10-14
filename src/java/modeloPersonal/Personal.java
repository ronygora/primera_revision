/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloPersonal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
        
/**
 *
 * @author Usuario
 */
public class Personal extends Persona {
    private int id_puesto;
    Conexion cn;

    public Personal() {
    }

    public Personal(int id_puesto, int id, String nombre_personal, String apellido_personal, String telefono_personal, String direccion_personal) {
        super(id, nombre_personal, apellido_personal, telefono_personal, direccion_personal);
        this.id_puesto = id_puesto;
    }
    
    
    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
    
 public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "SELECT pe.id_personal as id,pe.nombre_personal,pe.apellido_personal,pe.telefono_personal,pe.direccion_personal,p.puesto,p.id_puesto FROM personal as pe inner join puesto as p on pe.id_puesto = p.id_puesto;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","nombre_personal","apellido_personal","telefono_personal","direccion_personal","puesto","id_puesto"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[7];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_personal");
          datos[2] = consulta.getString("apellido_personal");
          datos[3] = consulta.getString("telefono_personal");
          datos[4] = consulta.getString("direccion_personal");
          datos[5] = consulta.getString("puesto");
          datos[6] = consulta.getString("id_puesto");
          tabla.addRow(datos);
      
      }
      
     cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
 
 
    @Override
    public int agregar1(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO personal(nombre_personal,apellido_personal,telefono_personal,direccion_personal,id_puesto) VALUES(?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNombre_personal());
            parametro.setString(2,getApellido_personal());
            parametro.setString(3,getTelefono_personal());
            parametro.setString(4,getDireccion_personal());
            parametro.setInt(5,getId_puesto());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    @Override
    public int modificar1 (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "UPDATE personal SET nombre_personal= ?,apellido_personal= ?,telefono_personal= ?,direccion_personal= ?,id_puesto= ? WHERE id_personal = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,this.getNombre_personal());
            parametro.setString(2,this.getApellido_personal());
            parametro.setString(3,this.getTelefono_personal());
            parametro.setString(4,this.getDireccion_personal());
            parametro.setInt(5, getId_puesto());
            parametro.setInt(6, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    @Override
    public int eliminar1 (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "DELETE FROM personal WHERE id_personal = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
   
}
