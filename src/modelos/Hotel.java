package modelos;

public class Hotel extends Hospederia {
    protected boolean conDesayuno;

    public Hotel(double valorBaseNoche, int cantidadNoches, DatosCliente datosCliente, String tipoTemporada, int capacidad,
                 boolean esFumador, boolean conDesayuno) {
        super(valorBaseNoche, cantidadNoches, datosCliente, tipoTemporada, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    //metodos
    public double adicional() {
        double montoAdicional = 0;
        if (isEsFumador() && isConDesayuno()) {
            montoAdicional = subtotal() * 0.3;
        }
        return montoAdicional;
    }


    @Override
    public double valorACancelar() {
        return subtotal() - bonoDescuento() + adicional();
    }

    @Override
    public String toString() {
        return "Hotel: " +
                "\nIncluye desayuno: " + (conDesayuno ? "si" : "no") +
                "\nCapacidad: " + capacidad + " personas" +
                "\nEs fumador: " + (esFumador ? "si" : "no") +
                "\nValor base por noche: S/ " + valorBaseNoche +
                "\nCantidad de noches : " + cantidadNoches +
                "\nTipo de temporada: " + tipoTemporada;
    }
}
