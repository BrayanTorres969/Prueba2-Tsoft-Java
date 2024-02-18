package modelos;

public class Carpa extends MedioDeAlojamiento {

    protected int cantidadPersonas;

    public Carpa(double valorBaseNoche, int cantidadNoches, DatosCliente datosCliente, String tipoTemporada,
                 int cantidadPersonas) {
        super(valorBaseNoche, cantidadNoches, datosCliente, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public double valorACancelar() {
        return this.subtotal() - this.bonoDescuento();
    }

    @Override
    public String toString() {
        return "Carpa: " +
                "\nCantidad de personas: " + cantidadPersonas +
                "\nValor base por noche: S/ " + valorBaseNoche +
                "\nCantidad de noches : " + cantidadNoches +
                "\nTipo de temporada: " + tipoTemporada;
    }
}
