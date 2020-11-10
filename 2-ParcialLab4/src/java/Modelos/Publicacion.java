/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Publicacion 
{
    private int idPublicacion;
    private int idActividad;
    private String texto;
    private String fecha;
    private boolean habilitado;

    public Publicacion(int idPublicacion, int idActividad, String texto, String fecha, boolean habilitado) {
        this.idPublicacion = idPublicacion;
        this.idActividad = idActividad;
        this.texto = texto;
        this.fecha = fecha;
        this.habilitado = habilitado;
    }

    public Publicacion() {
    }
    

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "idPublicacion=" + idPublicacion + ", idActividad=" + idActividad + ", texto=" + texto + ", fecha=" + fecha + ", habilitado=" + habilitado + '}';
    }
    
    
    
}
