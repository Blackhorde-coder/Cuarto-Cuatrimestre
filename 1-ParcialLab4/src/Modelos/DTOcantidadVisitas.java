
package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class DTOcantidadVisitas 
{
    private String nombre;
    private int cantidad;

    public DTOcantidadVisitas() {
    }

    public DTOcantidadVisitas(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DTOcantidadVisitas{" + "nombre=" + nombre + ", cantidad=" + cantidad + '}';
    }
    
    
}
