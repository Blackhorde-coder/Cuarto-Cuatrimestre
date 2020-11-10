

package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Oferta 
{
    private int idOferta;
    private int idProducto;
    private double precioNormal;
    private double precioOferta;
    private int stock;
    private String fechaInicioOferta;
    private int diasOferta;

    public Oferta(int idOferta, int idProducto, double precioNormal, double precioOferta, int stock, String fechaInicioOferta, int diasOferta) {
        this.idOferta = idOferta;
        this.idProducto = idProducto;
        this.precioNormal = precioNormal;
        this.precioOferta = precioOferta;
        this.stock = stock;
        this.fechaInicioOferta = fechaInicioOferta;
        this.diasOferta = diasOferta;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public int getStock() {
        return stock;
    }

    public String getFechaInicioOferta() {
        return fechaInicioOferta;
    }

    public int getDiasOferta() {
        return diasOferta;
    }
    
    
}
