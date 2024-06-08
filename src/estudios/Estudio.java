package estudios;

public abstract class Estudio {
    private EstadoEstudio estado;

    enum EstadoEstudio {
        PENDIENTE, REALIZADO
    }

    public Estudio() {
        this.estado = EstadoEstudio.PENDIENTE;
    }

    public void setRealizado() {
        this.estado = EstadoEstudio.REALIZADO;
    }

    public boolean estaRealizado() {
        return this.estado == EstadoEstudio.REALIZADO;
    }

    public EstadoEstudio getEstado() {
        return this.estado;
    }

    @Override
    public abstract String toString();
}
