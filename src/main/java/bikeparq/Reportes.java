package bikeparq;

import java.util.List;

public final class Reportes {

    private static final String TIPO_CARRO = "carro";
    private static final String TIPO_MOTO = "moto";

    private Reportes() {
    }

    public static Resumen resumenDelDia(List<Registro> registros) {
        int totalCobrado = 0;
        int cantidadCarros = 0;
        int cantidadMotos = 0;

        for (Registro registro : registros) {
            if (TIPO_CARRO.equals(registro.tipo())) {
                cantidadCarros++;
                totalCobrado += registro.valor();
            } else if (TIPO_MOTO.equals(registro.tipo())) {
                cantidadMotos++;
                totalCobrado += registro.valor();
            }
        }

        return new Resumen(totalCobrado, cantidadCarros, cantidadMotos);
    }

    public static int mayorCobro(List<Registro> registros) {
        int cobroMaximo = 0;
        for (Registro registro : registros) {
            if (registro.valor() > cobroMaximo) {
                cobroMaximo = registro.valor();
            }
        }
        return cobroMaximo;
    }
}
