package myLinkedList;

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
        for (int i = 0; i < index - 1; i++) {
            if (temp.next != null) {
                temp = temp.next;
            }
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
        linkedList.displayAll();;
        System.out.println();
        linkedList.delete(3);
        // linkedList.deleteLast();
        System.out.println(linkedList.length());
        linkedList.displayAll();
    }

}