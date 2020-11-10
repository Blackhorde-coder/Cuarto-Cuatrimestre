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
public class FormaPago 
{
    private int idformapago;
    private String detalle;

    public FormaPago(int idformapago, String detalle) {
        this.idformapago = idformapago;
        this.detalle = detalle;
    }

    public int getIdformapago() {
        return idformapago;
    }

    public void setIdformapago(int idformapago) {
        this.idformapago = idformapago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "FormaPago{" + "idformapago=" + idformapago + ", detalle=" + detalle + '}';
    }
    
    
    
}
