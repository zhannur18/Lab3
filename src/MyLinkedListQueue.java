import java.util.NoSuchElementException;

public class MyLinkedListQueue<E extends Comparable<E>> {
    private MyLinkedList<E> list;

    public MyLinkedListQueue() {
        list = new MyLinkedList<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public void addAll(MyList o) {
                for(int i = 0; i < o.size(); i++)
                    add((E) o.get(i));

            }
        };
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0 || list.get(0) == null;

    }

    public int size() {
        return list.size();
    }
}