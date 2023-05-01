public class Main {
    public static void main(String[] args) {
        MyLinkedListQueue que = new MyLinkedListQueue();
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(7);
        que.enqueue(9);
        que.dequeue();
        que.dequeue();
        que.dequeue();
        que.dequeue();

    }
}