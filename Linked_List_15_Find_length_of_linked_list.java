public class Linked_List_15_Find_length_of_linked_list {
    private static int length(Node slow, Node fast) {
        int length = 1;
        fast = fast.next;
        while (slow != fast) {
            length++;
            fast = fast.next;
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
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;

        int length = findLoopLength(one);
        System.out.println(length);
    }
}
