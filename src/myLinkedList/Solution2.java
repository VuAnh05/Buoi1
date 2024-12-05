package myLinkedList;

public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int sum = 0;
        while ( l1 != null || l2 != null || res != 0 ){
            int val1 = 0;
            int val2 = 0;
            if ( l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if ( l2 != null ){
                val2 = l2.val;
                l2 = l2.next;
            }
            sum = val1 + val2 + res;
            res = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
