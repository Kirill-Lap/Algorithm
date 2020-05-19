package Lesson2;

import java.util.Arrays;

public class ArrayImpl<E> implements Array<E> {

    protected static final int INITIAL_CAPACITY = 4;
    protected E[] data;
    protected int size;

    public ArrayImpl() {
        this(null, INITIAL_CAPACITY);
    }

    public ArrayImpl(E... data) {
        this(data, data.length);
    }

    public ArrayImpl(int initialCapacity) {
        this(null, initialCapacity);
    }

    @SuppressWarnings("unchecked")
    protected ArrayImpl (E[] data, int initialCapacity){
        this.data = data != null ? data : (E[]) new Object[initialCapacity];
        this.size = data != null ? data.length : 0;
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }


    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index < 0 ) return false;
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        try{
            checkIndex(index);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
        E removedItem = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return removedItem;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    protected void checkIndex(int index) {
        if (index<0 || index >size) {
            throw new IndexOutOfBoundsException(String.format("Invalid index %d for array with length %d", index, size));
        }
    }

    protected void checkAndGrow() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length*2);
        }
    }
}
