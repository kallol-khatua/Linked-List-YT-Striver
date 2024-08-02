import java.util.Scanner;

public class Linked_List_22_rotate_LL {
    private static Node convertArrToLL(int[] arr) {
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

    private static Node rotate(Node head, int k) {

        Node temp = head;

        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k > 0) {
            int reach = length - k;
            Node temp2 = head;
            while (reach > 1) {
                reach--;
                temp2 = temp2.next;
            }

            temp.next = head;
            head = temp2.next;
            temp2.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrToLL(arr);
        printLL(head);

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Node newHead = rotate(head, k);
        printLL(newHead);
    }
}
