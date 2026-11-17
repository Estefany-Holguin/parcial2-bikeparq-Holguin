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
    @DisplayName("R4: Hora 24 fuera de rango debe lanzar error")
    void testHoraInvalidaLanzaError() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, 24));
    }
}
