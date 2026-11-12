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

    @Test
    void removeTengahMenggeserElemen() {
        ArrayDinamis<Integer> a = new ArrayDinamis<>();
        for (int i = 0; i < 5; i++) a.add(i);
        assertEquals(2, a.remove(2));
        assertEquals(4, a.size());
        assertEquals(3, a.get(2));
        a.validateInvariant();
    }

    @Test
    void removePertamaDanTerakhir() {
        ArrayDinamis<Integer> a = new ArrayDinamis<>();
        for (int i = 0; i < 5; i++) a.add(i);
        assertEquals(0, a.remove(0));
        assertEquals(4, a.remove(3));
        assertEquals(3, a.size());
        assertEquals(1, a.get(0));
        a.validateInvariant();
    }

    @Test
    void containsDanClear() {
        ArrayDinamis<Integer> a = new ArrayDinamis<>();
        a.add(10); a.add(20);
        assertTrue(a.contains(20));
        assertFalse(a.contains(99));
        a.clear();
        assertTrue(a.isEmpty());
        a.validateInvariant();
    }

    @Test
    void indeksTidakValidMelempar() {
        ArrayDinamis<Integer> a = new ArrayDinamis<>();
        a.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> a.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> a.get(-1));
    }
}