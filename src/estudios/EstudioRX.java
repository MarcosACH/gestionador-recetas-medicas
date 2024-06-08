package estudios;

public class EstudioRX extends Estudio {
    private String descripcion;

    public EstudioRX(String descripcion) {
        super();
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "RX: Estudio de imagen RX de " + this.descripcion + " (" + getEstado() + ")";
    }
}