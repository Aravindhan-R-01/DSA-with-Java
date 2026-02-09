// Reverse Linked List:
// Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
// Example 1:
// Input: head = [0,1,2,3]
// Output: [3,2,1,0]
// Example 2:
// Input: head = []
// Output: []
// Constraints:
// 0 <= The length of the list <= 1000.
// -1000 <= Node.val <= 1000


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Day138_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
