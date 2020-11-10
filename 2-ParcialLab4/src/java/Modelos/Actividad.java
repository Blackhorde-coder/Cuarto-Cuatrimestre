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
public class Actividad 
{
    private int idActividad;
    private String detalle;
    private double costo;
    private boolean habilitado;

    public Actividad(int idActividad, String detalle, double costo, boolean habilitado) {
        this.idActividad = idActividad;
        this.detalle = detalle;
        this.costo = costo;
        this.habilitado = habilitado;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", detalle=" + detalle + ", costo=" + costo + ", habilitado=" + habilitado + '}';
    }
    
    
    
}
