package Lesson3;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_SIZE = 4;
    private E[] data;
    private int size;
    private int tailPointer;
    private int headPointer;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.size = 0;
        data = (E[]) new Object[maxSize];
        tailPointer = -1;
        headPointer = 0;
    }

    @SuppressWarnings("unchecked")
    public QueueImpl() {
        this.size = 0;
        data = (E[]) new Object[DEFAULT_SIZE];
        tailPointer = -1;
        headPointer = 0;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        incrementTailPointer();
        data[tailPointer] = value;

        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = data[headPointer];
        incrementHeadPointer();
        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[headPointer];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    private void incrementTailPointer() {
        tailPointer = tailPointer == data.length-1 ? 0 : tailPointer+1;
    }

    private void incrementHeadPointer() {
        headPointer = headPointer == data.length-1 ? 0 : headPointer+1;
    }

}
