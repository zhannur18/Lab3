import java.util.EmptyStackException;

public class MyArrayListStack<E extends Comparable<E>> {
    private MyArrayList<E> list;

    public MyArrayListStack() {
        list = new MyArrayList<>();
    }

    public void push(E element) {
        list.add(0);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) list.remove(0);
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
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