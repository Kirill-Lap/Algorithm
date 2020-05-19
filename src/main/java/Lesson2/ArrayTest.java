package Lesson2;

import java.util.Random;

public class ArrayTest {

    public static void main(String[] args) {


//        simpleTest();
//        sortTest();
        hardTest();

    }


    private static void hardTest() {
        int size = 100000;
        SortableArrayImpl<Integer> data1 = new SortableArrayImpl<>(size);
        SortableArrayImpl<Integer> data2 = new SortableArrayImpl<>(size);
        SortableArrayImpl<Integer> data3 = new SortableArrayImpl<>(size);
        Random random = new Random();
        int val;

        for (int i = 0; i < size/2; i++) {
            val = random.nextInt(size);
            data1.add(val);
            data2.add(val);
            data3.add(val);
        }

        data1.display();
        long timeStamp = System.currentTimeMillis();
        data1.sortInsert();
        System.out.println(System.currentTimeMillis()-timeStamp);
        data1.display();

        timeStamp = System.currentTimeMillis();
        data2.sortBubble();
        System.out.println(System.currentTimeMillis()-timeStamp);
        data2.display();

        timeStamp = System.currentTimeMillis();
        data3.sortSelect();
        System.out.println(System.currentTimeMillis()-timeStamp);
        data3.display();
    }

    private static void sortTest() {
        SortableArrayImpl<Integer> data = new SortableArrayImpl<>();
        data.add(7);
        data.add(2);
        data.add(5);
        data.add(1);
        data.add(4);
        data.add(6);
        data.display();

//        data.sortBubble();
//        data.sortSelect();
        data.sortInsert();
        data.display();
    }

    private static void simpleTest() {
        Array<Integer> data = new ArrayImpl<>();
        data.add(6);
        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);
        data.display();

//        data.remove(2);
        data.remove(Integer.valueOf(3));
        data.display();
    }
}
