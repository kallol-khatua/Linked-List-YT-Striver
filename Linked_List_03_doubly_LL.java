class DLLNode {
    int data;
    DLLNode next;
    DLLNode back;

    DLLNode(int data, DLLNode next, DLLNode back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class Linked_List_03_doubly_LL {
    private static DLLNode convertArrToDLL(int[] arr) {
        DLLNode head = new DLLNode(arr[0]);
        DLLNode prev = head;
        for(int i = 1; i < arr.length; i++) {
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

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9};
        DLLNode head = convertArrToDLL(arr);
        printDLL(head);
    }
}
