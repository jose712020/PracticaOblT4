package models;

import utils.Utils;

import java.util.Scanner;

public class Tienda {
    private Cliente c1;
    private Cliente c2;
    private Trabajadores t1;
    private Trabajadores t2;
    private Trabajadores t3;
    private Administrador admin;
    private Productos prod1;
    private Productos prod2;
    private Productos prod3;
    private Productos prod4;
    private Productos prod5;
    private Productos prod6;
    private Productos prod7;
    private Productos prod8;

    public Tienda() {
        c1 = null;
        c2 = null;
        t1 = new Trabajadores("Carlos", "1234");
        t2 = null;
        t3 = null;
        admin = new Administrador("Admin", "root", t1, t2, t3);
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

    public Cliente getC2() {
        return c2;
    }

    public Trabajadores getT1() {
        return t1;
    }

    public Trabajadores getT2() {
        return t2;
    }

    public Trabajadores getT3() {
        return t3;
    }

    public Administrador getAdmin() {
        return admin;
    }

    //Otros Metodos
    public String pintaCatalogo() {
        String salida = "";
        salida += "=== CATÁLOGO DE PRODUCTOS ===\n";
        salida += prod1.pintaCatalogo();
        salida += prod2.pintaCatalogo();
        salida += prod3.pintaCatalogo();
        salida += prod4.pintaCatalogo();
        salida += prod5.pintaCatalogo();
        salida += prod6.pintaCatalogo();
        salida += prod7.pintaCatalogo();
        salida += prod8.pintaCatalogo();
        return salida;
    }

    public boolean existeCliente1() {
        return c1 != null;
    }

    public boolean existeCliente2() {
        return c2 != null;
    }

    public boolean noExisteCliente1() {
        return c1 == null;
    }

    public boolean noExisteCliente2() {
        return c2 == null;
    }

    public boolean todoLlenoClientes() {
        return c1 != null && c2 != null;
    }

    public void inicioSesion() {
        var s = new Scanner(System.in);
        String correoTeclado, contraTeclado;
        System.out.print("""
                INICIO DE SESIÓN:
                Introduzca correo electrónico (Cliente) o nombre (Trabajador o Admininistrador):\s""");
        correoTeclado = s.nextLine();
        System.out.print("Introduce tu contraseña: ");
        contraTeclado = s.nextLine();
        if (existeCliente1() && c1.iniciaSesion(contraTeclado, correoTeclado)) encendidoInicioSesionCliente1();
        else if (existeCliente2() && c2.iniciaSesion(contraTeclado, correoTeclado)) encendidoInicioSesionCliente2();
        else if (existeT1() && t1.iniciaSesion(contraTeclado, correoTeclado)) encendidoInicioSesionT1();
        else if (existeT2() && t2.iniciaSesion(contraTeclado, correoTeclado)) encendidoInicioSesionT2();
        else if (existeT3() && t3.iniciaSesion(contraTeclado, correoTeclado)) encendidoInicioSesionT3();
        else if (existeAdmin() && admin.iniciaSesion(contraTeclado, correoTeclado)) encendidoInicioSesionAdmin();
        else System.out.println("Datos incorrectos...");
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
    }

    public void registro() {
        var s = new Scanner(System.in);
        String correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, nombreTeclado;
        int telefonoTeclado;

        if (todoLlenoClientes()) System.out.println("No se pueden crear más clientes");
        else {
            System.out.print("""
                    REGISTRO:
                    Introduzca correo electrónico:\s""");
            correoTeclado = s.nextLine();
            System.out.print("Introduce la contraseña de tu cuenta: ");
            contraTeclado = s.nextLine();
            System.out.print("Introduce un nombre para su cuenta: ");
            nombreTeclado = s.nextLine();
            System.out.print("Introduce tu direccion: ");
            direccionTeclado = s.nextLine();
            System.out.print("Introduce su localidad: ");
            localidadTeclado = s.nextLine();
            System.out.print("Introduce su provincia: ");
            provinciaTeclado = s.nextLine();
            System.out.print("Introduzca su teléfono: ");
            telefonoTeclado = Integer.parseInt(s.nextLine());
            if (noExisteCliente1())
                c1 = new Cliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
            else
                c2 = new Cliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
            System.out.println("Registro guardado correctamente");
        }
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
    }

    //Clientes

    public void encendidoInicioSesionCliente1() {
        c1.setInicioCorrecto(true);
    }

    public void apagadoInicioSesionCliente1() {
        c1.setInicioCorrecto(false);
    }

    public boolean inicioSesionCliente1() {
        return existeCliente1() && c1.isInicioCorrecto();
    }

    public String pintaCliente1() {
        return c1.pintaCliente();
    }

    public void encendidoInicioSesionCliente2() {
        c2.setInicioCorrecto(true);
    }

    public void apagadoInicioSesionCliente2() {
        c2.setInicioCorrecto(false);
    }

    public boolean inicioSesionCliente2() {
        return existeCliente2() && c2.isInicioCorrecto();
    }

    public String pintaPedidoCliente1() {
        if (!c1.hayPedido1()) return "No hay ningún pedido";
        return c1.pintaPedidoCliente();
    }

    public String pintaPedidoCliente2() {
        if (!c2.hayPedido1()) return "No hay ningún pedido";
        return c2.pintaPedidoCliente();
    }

    public String pintaCliente2() {
        return c2.pintaCliente();
    }

    public void realizaPedidoCliente1() {
        Scanner s = new Scanner(System.in);
        Productos productoSeleccionado1 = null, productoSeleccionado2 = null, productoSeleccionado3 = null;
        boolean productoFinalizado = false, bucleCorrecto = false;
        String op, productoTeclado;
        int contadorProductos = 0;

        do {
            System.out.print("Introduce el número del producto mostrado en el catálogo (máximo 3 productos): ");
            productoTeclado = s.nextLine();
            switch (productoTeclado) {//Switch producto 1 cliente 1
                case "1":
                    productoSeleccionado1 = prod1;
                    contadorProductos++;
                    break;
                case "2":
                    productoSeleccionado1 = prod2;
                    contadorProductos++;
                    break;
                case "3":
                    productoSeleccionado1 = prod3;
                    contadorProductos++;
                    break;
                case "4":
                    productoSeleccionado1 = prod4;
                    contadorProductos++;
                    break;
                case "5":
                    productoSeleccionado1 = prod5;
                    contadorProductos++;
                    break;
                case "6":
                    productoSeleccionado1 = prod6;
                    contadorProductos++;
                    break;
                case "7":
                    productoSeleccionado1 = prod7;
                    contadorProductos++;
                    break;
                case "8":
                    productoSeleccionado1 = prod8;
                    contadorProductos++;
                    break;
            } //Switch producto 1
            if (productoTeclado.equals("1") || productoTeclado.equals("2") || productoTeclado.equals("3") || productoTeclado.equals("4") || productoTeclado.equals("5") || productoTeclado.equals("6") || productoTeclado.equals("7") || productoTeclado.equals("8")) {
                System.out.println("Producto agregado a la cesta");
                bucleCorrecto = true;
            } else {
                System.out.println("Dicho producto no existe"); //Del producto 1
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
            }
        } while (!bucleCorrecto);

        System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1) ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
        op = s.nextLine();

        if (op.equalsIgnoreCase("S")) {//Añadir producto 2
            bucleCorrecto = false;
            do {
                System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                productoTeclado = s.nextLine();
                switch (productoTeclado) {
                    case "1":
                        productoSeleccionado2 = prod1;
                        contadorProductos++;
                        break;
                    case "2":
                        productoSeleccionado2 = prod2;
                        contadorProductos++;
                        break;
                    case "3":
                        productoSeleccionado2 = prod3;
                        contadorProductos++;
                        break;
                    case "4":
                        productoSeleccionado2 = prod4;
                        contadorProductos++;
                        break;
                    case "5":
                        productoSeleccionado2 = prod5;
                        contadorProductos++;
                        break;
                    case "6":
                        productoSeleccionado2 = prod6;
                        contadorProductos++;
                        break;
                    case "7":
                        productoSeleccionado2 = prod7;
                        contadorProductos++;
                        break;
                    case "8":
                        productoSeleccionado2 = prod8;
                        contadorProductos++;
                        break;
                } //Switch producto 2
                if (productoTeclado.equals("1") || productoTeclado.equals("2") || productoTeclado.equals("3") || productoTeclado.equals("4") || productoTeclado.equals("5") || productoTeclado.equals("6") || productoTeclado.equals("7") || productoTeclado.equals("8")) {
                    System.out.println("Producto agregado a la cesta");
                    bucleCorrecto = true;
                } else {
                    System.out.println("Dicho producto no existe"); //Del producto 2
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } while (!bucleCorrecto); //Bucle producto 2
        } else {//Si no es "S"
            productoFinalizado = true;

            c1.realizaPedido(productoSeleccionado1, c1.getDireccion());//Realizar pedido solo con un producto
            if (admin.getPedidos1() == null) admin.setPedidos1(c1.getPedido1());
            if (admin.getPedidos2() == null) admin.setPedidos2(c1.getPedido2());
            if (c1.hayPedido1()) c1.guardaClientePedido1(c1);
            if (c1.hayPedido2()) c1.guardaClientePedido2(c1);
            System.out.println("Su precio a pagar en total es de " + c1.recibirPrecioTotal());

            //Realizar pedido solo con un producto
        }
        if (!productoFinalizado) {
            System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1) ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
            op = s.nextLine();
        }
        if (op.equalsIgnoreCase("S") && contadorProductos == 2) {//Añadir producto 3 y último
            bucleCorrecto = false;
            do {
                System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                productoTeclado = s.nextLine();
                switch (productoTeclado) {
                    case "1":
                        productoSeleccionado3 = prod1;
                        contadorProductos++;
                        break;
                    case "2":
                        productoSeleccionado3 = prod2;
                        contadorProductos++;
                        break;
                    case "3":
                        productoSeleccionado3 = prod3;
                        contadorProductos++;
                        break;
                    case "4":
                        productoSeleccionado3 = prod4;
                        contadorProductos++;
                        break;
                    case "5":
                        productoSeleccionado3 = prod5;
                        contadorProductos++;
                        break;
                    case "6":
                        productoSeleccionado3 = prod6;
                        contadorProductos++;
                        break;
                    case "7":
                        productoSeleccionado3 = prod7;
                        contadorProductos++;
                        break;
                    case "8":
                        productoSeleccionado3 = prod8;
                        contadorProductos++;
                        break;
                }
                if (productoTeclado.equals("1") || productoTeclado.equals("2") || productoTeclado.equals("3") || productoTeclado.equals("4") || productoTeclado.equals("5") || productoTeclado.equals("6") || productoTeclado.equals("7") || productoTeclado.equals("8")) {
                    System.out.println("Producto agregado a la cesta");
                    bucleCorrecto = true;
                } else {
                    System.out.println("Dicho producto no existe"); //Del producto 2
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } while (!bucleCorrecto);

            System.out.println("No se pueden añadir ya más productos");
            productoFinalizado = true;

            c1.realizaPedido(productoSeleccionado1, productoSeleccionado2, productoSeleccionado3, c1.getDireccion());//Realizar pedido con los tres productos
            if (admin.getPedidos1() == null) admin.setPedidos1(c1.getPedido1());
            if (admin.getPedidos2() == null) admin.setPedidos2(c1.getPedido2());
            if (c1.hayPedido1()) c1.guardaClientePedido1(c1);
            if (c1.hayPedido2()) c1.guardaClientePedido2(c1);
            System.out.println("Su precio a pagar en total es de " + c1.recibirPrecioTotal());

        }
        if (op.equalsIgnoreCase("N") && contadorProductos == 2) {
            productoFinalizado = true;

            c1.realizaPedido(productoSeleccionado1, productoSeleccionado2, c1.getDireccion());//Realizar pedido solo con dos productos
            if (admin.getPedidos1() == null) admin.setPedidos1(c1.getPedido1());
            if (admin.getPedidos2() == null) admin.setPedidos2(c1.getPedido2());
            if (c1.hayPedido1()) c1.guardaClientePedido1(c1);
            if (c1.hayPedido2()) c1.guardaClientePedido2(c1);
            System.out.println("Su precio a pagar en total es de " + c1.recibirPrecioTotal());


        }
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
    }

    public void realizaPedidoCliente2() {
        Scanner s = new Scanner(System.in);
        Productos productoSeleccionado1 = null, productoSeleccionado2 = null, productoSeleccionado3 = null;
        boolean productoFinalizado = false, bucleCorrecto = false;
        String op, productoTeclado;
        int contadorProductos = 0;

        do {
            System.out.print("Introduce el número del producto mostrado en el catálogo (máximo 3 productos): ");
            productoTeclado = s.nextLine();
            switch (productoTeclado) {//Switch producto 1 cliente 1
                case "1":
                    productoSeleccionado1 = prod1;
                    contadorProductos++;
                    break;
                case "2":
                    productoSeleccionado1 = prod2;
                    contadorProductos++;
                    break;
                case "3":
                    productoSeleccionado1 = prod3;
                    contadorProductos++;
                    break;
                case "4":
                    productoSeleccionado1 = prod4;
                    contadorProductos++;
                    break;
                case "5":
                    productoSeleccionado1 = prod5;
                    contadorProductos++;
                    break;
                case "6":
                    productoSeleccionado1 = prod6;
                    contadorProductos++;
                    break;
                case "7":
                    productoSeleccionado1 = prod7;
                    contadorProductos++;
                    break;
                case "8":
                    productoSeleccionado1 = prod8;
                    contadorProductos++;
                    break;
            } //Switch producto 1
            if (productoTeclado.equals("1") || productoTeclado.equals("2") || productoTeclado.equals("3") || productoTeclado.equals("4") || productoTeclado.equals("5") || productoTeclado.equals("6") || productoTeclado.equals("7") || productoTeclado.equals("8")) {
                System.out.println("Producto agregado a la cesta");
                bucleCorrecto = true;
            } else {
                System.out.println("Dicho producto no existe"); //Del producto 1
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
            }
        } while (!bucleCorrecto);

        System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1) ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
        op = s.nextLine();

        if (op.equalsIgnoreCase("S")) {//Añadir producto 2
            bucleCorrecto = false;
            do {
                System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                productoTeclado = s.nextLine();
                switch (productoTeclado) {
                    case "1":
                        productoSeleccionado2 = prod1;
                        contadorProductos++;
                        break;
                    case "2":
                        productoSeleccionado2 = prod2;
                        contadorProductos++;
                        break;
                    case "3":
                        productoSeleccionado2 = prod3;
                        contadorProductos++;
                        break;
                    case "4":
                        productoSeleccionado2 = prod4;
                        contadorProductos++;
                        break;
                    case "5":
                        productoSeleccionado2 = prod5;
                        contadorProductos++;
                        break;
                    case "6":
                        productoSeleccionado2 = prod6;
                        contadorProductos++;
                        break;
                    case "7":
                        productoSeleccionado2 = prod7;
                        contadorProductos++;
                        break;
                    case "8":
                        productoSeleccionado2 = prod8;
                        contadorProductos++;
                        break;
                } //Switch producto 2
                if (productoTeclado.equals("1") || productoTeclado.equals("2") || productoTeclado.equals("3") || productoTeclado.equals("4") || productoTeclado.equals("5") || productoTeclado.equals("6") || productoTeclado.equals("7") || productoTeclado.equals("8")) {
                    System.out.println("Producto agregado a la cesta");
                    bucleCorrecto = true;
                } else {
                    System.out.println("Dicho producto no existe"); //Del producto 2
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } while (!bucleCorrecto); //Bucle producto 2
        } else {//Si no es "S"
            productoFinalizado = true;

            c2.realizaPedido(productoSeleccionado1, c2.getDireccion());//Realizar pedido solo con un producto
            if (admin.getPedidos3() == null) admin.setPedidos3(c2.getPedido1());
            if (admin.getPedidos4() == null) admin.setPedidos4(c2.getPedido2());
            if (c2.hayPedido1()) c2.guardaClientePedido1(c2);
            if (c2.hayPedido2()) c2.guardaClientePedido2(c2);
            System.out.println("Su precio a pagar en total es de " + c2.recibirPrecioTotal());

            //Realizar pedido solo con un producto
        }
        if (!productoFinalizado) {
            System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1) ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
            op = s.nextLine();
        }
        if (op.equalsIgnoreCase("S") && contadorProductos == 2) {//Añadir producto 3 y último
            bucleCorrecto = false;
            do {
                System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                productoTeclado = s.nextLine();
                switch (productoTeclado) {
                    case "1":
                        productoSeleccionado3 = prod1;
                        contadorProductos++;
                        break;
                    case "2":
                        productoSeleccionado3 = prod2;
                        contadorProductos++;
                        break;
                    case "3":
                        productoSeleccionado3 = prod3;
                        contadorProductos++;
                        break;
                    case "4":
                        productoSeleccionado3 = prod4;
                        contadorProductos++;
                        break;
                    case "5":
                        productoSeleccionado3 = prod5;
                        contadorProductos++;
                        break;
                    case "6":
                        productoSeleccionado3 = prod6;
                        contadorProductos++;
                        break;
                    case "7":
                        productoSeleccionado3 = prod7;
                        contadorProductos++;
                        break;
                    case "8":
                        productoSeleccionado3 = prod8;
                        contadorProductos++;
                        break;
                }
                if (productoTeclado.equals("1") || productoTeclado.equals("2") || productoTeclado.equals("3") || productoTeclado.equals("4") || productoTeclado.equals("5") || productoTeclado.equals("6") || productoTeclado.equals("7") || productoTeclado.equals("8")) {
                    System.out.println("Producto agregado a la cesta");
                    bucleCorrecto = true;
                } else {
                    System.out.println("Dicho producto no existe"); //Del producto 2
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                }
            } while (!bucleCorrecto);

            System.out.println("No se pueden añadir ya más productos");
            productoFinalizado = true;

            c2.realizaPedido(productoSeleccionado1, productoSeleccionado2, productoSeleccionado3, c2.getDireccion());//Realizar pedido con los tres productos
            if (admin.getPedidos3() == null) admin.setPedidos3(c2.getPedido1());
            if (admin.getPedidos4() == null) admin.setPedidos4(c2.getPedido2());
            if (c2.hayPedido1()) c2.guardaClientePedido1(c2);
            if (c2.hayPedido2()) c2.guardaClientePedido2(c2);
            System.out.println("Su precio a pagar en total es de " + c2.recibirPrecioTotal());

        }
        if (op.equalsIgnoreCase("N") && contadorProductos == 2) {
            productoFinalizado = true;

            c2.realizaPedido(productoSeleccionado1, productoSeleccionado2, c2.getDireccion());//Realizar pedido solo con dos productos
            if (admin.getPedidos3() == null) admin.setPedidos3(c2.getPedido1());
            if (admin.getPedidos4() == null) admin.setPedidos4(c2.getPedido2());
            if (c2.hayPedido1()) c2.guardaClientePedido1(c2);
            if (c2.hayPedido2()) c2.guardaClientePedido2(c2);
            System.out.println("Su precio a pagar en total es de " + c2.recibirPrecioTotal());


        }
        Utils.pulsaContinuar();
        Utils.limpiarpantalla();
    }

