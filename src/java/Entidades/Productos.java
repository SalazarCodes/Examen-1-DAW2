/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Productos {
    
    private String idProducto;
    private String descripcion;
    private String precio;
    private String stock;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Productos(String idProducto, String descripcion, String precio, String stock) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public Productos() {
    }
        
}
