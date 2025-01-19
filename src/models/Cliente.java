package models;

public class Cliente {
    private String correo;
    private String nombre;
    private String clave;
    private String direccion;
    private String localidad;
    private String provincia;
    private int telefono;
    private Pedidos pedido1;
    private Pedidos pedido2;
    private static int contadorClientes = 0;
    private boolean inicioCorrecto;

    //Constructor
    public Cliente(String correo, String clave, String direccion, String localidad, String provincia, int telefono, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.nombre = nombre;
        pedido1 = null;
        pedido2 = null;
        contadorClientes++;
    }

    //Constructor copia
    public Cliente(Cliente cliente){
        this.correo = cliente.correo;
        this.clave = cliente.clave;
        this.direccion = cliente.direccion;
        this.localidad = cliente.localidad;
        this.provincia = cliente.provincia;
        this.telefono = cliente.telefono;
        this.nombre = cliente.nombre;
    }

    //Getters y setters
    public boolean isInicioCorrecto() {
        return inicioCorrecto;
    }

    public void setInicioCorrecto(boolean inicioCorrecto) {
        this.inicioCorrecto = inicioCorrecto;
    }

    public String getNombre() {
        return nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }


    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public Pedidos getPedido1() {
        return pedido1;
    }


    public Pedidos getPedido2() {
        return pedido2;
    }

    //Métodos
    public boolean hayHueco(){
        return (pedido1 == null || pedido2 == null);
    }

    public boolean nohayPedidos(){
        if (pedido1 == null && pedido2 == null) return true;
        return false;
    }

    public boolean hayPedido1(){
        return pedido1 != null;
    }
    public boolean hayPedido2(){
        return pedido2 != null;
    }

    public boolean realizaPedido(Productos producto1, String direccion){
        if (pedido1 == null){
            pedido1 = new Pedidos(producto1, direccion);
            return true;
        }
        if (pedido2 == null){
            pedido2 = new Pedidos(producto1, direccion);
            return true;
        }
        return false;
    }
    public boolean realizaPedido(Productos producto1, Productos producto2, String direccion){
        if (pedido1 == null){
            pedido1 = new Pedidos(producto1, producto2, direccion);
            return true;
        }
        if (pedido2 == null){
            pedido2 = new Pedidos(producto1, producto2, direccion);
            return true;
        }
        return false;
    }
    public boolean realizaPedido(Productos producto1, Productos producto2, Productos producto3, String direccion){
        if (pedido1 == null){
            pedido1 = new Pedidos(producto1, producto2, producto3, direccion);
            return true;
        }
        if (pedido2 == null){
            pedido2 = new Pedidos(producto1, producto2, producto3, direccion);
            return true;
        }
        return false;
    }
    public double recibirPrecioTotal(){
        if (pedido1 != null && pedido2 == null) return pedido1.sumarPrecioProductos();
        if (pedido1 != null && pedido2 != null) return pedido2.sumarPrecioProductos();
        return -1;
    }

    public String pintaCliente() {
        return "================================\n" +
                "Cliente: " + nombre + "\n" +
                "Correo: " + correo + "\n" +
                "Clave: " + clave + "\n" +
                "Direccion: " + direccion + "\n" +
                "Localidad: " + localidad + "\n" +
                "Provincia: " + provincia + "\n" +
                "Telefono: " + telefono + "\n" +
                "================================";
    }

    public String menuCliente(){
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + nombre + "\n";
        salida += "1.- Consultar el catálogo de productos" + "\n";
        salida += "2.- Realizar un pedido" + "\n";
        salida += "3.- Ver mis pedidos realizados" + "\n";
        salida += "4.- Ver mis datos personales" + "\n";
        salida += "5.- Modificar mis datos personales" + "\n";
        salida += "6.- Cerrar sesión" + "\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    public boolean iniciaSesion(String contraTeclado, String correoTeclado) {
        return (contraTeclado.equals(getClave()) && correoTeclado.equals(getCorreo()));
    }

