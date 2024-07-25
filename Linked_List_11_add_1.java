public class Linked_List_11_add_1 {
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

    private static Node reverse(Node head) {
        if(head == null) return head;
        Node prev = null;
        while (head != null) {
            Node front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }

        return prev;
    }

    private static Node addOne(Node head)
    {
        if(head == null) {

            return new Node(1) ;
        }

        Node reverseHead = reverse(head);
        Node store = reverseHead;

        int carry = 1;
        Node prev = null;
        while(reverseHead != null) {
            int sum = reverseHead.data + carry;
            reverseHead.data = sum % 10;
            carry = sum / 10;
            prev = reverseHead;
            reverseHead = reverseHead.next;
        }
        if(carry > 0) {
            prev.next = new Node(carry);
        }

        Node newHead = reverse(store);
        return newHead;
    }

    private static int addOneRecursion(Node head) {
        if(head == null) return 1;
        int carry = addOneRecursion(head.next);
        int sum = carry + head.data;
        head.data = sum % 10;
        return sum / 10;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        Node head = convertArrToLL(arr);
        printLL(head);

//        Node newHead = addOne(head);
//        printLL(newHead);

        int carry = addOneRecursion(head);
        if(carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            printLL(newNode);
            return;
        }
        printLL(head);
    }
}
