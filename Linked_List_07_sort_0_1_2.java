public class Linked_List_07_sort_0_1_2 {
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

    private static Node sort012(Node head) {
        if (head == null) return head;
        Node temp = head;

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        two.next = null;
        one.next = twoHead.next;
        zero.next = oneHead.next;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 2, 2};
        Node head = convertArrToLL(arr);
        printLL(head);

        Node sort012 = sort012(head);
        printLL(sort012);
    }
}