    public void modificarDatosPersonalesC1() {
        Scanner s = new Scanner(System.in);
        String correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, nombreTeclado;
        int telefonoTeclado;

        System.out.print("""
                MODIFICACIÓN DE DATOS:
                Introduzca nuevo correo electrónico:\s""");
        correoTeclado = s.nextLine();
        System.out.print("Introduce la nueva contraseña de tu cuenta: ");
        contraTeclado = s.nextLine();
        System.out.print("Introduce un nuevo nombre para su cuenta: ");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce tu nueva direccion (o repita datos): ");
        direccionTeclado = s.nextLine();
        System.out.print("Introduce su nueva localidad (o repita datos): ");
        localidadTeclado = s.nextLine();
        System.out.print("Introduce su nueva provincia (o repita datos): ");
        provinciaTeclado = s.nextLine();
        System.out.print("Introduzca su nuevo teléfono (o repita datos): ");
        telefonoTeclado = Integer.parseInt(s.nextLine());

        c1.modificarDatosCliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
    }

    public void modificarDatosPersonalesC2() {
        Scanner s = new Scanner(System.in);
        String correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, nombreTeclado;
        int telefonoTeclado;

        System.out.print(""" 
                MODIFICACIÓN DE DATOS:
                Introduzca nuevo correo electrónico:\s""");
        correoTeclado = s.nextLine();
        System.out.print("Introduce la nueva contraseña de tu cuenta: ");
        contraTeclado = s.nextLine();
        System.out.print("Introduce un nuevo nombre para su cuenta: ");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce tu nueva direccion (o repita datos): ");
        direccionTeclado = s.nextLine();
        System.out.print("Introduce su nueva localidad (o repita datos): ");
        localidadTeclado = s.nextLine();
        System.out.print("Introduce su nueva provincia (o repita datos): ");
        provinciaTeclado = s.nextLine();
        System.out.print("Introduzca su nuevo teléfono (o repita datos): ");
        telefonoTeclado = Integer.parseInt(s.nextLine());

        c2.modificarDatosCliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
    }

