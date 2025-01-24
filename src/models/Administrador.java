package models;

public class Administrador {
    //Atributos
    private String nombre;
    private String clave;
    private Pedidos pedidos1;
    private Pedidos pedidos2;
    private Pedidos pedidos3;
    private Pedidos pedidos4;
    private boolean inicioCorrecto;

    //Constructor
    public Administrador() {
        nombre = "Admin";
        clave = "root";
        this.pedidos1 = null;
        this.pedidos2 = null;
        this.pedidos3 = null;
        this.pedidos4 = null;
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

    public Pedidos getPedidos1() {
        return pedidos1;
    }

    public void setPedidos1(Pedidos pedidos1) {
        this.pedidos1 = pedidos1;
    }

    public Pedidos getPedidos2() {
        return pedidos2;
    }

    public void setPedidos2(Pedidos pedidos2) {
        this.pedidos2 = pedidos2;
    }

    public Pedidos getPedidos3() {
        return pedidos3;
    }

    public void setPedidos3(Pedidos pedidos3) {
        this.pedidos3 = pedidos3;
    }

    public Pedidos getPedidos4() {
        return pedidos4;
    }

    public void setPedidos4(Pedidos pedidos4) {
        this.pedidos4 = pedidos4;
    }

    public boolean isInicioCorrecto() {
        return inicioCorrecto;
    }

    public void setInicioCorrecto(boolean inicioCorrecto) {
        this.inicioCorrecto = inicioCorrecto;
    }

    //Otros metodos
    public void inicioCorrectoEncendido() {
        setInicioCorrecto(true);
    }

    public void apagadoInicioCorrecto() {
        setInicioCorrecto(false);
    }


}
