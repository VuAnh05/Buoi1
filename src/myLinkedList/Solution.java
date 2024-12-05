package myLinkedList;

class Solution {
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

    public static String laySo(ListNode node) {
        String res = "";
        while (node != null) {
            res += node.getVal();
            node = node.next;
        }
        StringBuilder sb = new StringBuilder(res);
        return sb.reverse().toString();

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = laySo(l1);
        String num2 = laySo(l2);

        long sum = Long.parseLong(num1) + Long.parseLong(num2);

        String res = String.valueOf(sum);
        
        char[] c = res.toCharArray();
        int[] a = new int[c.length];
        ListNode head = new ListNode();
        ListNode temp = head;
        
        for (int i = 0; i < c.length; i++) {
            a[i] = c[i] - '0';
        }

        for (int i = 0; i < a.length; i++) {
            ListNode newNode = new ListNode(a[i]);
            temp.next = newNode;
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