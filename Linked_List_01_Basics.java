class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Linked_List_01_Basics {
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
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7};
//        Node y = new Node(arr[3]);
//        System.out.println(y.data);
//        System.out.println(y.next);

        Node head = convertArrToLL(arr);
//        System.out.println(head.next.data);

        printLL(head);
    }
}
