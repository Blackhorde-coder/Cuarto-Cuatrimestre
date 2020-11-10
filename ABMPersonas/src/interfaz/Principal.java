package interfaz;

import gestores.GestorPersonas;
import java.util.ArrayList;
import modelo.EstadoCivil;
import modelo.Persona;

public class Principal {

    public static void main(String[] args) {

        GestorPersonas gestor = new  GestorPersonas();
        
        ArrayList<EstadoCivil> listaEC = gestor.obtenerEstadosCiviles();
        
        for (EstadoCivil estadoCivil : listaEC) {
            System.out.println(estadoCivil);
        }

        ArrayList<Persona> listaPer = gestor.obtenerTodos();
        
        for (Persona persona : listaPer) {
            System.out.println(persona);
        }
    }
    
}
