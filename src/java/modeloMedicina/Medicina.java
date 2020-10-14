/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMedicina;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dlope
 */
public class Medicina extends Medicinas{
     private String nombre;
     private int id_tipo;
     private Conexion cn;

    public Medicina() {}
    public Medicina(String nombre, int id_tipo, int id, int existencia, String lote, String descripcion) {
        super(id, existencia, lote, descripcion);
        this.nombre = nombre;
        this.id_tipo = id_tipo;
    }

     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
     
    public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
     String query ="select m.id_medicina as id, m.nombre_medicina, t.tipo_medicina, t.id_tipo, m.lote_medicina, m.descripcion_medicina, m.existencia from medicina as m inner join tipo_medicina as t on m.id_tipo = t.id_tipo;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
     String encabezado[] = {"id","nombre_medicina","tipo","id_tipo","lote","descrpcion","existencia"};
     tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[7];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nombre_medicina");
          datos[2] = consulta.getString("tipo_medicina");
          datos[3] = consulta.getString("id_tipo");
          datos[4] = consulta.getString("lote_medicina");
          datos[5] = consulta.getString("descripcion_medicina");
          datos[6] = consulta.getString("existencia");
          
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
        int retorno =0;
    try{
        PreparedStatement parametro;
        cn = new Conexion();
        String query="INSERT INTO medicina(nombre_medicina,id_tipo,lote_medicina,descripcion_medicina,existencia) VALUES(?,?,?,?,?); ";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNombre());
        parametro.setInt(2, getId_tipo());
        parametro.setString(3, getLote());
        parametro.setString(4, getDescripcion());
        parametro.setInt(5, getExistencia());
  
        retorno = parametro.executeUpdate();
        
        cn.cerrar_conexion();
        }
    catch(SQLException ex){
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
        String query="update medicina set nombre_medicina= ?,id_tipo= ?,lote_medicina= ?,descripcion_medicina= ?,existencia= ? where id_medicina= ?;";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNombre());
        parametro.setInt(2, getId_tipo());
        parametro.setString(3, getLote());
        parametro.setString(4, getDescripcion());
        parametro.setInt(5, getExistencia());
         parametro.setInt(6, getId());
        retorno = parametro.executeUpdate();
        
        cn.cerrar_conexion();
        }
    catch(SQLException ex){
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
        String query="DELETE from medicina where id_medicina =?; ";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
        parametro.setInt(1, getId());
        retorno = parametro.executeUpdate();
        
        cn.cerrar_conexion();
        }
    catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
    return retorno;
         }
}
