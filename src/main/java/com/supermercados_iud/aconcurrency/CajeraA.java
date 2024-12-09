package com.supermercados_iud.aconcurrency;

import com.supermercados_iud.Producto;
import com.supermercados_iud.cliente.Cliente;

/**
 * clase que determina a las cajeras y sus funsionalidades
 */
public class CajeraA {

    /*
     * @param: nombre, se utiliza para establecer el nombre de la cajera
     */
    private final String nombre;

    /**
     * @param nombre
     */
    public CajeraA(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * metodo encargado de realizar el proceso de compra realizado por una cajera
     * 
     * @param cliente
     * @param timeStamp
     */
    public void procesarcompra(Cliente cliente, long timeStamp) {

        System.out.println(
                "la cajera " + this.nombre + " ha comenzado a procesar la compra del cliente "
                        + cliente.getNombre() + " en el timpo "
                        + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        for (Producto producto : cliente.getProductos()) {

            this.tiempSimuProces();
            System.out.println("Cajera " + this.nombre + " procesando producto: "
                    + producto.getNombre() + " | Precio: " + producto.getPrice()
                    + " | Cantidad: " + producto.getCantidad()
                    + " | Costo total: " + (producto.getCantidad() * producto.getPrice()));
        }
        System.out.println("la cajera " + this.nombre + "ha terminado de procesar la compra del cliente "
                + cliente.getNombre() + " en el timpo " + (System.currentTimeMillis() - timeStamp)
                        / 1000
                + "seg");
        System.out.println();

    }

    /**
     * Método que simula el tiempo necesario para procesar un producto.
     */
    private void tiempSimuProces() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
