// Estrategia de cobro para Momazon
class MomazonCobro implements CobroStrategy {
    private final boolean premium;

    public MomazonCobro(boolean premium) {
        this.premium = premium;
    }

    @Override
    public double cobrar(double mesesContratados) {
        return premium ? 150 * mesesContratados : 110 * mesesContratados;
    }
}