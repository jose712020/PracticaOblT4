package utils;

import models.Cliente;
import models.Tienda;

import java.util.Scanner;

public class Menus {

    public static final Scanner S = new Scanner(System.in);

    public static String inicioSesion() {
        String salida = "";
        salida += """
                    BIENVENIDO.
                    1. Iniciar sesión
                    2. Registrarse
                    ELIGA UNA OPCIÓN:\s""";
        return salida;
    }


    public static void modificarDatosPersonalesC2(Tienda tienda) {
        Scanner s = new Scanner(System.in);
        String correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, nombreTeclado;
        int telefonoTeclado;

        System.out.print(""" 
                MODIFICACIÓN DE DATOS:
                Introduzca nuevo correo electrónico:\s""");
        correoTeclado = s.nextLine();
        System.out.print("Introduce la nueva contraseña de tu cuenta: ");
        contraTeclado = s.nextLine();
        System.out.print("Introduce un nuevo nombre para su cuenta: ");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce tu nueva direccion (o repita datos): ");
        direccionTeclado = s.nextLine();
        System.out.print("Introduce su nueva localidad (o repita datos): ");
        localidadTeclado = s.nextLine();
        System.out.print("Introduce su nueva provincia (o repita datos): ");
        provinciaTeclado = s.nextLine();
        System.out.print("Introduzca su nuevo teléfono (o repita datos): ");
        telefonoTeclado = Integer.parseInt(s.nextLine());

        tienda.getC2().modificarDatosCliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
    }



}
