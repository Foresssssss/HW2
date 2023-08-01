package HW2;

class Node {
    // Значение ноды
    int value;
    // Следующая нода
    Node next = null;

    public Node(int value) {
        this.value = value;
    }
}

class LinkedList {
    // Первая нода в списке
    Node head;

    // Метод добавления элемента
    public void add(int value) {
        // Если список пуст, создаем первую ноду
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            // Ищем последнюю ноду в списке
            while (current.next != null) {
                current = current.next;
            }
            // Создаем новую ноду и привязываем ее к последней ноде в списке
            current.next = new Node(value);
        }
    }

    // Метод получения элемента по индексу
    public int get(int index) {
        Node current = head;
        int currentIndex = 0;
        // Ищем ноду с нужным индексом
        while (current != null) {
            if (currentIndex == index) {
                return current.value;
            }
            current = current.next;
            currentIndex++;
        }
        // Если индекс вне диапазона, выбрасываем исключение
        throw new IndexOutOfBoundsException();
    }

    // Метод удаления элемента по индексу
    public void remove(int index) {
        // Если удаляем первую ноду
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            int currentIndex = 0;
            // Ищем ноду перед удаляемой
            while (current != null) {
                if (currentIndex == index - 1) {
                    // Переставляем указатель с предыдущей ноды на ноду после удаляемой
                    // Таким образом, удаляем ноду из цепи списка
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
                currentIndex++;
            }
            // Если индекс вне диапазона, выбрасываем исключение
            throw new IndexOutOfBoundsException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5); // Добавляем элемент 5
        linkedList.add(10); // Добавляем элемент 10
        linkedList.add(15); // Добавляем элемент 15

        System.out.println(linkedList.get(0)); // Выведет: 5
        System.out.println(linkedList.get(1)); // Выведет: 10
        System.out.println(linkedList.get(2)); // Выведет: 15

        linkedList.remove(1); // Удаляем элемент с индексом 1

        System.out.println(linkedList.get(0)); // Выведет: 5
        System.out.println(linkedList.get(1)); // Выведет: 15
    }
}
