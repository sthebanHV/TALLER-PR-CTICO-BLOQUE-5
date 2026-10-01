import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        if (nuevaFecha == null || !nuevaFecha.isAfter(this.fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                    "Error: La nueva fecha de devolución debe ser posterior a la "
                            + "fecha prevista actual (" + this.fechaPrevistaDevolucion + ").");
        }

        LocalDate fechaAnterior = this.fechaPrevistaDevolucion;
        this.fechaPrevistaDevolucion = nuevaFecha;
        Renovacion nuevaRenovacion =
                new Renovacion(LocalDate.now(), fechaAnterior, nuevaFecha);
        this.renovaciones.add(nuevaRenovacion);
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public int getCantidadRenovaciones() {
        return renovaciones.size();
    }
}
