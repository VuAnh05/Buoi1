package myLinkedList;

public class myLinkedList {
    private Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        myLinkedList linkedList = new myLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
    }
}
