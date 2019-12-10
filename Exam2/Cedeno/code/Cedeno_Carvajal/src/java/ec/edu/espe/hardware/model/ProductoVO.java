/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hardware.model;

/**
 *
 * @author Melissa
 */
public class ProductoVO {
    private int id;
    private String nombre;
    private String tipo;
    private int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoVO() {
    }

    public ProductoVO(int id, String nombre, String tipo, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoVO{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", cantidad=" + cantidad + '}';
    }
    
    
}
