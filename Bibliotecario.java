public class Bibliotecario extends Usuario implements Notificable {
    private String codigoEmpleado;
    private String turno;

    public Bibliotecario(String identificacion, String nombre, String correo,
            String codigoEmpleado, String turno) {
        super(identificacion, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("[Notificación a Bibliotecario " + getNombre() + "]: " + mensaje);
    }
}
