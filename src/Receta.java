import estudios.Estudio;

public class Receta {
    enum EstadoReceta {
        CARGADA, PROCESADA
    }

    private int id;
    private static int ultimoId = 1;
    private EstadoReceta estado;
    private Profesional profesional;
    private Paciente paciente;
    private Estudio[] estudios;

    private static int getUltimoId() {
        int actual = ultimoId;
        ultimoId++;
        return actual;
    }

    public Receta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        this.id = getUltimoId();
        this.estado = EstadoReceta.CARGADA;
        this.profesional = profesional;
        this.paciente = paciente;
        this.estudios = estudios;
    }

    public void setProcesada() {
        if (this.estado != EstadoReceta.PROCESADA) {
            this.estado = EstadoReceta.PROCESADA;
            for (Estudio estudio : estudios) {
                estudio.setRealizado();
            }
        }

        for (Estudio estudio : estudios) {
            System.out.println("Notificando a paciente " + paciente + " sobre " + estudio);
            System.out.println("Notificando a profesional " + profesional + " sobre " + estudio);
        }
    }

    public boolean estaProcesada() {
        return this.estado == EstadoReceta.PROCESADA;
    }

    public Estudio[] getEstudios() {
        return estudios;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        String salida = "Receta " + id + ":";
        salida += "\n- Profesional: " + profesional;
        salida += "\n- Paciente: " + paciente;
        salida += "\n- Estado: " + estado;
        salida += "\n- Estudios:";

        for (Estudio estudio : estudios) {
            salida += "\n - " + estudio;
        }

        return salida;
    }
}
