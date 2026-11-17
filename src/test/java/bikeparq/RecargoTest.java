package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecargoTest {

    @Test
    @DisplayName("R1: Aplica recargo de 2000 en horario nocturno")
    void testRecargoNocturno() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 22));
    }

    @Test
    @DisplayName("R1: Aplica recargo en horario de madrugada")
    void testRecargoMadrugada() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 5));
    }

    @Test
    @DisplayName("R2: Horario diurno mantiene la misma tarifa")
    void testHorarioDiurnoSinRecargo() {
        assertEquals(3000, Recargo.aplicarRecargoNocturno(3000, 10));
    }

    @Test
    @DisplayName("R3: Tarifa 0 en tiempo de gracia no tiene recargo de noche")
    void testTarifaCeroSinRecargo() {
        assertEquals(0, Recargo.aplicarRecargoNocturno(0, 23));
    }

    @Test
    @DisplayName("R4: Hora 24 fuera de rango debe lanzar error")
    void testHoraInvalidaLanzaError() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, 24));
    }

    @Test
    @DisplayName("R4: Hora negativa fuera de rango debe lanzar error")
    void testHoraNegativaLanzaError() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, -1));
    }
}
