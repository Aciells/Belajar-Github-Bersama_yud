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
    @Override public T remove(int index) { throw new UnsupportedOperationException(); }
    @Override public boolean contains(T item) { throw new UnsupportedOperationException(); }
    @Override public void clear() { throw new UnsupportedOperationException(); }
}