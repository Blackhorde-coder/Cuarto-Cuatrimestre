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
public class Socio 
{
    private String nombre;
    private String apellido;
    private int documento;
    private int tipodocumento;
    private String direccion;
    private int numero;
    private String localidad;
    private String telefono;
    private String email;
    private boolean habilitado;

    public Socio(String nombre, String apellido, int documento, int tipodocumento, String direccion, int numero, String localidad, String telefono, String email, boolean habilitado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.tipodocumento = tipodocumento;
        this.direccion = direccion;
        this.numero = numero;
        this.localidad = localidad;
        this.telefono = telefono;
        this.email = email;
        this.habilitado = habilitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    } 
}
