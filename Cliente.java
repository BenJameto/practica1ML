import java.util.List;
import java.util.ArrayList;
// Cliente
class Cliente implements Observador {
    private final String nombre;
    public final List<String> serviciosContratados;
    private double dineroDisponible;

    public Cliente(String nombre, double dineroDisponible) {
        this.nombre = nombre;
        this.serviciosContratados = new ArrayList<>();
        this.dineroDisponible = dineroDisponible;
    }

    public void contratarServicio(String servicio, CobroStrategy cobroStrategy) {
        serviciosContratados.add(servicio);
        System.out.println("Bienvenido " + nombre + " al servicio de " + servicio);
    }

    public void cancelarServicio(String servicio) {
        serviciosContratados.remove(servicio);
        System.out.println("Lamentamos que dejes el servicio " + nombre);
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }

    public String getNombre() {
        return nombre;
    }

    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
}