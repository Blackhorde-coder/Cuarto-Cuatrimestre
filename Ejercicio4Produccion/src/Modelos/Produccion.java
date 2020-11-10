package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Produccion {

    private int idProduccion;
    private Responsable responsable;
    private Componente componente;
    private int cantidad;
    private String fecha;

    public Produccion() {
    }

    public Produccion(int idProduccion, Responsable Responsable, Componente Componente, int cantidad, String fecha) 
    {
        this.idProduccion = idProduccion;
        this.responsable = Responsable;
        this.componente = Componente;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Componente getComponente() {
        return componente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    @Override
    public String toString() {
        return "Produccion{" + "idProduccion=" + idProduccion + ", responsable=" + responsable + ", componente=" + componente + ", cantidad=" + cantidad + ", fecha=" + fecha + '}';
    }
    
    

}
