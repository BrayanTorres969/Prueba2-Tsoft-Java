package modelos;

public class DatosCliente {
    /*
        DatosCliente tiene nombre y rut del cliente.
     */
    //atributos
    private String nombre;
    private String rut;

    //constructores

    public DatosCliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    //metodos
}
