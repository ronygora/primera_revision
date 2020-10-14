/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMedicina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Dlope
 */
public class Tipo {
    private int id_tipo;
    private String tipo_medicina;
    private Conexion cn;
    public Tipo(){}
    public Tipo(int id_tipo, String tipo_medicina) {
        this.id_tipo = id_tipo;
        this.tipo_medicina = tipo_medicina;
    }

    
    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo_medicina() {
        return tipo_medicina;
    }

    public void setTipo_medicina(String tipo_medicina) {
        this.tipo_medicina = tipo_medicina;
    }
    public HashMap drop_tipo(){
    HashMap<String,String> drop = new HashMap();
    try{
        cn = new Conexion();
        String query= "SELECT id_tipo as id, tipo_medicina from tipo_medicina;";
        cn.abrir_conexion();
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("tipo_medicina"));   
        }
        cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return drop;
    
    }
    
}
