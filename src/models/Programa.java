package models;

public class Programa {
    private Cliente c1;
    private Cliente c2;
    private Trabajadores t1;
    private Trabajadores t2;
    private Trabajadores t3;
    private Administrador admin;
    private Productos prod1 = new Productos("PlayStation 5", 469.99);
    private Productos prod2 = new Productos("El Árbol de la ciencia - Pio Baroja", 10.40);
    private Productos prod3 = new Productos("IPhone 16 Pro Max", 1550);
    private Productos prod4 = new Productos("Xiaomi 11T", 233.83);
    private Productos prod5 = new Productos("Netflix Tarjeta Regalo 100 euros", 100);
    private Productos prod6 = new Productos("Playmobil Casa de Campo", 54.99);
    private Productos prod7 = new Productos("Zootrópolis - DVD", 13.89);
    private Productos prod8 = new Productos("FunkoPop! - Arcane Jinx", 15.99);

    public Programa() {
        c1 = null;
        c2 = null;
        t1 = null;
        t2 = null;
        t3 = null;
        admin = null;
        prod1 = new Productos("PlayStation 5", 469.99);
        prod2 = new Productos("El Árbol de la ciencia - Pio Baroja", 10.40);
        prod3 = new Productos("IPhone 16 Pro Max", 1550);
        prod4 = new Productos("Xiaomi 11T", 233.83);
        prod5 = new Productos("Netflix Tarjeta Regalo 100 euros", 100);
        prod6 = new Productos("Playmobil Casa de Campo", 54.99);
        prod7 = new Productos("Zootrópolis - DVD", 13.89);
        prod8 = new Productos("FunkoPop! - Arcane Jinx", 15.99);
    }

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

    public Trabajadores getT1() {
        return t1;
    }

    public void setT1(Trabajadores t1) {
        this.t1 = t1;
    }

    public Trabajadores getT2() {
        return t2;
    }

    public void setT2(Trabajadores t2) {
        this.t2 = t2;
    }

    public Trabajadores getT3() {
        return t3;
    }

    public void setT3(Trabajadores t3) {
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

    public Productos getProd6() {
        return prod6;
    }

    public void setProd6(Productos prod6) {
        this.prod6 = prod6;
    }

    public Productos getProd7() {
        return prod7;
    }

    public void setProd7(Productos prod7) {
        this.prod7 = prod7;
    }

    public Productos getProd8() {
        return prod8;
    }

    public void setProd8(Productos prod8) {
        this.prod8 = prod8;
    }

    //Otros Metodos
    public String pintaCatalogo() {
        String salida = "";
        salida += "=== CATÁLOGO DE PRODUCTOS ===\n";
        salida+= prod1.pintaCatalogo();
        salida+= prod2.pintaCatalogo();
        salida+= prod3.pintaCatalogo();
        salida+= prod4.pintaCatalogo();
        salida+= prod5.pintaCatalogo();
        salida+= prod6.pintaCatalogo();
        salida+= prod7.pintaCatalogo();
        salida+= prod8.pintaCatalogo();
        return salida;
    }

    public boolean existeCliente1() {
        return c1 != null;
    }

    public boolean existeCliente2() {
        return c1 != null;
    }

    public boolean huecoClientes() {
        return c1 != null && c2 != null;
    }

}
