
package Modelo;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class Curso 
{
    private int idCurso;
    private String nombreCurso;
    private String turno;
    private int cupoMaximo;

    public Curso(int idCurso, String nombreCurso, String turno, int cupoMaximo) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.turno = turno;
        this.cupoMaximo = cupoMaximo;
    }

    public Curso() 
    {
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getTurno() {
        return turno;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    @Override
    public String toString() 
    {
        return nombreCurso+" turno "+turno;
    }
    
    
    
    
}