    public String pintaPedidoC1() {
        String salida = "";
        salida += "===== Cliente 1 =====\n";
        return salida + c1.pintaPedidoCliente();
    }

    public String pintaPedidoC2() {
        String salida = "";
        salida += "===== Cliente 2 =====\n";
        return salida + c2.pintaPedidoCliente();
    }

    //Trabajadores
    public boolean existeT1() {
        return t1 != null;
    }

    public boolean existeT2() {
        return t2 != null;
    }

    public boolean existeT3() {
        return t3 != null;
    }

    public boolean noExisteT1() {
        return t1 == null;
    }

    public boolean noExisteT2() {
        return t2 == null;
    }

    public boolean noExisteT3() {
        return t3 == null;
    }

    public boolean todoLlenoTrabajadores() {
        return t1 != null && t2 != null && t3 != null;
    }

    public void encendidoInicioSesionT1() {
        t1.setInicioCorrecto(true);
    }

    public void apagadoInicioSesionT1() {
        t1.setInicioCorrecto(false);
    }

    public boolean inicioSesionT1() {
        return existeT1() && t1.isInicioCorrecto();
    }

    public void encendidoInicioSesionT2() {
        t2.setInicioCorrecto(true);
    }

    public void apagadoInicioSesionT2() {
        t2.setInicioCorrecto(false);
    }

