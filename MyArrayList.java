package HW2;


public class MyArrayList<E> {
    private E[] array;
    private int size;

    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public boolean add(E element) {
        if (size >= array.length) {
            E[] bigger = (E[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                bigger[i] = array[i];
            }
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        add(element);
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        E element = get(index);
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) == -1) return false;
        else return true;
    }

  //  public String toString() {
      //  String str = "[";
      //  for (int i = 0; i < size; i++) {
    //        str = str + array[i].toString() + ", ";
     //   }
     //   str = str + array[3]
}