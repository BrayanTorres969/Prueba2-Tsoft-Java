package controlador;

import modelos.Cabagna;
import modelos.Carpa;
import modelos.Hotel;
import modelos.MedioDeAlojamiento;

import java.util.ArrayList;

public class EmpresaTurismo {

    //Atributos
    private ArrayList<MedioDeAlojamiento> empresa;

    //constructor

    public EmpresaTurismo() {
        this.empresa = new ArrayList<>();
    }

    //Accesadores y mutadores

    public ArrayList<MedioDeAlojamiento> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<MedioDeAlojamiento> empresa) {
        this.empresa = empresa;
    }

    //Métodos que controlan la lógica de la empresa

    public int buscarAlojamiento(String rutCliente) {
        for (int i = 0; i < empresa.size(); i++) {

            if (empresa.get(i).getDatosCliente().getRut().compareToIgnoreCase(rutCliente) == 0) {
                //encontre el rut en la posición respectiva del indice
                return i;
            }
        }
        return -1; //no existe el rut del cliente asociado a ninguno de los alojamientos registrados
    }

    public void ingresarCarpa(Carpa carpa) {
        if (buscarAlojamiento(carpa.getDatosCliente().getRut()) == -1) {
            empresa.add(carpa);
        }
    }

    public void ingresarCabagna(Cabagna cabagna) {
        if (buscarAlojamiento(cabagna.getDatosCliente().getRut()) == -1) {
            empresa.add(cabagna);
        }
    }

    public void ingresarHotel(Hotel hotel) {
        if (buscarAlojamiento(hotel.getDatosCliente().getRut()) == -1) {
            empresa.add(hotel);
        }
    }

    public void mostrarMediosDeAlojamiento() {
        for (int i = 0; i < empresa.size(); i++) {
            System.out.println("------ << " + (i + 1) + " >> -----------------------------------------");
            System.out.println(empresa.get(i).toString());
        }
    }

    public void buscarDatosClienteX(String rutCliente) {
        if (empresa.size() > 0) {
            for (int i = 0; i < empresa.size(); i++) {
                if (empresa.get(i).getDatosCliente().getRut().compareToIgnoreCase(rutCliente) == 0) {//encuentra los
                    // datos del cliente
                    System.out.println("****** Datos del cliente ******");
                    System.out.println("Nombres: " + empresa.get(i).getDatosCliente().getNombre());
                    System.out.println("Rut: " + empresa.get(i).getDatosCliente().getRut());
                    System.out.println("***** Datos de alojamiento *****");
                    System.out.println("El cliente se encuentra alojado en un/una");
                    System.out.println(empresa.get(i).toString());

                } else {
                    System.out.println("\n========================================================");
                    System.out.println("==== El rut ingresado no pertenece a ningún cliente ====");
                    System.out.println("========================================================\n");
                }
            }

        } else {
            System.out.println("El arreglo está vacio");
        }
    }

    public double totalAdicional() {
        Hotel hotel = null;
        int total = 0;
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i) instanceof Hotel) {
                hotel = (Hotel) empresa.get(i);
                total += hotel.adicional();
            }
        }
        return total;
    }

    public double totalBonoDescuento() {
        double total = 0;
        for (int i = 0; i < empresa.size(); i++) {
            total += empresa.get(i).bonoDescuento();
        }
        return total;
    }

    public int contarMediosDeAlojamiento(Class<? extends MedioDeAlojamiento> tipoMedio) {
        int total = 0;
        for (MedioDeAlojamiento medio : empresa) {
            if (tipoMedio.isInstance(medio)) {
                total++;
            }
        }
        return total;
    }

    public void aplicarIncrementoValorBase() {
        Cabagna cabagna = null;
        int contador = 0, contCabanas = 0;
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i) instanceof Cabagna) {
                contCabanas++;
                cabagna = (Cabagna) empresa.get(i);
                if (cabagna.getCapacidad() > 5) {
                    System.out.println("----------------------------------------------------");
                    System.out.println((contador + 1) + " )");
                    System.out.println("Rut cliente: " + cabagna.getDatosCliente().getRut());
                    System.out.println("Valor base anterior: S/ " + cabagna.getValorBaseNoche());
                    cabagna.incrementarValorBase();
                    System.out.println("valor base nuevo: S/ " + cabagna.getValorBaseNoche());
                    System.out.println("----------------------------------------------------\n");
                    contador++;
                }
            }
        }
        System.out.println("Se aplicó el incremento a " + contador + " de " + contCabanas + " cabañas.");
    }

    public void valorACancelarPorCliente(String rutCliente) {
        if (this.buscarAlojamiento(rutCliente) != -1) {
            for (int i = 0; i < empresa.size(); i++) {
                System.out.println("--------------------------------------------------------");
                System.out.println(empresa.get(i).getDatosCliente().getNombre());
                System.out.println("--------------------------------------------------------");
                System.out.println("S/ " + empresa.get(i).valorACancelar());
            }
        } else {
            System.out.println(">>> No existe cliente registrado con ese rut <<<");
        }
    }


}
