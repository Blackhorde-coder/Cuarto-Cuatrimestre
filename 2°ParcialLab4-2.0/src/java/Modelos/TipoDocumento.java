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
public class TipoDocumento 
{
    private int idtipodoc;
    private String detalle;

    public TipoDocumento(int idtipodoc, String detalle) {
        this.idtipodoc = idtipodoc;
        this.detalle = detalle;
    }

    public int getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(int idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return detalle;
    }
    
    
}
