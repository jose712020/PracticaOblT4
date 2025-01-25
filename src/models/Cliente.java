package models;

public class Cliente {
    //Atributos
    private String nombre;
    private String correo;
    private String pass;
    private String direccion;
    private String localidad;
    private String provincia;
    private int telefono;
    private Pedidos pedido1;
    private Pedidos pedido2;
    private boolean inicioCorrecto;

    //Constructor
    public Cliente(String nombre, String correo, String pass, String direccion, String localidad, String provincia, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        inicioCorrecto = false;
        pedido1 = null;
        pedido2 = null;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isInicioCorrecto() {
        return inicioCorrecto;
    }

    public void setInicioCorrecto(boolean inicioCorrecto) {
        this.inicioCorrecto = inicioCorrecto;
    }

    public Pedidos getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedidos pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedidos getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedidos pedido2) {
        this.pedido2 = pedido2;
    }

    //Otros metodos
    public void inicioCorrectoEncendido() {
        setInicioCorrecto(true);
    }

    public void apagadoInicioCorrecto() {
        setInicioCorrecto(false);
    }

    //Metodo que pinta los datos del cliente
    public String pintaDatosCliente() {
        String salida = "";
        salida += "\n******************\n";
        salida += "Nombre: " + nombre + "\n";
        salida += "Correo: " + correo + "\n";
        salida += "Dirección: " + direccion + "\n";
        salida += "Localidad: " + localidad + "\n";
        salida += "Provincia: " + provincia + "\n";
        salida += "Teléfono: " + telefono + "\n\n";
        return salida;
    }

    //Metodo que comprueba si tenemos huecos para hacer pedidos
    public boolean hayHuecoPedidos() {
        return pedido1 == null && pedido2 == null;
    }

    //Metodo que modifica los datos del cliente, si introduce -1 no se modifican y se dejan los que tenia
    public void modificarDatosCliente(String correoTeclado, String contraTeclado, String direccionTeclado, String localidadTeclado,
                                      String provinciaTeclado, int telefonoTeclado, String nombreTeclado) {
        correo = correoTeclado;
        pass = contraTeclado;
        if (!direccionTeclado.equals("-1")) direccion = direccionTeclado;
        if (!localidadTeclado.equals("-1")) localidad = localidadTeclado;
        if (!provinciaTeclado.equals("-1")) provincia = provinciaTeclado;
        if (telefonoTeclado != -1) telefono = telefonoTeclado;
        if (!nombreTeclado.equals("-1")) nombre = nombreTeclado;
    }



    //Metodo que realiza un pedido del cliente
/*    public boolean realizaPedido(Productos producto1, Productos producto2, Productos producto3, String direccion){
        if (pedido1 == null){
            pedido1 = new Pedidos(producto1, producto2, producto3, direccion);
            return true;
        }

        return false;
    }*/


}
