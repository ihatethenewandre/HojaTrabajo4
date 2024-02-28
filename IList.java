public interface IList<T> {
    void addFirst(T value);
    void addLast(T value);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();
    int size();
    boolean isEmpty();
}