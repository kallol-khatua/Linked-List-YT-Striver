public class Linked_List_02_deletion_and_insertion {
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

    private static Node removeHead(Node head) {
        if (head == null) return null;
        return head.next;
    }

    private static Node removeTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeKth(Node head, int k) {
        if (head == null) return null; // no element
        if (head.next == null) { // single element
            if (k == 1) return null;
            else return head;
        }

        if (k == 1) { // removing head
            return head.next;
        }

        Node temp = head;
        Node prev = null;
        int count = 1;
        while (temp != null) {
            if (count == k) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 6};
        Node head = convertArrToLL(arr);
        printLL(head);

//        Node removeHead = removeHead(head);
//        printLL(removeHead);

//        Node removeTail = removeTail(head);
//        printLL(head);

        Node removeKth = removeKth(head, 4);
        printLL(removeKth);
    }
}