    public String pintaPedido1(){
        String salida = "";
        salida += "==========\tPedido " + pedido1.getId() + "\t===========\n";
        salida += "Estado: " + (pedido1.getEstado() == null ? "" : pedido1.getEstado()) + "\n";
        salida += "Cliente: " + nombre + "\n";
        salida += "Dirección: " + pedido1.getDireccionEntrega() + "\n";
        salida += "Localidad: " + localidad + "\n";
        salida += "Provincia: " + provincia + "\n";
        salida += "Teléfono: " + telefono + "\n";
        salida += "Correo: " + correo + "\n";
        salida += "Fecha del pedido: " + (pedido1 == null ? "" : pedido1.getFecha()) + "\n";
        salida += "Fecha de entrega estimada: " + (pedido1 == null ? "" : pedido1.getFechaLlegada()) + "\n";
        salida += "Comentario del pedido: " + (pedido1.getComentario() == null ? "" : pedido1.getComentario()) + "\n";
        salida += "Detalles del pedido:\n";
        salida += (pedido1.getProducto1() == null ? "" : pedido1.pintarProducto1Pedido()) + "\n";
        salida += (pedido1.getProducto2() == null ? "" : pedido1.pintarProducto2Pedido()) + "\n";
        salida += (pedido1.getProducto3() == null ? "" : pedido1.pintarProducto3Pedido()) + "\n";
        salida += "Total pedido: " + pedido1.sumarPrecioProductos() + "€\n";
        return salida;
    }

    public String pintaPedido2(){
        String salida = "";
        salida += "==========\tPedido " + pedido2.getId() + "\t===========\n";
        salida += "Estado: " + (pedido2.getEstado() == null ? "" : pedido2.getEstado()) + "\n";
        salida += "Cliente: " + nombre + "\n";
        salida += "Dirección: " + pedido2.getDireccionEntrega() + "\n";
        salida += "Localidad: " + localidad + "\n";
        salida += "Provincia: " + provincia + "\n";
        salida += "Teléfono: " + telefono + "\n";
        salida += "Correo: " + correo + "\n";
        salida += "Fecha del pedido: " + (pedido2 == null ? "" : pedido2.getFecha()) + "\n";
        salida += "Fecha de entrega estimada: " + (pedido2 == null ? "" : pedido2.getFechaLlegada()) + "\n";
        salida += "Comentario del pedido: " + (pedido2.getComentario() == null ? "" : pedido2.getComentario()) + "\n";
        salida += "Detalles del pedido:\n";
        salida += (pedido2.getProducto1() == null ? "" : pedido2.pintarProducto1Pedido()) + "\n";
        salida += (pedido2.getProducto2() == null ? "" : pedido2.pintarProducto2Pedido()) + "\n";
        salida += (pedido2.getProducto3() == null ? "" : pedido2.pintarProducto3Pedido()) + "\n";
        salida += "Total pedido: " + pedido2.sumarPrecioProductos() + "€\n";
        return salida;
    }

    public String pintaPedidoCliente(){
        if (pedido1 != null && pedido2 == null) return pintaPedido1();
        return pintaPedido1() + pintaPedido2();
    }



    public String menuAsignacionTrabajadorPedido1(){
        String salida = "";
            salida += (pedido1 != null ? ". " + pedido1.getId() + " - " + nombre + " (" + localidad + ") - " +
                    pedido1.sumarProductosPedido() + " productos - " +  pedido1.sumarPrecioProductos() + "€\n" : "");
        return salida;
    }
    public String menuAsignacionTrabajadorPedido2(){
        String salida = "";
        salida += (pedido2 != null ? ". " + pedido2.getId() + " - " + nombre + " (" + localidad + ") - " +
                pedido2.sumarProductosPedido() + " productos - " +  pedido2.sumarPrecioProductos() + "€\n" : "");
        return salida;
    }

    public void guardaClientePedido1(Cliente cliente){
        this.correo = cliente.correo;
        this.clave = cliente.clave;
        this.direccion = cliente.direccion;
        this.localidad = cliente.localidad;
        this.provincia = cliente.provincia;
        this.telefono = cliente.telefono;
        this.nombre = cliente.nombre;
        pedido1.setClientePedido(cliente);
    }

    public void guardaClientePedido2(Cliente cliente){
        this.correo = cliente.correo;
        this.clave = cliente.clave;
        this.direccion = cliente.direccion;
        this.localidad = cliente.localidad;
        this.provincia = cliente.provincia;
        this.telefono = cliente.telefono;
        this.nombre = cliente.nombre;
        pedido2.setClientePedido(cliente);
    }

    public void modificarDatosCliente(String correo, String clave, String direccion, String localidad, String provincia, int telefono, String nombre){
        this.correo = correo;
        this.clave = clave;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.nombre = nombre;
    }

}


