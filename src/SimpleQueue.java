import java.util.NoSuchElementException;

public class SimpleQueue {

    String[] array;
    private int size;
    private int capacity;

    public SimpleQueue(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException();
        }

        array = new String[capacity];
        size = 0;
    }

    public boolean add(String s) {
        if(s == null) {
            throw new NullPointerException();
        }

        if(array.length == size) {
            throw new IllegalStateException("Queue full");
        }

        else {
            array[size++] = s;
            return true;
        }
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
    }

    public boolean contains(String s) {
        for(int i = 0; i < size; i++) {
            if(array[i] == s) {
                return true;
            }
        }

        return false;
    }

    public String element() {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        return array[0];
    }

    public boolean offer(String s) {
        if(size == array.length) {
            return false;
        }

        if(s == null) {
            throw new NullPointerException();
        }

        add(s);
        return true;
    }

    public String peek() {
        return array[0];
    }

    public String poll() {
        try {
            return remove();
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    public int remainingCapacity() {
        return array.length - size;
    }

    public String remove() {
        return remove(0);
    }

    public String remove(int index) {
        if(index >= size) {
            throw new NoSuchElementException();
        }

        String output = array[index];
        for(int i = index; i < size - 1; i ++) {
            array[i] = array[i + 1];
        }

        array[--size] = null;

        return output;
    }

    public boolean remove(String s) {
        int index;
        for(int i = 0; i < size; i++) {
            if(array[i] == s) {
                index = i;
                remove(index);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String startString = "[";
        for(int i = 0; i < size-1; i++) {
            startString = startString + array[i];
            startString = startString + ", ";
        }

        if(size != 0) {
            startString = startString + array[size - 1];
        }

        startString = startString + "]";
        return startString;
    }
}