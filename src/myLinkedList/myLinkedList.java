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

    public void delete(int index) {
        Node temp = head;
        if (index == 0) {
            head = head.next;
            return;
        }
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
    public int length(){
        Node temp = head;
        int count = 0;
        while ( temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        myLinkedList linkedList = new myLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(12);
        linkedList.add(124,2);
        linkedList.delete(21);
        System.out.println(linkedList.length());
        linkedList.displayAll();
    }

}
