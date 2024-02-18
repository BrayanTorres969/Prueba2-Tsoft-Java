package modelos;

public class Hospederia extends MedioDeAlojamiento {

    protected int capacidad;
    protected boolean esFumador;


    public Hospederia(double valorBaseNoche, int cantidadNoches, DatosCliente datosCliente, String tipoTemporada,
                      int capacidad, boolean esFumador) {
        super(valorBaseNoche, cantidadNoches, datosCliente, tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    @Override
    public double valorACancelar() {
        return this.subtotal() - this.bonoDescuento();
    }
}
