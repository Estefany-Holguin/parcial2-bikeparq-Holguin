package bikeparq;

public final class Recargo {

    private Recargo() {
    }

    public static int aplicarRecargoNocturno(int tarifa, int horaEntrada) {
        if ((horaEntrada >= 20 && horaEntrada <= 23) || (horaEntrada >= 0 && horaEntrada <= 5)) {
            return tarifa + 2000;
        }
        return tarifa;
    }
}
