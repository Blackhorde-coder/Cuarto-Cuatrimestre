
package DTO;

public class DtoReporte 
{
    private String producto;
    private int cantidad;

    public DtoReporte(String producto, int cantidad) 
    {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getProducto() 
    {
        return producto;
    }

    public int getCantidad() 
    {
        return cantidad;
    }  
}
