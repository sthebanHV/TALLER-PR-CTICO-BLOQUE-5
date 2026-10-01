import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante(
                "10023", "Ana Gómez", "ana.gomez@correo.com",
                "EST-9988", "Ingeniería de Sistemas");
        Libro libro = new Libro("978-3-16-148410-0", "Patrones de Diseño en Java");
        Ejemplar ejemplar = new Ejemplar("EJE-01", libro);

        Prestamo prestamo =
                new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 10));

        System.out.println("--- PRUEBA 1: Renovación Válida ---");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 20));
            estudiante.notificar("Su préstamo fue renovado con éxito.");
            System.out.println("Nueva fecha de devolución: "
                    + prestamo.getFechaPrevistaDevolucion());
            System.out.println("Cantidad total de renovaciones: "
                    + prestamo.getCantidadRenovaciones());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- PRUEBA 2: Renovación Inválida ---");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 15));
        } catch (IllegalArgumentException e) {
            System.out.println("[Excepción controlada correctamente]: " + e.getMessage());
        }
    }
}
