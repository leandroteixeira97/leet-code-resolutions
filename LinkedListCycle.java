import java.util.ArrayList;
import java.util.List;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val; this.next = null;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        System.out.println(hasCycle(l1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        List<ListNode> nodeList = new ArrayList<>();

        ListNode currentNode = head;

        while (currentNode != null) {
            if (nodeList.contains(currentNode)) {
                return true;
            }

            nodeList.add(currentNode);

            currentNode = currentNode.next;
        }

        return false;
    }
}
