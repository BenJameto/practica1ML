// Estrategia de cobro para Spootify
class SpootifyCobro implements CobroStrategy {
    private final boolean premium;

    public SpootifyCobro(boolean premium) {
        this.premium = premium;
    }

    @Override
    public double cobrar(double mesesContratados) {
        return premium ? 80 * mesesContratados : 0;
    }
}