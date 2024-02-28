import java.util.NoSuchElementException;

public interface IStack<T> {
    void push(T item);
    T pop() throws NoSuchElementException;
    T peek() throws NoSuchElementException;
    boolean empty();
    int size();
}