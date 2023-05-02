import java.util.Arrays;
public abstract class MyArrayList  <T extends Comparable<T>> implements MyList {
    int size = 0;
    int[] arr;

    public MyArrayList() {
        arr = new int[5];
    }


    @Override
    public int size() { //Returns the number of elements in the array
        return size;
    }

    @Override
    public boolean contains(Object o) {//It determines if a specific item is present in the arrayList.
        for (int i = 0; i < size; i++) {//Returns  if the array contains the specified element
            if (arr[i] == (int) o) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void add(Object item) {// adding a particular item to an index
        arr[size] = (int) item;//Adds the specified element  to the end of the array
        size = size + 1;
    }

    @Override
    public void add(Object item, int index) {//Inserts the specified element  at the specified  in the array
        if (arr.length == size) {
            increasebuffer();
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = (int) item;
        size++;
    }

    public void increasebuffer() {// It is a function that increases
        int[] temp = new int[size + 5];// Increases the size of the array by creating a new array with 5 more elements and copying the old elements into it
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public boolean remove(Object item) {//Removes the first occurrence of the specified element  from the array, if it exists.
        for (int i = 0; i < size; i++) {
            if ((int) item == arr[i]) {
                remove(i);
                size--;
                return true;
            }

        }
        return false;
    }

    @Override
    public Object remove(int index) {// this procedure moves each element by one, overwriting the element to be deleted.
        int temp = arr[index];//Removes the element at the specified  from the array, shifting the elements after  to the left by one position
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
        size--;
        return temp;
    }

}


    //boolean empty() – Returns whether the stack is empty

        //int size() – Returns the size of the stack

        //peek() – Returns a reference to the topmost element of the stack
        //push(T) – Adds the element at the top of the stack
        //pop() – Retrieves and deletes the topmost element of the stack
