import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyLinkedListStack<E extends Comparable<E>> {
    private MyLinkedList<E> list;

    public MyLinkedListStack() {
        list = new MyLinkedList<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public void addAll(MyList O) {

            }
        };
    }

    public void push(E element) {
        list.addFirst(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}