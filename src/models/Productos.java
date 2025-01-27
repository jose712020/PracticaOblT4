package models;

public class Productos {
    //Atributos
    private String nombre;
    private double precio;
    private int cantidad;

    //Constructor
    public Productos(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Métodos
    public String pintaDatos() {
        String salida = "";
        salida += "**************************************************\n";
        salida += "Nombre: " + nombre + "\n";
        salida += "Precio: " + precio + "\n";
        salida += "Cantidad: " + cantidad + "\n\n";
        return salida;
    }

}
