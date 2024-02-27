import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack_ArrayList<T> implements IStack<T> {
    private ArrayList<T> arrayList;

    public Stack_ArrayList() {
        arrayList = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        arrayList.add(item);
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return arrayList.remove(arrayList.size() - 1);
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return arrayList.get(arrayList.size() - 1);
    }

    @Override
    public boolean empty() {
        return arrayList.isEmpty();
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}