package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Comunicaciones {
    public static boolean enviaMensajeTelegram(String mensaje) {
        String direccion; // URL de la API de mi bot en mi conversación
        
        direccion = fijo + mensaje; //Metemos el mensaje al final
        URL url;
        boolean dev;
        dev=false;
        try {
            url = new URL(direccion);  // Creando un objeto URL con la dirección de la API de mi bot
            URLConnection con = url.openConnection();  // Realizando la petición GET
            // Con esto, copiamos en un la respuesta HTTP, por si lo necesitamos
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev=true;  // Ha tenido éxito
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dev;  // Devuelvo si ha tenido éxito o no
    }
}
