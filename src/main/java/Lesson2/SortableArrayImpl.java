package Lesson2;

public class SortableArrayImpl<E extends Object & Comparable<? super E>> extends ArrayImpl<E> {

    public SortableArrayImpl(int size) {
        super(size);
    }

    public SortableArrayImpl() {
        super();
    }


    public void sortBubble(){
        for (int j = 0; j < size - 1; j++) {
           boolean isChanged = false;
           for (int i = 0; i < size - j - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    switchItems(i, i + 1);
                    isChanged = true;
                }

            }
           if(!isChanged) break;
        }
    }

    public void sortSelect(){
        for (int i = 0; i < size - 1; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < size; j++) {
                if (data[minValueIndex].compareTo(data[j])>0) {
                    minValueIndex = j;
                }
            }
            if (i != minValueIndex) {
                switchItems(i, minValueIndex);
            }
        }
    }

    public void sortInsert(){
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int targetPos = i;
            for (int j = i-1; j >= 0 ; j--) {
                if (data[j].compareTo(temp) > 0) {
                    data[j+1] = data[j];
                    targetPos = j;
                } else {
                    break;
                }
            }
            if (targetPos != i) {
                data[targetPos] = temp;
            }
        }

    }


    private void switchItems(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
