package utils;

import models.Cliente;
import models.Tienda;
import models.Trabajador;

import java.util.Scanner;

public class Menus {
    public static final Scanner S = new Scanner(System.in);

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

    public static String menuCliente(Cliente cliente){
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

    public static String menuTrabajador(Trabajador trabajador){
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

}
