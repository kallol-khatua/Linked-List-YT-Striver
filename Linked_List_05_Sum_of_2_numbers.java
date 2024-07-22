import java.security.PrivateKey;

public class Linked_List_05_Sum_of_2_numbers {
    private static Node convertArrToSLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void printSLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node sumOfTwoNum(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int sum = carry;
            if(list1 != null) {
                sum += list1.data;
                list1 = list1.next;
            }
            if(list2 != null) {
                sum += list2.data;
                list2 = list2.next;
            }
            Node temp = new Node(sum % 10);
            carry = sum / 10;
            curr.next = temp;
            curr = temp;
        }
        if(carry > 0) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5};
        int[] arr2 = {4, 5, 9, 9};

        Node list1 = convertArrToSLL(arr1);
        Node list2 = convertArrToSLL(arr2);

        printSLL(list1);
        printSLL(list2);

        Node sumHead = sumOfTwoNum(list1, list2);
        printSLL(sumHead);
    }
}
