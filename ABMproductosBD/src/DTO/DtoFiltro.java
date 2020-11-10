
package DTO;


public class DtoFiltro 
{
    private String cliente;
    private String producto;
    private Double importeTotal;

    public DtoFiltro(String cliente, String producto, Double importeTotal) {
        this.cliente = cliente;
        this.producto = producto;
        this.importeTotal = importeTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }
    
    
}
