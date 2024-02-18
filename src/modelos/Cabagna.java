package modelos;

public class Cabagna extends Hospederia {
    protected boolean chimenea;

    public Cabagna(double valorBaseNoche, int cantidadNoches, DatosCliente datosCliente, String tipoTemporada,
                   int capacidad, boolean esFumador, boolean chimenea) {
        super(valorBaseNoche, cantidadNoches, datosCliente, tipoTemporada, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    //aumenta el valor base en un 18% si la capacidad de la cabaña es superior a 5.
    public void incrementarValorBase() {
        setValorBaseNoche(getValorBaseNoche() * 1.18);
    }

    @Override
    public String toString() {
        return "Cabaña: " +
                "\nTiene chimenea: " + (chimenea ? "si" : "no") +
                "\nCapacidad: " + capacidad + " personas" +
                "\nEs fumador: " + (esFumador ? "si" : "no") +
                "\nValor base por noche: S/ " + valorBaseNoche +
                "\nCantidad de noches : " + cantidadNoches +
                "\nTipo de temporada: " + tipoTemporada;
    }
}
