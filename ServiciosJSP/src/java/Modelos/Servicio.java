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
public class Servicio 
{
    private int id;
    private String tipo;
    private String descripcion;
    private double costo;

    public Servicio(int id, String tipo, String descripcion, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }
    
    
    
}
