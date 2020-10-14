/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMedicina;

/**
 *
 * @author Dlope
 */
abstract class Medicinas {
    private int id, existencia;
    private String  lote, descripcion;
    public Medicinas(){}
    public Medicinas(int id, int existencia, String lote, String descripcion) {
        this.id = id;
        this.existencia = existencia;
        this.lote = lote;
        this.descripcion = descripcion;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
    
}
