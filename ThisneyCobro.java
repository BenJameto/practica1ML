// Estrategia de cobro para Thisney+
class ThisneyCobro implements CobroStrategy {
    @Override
    public double cobrar(double mesesContratados) {
        if (mesesContratados <= 3) {
            return 130 * mesesContratados;
        } else {
            return 160 * mesesContratados;
        }
    }
}