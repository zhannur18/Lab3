import java.util.NoSuchElementException;

public class MyArrayListQueue<E extends Comparable<E>> {
    private MyArrayList<E> list;

    public MyArrayListQueue() {
        list = new MyArrayList<>();
    }

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) list.remove(0);
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) list.get(0);
    }

    public boolean isEmpty(){
        if(list.size() == 0 || list.get(0) == null){
            return true;
        }else{
            return false;
        }
    }

    public int size() {
        return list.size();
    }
}