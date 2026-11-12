package struktur;

public interface StrukturData<T> {
    void add(T item);
    T get(int index);
    T remove(int index);
    int size();
    boolean isEmpty();
    boolean contains(T item);
    void clear();
}