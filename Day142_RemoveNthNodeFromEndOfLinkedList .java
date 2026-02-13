// Remove Node From End of Linked List
// You are given the beginning of a linked list head, and an integer n.
// Remove the nth node from the end of the list and return the beginning of the list.
// Example 1:
// Input: head = [1,2,3,4], n = 2
// Output: [1,2,4]
// Example 2:
// Input: head = [5], n = 1
// Output: []
// Example 3:
// Input: head = [1,2], n = 2
// Output: [2]
// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz


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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int removeIndex = nodes.size() - n;
        if (removeIndex == 0) {
            return head.next;
        }
        nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;
        return head;
    }
}
