package linkedList;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        //создаем пустой список
        LinkedList list = new LinkedList();
        // создаем список на основе одного элемента
        LinkedList list2 = new LinkedList(1);
        // создаем список на основе массива элементов
        LinkedList list3 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6, 8});
        // создаем список на основе ранее созданого элемента списка
        LinkedList list4 = new LinkedList(list3);
        // Print the LinkedList
        list3.insert(new int[]{34, 34, 45, 56, 67, 78}, 2);
        list3.insert(list2);
        list3.insert(list2, 2);

        list3.remove(4);

        list.printList();
        System.out.println();
        list2.printList();
        System.out.println();
        list3.printList();
        System.out.println();
        list4.printList();
    }
}

class LinkedList {
    Node head;

    // конструкторы
    LinkedList() {
    }

    LinkedList(int value) {
        this.insert(value);
    }

    LinkedList(int[] values) {
        for (int value : values
        ) {
            this.insert(value);
        }
    }

    LinkedList(LinkedList list) {
        this.head = list.head;
    }

    public void printList() {
        Node currNode = this.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.getNext();
        }
    }

    public void insert(int data) {
        Node new_node = new Node(data);
        new_node.setNext(null);
        nodeListInsertion(new_node);
    }

    public void insert(int[] data) {
        for (int d : data
        ) {
            Node new_node = new Node(d);
            new_node.setNext(null);
            nodeListInsertion(new_node);
        }

    }

    public void insert(LinkedList list) {
        Node current = list.head;
        for (int i = 0; i < list.getSize(); i++) {
            this.nodeListInsertion(current);
            current = current.getNext();
        }
    }

    public void insert(LinkedList list, int index) {
        Node current = head;
        for (int j = 0; j < list.getSize(); j++) {
            this.insert(current.data, index);
            current = current.getNext();
            index++;
        }
    }

    public void insert(int data, int index) {
        Node temp = new Node(data);
        Node current = head;
        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }
        temp.setNext(Objects.requireNonNull(current).getNext());
        current.setNext(temp);
    }

    public void insert(int[] data, int index) {
        for (int d : data
        ) {
            Node temp = new Node(d);
            Node current = head;
            if (current != null) {
                for (int i = 0; i < index && current.getNext() != null; i++) {
                    current = current.getNext();
                }
            }
            temp.setNext(Objects.requireNonNull(current).getNext());
            current.setNext(temp);
            index++;
        }
    }

    private void nodeListInsertion(Node new_node) {
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = this.head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            // Insert the new_node at last node
            last.setNext(new_node);
        }
    }

    public boolean remove(int index) {
        Node current = this.head;
        if (this.head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            return true;
        }
        return false;
    }

    public int getSize() {
        Node temp = new Node();
        int size = 1;
        Node current = this.head;
        while (current.getNext() != null) {
            size++;
            temp.setNext(Objects.requireNonNull(current).getNext());
            current.setNext(temp);
        }
        return size;
    }
}

class Node {
    int data;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    Node() {
    }

    Node(int d) {
        data = d;
    }
}