    public boolean inicioSesionT2() {
        return existeT2() && t2.isInicioCorrecto();
    }

    public void encendidoInicioSesionT3() {
        t3.setInicioCorrecto(true);
    }

    public void apagadoInicioSesionT3() {
        t3.setInicioCorrecto(false);
    }

    public boolean inicioSesionT3() {
        return existeT3() && t3.isInicioCorrecto();
    }

    public String perfilTrabajador1() {
        return t1.pintaTrabajadores();
    }

    public String perfilTrabajador2() {
        return t2.pintaTrabajadores();
    }

    public String perfilTrabajador3() {
        return t3.pintaTrabajadores();
    }

    public void modificarDatosPersonalesT1() {
        Scanner s = new Scanner(System.in);

        String contraTeclado, nombreTeclado;

        System.out.print("""
                MODIFICACIÓN DE DATOS:
                Introduce el nuevo nombre del trabajador:\s""");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce la nueva clave del trabajador: ");
        contraTeclado = s.nextLine();
        t1.modificarDatosTrabajador(nombreTeclado, contraTeclado);
    }

    public void modificarDatosPersonalesT2() {
        Scanner s = new Scanner(System.in);

        String contraTeclado, nombreTeclado;

        System.out.print("""
                MODIFICACIÓN DE DATOS:
                Introduce el nuevo nombre del trabajador:\s""");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce la nueva clave del trabajador: ");
        contraTeclado = s.nextLine();
        t2.modificarDatosTrabajador(nombreTeclado, contraTeclado);
    }

