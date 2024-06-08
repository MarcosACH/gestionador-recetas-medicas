import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import estudios.Estudio;

public class Hospital {
    private String nombre;
    private List<Profesional> profesionales;
    private List<Paciente> pacientes;
    private List<Receta> recetas;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.profesionales = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.recetas = new ArrayList<>();
    }

    public Profesional registrarProfesional(String nombre, int matricula) {
        Profesional nuevo = new Profesional(nombre, matricula);
        int indice = profesionales.indexOf(nuevo);

        if (indice != -1) {
            return profesionales.get(indice);
        } else {
            profesionales.add(nuevo);
            return nuevo;
        }
    }

    public Paciente registrarPaciente(String nombre, int dni) {
        Paciente nuevo = new Paciente(nombre, dni);
        int indice = pacientes.indexOf(nuevo);

        if (indice != -1) {
            return pacientes.get(indice);
        } else {
            pacientes.add(nuevo);
            return nuevo;
        }
    }

    public Receta cargarReceta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        if (!profesionales.contains(profesional)) {
            throw new IllegalArgumentException(profesional + " no es profesional del hospital.");
        }
        if (!pacientes.contains(paciente)) {
            throw new IllegalArgumentException(paciente + " no es paciente del hospital.");
        }

        Receta nueva = new Receta(profesional, paciente, estudios);
        recetas.add(nueva);
        return nueva;
    }

    public void procesar(Receta receta) {
        if (receta.estaProcesada()) {
            throw new IllegalArgumentException("La receta ya está procesada.");
        }
        if (!recetas.contains(receta)) {
            throw new IllegalArgumentException("Esta receta no esta cargada.");
        }

        receta.setProcesada();
    }

    public void mostrarRecetas() {
        String salida = "Recetas de " + nombre + ":";
        for (Receta receta : recetas) {
            salida += "\n" + receta;
        }

        System.out.println(salida);
    }

    public void mostrarRecetasProcesadas() {
        String salida = "Recetas procesadas de " + nombre + ":";
        for (Receta receta : recetas) {
            if (receta.estaProcesada()) {
                salida += "\n" + receta;
            }
        }

        System.out.println(salida);
    }

    public void mostrarPacientesConEstudios(int estudios) {
        String salida = "Pacientes con al menos " + estudios + " estudios realizados en " + nombre + ":";
        Map<Paciente, Integer> contador = new HashMap<>();

        for (Receta receta : recetas) {
            if (receta.estaProcesada()) {
                if (contador.containsKey(receta.getPaciente())) {
                    contador.put(receta.getPaciente(),
                            contador.get(receta.getPaciente()) + receta.getEstudios().length);
                } else {
                    contador.put(receta.getPaciente(), receta.getEstudios().length);
                }
            }
        }

        for (Map.Entry<Paciente, Integer> entry : contador.entrySet()) {
            if (entry.getValue() >= estudios) {
                salida += "\n" + entry.getKey();
            }
        }

        System.out.println(salida);
    }
}
