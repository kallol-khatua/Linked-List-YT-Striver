public class Linked_List_09_reverse_SLL {
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

    private static Node iterativeReverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node temp = head;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    private static Node recursiveReverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 0, 8};
        Node head = convertArrToLL(arr);
        printLL(head);

//        Node iterativeReverse = iterativeReverse(head);
//        printLL(iterativeReverse);

        Node recursiveReverse = recursiveReverse(head);
        printLL(recursiveReverse);
    }
}
