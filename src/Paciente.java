
public class Paciente {
    private String nombre;
    private int dni;

    public Paciente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + " [" + dni + "]";
    }
}
