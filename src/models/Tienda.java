package models;

import data.Data;

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
        prod1 = Data.prod1;
        prod2 = Data.prod2;
        prod3 = Data.prod3;
        prod4 = Data.prod4;
        prod5 = Data.prod5;
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
        c1.setValid(true);
        //c2 = new Cliente("Wiwi", "jl@hola", "1234", "Avd Lopez", "Martos", "Jaen", 12345678);
        t1 = new Trabajador("Manule", "1111", "manule@hola", 12354221);
        t1.setValid(true);
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
    public boolean registro(String correoTeclado, String contraTeclado, String nombreTeclado, String direccionTeclado, String localidadTeclado, String provinciaTeclado, int telefonoTeclado, String token) {
        if (c1 == null) {
            c1 = new Cliente(nombreTeclado, correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado);
            c1.setToken(token);
            return true;
        }
        if (c2 == null) {
            c2 = new Cliente(nombreTeclado, correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado);
            c2.setToken(token);
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
    public boolean darAltaTrabajador(String nombreTeclado, String contraTeclado, String correoTeclado, int telefonoTeclado, String token) {
        if (t1 == null) {
            t1 = new Trabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado);
            t1.setToken(token);
            return true;
        }
        if (t2 == null) {
            t2 = new Trabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado);
            t2.setToken(token);
            return true;
        }
        if (t3 == null) {
            t3 = new Trabajador(nombreTeclado, contraTeclado, correoTeclado, telefonoTeclado);
            t3.setToken(token);
            return true;
        }
        return false;
    }

    // Metodo que modifica un producto del catalogo
    public void modificaProducto(String nombreTeclado, double precioTeclado, Productos producto) {
        if (nombreTeclado.equalsIgnoreCase("no")) nombreTeclado = producto.getNombre();
        else producto.setNombre(nombreTeclado);
        if (precioTeclado == -1) precioTeclado = producto.getPrecio();
        else producto.setPrecio(precioTeclado);
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

    // Metodo que realiza un nuevo pedido para el cliente
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
        salida += "Estado: " + pedido.getEstado() + "\n";
        salida += "Cliente: " + clienteTemp.getNombre() + "\n";
        salida += "Dirección: " + pedido.getDireccionEntrega() + "\n";
        salida += "Localidad: " + clienteTemp.getLocalidad() + "\n";
        salida += "Provincia: " + clienteTemp.getProvincia() + "\n";
        salida += "Teléfono: " + clienteTemp.getTelefono() + "\n";
        salida += "Correo: " + clienteTemp.getCorreo() + "\n";
        salida += "Fecha del pedido: " + pedido.getFechaPedido() + "\n";
        salida += "Fecha de entrega estimada: " + pedido.getFechaEstimada() + "\n";
        salida += "Comentario del pedido: " + (pedido.getComentario() == null ? "No hay comentarios asignados" : pedido.getComentario()) + "\n";
        salida += "Detalles del pedido:\n";
        salida += (pedido.getProducto1() == null ? "" : "\t" + pedido.pintarProducto(pedido.getProducto1()) + "\n");
        salida += (pedido.getProducto2() == null ? "" : "\t" + pedido.pintarProducto(pedido.getProducto2()) + "\n");
        salida += (pedido.getProducto3() == null ? "" : "\t" + pedido.pintarProducto(pedido.getProducto3()) + "\n");
        salida += "Total pedido: " + pedido.sumarPrecioProductos() + "€\n";
        salida += "\n\n";
        return salida;
    }

    //Metodo que pinta los pedidos de todos los clientes para el administrador
    public String pintaPedidosAdmin() {
        String salida = "";
        if (c1 != null) {
            if (c1.getPedido1() != null) salida += pintaPedido(c1.getPedido1(), c1);
            if (c1.getPedido2() != null) salida += pintaPedido(c1.getPedido2(), c1);
        }
        if (c2 != null) {
            if (c2.getPedido1() != null) salida += pintaPedido(c2.getPedido1(), c2);
            if (c2.getPedido2() != null) salida += pintaPedido(c2.getPedido2(), c2);
        }
        if (salida.equals("")) salida += "No se ha realizado ningún pedido...";
        return salida;
    }


    // Pinta las ID de los pedidos que tiene un cliente
    public String pintaPedidosModificar(Cliente cliente) {
        String salida = "";
        if (cliente.getPedido1() == null && cliente.getPedido2() == null)
            salida += "El cliente " + cliente.getNombre() + " no tiene pedidos en curso...\n";
        if (cliente.getPedido1() != null)
            salida += "ID del Pedido: " + cliente.getPedido1().getId() + " de " + cliente.getNombre() + "\n";
        if (cliente.getPedido2() != null)
            salida += "ID del Pedido: " + cliente.getPedido2().getId() + " de " + cliente.getNombre() + "\n";
        return salida;
    }

    // Metodo que nos dice si existe un cliente
    public boolean existeCliente(Cliente cliente) {
        return cliente != null;
    }

    //Metodo que encuentra el ID de un pedido
    public Pedidos encuentraId(int id) {
        if (c1.getPedido1() != null && id == c1.getPedido1().getId()) return c1.getPedido1();
        if (c1.getPedido2() != null && id == c1.getPedido2().getId()) return c1.getPedido2();
        if (c2 != null && c2.getPedido1() != null && id == c2.getPedido1().getId()) return c2.getPedido1();
        if (c2 != null && c2.getPedido2() != null && id == c2.getPedido2().getId()) return c2.getPedido2();
        return null;
    }

    // Metodo que cuenta los pedidos realizados de todos los clientes
    public int contadorPedidos() {
        int cont = 0;
        if (c1 != null) {
            if (c1.getPedido1() != null) cont++;
            if (c1.getPedido2() != null) cont++;
        }
        if (c2 != null) {
            if (c2.getPedido1() != null) cont++;
            if (c2.getPedido2() != null) cont++;
        }
        return cont;
    }

    // Metodo que pinta el pedido en la asignacion de pedidos de cada cliente
    public String pintaAsignacionPedido() {
        String salida = "";
        int cont = 0;
        if (c1 != null) {
            if (c1.getPedido1() != null) {
                cont++;
                salida += cont + ". " + c1.pintaAsignacionPedido(c1.getPedido1());
            }
            if (c1.getPedido2() != null) {
                cont++;
                salida += cont + ". " + c1.pintaAsignacionPedido(c1.getPedido2());
            }
        }
        if (c2 != null) {
            if (c2.getPedido1() != null) {
                cont++;
                salida += cont + ". " + c2.pintaAsignacionPedido(c2.getPedido1());
            }
            if (c2.getPedido2() != null) {
                cont++;
                salida += cont + ". " + c2.pintaAsignacionPedido(c2.getPedido2());
            }
        }
        if (salida.equals("")) salida += "No hay pedidos para asignar...";
        return salida;
    }

    // Metodo del administrador que elige el pedido que quiere asignar al trabajador
    public Pedidos asignacionPedido(int op) {
        int cont = 0;
        if (c1 != null) {
            if (c1.getPedido1() != null) {
                cont++;
                if (cont == 1 && op == 1) return c1.getPedido1();
            }
            if (c1.getPedido2() != null) {
                cont++;
                if (cont == 2 && op == 2) return c1.getPedido2();
            }
        }
        if (c2 != null) {
            if (c2.getPedido1() != null) {
                cont++;
                if (cont == 1 && op == 1) return c2.getPedido1();
                if (cont == 2 && op == 2) return c2.getPedido1();
                if (cont == 3 && op == 3) return c2.getPedido1();
            }
            if (c2.getPedido2() != null) {
                cont++;
                if (cont == 1 && op == 1) return c2.getPedido2();
                if (cont == 2 && op == 2) return c2.getPedido2();
                if (cont == 3 && op == 3) return c2.getPedido2();
                if (cont == 4 && op == 4) return c2.getPedido2();
            }
        }
        return null;
    }

    // Metodo que pinta los pedidos asignados que tiene un trabajador
    public String pintaAsignacionPedidoTrabajadores() {
        String salida = "";
        int cont = 0;

        if (t1 != null) {
            cont++;
            salida += cont + ". " + t1.getNombre() + " - " + t1.numPedidosAsignados() +
                    (t1.numPedidosAsignados() == 1 ? " pedido" : " pedidos") + " en proceso\n";
        }
        if (t2 != null) {
            cont++;
            salida += cont + ". " + t2.getNombre() + " - " + t2.numPedidosAsignados() +
                    (t2.numPedidosAsignados() == 1 ? " pedido" : " pedidos") + " en proceso\n";
        }
        if (t3 != null) {
            cont++;
            salida += cont + ". " + t3.getNombre() + " - " + t3.numPedidosAsignados() +
                    (t3.numPedidosAsignados() == 1 ? " pedido" : " pedidos") + " en proceso\n";
        }
        return salida;
    }

    // Metodo que elige el trabajador al que le vamos a asignar el pedido
    public Trabajador eligeTrabajador(int op) {
        int cont = 0;

        if (t1 != null) {
            cont++;
            if (cont == 1 && op == 1) return t1;
        }
        if (t2 != null) {
            cont++;
            if (cont == 2 && op == 2) return t2;
        }
        if (t3 != null) {
            cont++;
            if (cont == 3 && op == 3) return t3;
        }
        return null;
    }

    // Metodo que setea un pedido en el trabajador, el pedido lo recibira de parte del administrador
    public boolean aniadePedidoTrabajador(Trabajador trabajador, Pedidos pedido) {
        if (trabajador.getPedidoAsignado1() == null) {
            trabajador.setPedidoAsignado1(pedido);
            return true;
        }
        if (trabajador.getPedidoAsignado2() == null) {
            if (pedido != trabajador.pedidoAsignado1) {
                trabajador.setPedidoAsignado2(pedido);
                return true;
            }
        }
        return false;
    }

    // Metodo que pinta los pedidos asignados que tiene un trabajador
    public String pintaPedidosTrabajador(Trabajador trabajadorTemp) {
        String salida = "";
        if (trabajadorTemp.pedidoAsignado1 != null)
            salida += "1. ID del pedido: " + trabajadorTemp.pedidoAsignado1.getId() + "\n";
        if (trabajadorTemp.pedidoAsignado2 != null)
            salida += "2. ID del pedido: " + trabajadorTemp.pedidoAsignado2.getId() + "\n";
        if (salida.equals("")) salida += "No tienes pedidos asignados";
        return salida;
    }

    // Metodo que nos dice en la asignacion de los pedidos del administrador si los elige el admin y la eleccion es automatica
    public boolean eleccionAsignacionPedido() {
        if (t1 != null && t2 == null && t3 == null) return false;
        if (t2 != null && t3 == null) {
            if (t1.numPedidosAsignados() == t2.numPedidosAsignados()) return true;
        }
        if (t3 != null) {
            if (t1.numPedidosAsignados() == t2.numPedidosAsignados()
                    && t1.numPedidosAsignados() == t3.numPedidosAsignados()
                    && t2.numPedidosAsignados() == t3.numPedidosAsignados()) return true;
            if (t3.numPedidosAsignados() < t1.numPedidosAsignados() && t3.numPedidosAsignados() < t2.numPedidosAsignados())
                return false;
            if (t2.numPedidosAsignados() < t1.numPedidosAsignados() && t2.numPedidosAsignados() < t3.numPedidosAsignados())
                return false;
            if (t1.numPedidosAsignados() < t2.numPedidosAsignados() && t1.numPedidosAsignados() < t3.numPedidosAsignados())
                return false;
            if (t1.numPedidosAsignados() == t2.numPedidosAsignados()) return true;
            if (t1.numPedidosAsignados() == t3.numPedidosAsignados()) return true;
            if (t2.numPedidosAsignados() == t3.numPedidosAsignados()) return true;
        }
        return false;
    }

    //Metodo que añade un pedido automaticamente a un trabajador
    public Trabajador aniadePedidoTrabajadorAutomatico() {
        if (t1 != null && t2 == null && t3 == null) return t1;
        if (t2 != null && t3 == null) {
            if (t1.numPedidosAsignados() < t2.numPedidosAsignados()) return t1;
            if (t1.numPedidosAsignados() > t2.numPedidosAsignados()) return t2;
        }
        if (t3 != null) {
            if (t1.numPedidosAsignados() < t2.numPedidosAsignados() && t1.numPedidosAsignados() < t3.numPedidosAsignados())
                return t1;
            if (t2.numPedidosAsignados() < t1.numPedidosAsignados() && t2.numPedidosAsignados() < t3.numPedidosAsignados())
                return t2;
            if (t3.numPedidosAsignados() < t1.numPedidosAsignados() && t3.numPedidosAsignados() < t2.numPedidosAsignados())
                return t3;
        }
        return null;
    }

    // Metodo que comprueba que las ID no sean iguales en caso de que se repita devolvera true
    public boolean generaIDiguales(int id) {
        if (c1.getPedido1() != null && id == c1.getPedido1().getId()) return true;
        if (c1.getPedido2() != null && id == c1.getPedido2().getId()) return true;
        if (c2 != null && c2.getPedido1() != null && id == c2.getPedido1().getId()) return true;
        if (c2 != null && c2.getPedido2() != null && id == c2.getPedido2().getId()) return true;
        return false;
    }

    // Metodo que comprueba que los correos no se repitan de los clientes
    public boolean compruebaCorreosClientes(String correoTeclado) {
        if (c1 != null && !correoTeclado.equals(c1.getCorreo())) return true;
        if (c2 != null && !correoTeclado.equals(c2.getCorreo())) return true;
        return false;
    }

    public String generaToken() {
        String token = "";
        token = "JM-" + (int) (Math.random() * 99999999);
        return token;
    }

    public boolean compruebaTokenCliente(Cliente clienteTemp, String tokenTeclado) {
        if (clienteTemp.getToken().equals(tokenTeclado)) {
            clienteTemp.setValid(true);
            return true;
        } else clienteTemp.setValid(false);
        return false;
    }

    // Metodo que comprueba que los correos no se repitan de los trabajadores
    public boolean compruebaCorreosTrabajadores(String correoTeclado) {
        if (t1 != null && !correoTeclado.equals(t1.getCorreo())) return true;
        if (t2 != null && !correoTeclado.equals(t2.getCorreo())) return true;
        if (t3 != null && !correoTeclado.equals(t3.getCorreo())) return true;
        return false;
    }

    public boolean compruebaTokenTrabajador(Trabajador trabajadorTemp, String tokenTeclado) {
        if (trabajadorTemp.getToken().equals(tokenTeclado)) {
            trabajadorTemp.setValid(true);
            return true;
        } else trabajadorTemp.setValid(false);
        return false;
    }
}
