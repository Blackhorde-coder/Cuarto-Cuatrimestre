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
public class Pago 
{
    private int idpago;
    private int documento;
    private double total;
    private String fecha;
    private int idperiodo;
    private int idformapago;

    public Pago(int idpago, int documento, double total, String fecha, int idperiodo, int idformapago) {
        this.idpago = idpago;
        this.documento = documento;
        this.total = total;
        this.fecha = fecha;
        this.idperiodo = idperiodo;
        this.idformapago = idformapago;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    public int getIdformapago() {
        return idformapago;
    }

    public void setIdformapago(int idformapago) {
        this.idformapago = idformapago;
    }

    @Override
    public String toString() {
        return "Pago{" + "idpago=" + idpago + ", documento=" + documento + ", total=" + total + ", fecha=" + fecha + ", idperiodo=" + idperiodo + ", idformapago=" + idformapago + '}';
    }
    
    
    
}
