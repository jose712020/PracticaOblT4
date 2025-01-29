package models;

public class Productos {
    //Atributos
    private String nombre;
    private double precio;

    //Constructor
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Métodos
    public String pintaDatos() {
        String salida = "";
        salida += "**************************************************\n";
        salida += "Nombre: " + nombre + "\n";
        salida += "Precio: " + precio + "\n";
        return salida;
    }

}
