public class Linked_List_15_Find_length_of_linked_list {
    private static int length(Node slow, Node fast) {
        int length = 0;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
            length++;
        }
        return length;
    }

    private static int findLoopLength(Node head) {
        if (head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return length(slow, fast);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
