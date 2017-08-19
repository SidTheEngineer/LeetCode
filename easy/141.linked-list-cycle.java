/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // Given a linked list, determine if it has a cycle in it. Can you do
 // this without using extra memory?
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // We will use the LinkedList trick of the rabbit and the turtle, 
        // i.e. having one pointer move twice as fast as another, the fast.
        // one starting one space ahead of the slow one. This allows
        // us the ability to not use extra memory when searching for a cycle.
        ListNode rabbit = head.next, turtle = head;

        while (rabbit != null && rabbit.next != null) {
            if (rabbit == turtle || rabbit.next == turtle) return true;
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }

        return false;
    }
}