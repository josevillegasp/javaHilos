package com.supermercados_iud;

/**
 * clase que determina los productos que el cliente va a llevar
 */
public class Producto {
    /**
     * atributo que determina el nombre
     */
    private String nombre;
    /**
     * atributo que determina el precio
     */
    private int price;
    /**
     * atributo que determina la cantidad
     */
    private int cantidad;

    /**
     * @param nombre
     * @param price
     * @param cantidad
     */
    public Producto(String nombre, int price, int cantidad) {
        this.nombre = nombre;
        this.price = price;
        this.cantidad = cantidad;
    }

    /**
     * metodo encargado de devolver el nombre del producto
     * 
     * @return el nombre asociado al producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo encargado de establer un nuevo nombre para el producto.
     * 
     * @param nombre - el nuevo nombre a modificar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo encargado de devolver el precio del producto
     * 
     * @return el precio asociado al producto
     */
    public int getPrice() {
        return price;
    }

    /**
     * metodo encargado de establer un nuevo precio al producto.
     * 
     * @param price - el nuevo precio a modificar
     */

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * metodo encargado de devolver la cantidad de producto
     * 
     * @return la cantidad asociada al producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * metodo encargado de establer la nueva cantidad para el producto.
     * 
     * @param cantidad - la nueva cantida a modificar
     */

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
