package HW2;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node head; // головной/первый элемент списка
    private int size; // размер списка

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // вставка элемента в начало списка
    public void addFirst(int value) {
        head = new Node(value, head);
        size++;
    }

    // вставка элемента в конец списка
    public void addLast(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }

        size++;
    }

    // вставка элемента по указанному индексу
    public void add(int value, int index) {
        if (index < 0 || index > size)   {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node current = head;

            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }

            Node newNode = new Node(value, current.getNext());
            current.setNext(newNode);
            size++;
        }
    }

    // удаление первого элемента из списка
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        head = head.getNext();

    }

    // удаление последнего элемента из списка
    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head.getNext() == null) {
            head = null;
        } else {
            Node current = head;

            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }

            current.setNext(null);
        }

    }

    // удаление элемента по указанному индексу
    public void remove(int index) {
        if (index < 0|| index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;

            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }

            current.setNext(current.getNext().getNext());

        }
    }

    // получение элемента по указанному индексу
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    // размер списка
    public int size() {
        return size;
    }

    // вывод всего списка на экран
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next  = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next  = next;
        }
    }
}