    public void modificarDatosPersonalesT3() {
        Scanner s = new Scanner(System.in);

        String contraTeclado, nombreTeclado;

        System.out.print("""
                MODIFICACIÓN DE DATOS:
                Introduce el nuevo nombre del trabajador:\s""");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce la nueva clave del trabajador: ");
        contraTeclado = s.nextLine();
        t3 = new Trabajadores(nombreTeclado, contraTeclado);
    }

    public String verPedidosAsignadosT1() {
        return t1.pedidosAsignados1() + t1.pedidosAsignados2();
    }

    public String verPedidosAsignadosT2() {
        return t2.pedidosAsignados1() + t2.pedidosAsignados2();
    }

    public String verPedidosAsignadosT3() {
        return t3.pedidosAsignados1() + t3.pedidosAsignados2();
    }

    public void modificarEstadoPedidoT1() {
        Scanner s = new Scanner(System.in);

        String op, fechaLlegadaTeclado;
        Pedidos pedidoTeclado = null;
        boolean existePedido = false;


        if (!t1.hayPedidoAsignado1() && !t1.hayPedidoAsignado2())
            System.out.println("No hay pedidos asignados");
        if (t1.hayPedidoAsignado1()) {
            System.out.println(t1.pedidosAsignados1());
            existePedido = true;
        }
        if (t1.hayPedidoAsignado2()) {
            System.out.println(t1.pedidosAsignados2());
            existePedido = true;
        }


        if (existePedido) {
            System.out.print("Elige el pedido a modificar: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    pedidoTeclado = t1.getPedido1();
                    break;
                case "2":
                    pedidoTeclado = t1.getPedido2();
                    break;
                default:
                    System.out.println("Pedido no existente");
            }
            System.out.println(t1.pintaMenuModificacionPedido(pedidoTeclado));

            boolean error = false;
            System.out.print("Seleccione el nuevo estado: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    pedidoTeclado.setEstado("Recibido");
                    break;
                case "2":
                    pedidoTeclado.setEstado("En preparación");
                    break;
                case "3":
                    pedidoTeclado.setEstado("Retrasado");
                    break;
                case "4":
                    pedidoTeclado.setEstado("Cancelado");
                    break;
                case "5":
                    pedidoTeclado.setEstado("Enviado");
                    break;
                default:
                    System.out.println("No existe dicho estado");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    error = true;
                    break;
            }
            if (!error) System.out.println("Estado actualizado correctamente");
            System.out.print("¿Quiere indicar una nueva fecha de entrega? (S/N): ");
            op = s.nextLine();
            if (op.equalsIgnoreCase("S")) {
                System.out.print("Introduzca la nueva fecha de entrega (formato dd/mm/yyyy)");
                fechaLlegadaTeclado = s.nextLine();
                pedidoTeclado.setFechaLlegada(fechaLlegadaTeclado);
            }
            System.out.println("¿Quiere añadir un comentario al pedido? (S/N): ");
            op = s.nextLine();
            if (op.equalsIgnoreCase("S")) {
                System.out.print("Introduzca el nuevo comentario: ");
                pedidoTeclado.setComentario(s.nextLine());
                System.out.println("Comentario guardado correctamente.");
            }
        }
    }

