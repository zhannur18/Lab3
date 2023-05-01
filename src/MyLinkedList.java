import java.util.NoSuchElementException;

public abstract class MyLinkedList<E extends Comparable<E>> implements MyList<E> {
    private E first;

    public E getFirst() {
        return first;
    }

    private class Node {
        E element;
        Node next;
        Node prev;

        Node(E e) {
            element = e;
            Node n;
            n = null;
            next = n;
            prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public void add(E item) {
        add(item, size);
    }

    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = new Node(item);
            if (tail == null) {
                tail = head;
            } else {
                head.next.prev = head;
            }
        } else if (index == size) {
            tail = new Node(item);
            tail.prev.next = tail;
        } else {
            Node prevNode = getNode(index - 1);
            Node nextNode = prevNode.next;
            Node newNode = new Node(item);
            prevNode.next = newNode;
            nextNode.prev = newNode;
        }

        size++;
    }

    public boolean remove(E item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public E remove(int index) {
        Node node = getNode(index);
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }

        size--;
        return node.element;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node n = head; n != null; n = n.next) {
                if (n.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node n = head; n != null; n = n.next) {
                if (o.equals(n.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o == null) {
            for (Node n = tail; n != null; n = n.prev) {
                if (n.element == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (Node n = tail; n != null; n = n.prev) {
                if (o.equals(n.element)) {
                    return index;
                }
                index--;
            }
        }
        return -1;
    }

    public void sort() { // sorting the linked list using the bubble sort and changing the data itself
        int n = 0; // double-checking the size of the array
        Node currentNode = this.head;
        while(currentNode != null){
            n++;
            currentNode = currentNode.next;
        }

        for(int i = 0; i < n; i++){
            currentNode = this.head;
            while(currentNode.next != null){
                E data1 = (E)currentNode.element;
                E data2 = (E)currentNode.next.element;

                if(data1.compareTo(data2) > 0){
                    currentNode.next.element = data1;
                    currentNode.element = data2;
                }
                currentNode = currentNode.next;
            }
        }
    }
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }
    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E removedData = head.element;
        head = head.next;
        size--;
        return removedData;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(E element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }
    }

