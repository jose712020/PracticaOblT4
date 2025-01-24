package models;

public class Trabajador {
    //Atributos
    private String nombre;
    private String clave;
    private String correo;
    private int telefono;
    private boolean inicioCorrecto;

    //Constructor
    public Trabajador(String nombre, String clave, String correo, int telefono) {
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.telefono = telefono;
        inicioCorrecto = false;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isInicioCorrecto() {
        return inicioCorrecto;
    }

    public void setInicioCorrecto(boolean inicioCorrecto) {
        this.inicioCorrecto = inicioCorrecto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //Otros metodos
    public void inicioCorrectoEncendido() {
        setInicioCorrecto(true);
    }

    public void apagadoInicioCorrecto() {
        setInicioCorrecto(false);
    }

    public String pintaDatosTrabajador() {
        String salida = "";
        salida += "\n******************\n";
        salida += "Nombre: " + nombre + "\n";
        salida += "Correo: " + correo + "\n";
        salida += "Teléfono: " + telefono + "\n\n";
        return salida;
    }

    //Metodo que modifica los datos del trabajador
    public void modificarDatosTrabajador(String nombreTeclado, String contraTeclado, int telefonoTeclado) {
        nombre = nombreTeclado;
        clave = contraTeclado;
        if (telefonoTeclado != -1) telefono = telefonoTeclado;
    }
}
