package struktur;

public class ArrayDinamis<T> implements StrukturData<T> {
    private Object[] data;
    private int size;

    public ArrayDinamis() {
        data = new Object[4];   // capacity awal 4
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("item tidak boleh null");
        if (size == data.length) resize();
        data[size] = item;
        size++;
    }

    private void resize() {
        Object[] baru = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            baru[i] = data[i];
        }
        data = baru;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        return (T) data[index];
    }

    // sisanya menyusul di langkah berikutnya
    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        T dihapus = (T) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return dihapus;
    }
    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public void validateInvariant() {
        if (size < 0 || size > data.length) {
            throw new IllegalStateException("size di luar 0..capacity: " + size);
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                throw new IllegalStateException("ada null di indeks " + i);
            }
        }
        for (int i = size; i < data.length; i++) {
            if (data[i] != null) {
                throw new IllegalStateException("sel sisa tidak null di indeks " + i);
            }
        }
    }
}