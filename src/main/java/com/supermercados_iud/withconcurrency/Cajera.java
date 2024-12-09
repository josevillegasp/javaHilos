package com.supermercados_iud.withconcurrency;

import com.supermercados_iud.Producto;
import com.supermercados_iud.cliente.Cliente;

/**
 * esta clase representa a la cajera y sus funsionalidades
 */

public class Cajera implements Runnable {
    /*
     * @param: nombre, se utiliza para establecer el nombre de la cajera
     */
    private final String nombre;
    /*
     * @param: supermercado, se utiliza para establecer al supermercado al que
     * pertenece
     */
    private Supermercado supermercado;
    /*
     * @param: inicialtime, con esta capturamos el tiempo inicial donde se empieza a
     * cobrar
     */
    private long initialtime = System.currentTimeMillis();

    /**
     * @param nombre
     */
    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {

            while (true) {

                Cliente cliente = supermercado.obtenerCliente();

                System.out.println(
                        "la cajera " + this.nombre + " ha comenzado a procesar la compra del cliente "
                                + cliente.getNombre() + " en el timpo "
                                + (System.currentTimeMillis() - initialtime) / 1000 + "seg");

                for (Producto producto : cliente.getProductos()) {

                    this.tiempSimuProces();
                    System.out.println("Cajera " + this.nombre + " procesando producto: "
                            + producto.getNombre() + " | Precio: " + producto.getPrice()
                            + " | Cantidad: " + producto.getCantidad()
                            + " | Costo total: " + (producto.getCantidad() * producto.getPrice()));
                }
                System.out.println("la cajera " + this.nombre + "ha terminado de procesar la compra del cliente "
                        + cliente.getNombre() + " en el timpo " + (System.currentTimeMillis() - initialtime)
                                / 1000
                        + "seg");
                System.out.println();

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

    /**
     * Actualizamos el supermercado al que pertenece la cajera
     */
    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

}
