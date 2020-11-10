
package Modelo;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Alumno 
{
    private int legajo;
    private String apeNom;
    private String tituloMedio;
    private int idCurso;

    public Alumno(int legajo, String apeNom, String tituloMedio, int idCurso) {
        this.legajo = legajo;
        this.apeNom = apeNom;
        this.tituloMedio = tituloMedio;
        this.idCurso = idCurso;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getApeNom() {
        return apeNom;
    }

    public String getTituloMedio() {
        return tituloMedio;
    }

    public int getIdCurso() {
        return idCurso;
    }
    
    
    
}
