package models;

public class Productos {
    private String nombre;
    private double precio;
    private static int cantProductos = 1;

    //Constructor
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    //Métodos
    public String pintaCatalogo(){
        String salida = "";
        if (cantProductos > 8) cantProductos = 1;
        salida += "= PRODUCTO " + cantProductos++ + " =\n";
        salida += nombre + " - " + precio + "\n";
        salida += "=============================\n";
        return salida;
    }


}