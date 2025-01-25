package view;

import models.*;
import utils.Menus;
import utils.Utils;

import java.util.Scanner;

public class mainPractica {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Tienda tienda = new Tienda();
        tienda.mock();
        Cliente clienteTemp = null;
        Trabajador trabajadorTemp = null;
        Administrador adminTemp = null;
        Pedidos pedidoTemp = null;

        String op, correoTeclado, contraTeclado, nombreTeclado, claveTeclado, direccionTeclado, localidadTeclado, provinciaTeclado;
        int telefonoTeclado, productoTeclado, cont;
        boolean continuar = false;

        do {
            System.out.print("""
                    BIENVENIDO.
                    1. Iniciar sesión
                    2. Registrarse
                    ELIGA UNA OPCIÓN:\s""");
            op = s.nextLine();

            switch (op) { //Switch del programa principal
                case "1": //Iniciar sesión
                    System.out.print("""
                            INICIO DE SESIÓN:
                            Introduzca correo electrónico (Cliente) o nombre (Trabajador o Admininistrador):\s""");
                    correoTeclado = s.nextLine();
                    System.out.print("Introduce tu contraseña: ");
                    claveTeclado = s.nextLine();
                    //En caso de los clientes
                    clienteTemp = tienda.inicioSesionCliente(correoTeclado, claveTeclado);
                    if (clienteTemp != null) clienteTemp.inicioCorrectoEncendido();
                    //En caso de los trabajadores
                    trabajadorTemp = tienda.inicioSesionTrabajador(correoTeclado, claveTeclado);
                    if (trabajadorTemp != null) trabajadorTemp.inicioCorrectoEncendido();
                    //En caso del administrador
                    adminTemp = tienda.inicioSesionAdmin(correoTeclado, claveTeclado);
                    if (adminTemp != null) adminTemp.inicioCorrectoEncendido();
                    if (clienteTemp == null && trabajadorTemp == null && adminTemp == null)
                        System.out.println("Datos incorrectos...");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    break; //Iniciar sesión
                case "2": //Registrarse
                    Utils.limpiarpantalla();
                    if (tienda.noHayHuecoClientes()) System.out.println("No hay hueco para registrar más clientes...");
                    else {
                        Menus.menuRegistro(tienda);
                    }
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    break; //Registrarse
                default:
                    System.out.println("Opción incorrecta");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    break;
            }

            if (clienteTemp != null && clienteTemp.isInicioCorrecto()) { // Menú del cliente
                do {
                    System.out.print(Menus.menuCliente(clienteTemp));
                    op = s.nextLine();
                    switch (op) {
                        case "1"://Consultar el catálogo de productos
                            System.out.println(tienda.pintaCatalogo());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2"://Realizar un pedido en clientes
                            if (!clienteTemp.hayHuecoPedidos()) System.out.println("No se pueden realizar más pedidos");
                            else {
                                cont = 0;
                                Productos productoTemp = null;
                                Pedidos pedido = null;
                                System.out.println(tienda.pintaCatalogo());
                                System.out.print("Introduce el número del producto mostrado en el catálogo (máx 3 productos): ");
                                productoTeclado = Integer.parseInt(s.nextLine());
                                productoTemp = tienda.aniadeProducto(productoTeclado);
                                if (productoTemp != null) {
                                    System.out.println("Producto agregado a la cesta...");
                                    cont++;
                                    System.out.println("¿Deseas continuar llevas " + cont + " productos? (S/N): ");
                                    op = s.nextLine();
                                    //if (op.equalsIgnoreCase("n")) pedido = tienda.realizaPedido(producto1, producto2, producto3, clienteTemp);
                                }
                            }
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3"://Ver pedidos realizados de clientes

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4"://Ver datos personales cliente
                            System.out.println(clienteTemp.pintaDatosCliente());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5"://Modificar datos personales clientes
                            System.out.print(""" 
                                    MODIFICACIÓN DE DATOS:
                                    Introduzca nuevo correo electrónico:\s""");
                            correoTeclado = s.nextLine();
                            System.out.print("Introduce la nueva contraseña de tu cuenta: ");
                            contraTeclado = s.nextLine();
                            System.out.print("Introduce un nuevo nombre para su cuenta (-1 para dejar mismos datos): ");
                            nombreTeclado = s.nextLine();
                            System.out.print("Introduce tu nueva direccion (-1 para dejar mismos datos): ");
                            direccionTeclado = s.nextLine();
                            System.out.print("Introduce su nueva localidad (-1 para dejar mismos datos): ");
                            localidadTeclado = s.nextLine();
                            System.out.print("Introduce su nueva provincia (-1 para dejar mismos datos): ");
                            provinciaTeclado = s.nextLine();
                            System.out.print("Introduzca su nuevo teléfono (-1 para dejar mismos datos): ");
                            telefonoTeclado = Integer.parseInt(s.nextLine());
                            clienteTemp.modificarDatosCliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6"://Cerrar sesión clientes
                            clienteTemp.apagadoInicioCorrecto();
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                    }
                } while (!op.equals("6"));
            } // Fin del menú del cliente

            if (trabajadorTemp != null && trabajadorTemp.isInicioCorrecto()) { // Menú Trabajadores
                do {
                    System.out.print(Menus.menuTrabajador(trabajadorTemp));
                    op = s.nextLine();
                    switch (op) {
                        case "1": //Consultar los pedidos que tengo asignados

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3": //Consultar el catálogo de productos
                            System.out.println(tienda.pintaCatalogo());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Modificar un producto del catálogo
                            Menus.modificaCatalogo(tienda);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5": //Ver mi perfil
                            System.out.println(trabajadorTemp.pintaDatosTrabajador());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Modificar mis datos personales
                            System.out.print("""
                                    MODIFICACIÓN DE DATOS:
                                    Introduce el nuevo nombre del trabajador:\s""");
                            nombreTeclado = s.nextLine();
                            System.out.print("Introduce la nueva clave del trabajador: ");
                            contraTeclado = s.nextLine();
                            System.out.print("Introduzca su nuevo teléfono (-1 para dejar mismos datos): ");
                            telefonoTeclado = Integer.parseInt(s.nextLine());
                            trabajadorTemp.modificarDatosTrabajador(nombreTeclado, contraTeclado, telefonoTeclado);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Cerrar sesión
                            trabajadorTemp.apagadoInicioCorrecto();
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                    }
                } while (!op.equals("7"));
            } // Fin del menú Trabajadores

            if (tienda.getAdmin().isInicioCorrecto()) { // Menú del administrador
                do {
                    System.out.print(Menus.menuAdministrador(tienda));
                    op = s.nextLine();
                    switch (op) {
                        case "1": //Asignar un pedido a un trabajador

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3": //Dar de alta un trabajador
                            if (tienda.todoLlenoTrabajadores())
                                System.out.println("No se pueden dar de alta más trabajadores.");
                            else {
                                System.out.print("Introduce el nombre del trabajador: ");
                                nombreTeclado = s.nextLine();
                                System.out.print("Introduce la clave del trabajador: ");
                                contraTeclado = s.nextLine();
                                System.out.println("Introduce el correo del trabajador: ");
                                correoTeclado = s.nextLine();
                                System.out.println("Introduce el teléfono del trabajador: ");
                                telefonoTeclado = Integer.parseInt(s.nextLine());
                                System.out.println(
                                        ((tienda.darAltaTrabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado)
                                                ? "Se ha registrado perfectamente" : "Ha ocurrido un error")));
                            }
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Ver todos los pedidos

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5": //Ver todos los clientes
                            System.out.println(tienda.verClientesAdmin());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Ver todos los trabajadores
                            System.out.println(tienda.verTrabajadoresAdmin());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Cerrar sesión
                            tienda.apagadoInicioSesionAdmin();
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                    }
                } while (!op.equals("7"));
            } // Fin del menú del administrador
        } while (true); // Menú del programa principal
    }
}