    public void modificarEstadoPedidoT2() {
        Scanner s = new Scanner(System.in);

        String op, fechaLlegadaTeclado;
        Pedidos pedidoTeclado = null;
        boolean existePedido = false;


        if (!t2.hayPedidoAsignado1() && !t2.hayPedidoAsignado2())
            System.out.println("No hay pedidos asignados");
        if (t2.hayPedidoAsignado1()) {
            System.out.println(t2.pedidosAsignados1());
            existePedido = true;
        }
        if (t2.hayPedidoAsignado2()) {
            System.out.println(t2.pedidosAsignados2());
            existePedido = true;
        }


        if (existePedido) {
            System.out.print("Elige el pedido a modificar: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    pedidoTeclado = t2.getPedido1();
                    break;
                case "2":
                    pedidoTeclado = t2.getPedido2();
                    break;
                default:
                    System.out.println("Pedido no existente");
            }
            System.out.println(t2.pintaMenuModificacionPedido(pedidoTeclado));

            boolean error = false;
            System.out.print("Seleccione el nuevo estado: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    pedidoTeclado.setEstado("Recibido");
                    break;
                case "2":
                    pedidoTeclado.setEstado("En preparación");
                    break;
                case "3":
                    pedidoTeclado.setEstado("Retrasado");
                    break;
                case "4":
                    pedidoTeclado.setEstado("Cancelado");
                    break;
                case "5":
                    pedidoTeclado.setEstado("Enviado");
                    break;
                default:
                    System.out.println("No existe dicho estado");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    error = true;
                    break;
            }
            if (!error) System.out.println("Estado actualizado correctamente");
            System.out.print("¿Quiere indicar una nueva fecha de entrega? (S/N): ");
            op = s.nextLine();
            if (op.equalsIgnoreCase("S")) {
                System.out.print("Introduzca la nueva fecha de entrega (formato dd/mm/yyyy)");
                fechaLlegadaTeclado = s.nextLine();
                pedidoTeclado.setFechaLlegada(fechaLlegadaTeclado);
            }
            System.out.println("¿Quiere añadir un comentario al pedido? (S/N): ");
            op = s.nextLine();
            if (op.equalsIgnoreCase("S")) {
                System.out.print("Introduzca el nuevo comentario: ");
                pedidoTeclado.setComentario(s.nextLine());
                System.out.println("Comentario guardado correctamente.");
            }
        }
    }

    public void modificarEstadoPedidoT3() {
        Scanner s = new Scanner(System.in);

        String op, fechaLlegadaTeclado;
        Pedidos pedidoTeclado = null;
        boolean existePedido = false;


        if (!t3.hayPedidoAsignado1() && !t3.hayPedidoAsignado2())
            System.out.println("No hay pedidos asignados");
        if (t3.hayPedidoAsignado1()) {
            System.out.println(t3.pedidosAsignados1());
            existePedido = true;
        }
        if (t3.hayPedidoAsignado2()) {
            System.out.println(t3.pedidosAsignados2());
            existePedido = true;
        }


        if (existePedido) {
            System.out.print("Elige el pedido a modificar: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    pedidoTeclado = t3.getPedido1();
                    break;
                case "2":
                    pedidoTeclado = t3.getPedido2();
                    break;
                default:
                    System.out.println("Pedido no existente");
            }
            System.out.println(t3.pintaMenuModificacionPedido(pedidoTeclado));

            boolean error = false;
            System.out.print("Seleccione el nuevo estado: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    pedidoTeclado.setEstado("Recibido");
                    break;
                case "2":
                    pedidoTeclado.setEstado("En preparación");
                    break;
                case "3":
                    pedidoTeclado.setEstado("Retrasado");
                    break;
                case "4":
                    pedidoTeclado.setEstado("Cancelado");
                    break;
                case "5":
                    pedidoTeclado.setEstado("Enviado");
                    break;
                default:
                    System.out.println("No existe dicho estado");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    error = true;
                    break;
            }
            if (!error) System.out.println("Estado actualizado correctamente");
            System.out.print("¿Quiere indicar una nueva fecha de entrega? (S/N): ");
            op = s.nextLine();
            if (op.equalsIgnoreCase("S")) {
                System.out.print("Introduzca la nueva fecha de entrega (formato dd/mm/yyyy)");
                fechaLlegadaTeclado = s.nextLine();
                pedidoTeclado.setFechaLlegada(fechaLlegadaTeclado);
            }
            System.out.println("¿Quiere añadir un comentario al pedido? (S/N): ");
            op = s.nextLine();
            if (op.equalsIgnoreCase("S")) {
                System.out.print("Introduzca el nuevo comentario: ");
                pedidoTeclado.setComentario(s.nextLine());
                System.out.println("Comentario guardado correctamente.");
            }
        }
    }

    public void modificarProductoCatalogoTrabajador() {
        Scanner s = new Scanner(System.in);

        String op, nombreTeclado, productoTeclado;
        double precioTeclado;

        System.out.print("Introduce el número del producto a modificar: ");
        productoTeclado = s.nextLine();
        switch (productoTeclado) {
            case "1":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod1.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod1.getPrecio();
                prod1 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "2":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod2.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod2.getPrecio();
                prod2 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "3":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod3.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod3.getPrecio();
                prod3 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "4":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod4.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod4.getPrecio();
                prod4 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "5":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod5.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod5.getPrecio();
                prod5 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "6":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod6.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod6.getPrecio();
                prod6 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "7":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod7.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod7.getPrecio();
                prod7 = new Productos(nombreTeclado, precioTeclado);
                break;
            case "8":
                System.out.println("Introduzca un nombre nuevo (introduce 'no' para dejar el anterior)");
                op = s.nextLine();
                if (op.equalsIgnoreCase("no")) nombreTeclado = prod8.getNombre();
                else nombreTeclado = op;
                System.out.println("Introduzca un precio nuevo (introduce '-1' para dejar el anterior)");
                precioTeclado = Double.parseDouble(s.nextLine());
                if (precioTeclado == -1) precioTeclado = prod8.getPrecio();
                prod8 = new Productos(nombreTeclado, precioTeclado);
                break;
            default:
                System.out.println("Producto no existente");
                Utils.pulsaContinuar();
                Utils.limpiarpantalla();
        }
    }

    //Admin
    public boolean existeAdmin() {
        return admin != null;
    }

    public boolean inicioSesionAdmin() {
        return existeAdmin() && admin.isInicioCorrecto();
    }

    public void encendidoInicioSesionAdmin() {
        admin.setInicioCorrecto(true);
    }

    public void apagadoInicioSesionAdmin() {
        admin.setInicioCorrecto(false);
    }

    public String verClientesAdmin() {
        if (existeCliente1() && !existeCliente2()) return c1.pintaCliente();
        if (existeCliente1() && existeCliente2()) return c1.pintaCliente() + c2.pintaCliente();
        return "No hay clientes registrados";
    }

