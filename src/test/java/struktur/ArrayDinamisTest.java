package struktur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayDinamisTest {
    @Test
    void addMelebihiCapacityTetapBenar() {
        ArrayDinamis<Integer> a = new ArrayDinamis<>();
        for (int i = 0; i < 10; i++) a.add(i);
        assertEquals(10, a.size());
        assertEquals(7, a.get(7));
    }
}