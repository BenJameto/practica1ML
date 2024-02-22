// Estrategia de cobro para HVO Max
class HvoMaxCobro implements CobroStrategy {
    @Override
    public double cobrar(double mesesContratados) {
        if (mesesContratados <= 3) {
            return 0;
        } else {
            return 140 * mesesContratados;
        }
    }
}