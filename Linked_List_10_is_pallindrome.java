public class Linked_List_10_is_pallindrome {
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

    private static Node reverseSLL(Node head) {
        Node prev = null;
        while (head != null) {
            Node front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }

    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        
//        finding the middle
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

//        reversing after middle
        Node  reverseHead = reverseSLL(slow.next);

//        checking of palindrome
        Node first = head;
        Node last = reverseHead;
        while (last != null) {
            if (first.data != last.data) {
                reverseSLL(slow.next);
                return false;
            }
            first = first.next;
            last = last.next;
        }
        reverseSLL(slow.next);
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        Node head = convertArrToLL(arr);
        printLL(head);

        boolean isPalindrome = isPalindrome(head);
        System.out.println(isPalindrome);
    }
}
