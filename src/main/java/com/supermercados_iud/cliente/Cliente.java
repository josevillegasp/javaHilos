package com.supermercados_iud.cliente;

import java.util.List;

import com.supermercados_iud.Producto;

/**
 * clase que determina los clinetes que llevaran los productos
 */
public class Cliente {
    /**
     * atributo que determina el nombre
     */
    private final String nombre;
    /**
     * lista en la cual contienen los productos que lleva el cliente
     */
    private List<Producto> productos;

    /**
     * @param nombre
     * @param productos
     */
    public Cliente(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    /**
     * metodo encargado de devolver el nombre del cliente
     * 
     * @return el nombre asociado al cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo encargado de devolver los productos
     * 
     * @return lista de productos asociado al cliente
     */
    public List<Producto> getProductos() {
        return productos;
    }

}
