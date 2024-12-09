package com.supermercados_iud.withconcurrency;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import com.supermercados_iud.cliente.Cliente;

public class Supermercado {

    /**
     * Cola para gestionar los clientes que llegan, los guardamos en la cola y luego
     * los vamos sacando uno a uno
     */
    private Queue<Cliente> colaClientes = new LinkedList<>();

    /**
     * se utiliiza el objeto lock para bloquear el hilo y evitar problemas de
     * concurrencia al modificar la cola
     */
    private final Object lock = new Object();

    /**
     * Array de cajeras
     */
    private Thread[] cajeras;

    /**
     * Constructor donde se inicializan las cajeras, Inicializamos el arreglo de
     * hilos de cajeras y tambien Asignamos el supermercado a cada cajera
     * 
     * @param cajerasList : es una lista donde guardamos las cajeras
     */
    public Supermercado(List<Cajera> cajerasList) {
        cajeras = new Thread[cajerasList.size()];

        for (int i = 0; i < cajerasList.size(); i++) {
            cajeras[i] = new Thread(cajerasList.get(i));
            cajerasList.get(i).setSupermercado(this);
        }
    }

    /**
     * Método para iniciar el supermercado con los clientes, Agregar los clientes a
     * la cola he iniciar los hilos de las cajeras
     * 
     * @param clientes cliente es una lista que contiene los clientes que van
     *                 llegando y que van a ingresar a la cola
     */
    public void iniciar(List<Cliente> clientes) {

        for (Cliente cliente : clientes) {
            addCliente(cliente);
        }

        for (Thread cajera : cajeras) {
            cajera.start();
        }
    }

    /**
     * Este metodo agrega los cliente a la cola
     * 
     * @param cliente
     */
    public void addCliente(Cliente cliente) {
        synchronized (lock) {
            colaClientes.offer(cliente);
            lock.notify(); // Notifica a las cajeras que hay un nuevo cliente en la cola
        }
    }

    /**
     * Método para obtener un cliente de la cola (será usado por las cajeras)
     * 
     * @return retorna un cliente ha optener
     * @throws InterruptedException
     */
    public Cliente obtenerCliente() throws InterruptedException {
        synchronized (lock) {
            while (colaClientes.isEmpty()) {
                lock.wait(); // Si no hay clientes, la cajera espera
            }
            // Extraemos el primer cliente de la cola
            Cliente cliente = colaClientes.poll();
            return cliente;
        }
    }

}
