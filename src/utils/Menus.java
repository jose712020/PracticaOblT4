package utils;

import models.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menus {
    public static final Scanner S = new Scanner(System.in);

    //Menu del administrador
    public static String menuAdministrador(Tienda tienda) {
        String salida = "";
        salida += "FERNANSHOP\n";
        salida += "Bienvenido " + tienda.getAdmin().getNombre() + ". Tienes " + tienda.contadorPedidos() +
                (tienda.contadorPedidos() == 1 ? " pedido" : " pedidos") + " por asignar." + "\n";
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


    //Metodo que modifica el estado de un pedido el administrador
    public static void modificaEstadoPedido(Tienda tienda) {
        Pedidos pedido = null;
        String comentarioTeclado = "", fechaTeclado = "", respuestaTeclado = "";
        int id, estadoTeclado = -1, dia = -1, mes = -1, anio = -1;

        System.out.println("============ Modificación de pedidos ============");
        if (tienda.existeCliente(tienda.getC1())) System.out.println(tienda.pintaPedidosModificar(tienda.getC1()));
        if (tienda.existeCliente(tienda.getC2())) System.out.println(tienda.pintaPedidosModificar(tienda.getC2()));
        System.out.print("Introduce la ID del pedido a modificar (-1 en caso de que no haya pedidos): ");
        id = Integer.parseInt(S.nextLine());
        pedido = tienda.encuentraId(id);
        if (pedido == null) System.out.println("Pedido no encontrado...");
        else {
            System.out.println("==== Actualización del pedido " + pedido.getId() + " ====");
            System.out.println("Estado del pedido: " + pedido.getEstado());
            System.out.print("""
                    Nuevo estado:
                        1. Recibido
                        2. En preparación
                        3. Retrasado
                        4. Cancelado
                        5. Enviado
                    Seleccione el nuevo estado:\s""");
            estadoTeclado = Integer.parseInt(S.nextLine());
            if (!pedido.modificaEstado(estadoTeclado)) System.out.println("Ha ocurrido un error...");
            else {
                System.out.println("Estado actualizado correctamente.\n");

                System.out.print("¿Quiere indicar una nueva fecha de entrega? (S/N): ");
                respuestaTeclado = S.nextLine();

                if (respuestaTeclado.equalsIgnoreCase("s")) {
                    System.out.print("Introduce el día de la nueva fecha: ");
                    dia = Integer.parseInt(S.nextLine());
                    System.out.print("Introduce el mes de la nueva fecha: ");
                    mes = Integer.parseInt(S.nextLine());
                    System.out.print("Introduce el año de la nueva fecha: ");
                    anio = Integer.parseInt(S.nextLine());
                    System.out.println(pedido.modificaFecha(anio, mes, dia)
                            ? "Fecha actualizada correctamente" : "Ha ocurrido un error...");
                }
                System.out.print("¿Quiere añadir un comentario al pedido? (S/N): ");
                respuestaTeclado = S.nextLine();

                if (respuestaTeclado.equalsIgnoreCase("s")) {
                    System.out.print("Introduzca el nuevo comentario: ");
                    comentarioTeclado = S.nextLine();
                    pedido.modificaComentario(comentarioTeclado);
                    System.out.println("Comentario guardado correctamente.");
                }
            } //LLave del else que ha modificado el estado de un pedido
        } //Llave del else que encuentra una ID de un pedido

    }

    // Logo del menú principal
    public static void portada() {
        System.out.println("""
                
                ███████╗███████╗██████╗ ███╗   ██╗ █████╗ ███╗   ██╗███████╗██╗  ██╗ ██████╗ ██████╗\s
                ██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗████╗  ██║██╔════╝██║  ██║██╔═══██╗██╔══██╗
                █████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██╔██╗ ██║███████╗███████║██║   ██║██████╔╝
                ██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║╚██╗██║╚════██║██╔══██║██║   ██║██╔═══╝\s
                ██║     ███████╗██║  ██║██║ ╚████║██║  ██║██║ ╚████║███████║██║  ██║╚██████╔╝██║    \s
                ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝    \s
                                                                                                    \s
                """);
    }

    public static void asignarPedidos(Tienda tienda) {
        Pedidos pedido;
        int op;
        System.out.println("============ Asignación de trabajadores a pedidos ============");
        System.out.println(tienda.pintaAsignacionPedido());
        System.out.println("Seleccione el pedido a asignar (-1 si no hay pedidos): ");
        op = Integer.parseInt(S.nextLine());
        pedido = tienda.asignacionPedido(op);
        if (pedido != null) {
            System.out.println("\n==== Asignación del pedido " + pedido.getId() + " ====");
            System.out.println(tienda.pintaAsignacionPedidoTrabajadores());
            System.out.print("Seleccione el trabajador: ");
            op = Integer.parseInt(S.nextLine());
        } else System.out.println("Pedido no encontrado...");

    }
}
