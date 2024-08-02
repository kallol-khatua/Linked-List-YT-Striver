public class Linked_List_20_remove_duplicates_from_sorted_DLL {
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

    private static void removeDuplicated(DLLNode head) {
        if(head == null || head.next == null) {
            return;
        }

        DLLNode pre = head;
        DLLNode post = head.next;

        while(post != null) {
            if(pre.data == post.data) {
                post = post.next;
            } else {
                pre.next = post;
                post.back = pre;

                pre = post;
                post = post.next;
            }
        }

        pre.next = null;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 5, 7, 8, 8};
        DLLNode head = convertArrToDLL(arr);

        printDLL(head);

        removeDuplicated(head);

        printDLL(head);
    }
}
