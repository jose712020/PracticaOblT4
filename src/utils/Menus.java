package utils;

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

}
