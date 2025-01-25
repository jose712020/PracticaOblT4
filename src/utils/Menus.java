package utils;

import models.*;

import java.util.Scanner;

public class Menus {
    public static final Scanner S = new Scanner(System.in);

    //Menu del administrador
    public static String menuAdministrador(Tienda tienda) {
        String salida = "";
        salida += "FERNANSHOP\n";
        salida += "Bienvenido " + tienda.getAdmin().getNombre() + ". Tienes pedidos por asignar." + "\n";
        salida += "1.- Asignar un pedido a un trabajador" + "\n";
        salida += "2.- Modificar el estado de un pedido" + "\n";
        salida += "3.- Dar de alta un trabajador" + "\n";
        salida += "4.- Ver todos los pedidos" + "\n";
        salida += "5.- Ver todos los clientes" + "\n";
        salida += "6.- Ver todos los trabajadores" + "\n";
        salida += "7.- Cerrar sesión" + "\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    // Menu del cliente
    public static String menuCliente(Cliente cliente) {
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + cliente.getNombre() + "\n";
        salida += "1.- Consultar el catálogo de productos" + "\n";
        salida += "2.- Realizar un pedido" + "\n";
        salida += "3.- Ver mis pedidos realizados" + "\n";
        salida += "4.- Ver mis datos personales" + "\n";
        salida += "5.- Modificar mis datos personales" + "\n";
        salida += "6.- Cerrar sesión" + "\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    //Menu del trabajador
    public static String menuTrabajador(Trabajador trabajador) {
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + trabajador.getNombre() + ". Tienes 0 pedidos que gestionar\n";
        salida += "1.- Consultar los pedidos que tengo asignados" + "\n";
        salida += "2.- Modificar el estado de un pedido" + "\n";
        salida += "3.- Consultar el catálogo de productos" + "\n";
        salida += "4.- Modificar un producto del catálogo" + "\n";
        salida += "5.- Ver mi perfil" + "\n";
        salida += "6.- Modificar mis datos personales" + "\n";
        salida += "7.- Cerrar sesión" + "\n";
        salida += "Introduce una opción:";
        return salida;
    }

    //Menu de registro del programa principal
    public static void menuRegistro(Tienda tienda) {
        String correoTeclado, contraTeclado, nombreTeclado, direccionTeclado, localidadTeclado, provinciaTeclado;
        int telefonoTeclado;

        System.out.print("""
                REGISTRO:
                Introduce un nombre para su cuenta:\s""");
        nombreTeclado = S.nextLine();
        System.out.print("Introduce la contraseña de tu cuenta: ");
        contraTeclado = S.nextLine();
        System.out.print("Introduzca correo electrónico: ");
        correoTeclado = S.nextLine();
        System.out.print("Introduce tu direccion: ");
        direccionTeclado = S.nextLine();
        System.out.print("Introduce su localidad: ");
        localidadTeclado = S.nextLine();
        System.out.print("Introduce su provincia: ");
        provinciaTeclado = S.nextLine();
        System.out.print("Introduzca su teléfono: ");
        telefonoTeclado = Integer.parseInt(S.nextLine());
        System.out.println((tienda.registro(correoTeclado, contraTeclado, nombreTeclado, direccionTeclado,
                localidadTeclado, provinciaTeclado, telefonoTeclado) ?
                "Se ha registrado correctamente" : "No se ha podido registrar"));
    }

    //Menu del trabajador que modifica un producto del catalogo
    public static void modificaCatalogo(Tienda tienda) {
        Productos temp = null;

        String nombreTeclado;
        int productoTeclado, cantidadTeclado;
        double precioTeclado;

        System.out.println(tienda.pintaCatalogo());
        System.out.print("Introduce el número del producto ha modificar: ");
        productoTeclado = Integer.parseInt(S.nextLine());
        temp = tienda.eligeProducto(productoTeclado);
        if (temp != null) {
            System.out.print("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior): ");
            nombreTeclado = S.nextLine();
            System.out.print("Introduzca un precio nuevo (introduce '-1' para dejar el anterior): ");
            precioTeclado = Double.parseDouble(S.nextLine());
            System.out.print("Introduzca una nueva cantidad (introduce '-1' para dejar el anterior): ");
            cantidadTeclado = Integer.parseInt(S.nextLine());
            tienda.modificaProducto(nombreTeclado, precioTeclado, cantidadTeclado, temp);
        } else System.out.println("Producto no encontrado...");
    }

    // Realiza Pedido de un cliente
    public static void realizaPedido(Tienda tienda, Cliente clienteTemp) {
        String op;
        int productoTeclado, cont;
        boolean finalizado = false;

        cont = 0;
        Productos producto1 = null, producto2 = null, producto3 = null;
        Pedidos pedido = null;

        System.out.println(tienda.pintaCatalogo());
        System.out.print("Introduce el número del producto mostrado en el catálogo (máx 3 productos): ");
        productoTeclado = Integer.parseInt(S.nextLine());
        producto1 = tienda.eligeProducto(productoTeclado);
        if (producto1 != null) {
            System.out.println("Producto agregado a la cesta...");
            cont++;
            System.out.println("¿Deseas continuar llevas " + cont + " productos? (S/N): ");
            op = S.nextLine();
            if (op.equalsIgnoreCase("n")) finalizado = true;
            else {
                System.out.println(tienda.pintaCatalogo());
                System.out.print("Introduce el número del producto mostrado en el catálogo (máx 3 productos): ");
                productoTeclado = Integer.parseInt(S.nextLine());
                producto2 = tienda.eligeProducto(productoTeclado);
                if (producto2 != null) {
                    System.out.println("Producto agregado a la cesta...");
                    cont++;
                    System.out.println("¿Deseas continuar llevas " + cont + " productos? (S/N): ");
                    op = S.nextLine();
                    if (op.equalsIgnoreCase("n")) finalizado = true;
                    else {
                        System.out.println(tienda.pintaCatalogo());
                        System.out.print("Introduce el número del producto mostrado en el catálogo (máx 3 productos): ");
                        productoTeclado = Integer.parseInt(S.nextLine());
                        producto3 = tienda.eligeProducto(productoTeclado);
                        if (producto3 != null) {
                            System.out.println("Producto agregado a la cesta...");
                            finalizado = true;
                        }
                    }
                }
            }
        }
        if (finalizado) {
            pedido = tienda.agregaCesta(producto1, producto2, producto3, clienteTemp);
            System.out.println((tienda.realizaPedido(pedido, clienteTemp) ? "Compra finalizada con exito..." : "Ha ocurrido un error"));
        }
    }


}
