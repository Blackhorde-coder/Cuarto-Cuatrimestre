
package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Producto 
{
    private int idProducto;
    private String nombre;

    public Producto(int idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() 
    {
        return idProducto +"  "+nombre;
    }
    
    
    
}
