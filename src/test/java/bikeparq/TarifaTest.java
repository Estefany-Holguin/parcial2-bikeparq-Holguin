package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TarifaTest {

    @Test
    @DisplayName("Esvalido: carro permanece 60 minutos y paga 3000")
    void testCp01EsValido() {
        assertEquals(3000, Tarifa.calcularTarifa(60, "carro"));
    }

    @Test
    @DisplayName("EsLimite: moto permanece 10 minutos de gracia y paga 0")
    void testCp02EsLimite() {
        assertEquals(0, Tarifa.calcularTarifa(10, "moto"));
    }

    @Test
    @DisplayName("Es invalido: tipo bicicleta no permitido")
    void testCp03EsInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(60, "bicicleta"));
    }
}
