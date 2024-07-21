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
        System.out.println();
    }

    private static int lengthOfLL(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    private static boolean isValuePresent(Node head, int val){
        boolean isPresent = false;
        Node temp = head;
        while (temp != null) {
            if(temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return isPresent;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7};
//        Node y = new Node(arr[3]);
//        System.out.println(y.data);
//        System.out.println(y.next);

        Node head = convertArrToLL(arr);
//        System.out.println(head.next.data);

//        printLL(head);

//        System.out.println("length of linked list = " + lengthOfLL(head));

        System.out.println("Is value present " + isValuePresent(head, 4));
    }
}
