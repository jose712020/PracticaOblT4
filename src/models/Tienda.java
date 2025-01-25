package models;

public class Tienda {
    //Atributos
    private Cliente c1;
    private Cliente c2;
    private Trabajador t1;
    private Trabajador t2;
    private Trabajador t3;
    private Administrador admin;
    private Productos prod1;
    private Productos prod2;
    private Productos prod3;
    private Productos prod4;
    private Productos prod5;

    //Constructor
    public Tienda() {
        c1 = null;
        c2 = null;
        t1 = null;
        t2 = null;
        t3 = null;
        admin = new Administrador();
        prod1 = null;
        prod2 = null;
        prod3 = null;
        prod4 = null;
        prod5 = null;
    }

    //Getter y Setter
    public Cliente getC1() {
        return c1;
    }

    public void setC1(Cliente c1) {
        this.c1 = c1;
    }

    public Cliente getC2() {
        return c2;
    }

    public void setC2(Cliente c2) {
        this.c2 = c2;
    }

    public Trabajador getT1() {
        return t1;
    }

    public void setT1(Trabajador t1) {
        this.t1 = t1;
    }

    public Trabajador getT2() {
        return t2;
    }

    public void setT2(Trabajador t2) {
        this.t2 = t2;
    }

    public Trabajador getT3() {
        return t3;
    }

