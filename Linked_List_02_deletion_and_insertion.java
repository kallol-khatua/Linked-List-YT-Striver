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

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 6};
        Node head = convertArrToLL(arr);
        printLL(head);

//        Node removeHead = removeHead(head);
//        printLL(removeHead);
    }
}
