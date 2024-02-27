import java.util.Vector;
import java.util.NoSuchElementException;

public class Stack_Vector<T> implements IStack<T> {
    private Vector<T> vector;

    public Stack_Vector() {
        vector = new Vector<>();
    }

    @Override
    public void push(T item) {
        vector.add(item);
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return vector.get(vector.size() - 1);
    }

    @Override
    public boolean empty() {
        return vector.isEmpty();
    }

    @Override
    public int size() {
        return vector.size();
    }
}