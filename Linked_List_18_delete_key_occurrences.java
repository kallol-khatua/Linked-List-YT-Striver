public class Linked_List_18_delete_key_occurrences {
    private static DLLNode convertArrToDLL(int[] arr) {
        DLLNode head = new DLLNode(arr[0]);
        DLLNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            DLLNode temp = new DLLNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void printDLL(DLLNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static DLLNode deleteAllOccurrences(DLLNode head, int k) {
        if (head == null) return head;
        DLLNode temp = head;
        DLLNode prev;
        DLLNode next;
        while (temp != null) {
            if (temp.data == k) {
                if (temp == head) {
                    head = head.next;
                }
                prev = temp.back;
                next = temp.next;

                if (prev != null) prev.next = next;
                if (next != null) next.back = prev;

            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 2, 6, 9, 2};

        DLLNode head = convertArrToDLL(arr);
        printDLL(head);

        DLLNode deletedLL = deleteAllOccurrences(head, 2);
        printDLL(deletedLL);

    }
}