    public String verTrabajadoresAdmin() {
        if (existeT1() && !existeT2() && !existeT3()) return t1.pintaTrabajadores();
        if (existeT1() && existeT2() && !existeT3()) return t1.pintaTrabajadores() + t2.pintaTrabajadores();
        if (existeT1() && existeT2() && existeT3())
            return t1.pintaTrabajadores() + t2.pintaTrabajadores() + t3.pintaTrabajadores();
        return "No hay trabajadores registrados";
    }

    public void darAltaTrabajador() {
        Scanner s = new Scanner(System.in);
        String contraTeclado, nombreTeclado;

        System.out.print("Introduce el nombre del trabajador: ");
        nombreTeclado = s.nextLine();
        System.out.print("Introduce la clave del trabajador: ");
        contraTeclado = s.nextLine();
        if (noExisteT1()) t1 = new Trabajadores(nombreTeclado, contraTeclado);
        else if (existeT1() && noExisteT2()) t2 = new Trabajadores(nombreTeclado, contraTeclado);
        else if (existeT2() && noExisteT3()) t3 = new Trabajadores(nombreTeclado, contraTeclado);
    }

    public void asignarPedidoTrabajador() {
        boolean tempCliente = false, error = false;
        int contadorPedidos = 0;
        if (noExisteCliente1() && noExisteCliente2()) error = true;
        if (existeCliente1() && !c1.nohayPedidos()) {
            System.out.println("=== Asignación de trabajadores a pedidos ===");
            if (c1.getPedido1() != null) {
                contadorPedidos++;
                System.out.println(contadorPedidos + c1.menuAsignacionTrabajadorPedido1());
            } else System.out.println(c1.menuAsignacionTrabajadorPedido1());
            if (c1.getPedido2() != null) {
                contadorPedidos++;
                System.out.println(contadorPedidos + c1.menuAsignacionTrabajadorPedido2());
            } else System.out.println(c1.menuAsignacionTrabajadorPedido2());
            tempCliente = true;
        }
        if (existeCliente2() && !c2.nohayPedidos()) {
            if (c2.getPedido1() != null) {
                contadorPedidos++;
                System.out.println(contadorPedidos + c2.menuAsignacionTrabajadorPedido1());
            } else System.out.println(c1.menuAsignacionTrabajadorPedido1());
            if (c2.getPedido2() != null) {
                contadorPedidos++;
                System.out.println(contadorPedidos + c2.menuAsignacionTrabajadorPedido2());
            } else System.out.println(c2.menuAsignacionTrabajadorPedido2());
            tempCliente = true;
        }
        if (tempCliente) {
            Scanner s = new Scanner(System.in);
            String op;
            Pedidos pedidoTeclado = null;

            System.out.print("Seleccione el pedido a asignar: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    boolean entra = false;
                    if (c1.getPedido1() != null) pedidoTeclado = c1.getPedido1();
                    else System.out.println();
                    if (c1.getPedido1() != null && c2 == null){
                        pedidoTeclado = c1.getPedido1();
                        entra = true;
                    }
                    else if (c1.getPedido1() != null && c2.getPedido1() != null){
                        pedidoTeclado = c1.getPedido1();
                        entra = true;
                    }
                    else System.out.println();
                    if (c2 == null && c1.getPedido1() != null && entra) pedidoTeclado = c1.getPedido1();
                    else if (c2.getPedido1() != null && c1.getPedido1() == null) pedidoTeclado = c2.getPedido1();
                    else System.out.println();
                    break;
                case "2":
                    entra = false;
                    if (c1.getPedido2() != null && c2 == null){
                        pedidoTeclado = c1.getPedido2();
                        entra = true;
                    }
                    else if (c1.getPedido2() != null && c2.getPedido1() != null){
                        pedidoTeclado = c1.getPedido2();
                        entra = true;
                    }
                    else System.out.println();
                    if (c2 == null && c1.getPedido2() != null && entra) pedidoTeclado = c1.getPedido2();
                    else if (c2.getPedido1() != null && c1.getPedido2() == null) pedidoTeclado = c2.getPedido1();
                    else System.out.println();
                    break;
                case "3":
                    if (c2.getPedido1() != null) pedidoTeclado = c2.getPedido1();
                    else System.out.println();
                    if (c2.getPedido2() != null) pedidoTeclado = c2.getPedido2();
                    System.out.println();
                    break;
                case "4":
                    if (noExisteCliente2()) System.out.println("El cliente 2 no existe");
                    else if (c2.nohayPedidos())
                        System.out.println("No hay pedidos en dicho cliente");
                    pedidoTeclado = c2.getPedido2();
                    break;
                default:
                    error = true;
                    break;
            }
            if (!error) {
                System.out.println(admin.menuAsignar(pedidoTeclado));
                System.out.print("Seleccione el trabajador: ");
                op = s.nextLine();
                switch (op) {
                    case "1":
                        t1.asignaPedido(pedidoTeclado);
                        System.out.println("Operación realizada correctamente, pedido asignado a " + t1.getNombre());
                        break;
                    case "2":
                        t2.asignaPedido(pedidoTeclado);
                        System.out.println("Operación realizada correctamente, pedido asignado a " + t2.getNombre());
                        break;
                    case "3":
                        t3.asignaPedido(pedidoTeclado);
                        System.out.println("Operación realizada correctamente, pedido asignado a " + t3.getNombre());
                        break;
                }
            }
        }
        if (existeCliente1() && c1.nohayPedidos() && existeCliente2() && c2.nohayPedidos())
            System.out.println("No hay pedidos");
        if (error) System.out.println("No existen clientes o el pedido seleccionado anteriormente no existe");
    }

