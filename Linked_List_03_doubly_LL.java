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

    private static DLLNode removeHead(DLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLLNode prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    private static DLLNode removeTail(DLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLLNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next.back = null;
        temp.next = null;
        return head;
    }

    private static DLLNode removeKth(DLLNode head, int k) {
        if (head == null) return null;
        if (head.next == null) {
            if (k == 1) {
                return null;
            } else {
                return head;
            }
        }

        if (k == 1) {
            DLLNode prev = head;
            head = head.next;
            head.back = null;
            prev.next = null;
            return head;
        }

        DLLNode temp = head;
        DLLNode prev = null;
        int count = 1;
        while (temp != null) {
            if (count == k) {
                prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.back = temp.back;
                }
                temp.next = null;
                temp.back = null;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }

    private static void removeNode(DLLNode node) {
        DLLNode prev = node.back;
        DLLNode front = node.next;

        node.back = node.next = null;
        prev.next = front;
        if (front != null) {
            front.back = prev;
        }
    }

    private static DLLNode insertBeforeHead(DLLNode head, int val) {
        DLLNode temp = head;
        head = new DLLNode(val, temp, null);
        temp.back = head;
        return head;
    }

    private static DLLNode insertBeforeTail(DLLNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) { // insert before head
            return insertBeforeHead(head, val);
        }

        DLLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        DLLNode prev = temp.back;

        DLLNode newNode = new DLLNode(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;

        return head;
    }

    private static DLLNode insertBeforeKth(DLLNode head, int val, int k) {
        if (head == null) return null;
        if (head.next == null && k == 1) {
            DLLNode temp = head;
            head = new DLLNode(val, temp, null);
            temp.back = head;
            return head;
        }

        int count = 1;
        DLLNode temp = head;
        DLLNode prev = null;
        while (temp != null) {
            if(k == 1) {
                head = new DLLNode(val, temp, null);
                temp.back = head;
                return head;
            }
            if (count == k) {
                DLLNode newNode = new DLLNode(val, temp, prev);
                prev.next = newNode;
                temp.back = newNode;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9};
        DLLNode head = convertArrToDLL(arr);
        printDLL(head);

//        DLLNode removeHead = removeHead(head);
//        printDLL(removeHead);

//        DLLNode removeTail = removeTail(head);
//        printDLL(head);

//        DLLNode removeKth = removeKth(head, 2);
//        printDLL(removeKth);

//        node != head, and minimum 2 node present
//        removeNode(head.next);
//        printDLL(head);

//        DLLNode insertBeforeHead = insertBeforeHead(head, 3);
//        printDLL(insertBeforeHead);

//        DLLNode insertBeforeTail = insertBeforeTail(head, 12);
//        printDLL(insertBeforeTail);

        DLLNode insertBeforeKth = insertBeforeKth(head, 12, 2);
        printDLL(insertBeforeKth);
    }
}
