package myLinkedList;

import java.util.Collections;

public class myLinkedList {
    private Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void add(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        Node temp = head;
        Node previous = null;
        if (head.next == null) {
            deleteFirst();
        }
        while (temp.next != null) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
    }

    public void delete(int index) {
        if (head == null) {
            return;
        }
        if (index < 0) {
            System.out.println("Invalid Index");
            return;
        }
        if (head.next == null) { // kiem tra neu cai list nay 1 phan tu
            deleteFirst();
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == length() - 1) {
            deleteLast();
            return;
        }
        Node temp = head;
        // dung for
        // for (int i = 0; i < index - 1; i++) {
        // if (temp.next != null) {
        // temp = temp.next;
        // }
        // }
        // dung while
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Invalid Index");
        }
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean search(int data) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node searchAtPosition(int index) {
        if (index < 0 || index > length() - 1) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            // nếu là i < index thì là nó lấy tại vị trí temp
            // còn i <= index thì là nó lấy tại vị trí temp.next
        }
        return temp;
    }

    public void sort() {
        if ( head == null || head.next == null){
            return;
        }
        Node i, j;
        int temp;
        for ( i = head; i.next != null; i = i.next){
            for ( j = i.next; j  != null; j = j.next){
                if ( i.getData() > j.getData()){
                    temp = i.getData();
                    i.setData(j.getData());
                    j.setData(temp);
                }
            }
        }
    }

    public void displayAll() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        myLinkedList linkedList = new myLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(12);
        linkedList.add(124, 2);
        linkedList.displayAll();
        System.out.println();
        System.out.println(linkedList.searchAtPosition(2));
        System.out.println();
        linkedList.delete(3);
        // linkedList.deleteLast();
        System.out.println(linkedList.length());
        linkedList.sort();
        linkedList.displayAll();
    }

}