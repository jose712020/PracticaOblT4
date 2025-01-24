package models;

public class Pedidos {
    private int id;
    private String comentario;
    private String estado;
    private String direccionEntrega;
    private Productos producto1;
    private Productos producto2;
    private Productos producto3;

    //Constructor
    public Pedidos(Productos producto1, Productos producto2, Productos producto3, String direccionEntrega) {
        id = generaId();
        this.direccionEntrega = direccionEntrega;
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
    }

    //Getter y Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Productos getProducto1() {
        return producto1;
    }

    public void setProducto1(Productos producto1) {
        this.producto1 = producto1;
    }

    public Productos getProducto2() {
        return producto2;
    }

    public void setProducto2(Productos producto2) {
        this.producto2 = producto2;
    }

    public Productos getProducto3() {
        return producto3;
    }

    public void setProducto3(Productos producto3) {
        this.producto3 = producto3;
    }

    //Otros metodos
    private int generaId() {
        return id = (int) (Math.random() * 100001);
    }
    //Metodo que inserta un producto
 /*   public boolean insertaProducto(Productos producto, String direccionEntrega) {

    }*/
}
