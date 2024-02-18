package vista;

import controlador.EmpresaTurismo;
import modelos.Cabagna;
import modelos.Carpa;
import modelos.DatosCliente;
import modelos.Hotel;

public class Aplicacion {
    public static void main(String[] args) {

        EmpresaTurismo empresaTurismo = new EmpresaTurismo();

        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1: //ingreso
                    DatosCliente datosCliente = crearDatosCliente();
                    int cantPersonas, capacidad;
                    boolean esFumador;
                    if (empresaTurismo.buscarAlojamiento(datosCliente.getRut()) == -1) {
                        //se puede registrar el alojamiento
                        double valorBaseNoche = ingresarValorBaseNoche();
                        int cantidadNoches = ingresarDatoEntero("Ingresar la cantidad de noches : ");
                        String tipoTemporada = ingresarTipoTemporada();
                        int tipoAlojamiento = seleccionarTipoAlojamiento();
                        switch (tipoAlojamiento) {
                            case 1:
                                //Carpa
                                System.out.println("---- Datos de la carpa -----");
                                cantPersonas = ingresarDatoEntero("Ingresar la cantidad de personas : ");
                                empresaTurismo.ingresarCarpa(new Carpa(valorBaseNoche, cantidadNoches, datosCliente,
                                        tipoTemporada, cantPersonas));
                                System.out.println(">>> Carpa ingresada correctamente. <<<");
                                break;
                            case 2:
                                //Cabaña
                                System.out.println("---- Datos de la cabaña -----");
                                cantPersonas = ingresarDatoEntero("Ingresar la cantidad de personas : ");
                                capacidad = ingresarDatoEntero("Ingresar la capacidad : ");
                                esFumador = ingresarDatoBooleano("¿Es fumador? : (s/n)");
                                boolean conChimenea = ingresarDatoBooleano("¿Desea una cabaña con chimenea? : (s/n)");
                                empresaTurismo.ingresarCabagna(new Cabagna(valorBaseNoche, cantidadNoches, datosCliente
                                        , tipoTemporada, capacidad, esFumador, conChimenea));
                                System.out.println(">>> Cabaña ingresada correctamente. <<<");
                                break;
                            case 3:
                                //Hotel
                                System.out.println("---- Datos del hotel -----");
                                cantPersonas = ingresarDatoEntero("Ingresar la cantidad de personas : ");
                                capacidad = ingresarDatoEntero("Ingresar la capacidad : ");
                                esFumador = ingresarDatoBooleano("¿Es fumador? : (s/n)");
                                boolean conDesayuno = ingresarDatoBooleano("¿Desea incluir desayuno? : (s/n)");
                                empresaTurismo.ingresarHotel(new Hotel(valorBaseNoche, cantidadNoches, datosCliente,
                                        tipoTemporada, capacidad, esFumador, conDesayuno));
                                System.out.println(">>> Hotel ingresado correctamente. <<<");
                                break;
                        }

                    } else {
                        System.out.println(">>> El rut " + datosCliente.getRut() + " se encuentra asociado a otro " +
                                "cliente. <<<");
                    }
                    break;
                case 2:
                    if (empresaTurismo.getEmpresa().size() == 0) { // no hay una alojamiento registrado
                        System.out.println(">>> Por favor, ingrese un alojamiento para continuar ... <<<");
                    } else {
                        System.out.println();
                        System.out.println("----------------Medios de Alojamiento ------------------");
                        empresaTurismo.mostrarMediosDeAlojamiento();
                        System.out.println("--------------------------------------------------------");
                    }
                    break;
                case 3://datos de un cliente X
                    if (empresaTurismo.getEmpresa().size() == 0) { // no hay un alojamiento registrado
                        System.out.println("Por favor, ingrese un alojamiento para continuar ...");
                    } else {
                        System.out.println("Ingrese el número rut del cliente a buscar: ");
                        String rutCliente = Leer.dato();
                        empresaTurismo.buscarDatosClienteX(rutCliente);
                    }
                    break;
                case 4:
                    if (empresaTurismo.getEmpresa().size() == 0) { // no hay una alojamiento registrado
                        System.out.println(">>> Por favor, ingrese un alojamiento para continuar ... <<<");
                    } else {
                        System.out.println();
                        System.out.println("--------------- Total adicional  -----------------------");
                        System.out.println(" S/ " + empresaTurismo.totalAdicional());
                        System.out.println("--------------------------------------------------------");
                    }
                    break;
                case 5:
                    if (empresaTurismo.getEmpresa().size() == 0) { // no hay una alojamiento registrado
                        System.out.println(">>> Por favor, ingrese un alojamiento para continuar ... <<<");
                    } else {
                        System.out.println();
                        System.out.println("--------------- Total bono descuento  ------------------");
                        System.out.println(" S/ " + empresaTurismo.totalBonoDescuento());
                        System.out.println("--------------------------------------------------------");
                    }
                    break;
                case 6://cantidad de medios

                    if (empresaTurismo.getEmpresa().size() == 0) { // no hay una alojamiento registrado
                        System.out.println(">>> Por favor, ingrese un alojamiento para continuar ... <<<");
                    } else {
                        System.out.println();
                        System.out.println("Para comenzar con la busqueda ....");
                        int tipoAlojamiento = seleccionarTipoAlojamiento();
                        switch (tipoAlojamiento) {
                            case 1: //carpa
                                int cantidadCarpa = empresaTurismo.contarMediosDeAlojamiento(Carpa.class);
                                System.out.println("--------------- Total de carpas  -----------------------");
                                System.out.println(cantidadCarpa);
                                System.out.println("--------------------------------------------------------");
                                break;
                            case 2: //cabaña
                                int cantidadCabagna = empresaTurismo.contarMediosDeAlojamiento(Cabagna.class);
                                System.out.println("--------------- Total de cabañas  ----------------------");
                                System.out.println(cantidadCabagna);
                                System.out.println("--------------------------------------------------------");
                                break;
                            case 3:
                                //hotel
                                int cantidadHotel = empresaTurismo.contarMediosDeAlojamiento(Hotel.class);
                                System.out.println("--------------- Total de hoteles  ----------------------");
                                System.out.println(cantidadHotel);
                                System.out.println("--------------------------------------------------------");
                                break;
                        }
                    }

                    break;
                case 7://calacular valor a cancelar por cliente X
                    if (empresaTurismo.getEmpresa().size() == 0) {
                        System.out.println(">>> Por favor, ingrese un alojamiento para continuar ... <<<");
                    } else {
                        System.out.println();
                        System.out.println("Ingresar el rut del cliente: ");
                        String rut = Leer.dato();
                        System.out.println("---------- Valor a cancelar por el cliente -------------");
                        empresaTurismo.valorACancelarPorCliente(rut);
                        System.out.println("--------------------------------------------------------");
                    }
                    break;
                case 8:
                    if (empresaTurismo.getEmpresa().size() == 0) { // no hay una alojamiento registrado
                        System.out.println(">>> Por favor, ingrese un alojamiento para continuar ... <<<");
                    } else {
                        System.out.println();
                        System.out.println("--------------- Aplicar incremento del valor base --");
                        empresaTurismo.aplicarIncrementoValorBase();
                        System.out.println("----------------------------------------------------");

                    }
                    break;
            }
        } while (opcion != 9);

    }

    //Método que muestra el menú de opciones al usuario
    public static int menu() {
        System.out.println();
        System.out.println("***** Bienvenido a la empresa de turismo *****");
        System.out.println("1) Ingresar Medio de Alojamiento: ");
        System.out.println("2) Mostrar medios de alojamiento: ");
        System.out.println("3) Datos de un cliente X: ");
        System.out.println("4) Total adicional: ");
        System.out.println("5) Total bono descuento: ");
        System.out.println("6) Cantidad medios de alojamiento X: ");
        System.out.println("7) Valor a cancelar por un cliente X: ");
        System.out.println("8) Aplicar incremento del valor base: ");
        System.out.println("9) Salir ");
        return Leer.datoInt();
    }

    //Método que muestra una interfaz para registrar datos del cliente y validar los datos ingresados
    public static DatosCliente crearDatosCliente() {
        String nomCliente;
        String[] datosNombre = null;
        do {
            System.out.println("ingrese nombre del cliente: (Ejm Pablo Rojas Rojas)");
            nomCliente = Leer.dato();
            datosNombre = nomCliente.split(" ");
        } while (datosNombre.length != 3);

        System.out.println("ingrese rut del cliente: (Ejm 12345678)");
        String rutCliente = Leer.dato();
        return new DatosCliente(nomCliente, rutCliente);
    }

    //Método que muestra una lista de opciones de alojamiento y captura el valor ingresado
    private static int seleccionarTipoAlojamiento() {
        int op;
        do {
            System.out.println(">> Escojer el tipo de alojamiento : ");
            System.out.println("1) Carpa");
            System.out.println("2) Cabaña");
            System.out.println("3) Hotel");
            System.out.print("Ingrese su opción: ");
            op = Leer.datoInt();
        } while (op < 1 || op > 3);
        return op;
    }

    // Métodos  para ingresar datos y validar
    private static double ingresarValorBaseNoche() {
        System.out.println("Ingresar el valor base por noche: ");
        return Leer.datoDouble();
    }

    /*Este método lanza una pregunta al usuario y se asegura que la respuesta
     sea un número entero mayor a 0
      */
    private static int ingresarDatoEntero(String pregunta) {
        int respuesta;
        do {
            System.out.println(pregunta);
            respuesta = Leer.datoInt();

            if (respuesta <= 0) {
                System.out.println("Respuesta no válida. Por favor, ingresa un número mayor a 0.");
            }
        } while (respuesta <= 0);
        return respuesta;
    }

    private static String ingresarTipoTemporada() {
        String respuesta;
        do {
            System.out.println("Ingresar el tipo de temporada : (alta, media o baja) ");
            respuesta = Leer.dato();
        } while (!respuesta.equalsIgnoreCase("alta") && !respuesta.equalsIgnoreCase("media")
                && !respuesta.equalsIgnoreCase("baja"));

        return respuesta;
    }

    /*Este método lanza una pregunta al usuario y se asegura que la respuesta sea s o n y luego lo guarda como un
    valor booleano */

    private static boolean ingresarDatoBooleano(String pregunta) {
        String respuesta;
        do {
            System.out.println(pregunta);
            respuesta = Leer.dato();

            if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                System.out.println("Respuesta no válida. Por favor, ingrese 's' o 'n'.");
            }
        } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));
        return respuesta.equalsIgnoreCase("s");
    }

}