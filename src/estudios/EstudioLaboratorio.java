package estudios;

public class EstudioLaboratorio extends Estudio {
    private int items;

    public EstudioLaboratorio(int items) {
        super();
        this.items = items;
    }

    @Override
    public String toString() {
        return "Laboratorio: Estudio de laboratorio (" + getEstado() + ")";
    }
}
