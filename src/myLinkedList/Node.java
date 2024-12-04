package myLinkedList;

public class Node {
    private int data;
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return this.data + " " + this.next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
    
    
}
