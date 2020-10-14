/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Dlope
 */
abstract class Persona {
    private int id_paciente;
    private String nombre_paciente,apellido_paciente,fecha_nac_paciente,genero_paciente,direccion_paciente,telefono_paciente;
    public Persona(){};
    public Persona(int id_paciente, String nombre_paciente, String apellido_paciente, String fecha_nac_paciente, String genero_paciente, String direccion_paciente, String telefono_paciente) {
        this.id_paciente = id_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paciente = apellido_paciente;
        this.fecha_nac_paciente = fecha_nac_paciente;
        this.genero_paciente = genero_paciente;
        this.direccion_paciente = direccion_paciente;
        this.telefono_paciente = telefono_paciente;
    }
   
  
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public String getFecha_nac_paciente() {
        return fecha_nac_paciente;
    }

    public void setFecha_nac_paciente(String fecha_nac_paciente) {
        this.fecha_nac_paciente = fecha_nac_paciente;
    }

    public String getGenero_paciente() {
        return genero_paciente;
    }

    public void setGenero_paciente(String genero_paciente) {
        this.genero_paciente = genero_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }
    
    public int agregar(){ return 0;}
    public int modificar(){ return 0;}
    public int eliminar(){ return 0;}
    
}
