
package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class DTOreporte 
{
    private String nombre;
    private int cantidad;

    public DTOreporte(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public DTOreporte() {
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
        return "NOMBRE: "+nombre+"--CANTIDAD: "+cantidad;
    }
    
    
}
