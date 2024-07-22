public class Linked_List_04_reverse_DLL {
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


    private static DLLNode reverseDLLInPlace(DLLNode head) {
        if (head.next == null) return head;
        DLLNode temp = head;
        DLLNode prev = null;
        while (temp != null) {
            DLLNode back = temp.back;
            temp.back = temp.next;
            temp.next = back;
            prev = temp;
            temp = temp.back;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7};
        DLLNode head = convertArrToDLL(arr);
        printDLL(head);

        DLLNode reverseHead = reverseDLLInPlace(head);
        printDLL(reverseHead);
    }
}