    public void setT3(Trabajador t3) {
        this.t3 = t3;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Productos getProd1() {
        return prod1;
    }

    public void setProd1(Productos prod1) {
        this.prod1 = prod1;
    }

    public Productos getProd2() {
        return prod2;
    }

    public void setProd2(Productos prod2) {
        this.prod2 = prod2;
    }

    public Productos getProd3() {
        return prod3;
    }

    public void setProd3(Productos prod3) {
        this.prod3 = prod3;
    }

    public Productos getProd4() {
        return prod4;
    }

    public void setProd4(Productos prod4) {
        this.prod4 = prod4;
    }

    public Productos getProd5() {
        return prod5;
    }

    public void setProd5(Productos prod5) {
        this.prod5 = prod5;
    }

    //Otros metodos

    //metodo mock
    public void mock() {
        c1 = new Cliente("Jl", "hola@hola", "1234", "Avd Lopez", "Martos", "Jaen", 12345678);
        //c2 = new Cliente("Wiwi", "jl@hola", "1234", "Avd Lopez", "Martos", "Jaen", 12345678);
        t1 = new Trabajador("Manule", "1111", "manule@hola", 12354221);
        prod1 = new Productos("PlayStation 5", 469.99, 93);
        prod2 = new Productos("El Árbol de la ciencia - Pio Baroja", 10.40, 74);
        prod3 = new Productos("IPhone 16 Pro Max", 1550, 87);
        prod4 = new Productos("Xiaomi 11T", 233.83, 75);
        prod5 = new Productos("Netflix Tarjeta Regalo 100 euros", 100, 97);
    }

    //Comparamos si los datos que ha metido el usuario coincide con los del administrador
    public Administrador inicioSesionAdmin(String nombreTeclado, String claveTeclado) {
        if (admin != null && admin.getNombre().equals(nombreTeclado) && admin.getClave().equals(claveTeclado))
            return admin;
        return null;
    }

    //En este metodo ponemos el boolean inicioCorrecto a true del administrador
    public void inicioSesionAdminActivado() {
        admin.setInicioCorrecto(true);
    }

    //En este metodo ponemos el boolean inicioCorrecto a false del administrador
    public void apagadoInicioSesionAdmin() {
        admin.setInicioCorrecto(false);
    }

    //Comparamos si los datos que ha metido el usuario coincide con los del cliente que introduzcamos
    public Cliente inicioSesionCliente(String nombreTeclado, String contraTeclado) {
        if (c1 != null && c1.getCorreo().equals(nombreTeclado) && c1.getPass().equals(contraTeclado)) return c1;
        if (c2 != null && c2.getCorreo().equals(nombreTeclado) && c2.getPass().equals(contraTeclado)) return c2;
        return null;
    }

    //En este metodo ponemos el boolean inicioCorrecto a true del cliente que introduzcamos
    public void inicioSesionClienteActivado(Cliente cliente) {
        cliente.setInicioCorrecto(true);
    }

    //En este metodo ponemos el boolean inicioCorrecto a false del cliente
    public void apagadoInicioSesionCliente(Cliente cliente) {
        cliente.setInicioCorrecto(false);
    }

    //Comparamos si los datos que ha metido el usuario coincide con los del cliente que introduzcamos
    public Trabajador inicioSesionTrabajador(String nombreTeclado, String contraTeclado) {
        if (t1 != null && t1.getNombre().equals(nombreTeclado) && t1.getClave().equals(contraTeclado)) return t1;
        if (t2 != null && t2.getNombre().equals(nombreTeclado) && t2.getClave().equals(contraTeclado)) return t2;
        if (t3 != null && t3.getNombre().equals(nombreTeclado) && t3.getClave().equals(contraTeclado)) return t3;
        return null;
    }

    // Metodo que muestra el catalogo de la tienda
    public String pintaCatalogo() {
        String salida = "";
        salida += "=== CATÁLOGO DE PRODUCTOS ===\n";
        salida += "\nProducto 1: \n" + prod1.pintaDatos();
        salida += "\nProducto 2: \n" + prod2.pintaDatos();
        salida += "\nProducto 3: \n" + prod3.pintaDatos();
        salida += "\nProducto 4: \n" + prod4.pintaDatos();
        salida += "\nProducto 5: \n" + prod5.pintaDatos();
        return salida;
    }

    //Metodo que pinta los clientes
    public String verClientesAdmin() {
        String salida = "";
        if (cuentaClientes() == 0) salida += "No hay clientes registrados...";
        if (c1 != null) salida += c1.pintaDatosCliente();
        if (c2 != null) salida += c2.pintaDatosCliente();
        return salida;
    }

    //Metodo que pinta los trabajadores
    public String verTrabajadoresAdmin() {
        String salida = "";
        if (cuentaTrabajadores() == 0) salida += "No hay trabajadores registrados...";
        if (t1 != null) salida += t1.pintaDatosTrabajador();
        if (t2 != null) salida += t2.pintaDatosTrabajador();
        if (t3 != null) salida += t3.pintaDatosTrabajador();
        return salida;
    }

    //Metodo que cuenta los clientes que hay
    public int cuentaClientes() {
        int cont = 0;
        if (c1 != null) cont++;
        if (c2 != null) cont++;
        return cont;
    }

    //Metodo que cuenta los clientes que hay
    public int cuentaTrabajadores() {
        int cont = 0;
        if (t1 != null) cont++;
        if (t2 != null) cont++;
        if (t3 != null) cont++;
        return cont;
    }

    //Metodo que registra un usuario en el menu principal del programa
    public boolean registro(String correoTeclado, String contraTeclado, String nombreTeclado, String direccionTeclado, String localidadTeclado, String provinciaTeclado, int telefonoTeclado) {
        if (c1 == null) {
            c1 = new Cliente(nombreTeclado, correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado);
            return true;
        }
        if (c2 == null) {
            c2 = new Cliente(nombreTeclado, correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado);
            return true;
        }
        return false;
    }

    //Metodo que comprueba si hay hueco en los clientes
    public boolean noHayHuecoClientes() {
        return c1 != null && c2 != null;
    }

    //Metodo que elige uno de los 5 productos al realizar un pedido
    public Productos eligeProducto(int i) {
        if (i == 1) return prod1;
        if (i == 2) return prod2;
        if (i == 3) return prod3;
        if (i == 4) return prod4;
        if (i == 5) return prod5;
        return null;
    }

    //Metodo que nos dice si no hay hueco para crear un trabajador
    public boolean todoLlenoTrabajadores() {
        return t1 != null && t2 != null && t3 != null;
    }

    //Metodo que hace que el administrador pueda dar de alta a un trabajador
    public boolean darAltaTrabajador(String nombreTeclado, String contraTeclado, String correoTeclado, int telefonoTeclado) {
        if (t1 == null) {
            t1 = new Trabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado);
            return true;
        }
        if (t2 == null) {
            t2 = new Trabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado);
            return true;
        }
        if (t3 == null) {
            t3 = new Trabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado);
            return true;
        }
        return false;
    }

    // Metodo que modifica un producto del catalogo
    public void modificaProducto(String nombreTeclado, double precioTeclado, int cantidadTeclado, Productos producto) {
        if (nombreTeclado.equalsIgnoreCase("no")) nombreTeclado = producto.getNombre();
        else producto.setNombre(nombreTeclado);
        if (precioTeclado == -1) precioTeclado = producto.getPrecio();
        else producto.setPrecio(precioTeclado);
        if (cantidadTeclado == -1) cantidadTeclado = producto.getCantidad();
        else producto.setCantidad(cantidadTeclado);
    }

    //Metodo que setea el pedido 1 o el pedido 2 de un cliente
    public boolean realizaPedido(Pedidos pedido, Cliente clienteTemp) {
        if (clienteTemp.getPedido1() == null) {
            clienteTemp.setPedido1(pedido);
            return true;
        }
        if (clienteTemp.getPedido2() == null) {
            clienteTemp.setPedido2(pedido);
            return true;
        }
        return false;
    }

    public Pedidos agregaCesta(Productos productoTemp1, Productos productoTemp2, Productos productoTemp3, Cliente clienteTemp) {
        Productos p1 = null, p2 = null, p3 = null;
        p1 = productoTemp1;
        p2 = productoTemp2;
        p3 = productoTemp3;
        return new Pedidos(p1, p2, p3, clienteTemp.getDireccion());
    }

    //Metodo que pinta los pedidos en total del cliente
    public String pintaPedidos(Cliente clienteTemp) {
        String salida = "";
        if (clienteTemp.getPedido1() == null && clienteTemp.getPedido2() == null) return "No hay pedidos realizados";
        if (clienteTemp.getPedido1() != null) salida += pintaPedido(clienteTemp.getPedido1(), clienteTemp);
        if (clienteTemp.getPedido2() != null) salida += pintaPedido(clienteTemp.getPedido2(), clienteTemp);
        return salida;
    }

    // Metodo que pinta los datos de un solo pedido
    private String pintaPedido(Pedidos pedido, Cliente clienteTemp) {
        String salida = "";
        salida += "\n\n";
        salida += "==========\tPedido " + pedido.getId() + "\t===========\n";
        salida += "Cliente: " + clienteTemp.getNombre() + "\n";
        salida += "Dirección: " + pedido.getDireccionEntrega() + "\n";
        salida += "Localidad: " + clienteTemp.getLocalidad() + "\n";
        salida += "Provincia: " + clienteTemp.getProvincia() + "\n";
        salida += "Teléfono: " + clienteTemp.getTelefono() + "\n";
        salida += "Correo: " + clienteTemp.getCorreo() + "\n";
        salida += "Fecha del pedido: " + pedido.getFechaPedido() + "\n";
        salida += "Fecha de entrega estimada: " + pedido.getFechaEstimada() + "\n";
        salida += "Detalles del pedido:\n";
        salida += (pedido.getProducto1() == null ? "" : pedido.pintarProducto(pedido.getProducto1())) + "\n";
        salida += (pedido.getProducto2() == null ? "" : pedido.pintarProducto(pedido.getProducto2())) + "\n";
        salida += (pedido.getProducto3() == null ? "" : pedido.pintarProducto(pedido.getProducto3())) + "\n";
        salida += "\n\n";
        return salida;
    }

    //Metodo que pinta los pedidos de todos los clientes para el administrador
    public String pintaPedidosAdmin() {
        String salida = "";
        if (c1 != null) {
            if (c1.getPedido1() != null) salida += pintaPedido(c1.getPedido1(), c1);
        }
        if (c2 != null) {
            if (c2.getPedido1() != null) salida += pintaPedido(c2.getPedido1(), c2);
        }
        if (salida.equals(""))  salida += "No se ha realizado ningún pedido...";
        return salida;
    }
}
