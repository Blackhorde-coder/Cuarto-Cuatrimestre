package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Responsable 
{
    private int idResponsable;
    private String nombre;

    public Responsable() {
    }

    public Responsable(int idResponsable, String nombre) 
    {
        this.idResponsable = idResponsable;
        this.nombre = nombre;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public String toString() 
    {
        return nombre;
    }
    
    
    
}
