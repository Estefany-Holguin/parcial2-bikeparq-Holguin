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

    @Test
    @DisplayName("Minutos negativos fuera de rango debe lanzar error")
    void testMinutosNegativosLanzaError() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(-1, "carro"));
    }

    @Test
    @DisplayName("Minutos mayores a 1440 fuera de rango debe lanzar error")
    void testMinutosMayoresA1440LanzaError() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(1441, "carro"));
    }

    @Test
    @DisplayName("Aplica tope diario cuando el cálculo lo supera")
    void testAplicaTopeDiario() {
        assertEquals(25_000, Tarifa.calcularTarifa(1000, "carro"));
    }
}
