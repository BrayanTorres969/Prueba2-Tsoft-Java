package modelos;

public abstract class MedioDeAlojamiento {
    protected double valorBaseNoche;
    protected int cantidadNoches;
    protected DatosCliente datosCliente;
    protected String tipoTemporada; //(alta, media o baja

    public MedioDeAlojamiento() {
    }

    public MedioDeAlojamiento(double valorBaseNoche, int cantidadNoches, DatosCliente datosCliente,
                              String tipoTemporada) {
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.datosCliente = datosCliente;
        this.tipoTemporada = tipoTemporada;
    }

    public double getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(double valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    //metodos
    //devolverá el subtotal a cancelar el cual será cantidad de noches por el valorBaseNoche
    public double subtotal() {
        return this.cantidadNoches * this.valorBaseNoche;
    }

    /*
    devolverá el valor a descontar sabiendo que es un 25% del subTotal
     si el tipo de temporada es baja o es de un 12.5% si el tipo Temporada es media.
     */
    public double bonoDescuento() {
        double valorDescontar = 0;
        if ("baja".equalsIgnoreCase(tipoTemporada)) {
            valorDescontar = this.subtotal() * 0.25;
        } else if ("media".equalsIgnoreCase(tipoTemporada)) {
            valorDescontar = this.subtotal() * 0.125;
        }
        return valorDescontar;
    }

    /*
    devolverá el valor a cancelar, el cual al subtotal se le debe
    descontar el bono y sumar el adicional, donde corresponda.
     */
    public abstract double valorACancelar();
}
