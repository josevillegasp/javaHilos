package com.supermercados_iud.withconcurrency;

import java.util.ArrayList;
import java.util.List;

import com.supermercados_iud.Producto;
import com.supermercados_iud.cliente.Cliente;

public class Main {
    public static void main(String[] args) {
        /**
         * se crean los productos
         */
        Producto producto1 = new Producto("Manzanas", 2000, 5); // 5 manzanas a $2000 cada una
        Producto producto2 = new Producto("Leche", 3500, 2); // 2 litros de leche a $3500 cada uno
        Producto producto3 = new Producto("Arroz", 1800, 3); // 3 kilos de arroz a $1800 cada uno
        Producto producto4 = new Producto("Café", 4500, 1); // 1 paquete de café a $4500
        Producto producto5 = new Producto("Azúcar", 2500, 2); // 2 kilos de azúcar a $2500 cada uno
        /**
         * se crean clientes con listas de productos
         */
        Cliente cliente1 = new Cliente("Juan", List.of(producto1, producto2));
        Cliente cliente2 = new Cliente("María", List.of(producto3, producto4));
        Cliente cliente3 = new Cliente("Carlos", List.of(producto5, producto1, producto3));
        Cliente cliente4 = new Cliente("Ana", List.of(producto2, producto4, producto5));
        Cliente cliente5 = new Cliente("Luisa", List.of(producto1, producto2, producto3, producto4, producto5));

        /**
         * se crean las cajeras
         */
        List<Cajera> cajeras = new ArrayList<>();
        cajeras.add(new Cajera("marta"));
        cajeras.add(new Cajera("rosa"));
        cajeras.add(new Cajera("andrea"));

        /**
         * se crea el supermercado, se instancia y se le pasa la lista de las cajeras
         */
        Supermercado supermercado = new Supermercado(cajeras);

        /**
         * se agregan los clientes a una lista
         */
        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3, cliente4, cliente5);

        /**
         * Iniciar la simulación, se llama al metodo iniciar de la instancia de
         * supermercado y se le pasa la lista de clientes
         */
        System.out.println("Supermercado abierto. ¡Comienza la atención!");
        supermercado.iniciar(clientes);

    }
}