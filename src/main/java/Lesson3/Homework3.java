package Lesson3;

import java.util.function.Supplier;

public class Homework3 {
    public static void main(String[] args) {

        queueTest();


    }

    private static void queueTest() {
        Supplier<Queue<Integer>> constructor = QueueImpl<Integer>::new;

        Queue<Integer> data = createQueue(constructor);
//        Queue<Integer> data = new QueueImpl<>(5);

        System.out.println(data.insert(10));
        System.out.println(data.insert(11));
        System.out.println(data.insert(12));
        System.out.println(data.insert(13));
        System.out.println(data.insert(14));
        System.out.println(data.insert(15));

        System.out.println(data.peekFront());

        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data.remove());

        System.out.println(data.insert(16));
        System.out.println(data.insert(17));
        System.out.println(data.insert(18));
        System.out.println(data.insert(19));


        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data.remove());
    }

    private static Queue<Integer> createQueue(Supplier<Queue<Integer>> factory) {
        return factory.get();
    }
}
