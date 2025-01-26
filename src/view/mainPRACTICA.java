package view;

import models.*;
import utils.Menus;
import utils.Utils;

import java.util.Scanner;

public class mainPRACTICA {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Tienda tienda = new Tienda();
        String op;

        do {
            System.out.print(Menus.inicioSesion());
            op = s.nextLine();

            switch (op) {
                case "1": //Iniciar sesión
                    tienda.inicioSesion();
                    break;
                case "2": //Registrarse
                    tienda.registro();
                    break;
                default:
                    System.out.println("Opción incorrecta...");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
            }

            if (tienda.inicioSesionCliente1() || tienda.inicioSesionCliente2()) { //Login Clientes
                do {
                    if (tienda.inicioSesionCliente1()) System.out.println(tienda.getC1().menuCliente());
                    if (tienda.inicioSesionCliente2()) System.out.println(tienda.getC2().menuCliente());
                    op = s.nextLine();
                    switch (op) {
                        case "1"://Consultar el catálogo de productos
                            System.out.println(tienda.pintaCatalogo());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2"://Realizar un pedido en clientes
                            if (tienda.inicioSesionCliente1() || tienda.inicioSesionCliente2()) {
                                if (tienda.inicioSesionCliente1() && !tienda.getC1().hayHueco() || tienda.inicioSesionCliente2()  && !tienda.getC2().hayHueco()) {
                                    System.out.println("No se pueden realizar más pedidos");
                                    Utils.pulsaContinuar();
                                    Utils.limpiarpantalla();
                                } else {
                                    if (tienda.inicioSesionCliente1()) tienda.realizaPedidoCliente1();
                                    if (tienda.inicioSesionCliente2()) tienda.realizaPedidoCliente2();
                                }
                            } //Si algun cliente a iniciado sesion
                            break;
                        case "3"://Ver pedidos realizados de clientes
                            if (tienda.inicioSesionCliente1()) {
                                System.out.println(tienda.pintaPedidoCliente1());
                                Utils.pulsaContinuar();
                                Utils.limpiarpantalla();
                            }
                            if (tienda.inicioSesionCliente2()) {
                                System.out.println(tienda.pintaPedidoCliente2());
                                Utils.pulsaContinuar();
                                Utils.limpiarpantalla();
                            }
                            break;
                        case "4"://Ver datos personales cliente
                            if (tienda.inicioSesionCliente1()) System.out.println(tienda.pintaCliente1());
                            if (tienda.inicioSesionCliente2()) System.out.println(tienda.pintaCliente2());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5"://Modificar datos personales clientes
                            if (tienda.inicioSesionCliente1()) {
                                tienda.modificarDatosPersonalesC1();
                                tienda.encendidoInicioSesionCliente1();
                            }
                            if (tienda.inicioSesionCliente2()) {
                                Menus.modificarDatosPersonalesC2(tienda);
                                tienda.encendidoInicioSesionCliente2();
                            }
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6"://Cerrar sesión clientes
                            if (tienda.inicioSesionCliente1()) tienda.apagadoInicioSesionCliente1();
                            if (tienda.inicioSesionCliente2()) tienda.apagadoInicioSesionCliente2();
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
            } //Login Clientes

            if (tienda.inicioSesionT1() || tienda.inicioSesionT2() || tienda.inicioSesionT3()) {
                do {
                    if (tienda.inicioSesionT1()) System.out.println(tienda.getT1().menuTrabajador());
                    if (tienda.inicioSesionT2()) System.out.println(tienda.getT2().menuTrabajador());
                    if (tienda.inicioSesionT3()) System.out.println(tienda.getT3().menuTrabajador());
                    op = s.nextLine();
                    switch (op) {
                        case "1": //Consultar los pedidos que tengo asignados
                            if (tienda.inicioSesionT1()) System.out.println(tienda.verPedidosAsignadosT1());
                            if (tienda.inicioSesionT2()) System.out.println(tienda.verPedidosAsignadosT2());
                            if (tienda.inicioSesionT3()) System.out.println(tienda.verPedidosAsignadosT3());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido
                            if (tienda.inicioSesionT1()) tienda.modificarEstadoPedidoT1();
                            if (tienda.inicioSesionT2()) tienda.modificarEstadoPedidoT2();
                            if (tienda.inicioSesionT3()) tienda.modificarEstadoPedidoT3();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3": //Consultar el catálogo de productos
                            System.out.println(tienda.pintaCatalogo());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Modificar un producto del catálogo
                            tienda.modificarProductoCatalogoTrabajador();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5": //Ver mi perfil
                            if (tienda.inicioSesionT1()) System.out.println(tienda.perfilTrabajador1());
                            if (tienda.inicioSesionT2()) System.out.println(tienda.perfilTrabajador2());
                            if (tienda.inicioSesionT3()) System.out.println(tienda.perfilTrabajador3());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Modificar mis datos personales
                            if (tienda.inicioSesionT1()) {
                                tienda.modificarDatosPersonalesT1();
                                tienda.encendidoInicioSesionT1();
                            }
                            if (tienda.inicioSesionT2()) {
                                tienda.modificarDatosPersonalesT2();
                                tienda.encendidoInicioSesionT2();
                            }
                            if (tienda.inicioSesionT3()) {
                                tienda.modificarDatosPersonalesT3();
                                tienda.encendidoInicioSesionT3();
                            }
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Cerrar sesión
                            if (tienda.inicioSesionT1()) tienda.apagadoInicioSesionT1();
                            if (tienda.inicioSesionT2()) tienda.apagadoInicioSesionT2();
                            if (tienda.inicioSesionT3()) tienda.apagadoInicioSesionT3();
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
            } //Login Trabajadores

            if (tienda.inicioSesionAdmin()) {
                do {
                    System.out.println(tienda.getAdmin().menuAdministrador());
                    op = s.nextLine();
                    switch (op) {
                        case "1": //Asignar un pedido a un trabajador
                            tienda.asignarPedidoTrabajador();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2": //Modificar el estado de un pedido
                            tienda.modificarEstadoPedidoAdmin();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "3": //Dar de alta un trabajador
                            if (tienda.todoLlenoTrabajadores()) System.out.println("No se pueden dar de alta más trabajadores.");
                            else tienda.darAltaTrabajador();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Ver todos los pedidos
                            if (tienda.noExisteCliente1()) System.out.println("El cliente 1 no existe");
                            else if (tienda.getC1().nohayPedidos()) System.out.println("El cliente 1 no ha realizado ningún primer pedido");
                            else System.out.println(tienda.pintaPedidoC1());
                            if (tienda.noExisteCliente2()) System.out.println("El cliente 2 no existe");
                            else if (tienda.getC2().nohayPedidos()) System.out.println("El cliente 1 no ha realizado ningún segundo pedido");
                            else System.out.println(tienda.pintaPedidoC2());
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
            } //Login Admin
        } while (true); //Bucle programa principal
    }
}