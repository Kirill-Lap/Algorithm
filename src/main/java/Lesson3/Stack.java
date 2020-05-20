package Lesson3;

public interface Stack<E> {

    void push(E value); //мы не делаем проверку на случай полного стека?

    E pop();

    E peek();

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

    boolean isFull();

}
