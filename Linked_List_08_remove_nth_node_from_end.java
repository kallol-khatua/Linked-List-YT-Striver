public class Linked_List_08_remove_nth_node_from_end {
    private static Node convertArrToLL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node removeNthNodeFromLast(Node head, int n) {
        int count = 0;
        Node fast = head;
        while(count < n) {
            fast = fast.next;
            count++;
        }
        if(fast == null) return head.next;
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 1};
        Node head = convertArrToLL(arr);
        printLL(head);
    }
}
