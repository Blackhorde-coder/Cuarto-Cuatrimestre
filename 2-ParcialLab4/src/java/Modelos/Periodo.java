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
public class Periodo 
{
    private int idperiodo;
    private String detalle;

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Periodo(int idperiodo, String detalle) {
        this.idperiodo = idperiodo;
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Periodo{" + "idperiodo=" + idperiodo + ", detalle=" + detalle + '}';
    }
    
    
    
}
