
import java.util.List;
import java.util.ArrayList;
class SistemaCobro {
    private final List<Cliente> clientes;

    public SistemaCobro() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cobrarServicios(double mes) {
        List<Cliente> clientesCopia = new ArrayList<>(clientes); // Copia de la lista original
        for (Cliente cliente : clientesCopia) {
            for (String servicio : cliente.serviciosContratados) {
                double costo = obtenerCosto(servicio, mes);
                if (cliente.getDineroDisponible() >= costo) {
                    cliente.setDineroDisponible(cliente.getDineroDisponible() - costo);
                    cliente.update(cliente.getNombre() + " paga $" + costo + " por el servicio de " + servicio);
                } else {
                    cliente.update("No se puede cobrar el servicio " + servicio + " a " + cliente.getNombre() + " por falta de fondos.");
                    cliente.cancelarServicio(servicio);
                }
            }
        }
    }

    private double obtenerCosto(String servicio, double mesesContratados) {
        switch (servicio) {
            case "Memeflix":
                return new MemeflixCobro().cobrar(mesesContratados);
            case "Momazon":
                return new MomazonCobro(false).cobrar(mesesContratados);
            case "Momazon Premium":
                return new MomazonCobro(true).cobrar(mesesContratados);
            case "Spootify":
                return new SpootifyCobro(false).cobrar(mesesContratados);
            case "Spootify Premium":
                return new SpootifyCobro(true).cobrar(mesesContratados);
            case "Thisney+":
                return new ThisneyCobro().cobrar(mesesContratados);
            case "HVO Max":
                return new HvoMaxCobro().cobrar(mesesContratados);
            default:
                return 0;
        }
    }
}