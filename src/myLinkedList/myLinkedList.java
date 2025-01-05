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

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= getLength()) {
            return;
        }
        if (head == null) {
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next; // Liên kết lại với node sau khi xóa
        }
    }
    
    public int getLength() {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {  // Chỉnh sửa vòng lặp để bao gồm cả phần tử cuối
            cnt++;
            temp = temp.next;
        }
        return cnt;
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
        if (index < 0 || index > getLength() - 1) {
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
        if (head == null || head.next == null) {
            return;
        }
        Node i, j;
        int temp;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (i.getData() > j.getData()) {
                    temp = i.getData();
                    i.setData(j.getData());
                    j.setData(temp);
                }
            }
        }
    }

    public void sortByPosition(int start, int end) {
        if ( head == null || start > end || start < 0 || end < 0 || end > getLength() - 1){
            return;
        }
        Node i = head, j, startNode = null, endNode = null;
        int index = 0;
        while ( index <= end){
            if ( index == start){
                startNode = i;
            }
            if ( index == end){
                endNode = i;
                break;
            }
            i = i.next;
            index++;
        }
        if ( startNode == null || endNode == null){
            return;
        }
        for ( i =  startNode; i != endNode.next; i = i.next){
            for ( j = i.next; j != endNode.next; j = j.next){
                if ( i.getData() > j.getData()){
                    int a = i.getData();
                    i.setData(j.getData());
                    j.setData(a);
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

    public String laySo(){
        if ( head == null){
            return "";
        }
        String res = "";
        Node temp = head;
        while ( temp != null){
            res += temp.getData();
            temp = temp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        myLinkedList linkedList = new myLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        linkedList.displayAll();
        System.out.println();
        String res = linkedList.laySo();
        StringBuilder sb = new StringBuilder(res);
        String k = sb.reverse().toString();
        char[] m = k.toCharArray();
        int[] a = new int[m.length];
        for ( int i = 0; i < m.length; i++){
            a[i] = m[i] - '0';
        }
        myLinkedList newNode = new myLinkedList();
        for ( int i = 0; i < a.length; i++){
            newNode.addLast(a[i]);
        }
        newNode.displayAll();
        linkedList.deleteAtIndex(0);
        System.out.println();
        linkedList.displayAll();
    }

}