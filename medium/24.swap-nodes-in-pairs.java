/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /*

 1->2->3 => 2->1->3
 1->2 => 2->1

 */


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode first = head, second = head.next, prev = null;

        while (second != null) {
            first.next = second.next;
            second.next = first;
            if (prev != null) {
                prev.next = second;
            } else {
                head = second;
            }

            if (first.next == null) {
                return head;
            } else {
                prev = first;
                first = first.next;
                second = first.next;
            }
        }
        return head;
    }
}