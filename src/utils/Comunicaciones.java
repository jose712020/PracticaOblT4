package utils;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class Comunicaciones {
    public static boolean enviaMensajeTelegram(String mensaje) {
        String direccion; // URL de la API de mi bot en mi conversación
        String fijo="https://api.telegram.org/bot7933251856:AAGX2oHNIFDQKXDq4PmQbst5v1zBQfddpZY/sendMessage?chat_id=1187949150&text=";
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

    public static boolean enviaCorreo(String destino, String mensaje, String asunto){
        boolean resultado = false;
        //Guardamos la dirección que va a remitir el mensaje
        String emisor = "fernanshopjlmanule@gmail.com";
        String usuario = "fernanshopjlmanule@gmail.com";//Usuario para el logueo en el server de correo
        String clave = "ceoeptmyuekuvbge";//Clave del usuario de correo
        //Host del servidor de correo
        String host = "smtp.gmail.com";
        //Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //Obtenemos la sesión en nuestro servidor de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(usuario, clave);
            }
        });
        try {
            //Creamos un mensaje de correo por defecto
            Message message = new MimeMessage(session);
            //En el mensaje, establecemos el emisor con los datos pasado sa la función
            message.setFrom(new InternetAddress(emisor));
            //En el mensaje, establecemos el receptor
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            //Establecemos el Asunto
            message.setSubject(asunto);
            //Añadimos el contenido del mensaje
            //message.setText(mensaje); Si solo mandamos texto
            message.setContent(mensaje, "text/html; charset=utf-8");
            //Intentamos mandar el mensaje
            Transport.send(message);
            resultado = true;
        } catch (Exception e){
            System.out.println("El correo introducido no es válido");
        }
        return resultado;
    }
}
