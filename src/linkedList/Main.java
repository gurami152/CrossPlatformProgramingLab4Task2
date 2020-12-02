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
        list3.insert(new int[]{34, -34, 45, -56, -67, 78}, 7);
        list3.insert(list2);
        list.insert(list2);
        list3.insert(list2, 2);

        list3.removeLast();
        list3.removeByKey(new int[]{8,34});

        list.printList();
        System.out.println();
        list2.printList();
        System.out.println();
        list3.printList();
        System.out.println();
        list3.go();
        list3.minimum();
        list3.maximum();
        System.out.println();
        list4.printList();
        LinkedList list5 = new LinkedList(list3.parametr());
        System.out.println();
        list5.printList();
    }
}

class LinkedList {
    Node head;

    // конструкторы
    LinkedList() {
        this.head=null;
    }

    LinkedList(int value) {
        this.insert(value);
    }

    LinkedList(int[] values) {
        Node[] nodes = new Node[values.length];
        int index = 0;

        for (int value : values
        ) {
            nodes[index] = new Node();
            nodes[index].data = value;
            if(index == values.length-1){
                nodes[index].setNext(null);
            } else {
                nodes[index].setNext(nodes[index+1]);
            }
            this.insert(nodes[index]);
            index++;

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

    public void insert(Node node) {
        nodeListInsertion(node);
    }
    public void insert(int[] data) {
        for (int d : data
        ) {
            Node new_node = new Node(d);
            new_node.setNext(new Node());
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

    public boolean remove() {
        int index =0;
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

    public void removeLast() {
        int index = this.getSize();
        Node current = this.head;
        if (this.head != null) {
            for (int i = 0; i < index-1 ; i++) {
                if (i == index-2){
                    current.setNext(null);
                }
                else {
                    current = current.getNext();
                }
            }
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

    public void removeByKey(int key) {
        Node current = this.head;
        if (current.data == key)
            current.setNext(current.getNext().getNext());
        current = current.getNext();
        for (int i = 0; i < this.getSize()-1; i++) {
            if (current.getNext().data == key)
                current.setNext(current.getNext().getNext());
            current = current.getNext();
        }
    }

    public void removeByKey(int[] key) {
        for (int k: key
        ) { Node current = this.head;
            for (int i = 0; i < this.getSize()-1; i++) {
                if (current.getNext().data == k)
                    current.setNext(current.getNext().getNext());
                current = current.getNext();
            }
        }
    }

    public boolean remove(int index, int list) {
        Node current = this.head;
        Node temp = this.head;
        if (this.head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;
                current = current.getNext();
            }
            for(int i =0; i<index +list;i++){
                temp = temp.getNext();
            }
            current.setNext(temp.getNext());
            return true;
        }
        return false;
    }

    public int getSize() {
        int size = 1;
        Node current = this.head;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void go(){
        Node current = this.head;
        for(int i=0;i<this.getSize();i++){
            System.out.println(current.data);
            current = current.getNext();
        }
    }

    public void minimum() {
        Node current = this.head;
        int min = current.data;
        for(int i=0;i<this.getSize();i++){
            if(current.data<min){
                min = current.data;
            }
            current = current.getNext();
        }
        System.out.println("Minimum "+ min);
    }

    public void maximum() {
        Node current = this.head;
        int max = current.data;
        for(int i=0;i<this.getSize();i++){
            if(current.data>max){
                max = current.data;
            }
            current = current.getNext();
        }
        System.out.println("Maximum "+ max);
    }

    public LinkedList parametr() {
        Node current = this.head;
        int size=0;
        for(int i=0;i<this.getSize();i++){
            if(current.data>0){
               size++;
            }
            current = current.getNext();
        }
        int[] array;
        array = new int[size];
        int index = 0;
        current = this.head;
        for(int i=0;i<getSize();i++){
            if(current.data>0){
                array[index] = current.data;
                index++;
            }
            current = current.getNext();
        }
        LinkedList list = new LinkedList(array);
        return list;
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
        next = new Node();
    }
}