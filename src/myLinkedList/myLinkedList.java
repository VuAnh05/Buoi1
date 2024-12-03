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

    public void add(int data, int index){
        Node newNode = new Node(data);
        if ( index == 0){
            addFirst(data);
            return;
        }
        else{
            Node temp = head;
            for ( int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }

    public static void main(String[] args) {
        myLinkedList linkedList = new myLinkedList();
        //linkedList.addFirst(1);
        //linkedList.addFirst(2);
        linkedList.addLast(12);
    }
}
