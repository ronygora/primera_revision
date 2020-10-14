/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloPersonal;

/**
 *
 * @author Usuario
 */
abstract class Persona {
    private int id;
    private String nombre_personal,apellido_personal,telefono_personal,direccion_personal;
    
    public Persona(){}

    public Persona(int id, String nombre_personal, String apellido_personal, String telefono_personal, String direccion_personal) {
        this.id = id;
        this.nombre_personal = nombre_personal;
        this.apellido_personal = apellido_personal;
        this.telefono_personal = telefono_personal;
        this.direccion_personal = direccion_personal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_personal() {
        return nombre_personal;
    }

    public void setNombre_personal(String nombre_personal) {
        this.nombre_personal = nombre_personal;
    }

    public String getApellido_personal() {
        return apellido_personal;
    }

    public void setApellido_personal(String apellido_personal) {
        this.apellido_personal = apellido_personal;
    }

    public String getTelefono_personal() {
        return telefono_personal;
    }

    public void setTelefono_personal(String telefono_personal) {
        this.telefono_personal = telefono_personal;
    }

    public String getDireccion_personal() {
        return direccion_personal;
    }

    public void setDireccion_personal(String direccion_personal) {
        this.direccion_personal = direccion_personal;
    }
    
public int agregar1(){return 0;}
public int modificar1 (){return 0;}
public int eliminar1 (){return 0;}
    
}
