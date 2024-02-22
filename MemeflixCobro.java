class MemeflixCobro implements CobroStrategy {
    @Override
    public double cobrar(double mesesContratados) {
        if (mesesContratados <= 3) {
            return 120 * mesesContratados;
        } else if (mesesContratados <= 6) {
            return 170 * mesesContratados;
        } else {
            return 200 * mesesContratados;
        }
    }
}