    public void modificarEstadoPedidoAdmin() {
        Scanner s = new Scanner(System.in);

        boolean error = false, errorAdmin = false;
        String op, fechaLlegadaTeclado;
        Pedidos pedidoTeclado = null;
        int contadorPedidosAdmin = 0;

        if (noExisteCliente1() && noExisteCliente2()) error = true;
        if (existeCliente1() && !c1.nohayPedidos()) {
            System.out.println("=== Modificación de pedidos ===");
            if (c1.getPedido1() != null) {
                contadorPedidosAdmin++;
                System.out.println(contadorPedidosAdmin + c1.menuAsignacionTrabajadorPedido1());
            } else System.out.println(c1.menuAsignacionTrabajadorPedido1());
            if (c1.getPedido2() != null) {
                contadorPedidosAdmin++;
                System.out.println(contadorPedidosAdmin + c1.menuAsignacionTrabajadorPedido2());
            } else System.out.println(c1.menuAsignacionTrabajadorPedido2());
        }
        if (existeCliente2() && !c2.nohayPedidos()) {
            if (c2.getPedido1() != null) {
                contadorPedidosAdmin++;
                System.out.println(contadorPedidosAdmin + c2.menuAsignacionTrabajadorPedido1());
            } else System.out.println(c1.menuAsignacionTrabajadorPedido1());
            if (c2.getPedido2() != null) {
                contadorPedidosAdmin++;
                System.out.println(contadorPedidosAdmin + c2.menuAsignacionTrabajadorPedido2());
            } else System.out.println(c2.menuAsignacionTrabajadorPedido2());
        }
        if (existeCliente1() && c1.nohayPedidos() && existeCliente2() && c2.nohayPedidos())
            System.out.println("No hay pedidos");
        else {
            System.out.print("Selecciona un pedido: ");
            op = s.nextLine();
            switch (op) {//Switch elección
                case "1":
                    if (noExisteCliente1() && noExisteCliente2()) {
                        System.out.println("No hay pedidos");
                        errorAdmin = true;
                    }
                    else {
                        if (existeCliente1() && c1.getPedido1() != null) pedidoTeclado = c1.getPedido1();
                        else System.out.println();
                        if (existeCliente1() && c1.getPedido1() != null && c2.getPedido1() != null) pedidoTeclado = c1.getPedido1();
                        else System.out.println();
                        if (existeCliente2() && c2.getPedido1() != null && c1.getPedido1() == null) pedidoTeclado = c2.getPedido1();
                    }
                    break;
                case "2":
                    if (noExisteCliente1() && noExisteCliente2()) {
                        System.out.println("No hay pedidos");
                        errorAdmin = true;
                    } else {
                        if (existeCliente1() && c1.getPedido2() != null && c2.getPedido1() != null) pedidoTeclado = c1.getPedido2();
                        else System.out.println();
                        if (c2.getPedido1() != null && c1.getPedido2() == null) pedidoTeclado = c2.getPedido1();
                        else System.out.println();
                    }
                    break;
                case "3":
                    if (noExisteCliente1() && noExisteCliente2()) {
                        System.out.println("No hay pedidos");
                        errorAdmin = true;
                    } else {
                        if (c2.getPedido1() != null) pedidoTeclado = c2.getPedido1();
                        else System.out.println();
                        if (c2.getPedido2() != null) pedidoTeclado = c2.getPedido2();
                        System.out.println();
                    }
                    break;
                case "4":
                    if (noExisteCliente1() && noExisteCliente2()) {
                        System.out.println("No hay pedidos");
                        errorAdmin = true;
                    } else {
                        if (noExisteCliente2()) System.out.println("El cliente 2 no existe");
                        else if (c2.nohayPedidos())
                            System.out.println("No hay pedidos en dicho cliente");
                        pedidoTeclado = c2.getPedido2();
                    }
                    break;
                default:
                    System.out.println("No existe ese pedido");
                    errorAdmin = true;
                    break;
            }
            if (!errorAdmin) {
                System.out.println(admin.pintaMenuModificacionPedido(pedidoTeclado));
                System.out.print("Seleccione el nuevo estado: ");
                op = s.nextLine();
                switch (op) {
                    case "1":
                        pedidoTeclado.setEstado("Recibido");
                        break;
                    case "2":
                        pedidoTeclado.setEstado("En preparación");
                        break;
                    case "3":
                        pedidoTeclado.setEstado("Retrasado");
                        break;
                    case "4":
                        pedidoTeclado.setEstado("Cancelado");
                        break;
                    case "5":
                        pedidoTeclado.setEstado("Enviado");
                        break;
                    default:
                        System.out.println("No existe dicho estado");
                        Utils.pulsaContinuar();
                        Utils.limpiarpantalla();
                        errorAdmin = true;
                        break;
                }
                if (!errorAdmin) System.out.println("Estado actualizado correctamente");
                System.out.print("¿Quiere indicar una nueva fecha de entrega? (S/N): ");
                op = s.nextLine();
                if (op.equalsIgnoreCase("S")) {
                    System.out.print("Introduzca la nueva fecha de entrega (formato dd/mm/yyyy)");
                    fechaLlegadaTeclado = s.nextLine();
                    pedidoTeclado.setFechaLlegada(fechaLlegadaTeclado);
                }
                System.out.print("¿Quiere indicar una nueva dirección? (S/N): ");
                op = s.nextLine();
                if (op.equalsIgnoreCase("S")) {
                    System.out.print("Introduzca la nueva dirección");
                    pedidoTeclado.setDireccionEntrega(s.nextLine());
                }
                System.out.println("¿Quiere añadir un comentario al pedido? (S/N): ");
                op = s.nextLine();
                if (op.equalsIgnoreCase("S")) {
                    System.out.print("Introduzca el nuevo comentario: ");
                    pedidoTeclado.setComentario(s.nextLine());
                    System.out.println("Comentario guardado correctamente.");
                }
            }
        }
    }
}
