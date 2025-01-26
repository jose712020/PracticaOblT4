package models;

import java.time.LocalDate;

public class Pedidos {
    private String id;
    private String fecha;
    private String fechaLlegada;
    private String comentario;
    private String estado;
    private String direccionEntrega;
    private Productos producto1;
    private Productos producto2;
    private Productos producto3;
    private static int contadorPedidos;
    private Cliente clientePedido;
    private static int contid = 0;

    //Constructor bugfix con 1 producto
    public Pedidos (Productos producto1, String direccionEntrega){
        id = "" + LocalDate.now().getMonthValue() + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + contid++;
        this.producto1 = producto1;
        fecha = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        fechaLlegada = (LocalDate.now().getDayOfMonth() + 5) + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        contadorPedidos++;
        this.direccionEntrega = direccionEntrega;
    }
    //Constructor bugfix con 2 productos
    public Pedidos (Productos producto1, Productos producto2, String direccionEntrega){
        id = "" + LocalDate.now().getMonthValue() + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + contid++;
        this.producto1 = producto1;
        this.producto2 = producto2;
        fecha = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        fechaLlegada = (LocalDate.now().getDayOfMonth() + 5) + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        contadorPedidos++;
        this.direccionEntrega = direccionEntrega;
    }
    //Constructor bugfix con 3 productos
    public Pedidos (Productos producto1, Productos producto2, Productos producto3, String direccionEntrega){
        id = "" + LocalDate.now().getMonthValue() + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + contid++;
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        fecha = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        fechaLlegada = (LocalDate.now().getDayOfMonth() + 5) + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        contadorPedidos++;
        this.direccionEntrega = direccionEntrega;
    }

    //Getters y setters
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getId() {
        return id;
    }

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(Cliente cliente) {
        clientePedido = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Productos getProducto1() {
        return producto1;
    }

    public Productos getProducto2() {
        return producto2;
    }

    public Productos getProducto3() {
        return producto3;
    }

    //Métodos
    public double sumarPrecioProductos(){
        double precioTotal = -1;
        if (producto1 != null && producto2 == null && producto3 == null) precioTotal = producto1.getPrecio();
        if (producto1 != null && producto2 != null && producto3 == null) precioTotal = producto1.getPrecio() + producto2.getPrecio();
        if (producto1 != null && producto2 != null && producto3 != null) precioTotal = producto1.getPrecio() + producto2.getPrecio() + producto3.getPrecio();
        return precioTotal;
    }

    public int sumarProductosPedido(){
        int contador = 0;
        if (producto1 != null && producto2 == null && producto3 == null) contador = 1;
        if (producto1 != null && producto2 != null && producto3 == null) contador = 2;
        if (producto1 != null && producto2 != null && producto3 != null) contador = 3;
        return contador;
    }



    public String pintarProducto1Pedido(){
        return "- " + producto1.getNombre() + " (" + producto1.getPrecio() + "€)";
    }

    public String pintarProducto2Pedido(){
        return "- " + producto2.getNombre() + " (" + producto2.getPrecio() + "€)";
    }

    public String pintarProducto3Pedido(){
        return "- " + producto3.getNombre() + " (" + producto3.getPrecio() + "€)";
    }
}
