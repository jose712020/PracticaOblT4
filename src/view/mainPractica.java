package view;

import models.*;
import utils.Comunicaciones;
import utils.Menus;
import utils.Utils;

import java.util.Scanner;

public class mainPractica {
    public static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {

        Tienda tienda = new Tienda();
        tienda.mock();
        Cliente clienteTemp = null;
        Trabajador trabajadorTemp = null;
        Administrador adminTemp = null;

        String op, correoTeclado, contraTeclado, nombreTeclado, claveTeclado, direccionTeclado, localidadTeclado,
                provinciaTeclado, tokenTeclado, token;
        int telefonoTeclado = -2;

        do {
            Menus.portada();
            op = pintaMenu();

            switch (op) { //Switch del programa principal
                case "1": //Iniciar sesión
                    System.out.print("""
                            INICIO DE SESIÓN:
                            Introduzca correo electrónico (Cliente) o nombre (Trabajador o Administrador):\s""");
                    correoTeclado = S.nextLine();
                    System.out.print("Introduce tu contraseña: ");
                    claveTeclado = S.nextLine();
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

            if (clienteTemp != null && clienteTemp.isInicioCorrecto() && !clienteTemp.isValid()) {
                System.out.print("Introduce tu token para registrarte: ");
                tokenTeclado = S.nextLine();
                if (tienda.compruebaToken(clienteTemp, tokenTeclado)) {
                    System.out.println("Token correcto...");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
                else {
                    System.out.println("Token incorrecto...");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            }


            if (clienteTemp != null && clienteTemp.isInicioCorrecto() && clienteTemp.isValid()) { // Menú del cliente
                do {
                    System.out.print(Menus.menuCliente(clienteTemp));
                    op = S.nextLine();
                    switch (op) {
                        case "1"://Consultar el catálogo de productos
                            System.out.println(tienda.pintaCatalogo());
                            Utils.animacionEnvioCorreo();
                            //Comunicaciones.enviaCorreo(clienteTemp.getCorreo(), "Hola, gracias por consultar nuestro productos", "BIENVENIDO AL CATÁLOGO");

                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2"://Realizar un pedido en clientes
                            if (!clienteTemp.hayHuecoPedidos()) System.out.println("No se pueden realizar más pedidos");
                            else Menus.realizaPedido(tienda, clienteTemp);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3"://Ver pedidos realizados de clientes
                            System.out.println(tienda.pintaPedidos(clienteTemp));
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4"://Ver datos personales cliente
                            System.out.println(clienteTemp.pintaDatosCliente());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5"://Modificar datos personales clientes
                            boolean correoValido = false, correoDistinto = false;
                            do {
                                do {  //Bucle que comprobará que el correo nuevo no se repita con el de otra persona
                                    System.out.print(""" 
                                        MODIFICACIÓN DE DATOS:
                                        Introduzca un nuevo correo electrónico:\s""");
                                    correoTeclado = S.nextLine();
                                    if (tienda.compruebaCorreos(correoTeclado)) correoDistinto = true;
                                    else {
                                        System.out.println("Este correo ya está en uso, introduzca uno nuevo...");
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();
                                    }
                                } while (!correoDistinto);
                                System.out.print("Introduce una nueva contraseña para tu cuenta: ");
                                contraTeclado = S.nextLine();
                                System.out.print("Introduce un nuevo nombre para tu cuenta (-1 para dejar mismos datos): ");
                                nombreTeclado = S.nextLine();
                                System.out.print("Introduce tu nueva dirección (-1 para dejar mismos datos): ");
                                direccionTeclado = S.nextLine();
                                System.out.print("Introduce su nueva localidad (-1 para dejar mismos datos): ");
                                localidadTeclado = S.nextLine();
                                System.out.print("Introduce su nueva provincia (-1 para dejar mismos datos): ");
                                provinciaTeclado = S.nextLine();
                                do {
                                    System.out.print("Introduzca su nuevo teléfono (-1 para dejar mismos datos): ");
                                    try {
                                        telefonoTeclado = Integer.parseInt(S.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Introduzca un valor numérico...");
                                        telefonoTeclado = -2;
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();
                                    }
                                } while (telefonoTeclado == -2);
                                //Generamos el token despues de la modificacion de datos
                                token = tienda.generaToken();

                                if (Comunicaciones.enviaCorreo(correoTeclado, "¡Hola! Bienvenido a FERNANDSHOP " + nombreTeclado + " " +
                                        "tu token de verificación de la cuenta es " + token, "TU CÓDIGO DE VERIFICACIÓN DE CUENTA"))
                                    correoValido = true;
                                else {
                                    Utils.pulsaContinuar();
                                    Utils.limpiarpantalla();
                                }
                            } while (!correoValido);
                            clienteTemp.modificarDatosCliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado, token);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();

                            System.out.print("Introduce tu nuevo token para continuar: ");
                            tokenTeclado = S.nextLine();
                            if (tienda.compruebaToken(clienteTemp, tokenTeclado)) {
                                System.out.println("Token correcto...");
                                clienteTemp.setValid(true);
                            } else {
                                System.out.println("Token incorrecto...");
                                clienteTemp.apagadoInicioCorrecto();
                                Utils.animacionFinSesion();
                            }

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
                }
                while (clienteTemp.isValid() && !op.equals("6"));
            } // Fin del menú del cliente

            if (trabajadorTemp != null && trabajadorTemp.isInicioCorrecto()) { // Menú Trabajadores
                do {
                    System.out.print(Menus.menuTrabajador(trabajadorTemp));
                    op = S.nextLine();
                    switch (op) {
                        case "1": //Consultar los pedidos que tengo asignados
                            Menus.consultarPedidosAsignados(tienda, trabajadorTemp);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido
                            Menus.modificaEstadoPedido(tienda);
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
                            nombreTeclado = S.nextLine();
                            System.out.print("Introduce la nueva clave del trabajador: ");
                            contraTeclado = S.nextLine();
                            do {
                                System.out.print("Introduzca su nuevo teléfono (-1 para dejar mismos datos): ");
                                try {
                                    telefonoTeclado = Integer.parseInt(S.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Introduzca un valor numérico...");
                                    Utils.pulsaContinuar();
                                    Utils.limpiarpantalla();
                                }
                            } while (telefonoTeclado == -2);
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

            if (adminTemp != null && adminTemp.isInicioCorrecto()) { // Menú del administrador
                do {
                    System.out.print(Menus.menuAdministrador(tienda));
                    op = S.nextLine();
                    switch (op) {
                        case "1": //Asignar un pedido a un trabajador
                            Menus.asignarPedidos(tienda);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido
                            Menus.modificaEstadoPedido(tienda);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3": //Dar de alta un trabajador
                            if (tienda.todoLlenoTrabajadores())
                                System.out.println("No se pueden dar de alta más trabajadores.");
                            else {
                                System.out.print("Introduce el nombre del trabajador: ");
                                nombreTeclado = S.nextLine();
                                System.out.print("Introduce la clave del trabajador: ");
                                contraTeclado = S.nextLine();
                                System.out.print("Introduce el correo del trabajador: ");
                                correoTeclado = S.nextLine();
                                do {
                                    System.out.print("Introduce el teléfono del trabajador: ");
                                    try {
                                        telefonoTeclado = Integer.parseInt(S.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Introduce un valor numérico...");
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();
                                    }
                                } while (telefonoTeclado == -2);
                                System.out.println(
                                        ((tienda.darAltaTrabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado)
                                                ? "Se ha registrado perfectamente" : "Ha ocurrido un error")));
                            }
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Ver todos los pedidos
                            System.out.println(tienda.pintaPedidosAdmin());
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
                            adminTemp.apagadoInicioCorrecto();
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

    private static boolean compruebaToken(Cliente clienteTemp, Tienda tienda) {
        String tokenTeclado;

        if (clienteTemp != null && clienteTemp.isInicioCorrecto() && !clienteTemp.isValid()) {
            System.out.print("Introduce tu token para registrarte: ");
            tokenTeclado = S.nextLine();
            return tienda.compruebaToken(clienteTemp, tokenTeclado);
        }
        return false;
    }

    //Funcion que pinta el Menú principal y devuelve la respuesta del cliente
    private static String pintaMenu() {
        String op = "";
        System.out.print("""
                BIENVENIDO.
                1. Iniciar sesión
                2. Registrarse
                ELIGE UNA OPCIÓN:\s""");
        op = S.nextLine();
        return op;
    }
}