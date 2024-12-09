package com.supermercados_iud.aconcurrency;

import java.util.List;

import com.supermercados_iud.Producto;
import com.supermercados_iud.cliente.Cliente;

public class cashierMain {

    public static void main(String[] args) {

        Producto producto1 = new Producto("Manzanas", 2000, 5); // 5 manzanas a $2000 cada una
        Producto producto2 = new Producto("Leche", 3500, 2); // 2 litros de leche a $3500 cada uno
        Producto producto3 = new Producto("Arroz", 1800, 3); // 3 kilos de arroz a $1800 cada uno
        Producto producto4 = new Producto("Café", 4500, 1); // 1 paquete de café a $4500
        Producto producto5 = new Producto("Azúcar", 2500, 2); // 2 kilos de azúcar a $2500 cada uno

        Cliente cliente1 = new Cliente("jose", List.of(producto1, producto2, producto3, producto4, producto5));
        Cliente cliente2 = new Cliente("carlos", List.of(producto1, producto2, producto3, producto4, producto5));
        Cliente cliente3 = new Cliente("andres", List.of(producto1, producto2, producto3, producto4, producto5));

        long inicialtime = System.currentTimeMillis();

        CajeraA cajera1 = new CajeraA("maria");
        CajeraA cajera2 = new CajeraA("rosa");
        CajeraA cajera3 = new CajeraA("carolina");

        cajera1.procesarcompra(cliente3, inicialtime);
        cajera2.procesarcompra(cliente2, inicialtime);
        cajera3.procesarcompra(cliente1, inicialtime);

    }

}
